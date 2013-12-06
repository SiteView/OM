package com.siteview.ecc.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import Siteview.SiteviewException;

import com.siteview.ecc.modle.EccAlarm;
import com.siteview.ecc.modle.StaticPam;
import com.siteview.ecc.util.EccInterface;

public class GetAlarmLog extends EccServer{
	private static String _key_="get_alarmlog:";//get_alarmlog:user={username},alarmruleid={alarmruleid}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.alarmruleid);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//¥ÌŒÛ«Î«Û
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String alarmruleid=map.get(StaticPam.alarmruleid);
		
		EccAlarm eccalarm=new EccAlarm();
		eccalarm.setAlarmRule(EccInterface.getAlarmRule(user));
		return _key_+StaticPam._good+JSONObject.fromObject(eccalarm).toString();//+EccInterface.get(user);
	}
}
