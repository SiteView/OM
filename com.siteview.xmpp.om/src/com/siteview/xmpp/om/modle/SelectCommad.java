package com.siteview.xmpp.om.modle;

import java.util.List;
import java.util.Map;

public class SelectCommad {
	private Map<String,List<String>> category;
	private List<String> type;
	
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}
	public Map<String, List<String>> getCategory() {
		return category;
	}
	public void setCategory(Map<String, List<String>> category) {
		this.category = category;
	}
	
}
