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
/**
 * @author lihua.zhong
 * 请求设备下面的监测器
 * get_subgroup:user={username};machineid={machineid};type=Machine
 */
public class GetSubMachine extends EccServer{
	private static String _key_="get_submachine:";
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.machineid);
		_keys.add(StaticPam.type);
	}
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		
		//错误请求
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam._error+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String machineid=map.get(StaticPam.machineid);
		if( UserInfor.users.get(map.get(StaticPam.username))!=null ){//&& UserInfor.users.get(user).equals(password)){
			SiteViewEcc siteviewecc=new SiteViewEcc();
			siteviewecc.setMonitors(EccInterface.getMonitor(user, machineid, map.get(StaticPam.type)));
			return _key_+StaticPam._good+JSONObject.fromObject(siteviewecc).toString();
		}
		return _key_+StaticPam._error+StaticPam.error_nologin;
	}
}
