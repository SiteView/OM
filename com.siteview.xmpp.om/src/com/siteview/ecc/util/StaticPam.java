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
	
	
	public static String _good="000:";//xmpp��������״̬
	public static String _error="001:";//xmpp���ش���
	public static String error_login="error_user_password";//�û��������������
	public static String error_key="error_request";//�������
}
