package com.siteview.xmpp.om.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Siteview.SiteviewException;

import com.siteview.ecc.util.OmApi;
import com.siteview.ecc.util.StaticPam;

public class SetCommend extends OmServer{
	private static String _key_="set_commend:";//set_commend:user={user};incidentid={incidentid};command={command}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.incidentid);
		_keys.add(StaticPam.command);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String incidentid=map.get(StaticPam.incidentid);
		String command=map.get(StaticPam.command);
		if(OmApi.setComment(incidentid, command)){
			return _key_+StaticPam._good;
		}
		return _key_+StaticPam._error;
	}
}
