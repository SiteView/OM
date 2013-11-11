package com.siteview.ecc.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import Siteview.SiteviewException;

import com.siteview.ecc.modle.SiteViewEcc;
import com.siteview.ecc.modle.StaticPam;
import com.siteview.ecc.util.EccInterface;
import com.siteview.ecc.util.UserInfor;
/*
 * ”√ªßµ«¬º
 */
public class LoginIn extends EccServer{
	private static String _key_="get_login:";//get_user:user={username},pwd={password}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.password);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam._error+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String password=map.get(StaticPam.password);
		
		if(UserInfor.users.get(user)==null||!UserInfor.users.get(user).equals(password))
			UserInfor.getUserInfor();
		
		if( UserInfor.users.get(user)!=null ){//&& UserInfor.users.get(user).equals(password)){
			SiteViewEcc siteviewecc=new SiteViewEcc();
			siteviewecc.setGroups(EccInterface.getGroup(user, ""));
			return _key_+StaticPam._good+JSONObject.fromObject(siteviewecc).toString();
		}
		return _key_+StaticPam._error+StaticPam.error_login;
	}
	
}
