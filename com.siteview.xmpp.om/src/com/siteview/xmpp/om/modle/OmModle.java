package com.siteview.xmpp.om.modle;

import java.util.List;

public class OmModle {
	private List<UserInfo> users;
	private List<Incident> incs;
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
	public List<Incident> getIncs() {
		return incs;
	}
	public void setIncs(List<Incident> incs) {
		this.incs = incs;
	}
}
