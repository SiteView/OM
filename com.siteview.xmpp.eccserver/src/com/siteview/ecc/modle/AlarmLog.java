package com.siteview.ecc.modle;

public class AlarmLog {
	private String alarmruleid;
	private String monitorid;//报警监测器id
	private String alarmname;//报警名称
	private String alarmtime;//报警时间
	private String monitortitle;//报警监测器标题
	private String alarmtype;//报警类型
	private String address;//发送地址
	private String alarmstatus;//报警状态
	public String getAlarmruleid() {
		return alarmruleid;
	}
	public void setAlarmruleid(String alarmruleid) {
		this.alarmruleid = alarmruleid;
	}
	public String getMonitorid() {
		return monitorid;
	}
	public void setMonitorid(String monitorid) {
		this.monitorid = monitorid;
	}
	public String getAlarmname() {
		return alarmname;
	}
	public void setAlarmname(String alarmname) {
		this.alarmname = alarmname;
	}
	public String getAlarmtime() {
		return alarmtime;
	}
	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}
	public String getMonitortitle() {
		return monitortitle;
	}
	public void setMonitortitle(String monitortitle) {
		this.monitortitle = monitortitle;
	}
	public String getAlarmtype() {
		return alarmtype;
	}
	public void setAlarmtype(String alarmtype) {
		this.alarmtype = alarmtype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAlarmstatus() {
		return alarmstatus;
	}
	public void setAlarmstatus(String alarmstatus) {
		this.alarmstatus = alarmstatus;
	}
	
}
