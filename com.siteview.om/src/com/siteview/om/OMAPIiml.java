package com.siteview.om;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.osgi.framework.ServiceException;
/**
 * 
 * @author lihua.zhong
 *
 */
public class OMAPIiml{
	public static String url="http://om.siteview.com/itsm/webservice/MyOm";//incident
	@SuppressWarnings("unchecked")
	public static Map<String, List<String>> getProduct() throws ServiceException{
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		List<String>product=null;
		Service service=new Service();  
		try {
		    Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("getProduct");
			product=(List<String>)call.invoke(new Object[]{});
			for(String s:product){
				String[] s0=s.split("=");
				String[] s1=s0[1].split(";");
				List<String> list=new ArrayList<String>();
				for(String ss:s1){
					if(ss!=null&&!ss.equals("null"))
						list.add(ss);
				}
				map.put(s0[0], list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return map;
	}

	public static String savaOm(String om) throws ServiceException {
		Service service=new Service();  
		try {
			Call call=(Call)service.createCall(); 
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("CreateOm");
			call.addParameter(new QName("om"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName("tablename"), XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnClass(String.class);
			String s= (String) call.invoke(new Object[]{om,"incident"});
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static List<String> getIncidentType() throws ServiceException {
		List<String> type=null;
		Service service=new Service();  
		try {
			Call call=(Call)service.createCall(); 
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("gettype");
			type=(List<String>)call.invoke(new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}
	
	@SuppressWarnings("unchecked")
	public static List<IncidentModle> getIncidents(String user,String password) throws ServiceException {
		List<IncidentModle> type=null;
		Service service=new Service();  
		try {
			Call call=(Call)service.createCall(); 
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("getIncidentModle");
			call.addParameter(new QName("user"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName("password"), XMLType.XSD_STRING, ParameterMode.IN);
			QName qn = new QName(url,"getIncidentModle");
			call.registerTypeMapping(IncidentModle.class,qn,
					new BeanSerializerFactory(IncidentModle.class,qn),
					new BeanDeserializerFactory(IncidentModle.class,qn));
			call.setReturnClass(IncidentModle.class);
			type =(ArrayList<IncidentModle>) call.invoke(new Object[]{user,password});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}
	
	public static void readComm(String key,String value){
		Service service=new Service();  
		try {
			Call call=(Call)service.createCall(); 
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("readybeak");
			call.addParameter(new QName("key"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName("value"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName("tablename"), XMLType.XSD_STRING, ParameterMode.IN);
			QName qn = new QName(url,"readybeak");
			call.setReturnType(qn);
			call.invoke(new Object[]{key,value,"incident"});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String savafeedback(String recid,String feedback){
		Service service=new Service();  
		String s="";
		try {
			Call call=(Call)service.createCall(); 
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("feedback");
			call.addParameter(new QName("recid"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName("feedback"), XMLType.XSD_STRING, ParameterMode.IN);
			QName qn = new QName(url,"feedback");
			call.setReturnQName(qn);
			s=(String) call.invoke(new Object[]{recid,feedback});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static void main(String[] args){
		System.out.println(getIncidents("lihua.zhong", "siteview1").size());
	}
}
