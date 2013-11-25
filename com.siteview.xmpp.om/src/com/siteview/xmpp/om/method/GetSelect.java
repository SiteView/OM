package com.siteview.xmpp.om.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import Siteview.SiteviewException;

import com.siteview.ecc.util.StaticPam;

public class GetSelect extends OmServer{
	private static String _key_="get_select:";//get_select:user={user}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		return _key_+StaticPam._good+JSONObject.fromObject(StaticPam.selectcom).toString();//+EccInterface.get(user);
	}
}
