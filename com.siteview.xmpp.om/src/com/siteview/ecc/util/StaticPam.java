package com.siteview.ecc.util;

import java.util.List;

import com.siteview.xmpp.om.modle.SelectCommad;
import com.siteview.xmpp.om.modle.UserInfo;

public class StaticPam {
	public static List<UserInfo> users;
	public static SelectCommad selectcom;
//	public static Map<String,String> map=new HashMap<String,String>();
	
	public static String username="user";
	public static String password="password";
	public static String owner="Owner";
	public static String loginid="loginid";
	public static String incidentid="incidentid";
	public static String command="command";
	public static String selfback="selfback";
	
	
	public static String _good="000:";//xmpp返回正常状态
	public static String _error="001:";//xmpp返回错误
	public static String error_login="error_user_password";//用户名或者密码错误
	public static String error_key="error_request";//请求错误
}
