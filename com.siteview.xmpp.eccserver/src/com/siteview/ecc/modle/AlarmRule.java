package com.siteview.ecc.modle;

import java.util.List;

public class AlarmRule {
	private String alarmName;//��������
	private String alarmType;//��������
	private String alarmEvent;//����״̬
	private String ruleStatus;//��������״̬
	private String recid;//��������id
	private List<MonitorModle> monitors;
	public String getAlarmName() {
		return alarmName;
	}
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmEvent() {
		return alarmEvent;
	}
	public void setAlarmEvent(String alarmEvent) {
		this.alarmEvent = alarmEvent;
	}
	public String getRuleStatus() {
		return ruleStatus;
	}
	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	public String getRecid() {
		return recid;
	}
	public void setRecid(String recid) {
		this.recid = recid;
	}
	public List<MonitorModle> getMonitors() {
		return monitors;
	}
	public void setMonitors(List<MonitorModle> monitors) {
		this.monitors = monitors;
	}
	
}
