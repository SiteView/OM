package com.siteview.ecc.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Siteview.SiteviewException;

import com.siteview.ecc.modle.StaticPam;
import com.siteview.ecc.util.EccInterface;

public class GetAlarmRule extends EccServer{
	private static String _key_="get_alarmrule:";//get_subgroup:user={username},parentid={parentid}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
//		_keys.add(StaticPam.parentid);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		
		return _key_;//+EccInterface.get(user);
	}
}
