package com.siteview.xmpp.om.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import Siteview.SiteviewException;

import com.siteview.ecc.util.OmApi;
import com.siteview.ecc.util.StaticPam;
import com.siteview.xmpp.om.modle.OmModle;
/**
 * @author lihua.zhong
 * 
 */
public class GetIncident extends OmServer{
	
	private static String _key_="get_incident:";//get_incident:user={user};Owner={Owner};loginid={loginid}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.owner);
		_keys.add(StaticPam.loginid);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String owmer=map.get(StaticPam.owner);
		String loginid=map.get(StaticPam.loginid);
		OmModle om=new OmModle();
		om.setIncs(OmApi.getIncident(StaticPam.owner, owmer));
		return _key_+StaticPam._good+JSONObject.fromObject(om).toString();//+EccInterface.get(user);
	}
}
