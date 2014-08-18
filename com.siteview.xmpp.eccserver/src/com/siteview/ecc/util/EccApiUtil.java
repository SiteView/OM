package com.siteview.ecc.util;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Element;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import com.siteview.xmpp.eccserver.Activator;

import Siteview.Operators;
import Siteview.SiteviewException;
import Siteview.SiteviewQuery;
import Siteview.Api.BusinessObject;
import Siteview.Api.ISiteviewApi;
import Siteview.thread.IPrincipal;


public class EccApiUtil {
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
	    query.AddOrderByDesc("CreatedDateTime");
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

	  public static synchronized Collection getLog(Map<String, Object> map, String s) throws SiteviewException {
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
	      Element xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, 
	        Operators.Equals, map.get(key).toString());
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

	  public static synchronized Collection getLog2(Map<String, Object> map, String s) throws SiteviewException {
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
	      Element xml = query.get_CriteriaBuilder().FieldAndValueExpression(key, Operators.Null, (String)map.get(key));
	      xmls[(i++)] = xml;
	    }
	    query.AddOrderByDesc("CreatedDateTime");
	    query.set_BusObSearchCriteria(query.get_CriteriaBuilder().AndExpressions(xmls));
	    Collection iCollenction = getApi().get_BusObService().get_SimpleQueryResolver().ResolveQueryToBusObList(query);
	    return iCollenction;
	  }

//	  public static IPrincipal getIPrincipal() {
//	    return mainIPrincipal;
//	  }

	  public static String getPath() {
	    return getPath(Activator.PLUGIN_ID);
	  }

	  public static String isLinuxReturnPerfixPath() {
	    if ("/".equals(File.separator)) {
	      return "/";
	    }
	    return "";
	  }

	  public static String getPath(String pluginid) {
	    String path = null;
	    try {
	      path = FileLocator.toFileURL(
	        Platform.getBundle(pluginid).getEntry("")).getPath();
	      path = isLinuxReturnPerfixPath() + path.substring(path.indexOf("/") + 1, path.length());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return path;
	  }
}
