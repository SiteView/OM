package com.siteview.ecc.modle;
/**
 *@author lihua.zhong
 *message ���������ֵ
 *monitorid �����id
 *monitortitle ���������
 *groupid �����id
 *createdata ����ʱ��
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
