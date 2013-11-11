package com.siteview.ecc.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Siteview.SiteviewException;
import com.siteview.ecc.modle.StaticPam;
import com.siteview.ecc.util.EccInterface;

/**
 * @author lihua.zhong
 * 获取子组、监测器、设备列表
 */
public class GetGroup extends EccServer{
	private static String _key_="get_user:";//get_subgroup:user={username},parentid={parentid}
	private static List<String> _keys=new ArrayList<String>();
	
	static{
		_keys.add(StaticPam.username);
		_keys.add(StaticPam.parentid);
	}
	
	public String update(String from,String body) throws SiteviewException{
		Map<String,String> map=new	HashMap<String,String>();
		//错误请求
		if(!isKeygood(body,_keys,map))
			return _key_+StaticPam.error_key;
		
		String user=map.get(StaticPam.username);
		String parentid=map.get(StaticPam.parentid);
		
		return _key_+EccInterface.getGroup(user, parentid);
	}
}
