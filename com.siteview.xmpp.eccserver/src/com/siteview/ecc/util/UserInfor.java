package com.siteview.ecc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Siteview.DataSet;
import Siteview.DataTable;
import Siteview.SiteviewException;
import Siteview.Api.ISiteviewApi;
/**
 * 
 * @author lihua.zhong
 * �����û�
 */
public class UserInfor {
	
	public static Map<String,String> users=new HashMap<String,String>();
	public static  List<String> superuser=null;
	
	//�û���Ϣ��ȡ
	public  static void getUserInfor() throws SiteviewException {
		superuser=new ArrayList<String>();
		ISiteviewApi api=EccApiUtil.getApi();
//		Siteview.thread.Thread.set_CurrentPrincipal(EccApiUtil.mainIPrincipal);
		DataSet ds = api.get_AuthenticationService().GetLoginIdsByGroupId("");
		DataTable dt = ds.get_Tables().get_Item(0);
		for(int i = 0; i< dt.get_Rows().size();i++){
			String s=dt.get_Rows().get_Item(i).get_Item(0).toString();
			Siteview.User u= EccApiUtil.getApi()
					.get_AuthenticationService().GetUser("User", s);
			if(u.get_SecurityGroupName().equals("������Ա")){
	 			users.put(u.get_LoginId(), u.get_InternalUserInfo().get_Password());
	 			superuser.add(u.get_LoginId());
			}else if(u.get_SecurityGroupName().equals("��⾭��")){
				users.put(u.get_LoginId(), u.get_InternalUserInfo().get_Password());
	 			superuser.add(u.get_LoginId());
			}
		}		
	}

}
