package com.siteview.ecc.modle;
/**
 * @author lihua.zhong
 * monitorid 监测器id
 * monitortype  监测器类型
 * machineid 设备ip
 * monitortitle 监测器标题
 * groupid 组id
 * status 状态
 * 监测器设备
 */
public class MonitorModle {
	private String monitorid;
	private String monitortype;
	private String monitortitle;
	private String machineid;
	private String groupid;
	private String status;
	private String des;
	public String getMonitorid() {
		return monitorid;
	}
	public void setMonitorid(String monitorid) {
		this.monitorid = monitorid;
	}
	public String getMonitortype() {
		return monitortype;
	}
	public void setMonitortype(String monitortype) {
		this.monitortype = monitortype;
	}
	public String getMonitortitle() {
		return monitortitle;
	}
	public void setMonitortitle(String monitortitle) {
		this.monitortitle = monitortitle;
	}
	public String getMachineid() {
		return machineid;
	}
	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
}
