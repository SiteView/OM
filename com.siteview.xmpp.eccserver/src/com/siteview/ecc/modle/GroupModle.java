package com.siteview.ecc.modle;
/**
 * @author lihua.zhong
 * groupparent 父组id
 * groupid  组id
 * groupname 组名
 * groupdes 组描述
 * status 状态
 * 监测器组
 */
public class GroupModle {
	private String groupparent;
	private String groupid;
	private String groupname;
	private String groupdes;
	private String status;
	private String lastmoddatetime;
	public String getGroupparent() {
		return groupparent;
	}
	public void setGroupparent(String groupparent) {
		this.groupparent = groupparent;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGroupdes() {
		return groupdes;
	}
	public void setGroupdes(String groupdes) {
		this.groupdes = groupdes;
	}
	public String getLastmoddatetime() {
		return lastmoddatetime;
	}
	public void setLastmoddatetime(String lastmoddatetime) {
		this.lastmoddatetime = lastmoddatetime;
	}
}
