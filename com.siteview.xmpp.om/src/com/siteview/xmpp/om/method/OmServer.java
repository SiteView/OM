package com.siteview.xmpp.om.method;

import java.util.List;
import java.util.Map;

import Siteview.SiteviewException;
/**
 * @author lihua.zhong
 * @param from
 * @param substring
 * @return
 */
public class OmServer {
	public String update(String from, String substring) throws SiteviewException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isKeygood(String body,List<String> list,Map<String,String> map){
		String[] s0=body.split(";");
		for(String s1:s0){
			String key=s1.substring(0,s1.indexOf("="));
			String value=s1.substring(s1.indexOf("=")+1);
			map.put(key, value);
		}
		for(String s:list){
			if(map.get(s)==null){
				return false;
			}
		}
		return true;
	}
}
