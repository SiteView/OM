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

public class GetMonitors extends EccServer{
	private static String _key_="get_monitors:";//get_subgroup:user={username},parentid={parentid}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		if( UserInfor.users.get(map.get(StaticPam.username))!=null ){//&& UserInfor.users.get(user).equals(password)){
			SiteViewEcc siteviewecc=new SiteViewEcc();
			siteviewecc.setMonitors(EccInterface.getMonitors(map.get(StaticPam.username)));
			return _key_+StaticPam._good+JSONObject.fromObject(siteviewecc).toString();
		}
		return _key_+StaticPam._error;
	}
}
