package com.siteview.ecc.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Siteview.SiteviewException;

public class EccServer {
	public String update(String from,String body)throws SiteviewException{
		return "";
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
