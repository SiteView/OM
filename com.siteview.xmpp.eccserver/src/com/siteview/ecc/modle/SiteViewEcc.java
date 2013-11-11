package com.siteview.ecc.modle;

import java.util.List;

public class SiteViewEcc {
	public List<GroupModle> groups;
	public List<MachineModle> machines;
	public List<MonitorModle> monitors;
	public List<MonitorLogModle> monitorlogs;
	public List<MonitorLogModle> getMonitorlogs() {
		return monitorlogs;
	}
	public void setMonitorlogs(List<MonitorLogModle> monitorlogs) {
		this.monitorlogs = monitorlogs;
	}
	public List<GroupModle> getGroups() {
		return groups;
	}
	public void setGroups(List<GroupModle> groups) {
		this.groups = groups;
	}
	public List<MachineModle> getMachines() {
		return machines;
	}
	public void setMachines(List<MachineModle> machines) {
		this.machines = machines;
	}
	public List<MonitorModle> getMonitors() {
		return monitors;
	}
	public void setMonitors(List<MonitorModle> monitors) {
		this.monitors = monitors;
	}
}
