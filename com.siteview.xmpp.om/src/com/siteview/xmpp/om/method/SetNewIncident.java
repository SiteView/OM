package com.siteview.xmpp.om.method;

import net.sf.json.JSONObject;
import Siteview.SiteviewException;

import com.siteview.ecc.util.OmApi;
import com.siteview.ecc.util.StaticPam;
import com.siteview.xmpp.om.modle.Incident;

public class SetNewIncident extends OmServer{
	private static String _key_="set_newincident:";//set_newincident:{incident}
	
	public String update(String from,String body) throws SiteviewException{
		JSONObject ob=JSONObject.fromObject(body);
		Incident incident=(Incident) JSONObject.toBean(ob);
		if(OmApi.setNewIncident(incident)){
			return _key_+StaticPam._good;
		}
		return _key_+StaticPam._error;
	}
}
