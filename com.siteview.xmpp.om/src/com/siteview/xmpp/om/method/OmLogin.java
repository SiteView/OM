package com.siteview.xmpp.om.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import Siteview.SiteviewException;

import com.siteview.ecc.util.OmApi;
import com.siteview.ecc.util.OmApiUtil;
import com.siteview.ecc.util.StaticPam;
import com.siteview.xmpp.om.modle.OmModle;

public class OmLogin extends OmServer{
	private static String _key_="get_login:";//get_login:user={user};password={password}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.password);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String password=map.get(StaticPam.password);
		boolean login=false;
		try{
			login=OmApiUtil.getApi().get_AuthenticationService().checkUser(user, password);
		}catch (Exception e) {
			login=false;
		}
		if(!login)
			return _key_+StaticPam._error+StaticPam.error_login;
		OmModle om=new OmModle();
		if(!user.equals("admin")){
			om.setIncs(OmApi.getIncident("Owner",user));
			return _key_+StaticPam._good+JSONObject.fromObject(om).toString();//+EccInterface.get(user);
		}else{
			om.setUsers(StaticPam.users);
			om.setIncs(OmApi.getIncidentforTwo());
			return _key_+StaticPam._good+JSONObject.fromObject(om).toString();//+EccInterface.get(user);
		}
	}
}
