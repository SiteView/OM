package com.siteview.ecc.modle;
/**
 * @author lihua.zhong
 * groupid 设备组id
 * machineid  设备id
 * machineip 设备ip
 * machinetitle 设备标题
 * status 状态
 * 监测器设备
 */
public class MachineModle {
	private String machineid;
	private String machineip;
	private String machinetitle;
	private String groupid;
	private String status;
	private String lastmoddatetime;
	public String getMachineid() {
		return machineid;
	}
	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}
	public String getMachineip() {
		return machineip;
	}
	public void setMachineip(String machineip) {
		this.machineip = machineip;
	}
	public String getMachinetitle() {
		return machinetitle;
	}
	public void setMachinetitle(String machinetitle) {
		this.machinetitle = machinetitle;
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
	public String getLastmoddatetime() {
		return lastmoddatetime;
	}
	public void setLastmoddatetime(String lastmoddatetime) {
		this.lastmoddatetime = lastmoddatetime;
	}
	
}
