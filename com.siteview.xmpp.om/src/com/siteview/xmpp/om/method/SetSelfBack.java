package com.siteview.xmpp.om.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Siteview.SiteviewException;

import com.siteview.ecc.util.OmApi;
import com.siteview.ecc.util.StaticPam;

public class SetSelfBack extends OmServer{
	private static String _key_="set_selfback:";//set_selfback:user={user};incidentid={incidentid};selfback={selfback}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.incidentid);
		_keys.add(StaticPam.selfback);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String incidentid=map.get(StaticPam.incidentid);
		String selfback=map.get(StaticPam.selfback);
		if(OmApi.setSelfback(incidentid, selfback)){
			return _key_+StaticPam._good;
		}
		return _key_+StaticPam._error;
	}
}
