package com.siteview.ecc.util;

import Siteview.Api.ISiteviewApi;
import Siteview.Api.SiteviewApi;
import Siteview.Api.SiteviewConnection;
import Siteview.IAuthenticationBundle;
import Siteview.SiteviewException;
import Siteview.thread.Thread;
import java.io.PrintStream;

public class ApiBroker
{
  private static ISiteviewApi api;
  private static String connName = "{Common}Ecc_Master";
  private static String userName = "admin";
  private static String password = "manage";

  public static ISiteviewApi getApi()
  {
	  try{
		  if(api==null){
		  ISiteviewApi siteview = SiteviewApi.get_CreateInstance();
		  	siteview.Connect("Ecc_Master");
			IAuthenticationBundle authentication = siteview.GetAuthenticationBundle();
			authentication.set_UserType("User");
			authentication.set_AuthenticationId("admin");
			authentication.set_Password("manage");
			System.out.println(siteview.Login(authentication));
			api=siteview;
//			Siteview.DataSet ds = siteview.get_AuthenticationService().GetLoginIdsByGroupId("");
//			System.out.println(ds);
		}
		}catch(Exception e){
			e.printStackTrace();
		}

    return api;
  }

  public static boolean Login(String connName, String strLoginId, String strLoginPassword)
  {
    boolean flag = false;
    try {
      getApi().Connect(connName);
      IAuthenticationBundle authenticationBundle = getApi().GetAuthenticationBundle();
      authenticationBundle.set_UserType("User");
      authenticationBundle.set_AuthenticationId(strLoginId);
      authenticationBundle.set_Password(strLoginPassword);
      flag = getApi().Login(authenticationBundle).booleanValue();
    } catch (SiteviewException e) {
      e.printStackTrace();
    }
    return flag;
  }

  public static boolean Login(String strLoginId, String strLoginPassword)
  {
    boolean flag = false;
    try {
      IAuthenticationBundle authenticationBundle = getApi().GetAuthenticationBundle();
      authenticationBundle.set_UserType("User");
      authenticationBundle.set_AuthenticationId(strLoginId);
      authenticationBundle.set_Password(strLoginPassword);
      flag = getApi().Login(authenticationBundle).booleanValue();
    } catch (SiteviewException e) {
      e.printStackTrace();
    }
    return flag;
  }
}