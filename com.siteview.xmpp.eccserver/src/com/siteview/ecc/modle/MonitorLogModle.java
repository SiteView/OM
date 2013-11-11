package com.siteview.ecc.modle;
/**
 *@author lihua.zhong
 *message 监测器返回值
 *monitorid 监测器id
 *monitortitle 监测器标题
 *groupid 监测组id
 *createdata 创建时间
 */
public class MonitorLogModle {
	private String status;
	private String message;
	private String monitorid;
	private String monitortitle;
	private String groupid;
	private String createData;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMonitorid() {
		return monitorid;
	}
	public void setMonitorid(String monitorid) {
		this.monitorid = monitorid;
	}
	public String getMonitortitle() {
		return monitortitle;
	}
	public void setMonitortitle(String monitortitle) {
		this.monitortitle = monitortitle;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getCreateData() {
		return createData;
	}
	public void setCreateData(String createData) {
		this.createData = createData;
	}
}
