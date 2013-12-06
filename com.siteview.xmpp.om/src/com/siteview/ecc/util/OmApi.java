package com.siteview.ecc.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Siteview.SiteviewException;
import Siteview.SiteviewValue;
import Siteview.Api.BusinessObject;

import com.siteview.xmpp.om.modle.Incident;
import com.siteview.xmpp.om.modle.SelectCommad;
import com.siteview.xmpp.om.modle.UserInfo;

public class OmApi {
	public static List<Incident> getAllIncident() throws SiteviewException{
		Map<String,String> map=new HashMap<String,String>();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		map.put("endTime", simp.format(cal.getTime()));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		map.put("startTime",simp.format(cal.getTime()));
		map.put("RecId", "");
		Collection<BusinessObject> col=OmApiUtil.getLog2(map,"incident");
		return formatIncident(col);
	}
	
	public static boolean setComment(String recId,String commentAndFeedback) throws SiteviewException{
		BusinessObject bo=OmApiUtil.CreateBo("RecId", recId, "incident");
		if(bo==null)
			return false;
		bo.GetField("CommentAndFeedback").SetValue(new SiteviewValue(commentAndFeedback));
		return bo.SaveObject(OmApiUtil.getApi(), true, false).get_SaveSuccess();
	}
	
	public static boolean setSelfback(String recId,String commentAndFeedback) throws SiteviewException{
		BusinessObject bo=OmApiUtil.CreateBo("RecId", recId, "incident");
		if(bo==null)
			return false;
		bo.GetField("SelfFeedback").SetValue(new SiteviewValue(commentAndFeedback));
		return bo.SaveObject(OmApiUtil.getApi(), true, false).get_SaveSuccess();
	}
	
	public static boolean setReadCommand(String recId) throws SiteviewException{
		BusinessObject bo=OmApiUtil.CreateBo("RecId", recId, "incident");
		if(bo==null)
			return false;
		bo.GetField("IsCommentUpdata").SetValue(new SiteviewValue(false));
		return bo.SaveObject(OmApiUtil.getApi(), true, false).get_SaveSuccess();
	}
	
	public static List<UserInfo> getAllUser(){
		return OmApiUtil.getUser();
	}
	
	public static List<Incident> getIncident(String owner,String value) throws SiteviewException{
		Map<String,String> map=new HashMap<String,String>();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		map.put("endTime", simp.format(cal.getTime()));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		map.put("startTime",simp.format(cal.getTime()));
		map.put(owner, value);
		Collection<BusinessObject> col=OmApiUtil.getLog(map,"incident");
		return formatIncident(col);
	}
	
	public static List<Incident> formatIncident(Collection<BusinessObject> col) throws SiteviewException{
		List<Incident> incs=new ArrayList<Incident>();
		Iterator<BusinessObject>   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=ite.next();
			Incident inc=new Incident();
			String s=bo.GetField("caseEndTime").get_NativeValue().toString();
			if(s!=null)
				s=s.substring(s.indexOf(" ")+1);
			inc.setCaseEndTime(s==null?"":s);
			s=bo.GetField("caseStartTime").get_NativeValue().toString();
			if(s!=null)
				s=s.substring(s.indexOf(" ")+1);
			inc.setCaseStartTime(s==null?"":s);
			s=bo.GetField("Category").get_NativeValue().toString();
			inc.setCategory(s==null?"":s);
			s=bo.GetField("CommentAndFeedback").get_NativeValue().toString();
			inc.setCommentAndFeedback(s==null?"":s);
			inc.setCostTime(bo.GetField("CostTime").get_NativeValue().toString());
			inc.setCreatedDateTime(bo.GetField("CreatedDateTime").get_NativeValue().toString());
			inc.setOwner(bo.GetField("Owner").get_NativeValue().toString());
			s=bo.GetField("Resolution").get_NativeValue().toString();
			inc.setResolution(s==null?"":s);
			s=bo.GetField("SelfFeedback").get_NativeValue().toString();
			inc.setSelfFeedback(s==null?"":s);
			inc.setIsCommentUpdata((Boolean)bo.GetField("IsCommentUpdata").get_NativeValue());
			s=bo.GetField("SubCategory").get_NativeValue().toString();
			inc.setSubCategory(s==null?"":s);
			s=bo.GetField("Subject").get_NativeValue().toString();
			inc.setSubject(s==null?"":s);
			s=bo.GetField("TypeOfIncident").get_NativeValue().toString();
			inc.setTypeOfIncident(s==null?"":s);
			inc.setUser("");
			inc.setRecId(bo.get_RecId());
			incs.add(inc);
		}
		return incs;
	}

	public static boolean setNewIncident(Incident inc) throws SiteviewException{
		try{
			BusinessObject bo=OmApiUtil.getApi().get_BusObService().Create("Incident");
			bo.GetField("caseEndTime").SetValue(new SiteviewValue(inc.getCaseEndTime()));
			bo.GetField("caseStartTime").SetValue(new SiteviewValue(inc.getCaseStartTime()));
			bo.GetField("Category").SetValue(new SiteviewValue(inc.getCategory()));
	//		bo.GetField("CommentAndFeedback").SetValue(new SiteviewValue(in));
			bo.GetField("CostTime").SetValue(new SiteviewValue(inc.getCostTime()));
			bo.GetField("Owner").SetValue(new SiteviewValue(inc.getOwner()));
			bo.GetField("SelfFeedback").SetValue(new SiteviewValue(inc.getSelfFeedback()));
			bo.GetField("SubCategory").SetValue(new SiteviewValue(inc.getSubCategory()));
			bo.GetField("TypeOfIncident").SetValue(new SiteviewValue(inc.getTypeOfIncident()));
			bo.GetField("Resolution").SetValue(new SiteviewValue(inc.getResolution()));
			bo.SaveObject(OmApiUtil.getApi(), true, false);
			bo.GetField("Subject").SetValue(new SiteviewValue(inc.getSubject()+"."));
			bo.GetField("Status").SetValue(new SiteviewValue("ÒÑ¹Ø±Õ"));//
			return bo.SaveObject(OmApiUtil.getApi(), true, false).get_SaveSuccess();
		}catch (Exception e) {
		}
		return false;
	}
	
	public static SelectCommad getProduct() {
		try{
			HashMap<String,List<String>> map=new HashMap<String,List<String>>();
			ArrayList<String>  types=new ArrayList<String>();
			SelectCommad select=new SelectCommad();
			Iterator<BusinessObject>  ite=null;
			Collection<BusinessObject> col=null;
			col=OmApiUtil.getCollection("Category");
			ite=col.iterator();
			while(ite.hasNext()){
				BusinessObject bo=ite.next();
				String Category=bo.GetField("Category").get_NativeValue().toString();
				map.put(Category, new ArrayList<String>());
			}
			
			
			col=OmApiUtil.getCollection("SubCategory");
			ite=col.iterator();
			while(ite.hasNext()){
				BusinessObject bo=ite.next();
				String Category=bo.GetField("Category").get_NativeValue().toString();
				String subcategory=bo.GetField("SubCategory").get_NativeValue().toString();
				map.get(Category).add(subcategory);
			}
//			product.setCategory(sub);
			col=OmApiUtil.getCollection("IncidentType");
			ite=col.iterator();
			while(ite.hasNext()){
				BusinessObject bo=ite.next();
				String t=bo.GetField("incidenttype").get_NativeValue().toString();
				types.add(t);
			}
			select.setCategory(map);
			select.setType(types);
			return select;
		}catch (Exception e) {
		}
		return null;
	}
}
