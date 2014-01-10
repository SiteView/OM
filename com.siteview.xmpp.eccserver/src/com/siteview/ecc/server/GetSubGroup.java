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
 * 请求组下面的子组+设备+监测器
 * get_subgroup:user={username};groupid={groupid};type=Group
 */
public class GetSubGroup extends EccServer{
	private static String _key_="get_subgroup:";
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.groupid);
		_keys.add(StaticPam.type);
	}
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		
		//错误请求
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam._error+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String groupid=map.get(StaticPam.groupid);
		if( UserInfor.users.get(map.get(StaticPam.username))!=null ){//&& UserInfor.users.get(user).equals(password)){
			SiteViewEcc siteviewecc=new SiteViewEcc();
			siteviewecc.setGroups(EccInterface.getGroup(user,groupid));
			siteviewecc.setMonitors(EccInterface.getMonitor(user, groupid, map.get(StaticPam.type)));
			siteviewecc.setMachines(EccInterface.getMachine(user, groupid));
			return _key_+StaticPam._good+JSONObject.fromObject(siteviewecc).toString();
		}
		return _key_+StaticPam._error+StaticPam.error_nologin;
	}
}
