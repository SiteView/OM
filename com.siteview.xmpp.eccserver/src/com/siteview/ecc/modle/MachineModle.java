package com.siteview.ecc.modle;
/**
 * @author lihua.zhong
 * groupid �豸��id
 * machineid  �豸id
 * machineip �豸ip
 * machinetitle �豸����
 * status ״̬
 * ������豸
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
