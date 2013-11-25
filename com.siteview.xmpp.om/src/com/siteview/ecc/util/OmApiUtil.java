package com.siteview.ecc.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;

import com.siteview.xmpp.om.modle.UserInfo;

import Siteview.Operators;
import Siteview.QueryInfoToGet;
import Siteview.SiteviewException;
import Siteview.SiteviewQuery;
import Siteview.Api.BusinessObject;
import Siteview.Api.Field;
import Siteview.Api.ISiteviewApi;


public class OmApiUtil {
//	 public static IPrincipal mainIPrincipal = null;

	  public static synchronized ISiteviewApi getApi()
	  {
	    return ApiBroker.getApi();
	  }

	  public static synchronized Collection getBussCollection(String s) throws SiteviewException {
//		  Siteview.thread.Thread.set_CurrentPrincipal(mainIPrincipal);
	    SiteviewQuery query = new SiteviewQuery();
	    query.AddBusObQuery(s, 1);
	    Element xml = null;
	    xml = query.get_CriteriaBuilder().FieldAndValueExpression("RecId", 
	      Operators.NotNull);
	    query.set_BusObSearchCriteria(xml);
	    Collection iCollenction = getApi()
	      .get_BusObService().get_SimpleQueryResolver()
	      .ResolveQueryToBusObList(query);
	    return iCollenction;
	  }

	  public static synchronized Collection getBussCollection(String key, String value, String s) throws SiteviewException
	  {
//		  Siteview.thread.Thread.set_CurrentPrincipal(mainIPrincipal);
	    SiteviewQuery query = new SiteviewQuery();
	    query.AddBusObQuery(s, 1);
	    Element xml = null;
	    xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, 
	      Operators.Equals, value);
	    query.set_BusObSearchCriteria(xml);
	    Collection iCollenction = getApi()
	      .get_BusObService().get_SimpleQueryResolver()
	      .ResolveQueryToBusObList(query);
	    return iCollenction;
	  }

	  public static String getHostName(String ip)
	  {
	    String s = "";
	    try {
	      if (ip.startsWith("\\")) {
	        InetAddress a = InetAddress.getByName(ip.substring(ip.indexOf("\\") + 2));
	        s = a.getHostAddress();
	      } else {
	        InetAddress a = InetAddress.getByName(ip);
	        s = a.getHostName();
	      }
	    } catch (UnknownHostException e) {
	      e.printStackTrace();
	    }
	    return s;
	  }

	  public static synchronized Collection getBussCollection(Map<String, String> map, String s) throws SiteviewException
	  {
//		  Siteview.thread.Thread.set_CurrentPrincipal(mainIPrincipal);
	    SiteviewQuery query = new SiteviewQuery();
	    query.AddBusObQuery(s, 1);
	    Element[] xmls = new Element[map.size()];

	    Iterator iterator = map.entrySet().iterator();
	    int i = 0;
	    while (iterator.hasNext()) {
	      String key = ((Map.Entry)iterator.next()).toString();
	      key = key.substring(0, key.indexOf("="));
	      Element xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, 
	        Operators.Equals, ((String)map.get(key)).toString());
	      xmls[(i++)] = xml;
	    }
	    query.set_BusObSearchCriteria(query.get_CriteriaBuilder()
	      .AndExpressions(xmls));
	    Collection iCollenction = getApi()
	      .get_BusObService().get_SimpleQueryResolver()
	      .ResolveQueryToBusObList(query);
	    return iCollenction;
	  }

	  public static synchronized BusinessObject CreateBo(String key, String s, String s1) throws SiteviewException {
//		  Siteview.thread.Thread.set_CurrentPrincipal(mainIPrincipal);
	    SiteviewQuery query = new SiteviewQuery();
	    query.AddBusObQuery(s1, 1);

	    Element xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, 
	      Operators.Equals, s);
	    query.set_BusObSearchCriteria(xml);
	    Collection iCollenction = getApi()
	      .get_BusObService().get_SimpleQueryResolver()
	      .ResolveQueryToBusObList(query);
	    BusinessObject bo = null;
	    Iterator interfaceTableIEnum = iCollenction.iterator();
	    if (interfaceTableIEnum.hasNext()) {
	      bo = (BusinessObject)interfaceTableIEnum.next();
	    }
	    return bo;
	  }

	  public static synchronized Collection getLog(Map<String, String> map, String s) throws SiteviewException {
//		  Siteview.thread.Thread.set_CurrentPrincipal(mainIPrincipal);
	    SiteviewQuery query = new SiteviewQuery();
	    query.AddBusObQuery(s, 1);
	    Element[] xmls = new Element[map.size() - 1];

	    int i = 0;
	    if (map.get("startTime") != null) {
	      Element xml = query.get_CriteriaBuilder().QueryListExpression(
	        "CreatedDateTime", Operators.Between.name());
	      query.get_CriteriaBuilder().AddLiteralValue(xml, 
	        map.get("startTime").toString());
	      query.get_CriteriaBuilder().AddLiteralValue(xml, 
	        map.get("endTime").toString());
	      xmls[(i++)] = xml;
	      map.remove("startTime");
	      map.remove("endTime");
	    }
	    Iterator iterator = map.entrySet().iterator();
	    while (iterator.hasNext()) {
	      String key = ((Map.Entry)iterator.next()).toString();
	      key = key.substring(0, key.indexOf("="));
	      Element xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, Operators.Equals, (String)map.get(key));
	      xmls[(i++)] = xml;
	    }
	    
	    query.AddOrderByDesc("CreatedDateTime");
	    query.set_BusObSearchCriteria(query.get_CriteriaBuilder()
	      .AndExpressions(xmls));
	    Collection iCollenction = getApi()
	      .get_BusObService().get_SimpleQueryResolver()
	      .ResolveQueryToBusObList(query);
	    return iCollenction;
	  }

	  public static synchronized Collection getLog2(Map<String, String> map, String s) throws SiteviewException {
//		  Siteview.thread.Thread.set_CurrentPrincipal(mainIPrincipal);
	    SiteviewQuery query = new SiteviewQuery();
	    query.AddBusObQuery(s, 1);
	    Element[] xmls = new Element[map.size() - 1];

	    int i = 0;
	    if (map.get("startTime") != null) {
	      Element xml = query.get_CriteriaBuilder().QueryListExpression("CreatedDateTime", Operators.Between.name());
	      query.get_CriteriaBuilder().AddLiteralValue(xml, map.get("startTime").toString());
	      query.get_CriteriaBuilder().AddLiteralValue(xml, map.get("endTime").toString());
	      xmls[(i++)] = xml;
	      map.remove("startTime");
	      map.remove("endTime");
	    }
	    Iterator iterator = map.entrySet().iterator();
	    while (iterator.hasNext()) {
	      String key = ((Map.Entry)iterator.next()).toString();
	      key = key.substring(0, key.indexOf("="));
	      Element xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, Operators.NotEqual, (String)map.get(key));
	      xmls[(i++)] = xml;
	    }
	    query.AddOrderByDesc("CreatedDateTime");
	    query.set_BusObSearchCriteria(query.get_CriteriaBuilder().AndExpressions(xmls));
	    Collection iCollenction = getApi().get_BusObService().get_SimpleQueryResolver().ResolveQueryToBusObList(query);
	    return iCollenction;
	  }

	  public static  List<UserInfo> getUser() {
		  List<UserInfo> users=new ArrayList<UserInfo>();
		  SiteviewQuery query = new SiteviewQuery();
			try {
				query.AddBusObQuery("Profile.Employee", QueryInfoToGet.All);
				Element el = query.get_CriteriaBuilder().FieldAndValueExpression("Status", Operators.Equals, "活动");
				query.set_BusObSearchCriteria(el);
				//duoge xie fa
				/*
				Element el1 = query.get_CriteriaBuilder().FieldAndValueExpression("fieldname1",Operators.Equals,"");
				Element el2 = query.get_CriteriaBuilder().FieldAndValueExpression("fieldname2",Operators.Equals,"");
				Element el3 = query.get_CriteriaBuilder().AndExpressions(new Element[]{el1,el2});
				-->query.set_BusObSearchCriteria(el3);
				*/
				Collection employeeList =getApi().get_BusObService().get_SimpleQueryResolver().ResolveQueryToBusObList(query);
				Iterator iterator = employeeList.iterator();
				
				while(iterator.hasNext())
				{
					BusinessObject busOb = (BusinessObject)iterator.next();
					Field loginIdAndPresence = busOb.GetField("LoginID");
					Field displayName = busOb.GetField("DisplayName");
					Field team= busOb.GetField("Team");;
					String loginID = loginIdAndPresence.get_Value().toString();
					String name = displayName.get_Value().toString();
					String teams=team.get_NativeValue().toString();
					UserInfo user=new UserInfo();
					user.setUsername(name);
					user.setLoginId(loginID);
					user.setTeam(teams);
					users.add(user);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			return users;
	  }
	  
	  /**
		 * @author lihua.zhong
		 * 获取一个业务对象的所有值
		 * @throws SiteviewException 
		 */
		public static Collection<BusinessObject> getCollection(String tablename) throws SiteviewException{
				SiteviewQuery query = new SiteviewQuery();
				query.AddBusObQuery(tablename, QueryInfoToGet.All);
				Element xml=null;
		        xml=query.get_CriteriaBuilder().FieldAndValueExpression("RecId",Operators.NotEqual,null);
				query.set_BusObSearchCriteria(xml);
				Collection iCollenction = OmApiUtil.getApi().get_BusObService()
						.get_SimpleQueryResolver().ResolveQueryToBusObList(query);
				return iCollenction;
		}
		
		/**
		 * @author lihua.zhong
		 * 根据key=value的所有值
		 * @throws SiteviewException 
		 */
		public static Collection<BusinessObject> getCollection(String key,String value,String tablename) throws SiteviewException{
				SiteviewQuery query = new SiteviewQuery();
				query.AddBusObQuery(tablename, QueryInfoToGet.All);
				Element xml=null;
		        xml=query.get_CriteriaBuilder().FieldAndValueExpression(key,Operators.Equals,value);
				query.set_BusObSearchCriteria(xml);
				Collection iCollenction = OmApiUtil.getApi().get_BusObService()
						.get_SimpleQueryResolver().ResolveQueryToBusObList(query);
				return iCollenction;
		}
}
