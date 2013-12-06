package com.siteview.ecc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.siteview.ecc.modle.AlarmLog;
import com.siteview.ecc.modle.AlarmRule;
import com.siteview.ecc.modle.EccAlarm;
import com.siteview.ecc.modle.GroupModle;
import com.siteview.ecc.modle.MachineModle;
import com.siteview.ecc.modle.MonitorLogModle;
import com.siteview.ecc.modle.MonitorModle;
import com.siteview.ecc.modle.StaticPam;

import Siteview.SiteviewException;
import Siteview.Api.BusinessObject;

public class EccInterface {
	/**
	 * 
	 * @param userid   用户名，
	 * @param parentid 父组id
	 * @return 所有有权限的组名+id集合 
	 * @throws SiteviewException 
	 */
	public static List<String> status=new ArrayList<String>();
	static{
		status.add("error");
		status.add("warning");
		status.add("nodata");
		status.add("disable");
		status.add("good");
	}
	
	public static List<GroupModle> getGroup(String userid,String parentid) throws SiteviewException{
		List<GroupModle> groups=new ArrayList<GroupModle>();
		List<String> per=new ArrayList<String>();
		boolean flag=true;
		if(!UserInfor.superuser.contains(userid)){
			getPermissions(userid, "Group",per);
			flag=false;
		}
		Collection col=EccApiUtil.getBussCollection(StaticPam.ecc_table_group_par, parentid, StaticPam.ecc_table_group);
		Iterator   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=(BusinessObject) ite.next();
			String id=bo.get_RecId();
			if(!flag){
				flag=per.contains(id);
			}
			if(!flag)
				continue;
			GroupModle group=new GroupModle();
			group.setGroupid(id);
			group.setGroupdes(bo.GetField(StaticPam.ecc_table_group_groupdes).get_NativeValue().toString());
			group.setGroupname(bo.GetField(StaticPam.ecc_table_group_groupname).get_NativeValue().toString());
			group.setGroupparent("");
			
			Collection<BusinessObject> bodny=EccApiUtil.getBussCollection(StaticPam.ecc_table_eccdyn_groupid, id, StaticPam.ecc_table_eccdyn);
			Iterator<BusinessObject> itedyn=bodny.iterator();
			int [] categorys=new int[5];//error,warning,nodata,disable,good
			while(itedyn.hasNext()){
				BusinessObject dyn=itedyn.next();
				String category=dyn.GetField(StaticPam.ecc_table_eccdyn_category).get_NativeValue().toString();
				categorys[status.indexOf(category)]++;
			}
			group.setStatus(status.get(getstatus(categorys)));
			groups.add(group);
		}
		return groups;
	}
	public static int getstatus(int[] status){
		for(int i=0;i<status.length;i++){
			if(status[i]>0)
				return i;
		}
		return 3;
	}
	
	/**
	 * 
	 * @param userid 用户id
	 * @param groupid 组id
	 * @return 该用户在此组下所有有权限的监测器
	 * @throws SiteviewException 
	 */
	public static List<MonitorModle> getMonitor(String userid,String parentid,String type) throws SiteviewException{
		List<MonitorModle> monitors=new ArrayList<MonitorModle>();
		StringBuffer machine=new StringBuffer();
		List<String> per=new ArrayList<String>();
		boolean flag=true;
		if(!UserInfor.superuser.contains(userid)){
			getPermissions(userid, "Monitor",per);
			flag=false;
		}
		String parm=StaticPam.ecc_table_monitor_group;
		if(type.equals("Machine")){
			parm=StaticPam.ecc_table_monitor_machine;
		}

		Map<String,String> map=new HashMap<String,String>();
		Collection coldyn=EccApiUtil.getBussCollection(StaticPam.ecc_table_eccdyn);
		Iterator   itedyn=coldyn.iterator();
		while(itedyn.hasNext()){
			BusinessObject dyn=(BusinessObject) itedyn.next();
			String category=dyn.GetField(StaticPam.ecc_table_eccdyn_category).get_NativeValue().toString();
			String monitorid=dyn.GetField(StaticPam.ecc_table_eccdyn_monitorid).get_NativeValue().toString();
			map.put(monitorid, category);
		}
		
		Collection col=EccApiUtil.getBussCollection(parm, parentid, StaticPam.ecc_table_monitor);
		Iterator   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=(BusinessObject) ite.next();
			String id=bo.get_RecId();
			String machineid=bo.GetField(StaticPam.ecc_table_monitor_machine).get_NativeValue().toString();
			if(!flag){
				flag=per.contains(id);
			}
			if(!flag)
				continue;
			if(type.equals("Group")&&machineid.length()==32)
				continue;
			MonitorModle monitor=new MonitorModle();
			monitor.setGroupid(bo.GetField(StaticPam.ecc_table_monitor_group).get_NativeValue().toString());
			monitor.setMachineid(machineid);
			monitor.setMonitorid(id);
			monitor.setMonitortitle(bo.GetField(StaticPam.ecc_table_monitor_title).get_NativeValue().toString());
			monitor.setMonitortype(bo.get_Alias());
			monitor.setStatus(map.get(id)==null?map.get(id):"nodata");
			monitors.add(monitor);
		}
		return monitors;
	}
	
	/**
	 * @param userid  用户id
	 * @param groupid 组id
	 * @return 该用户在此组下所有有权限的设备
	 * @throws SiteviewException
	 */
	public static List<MachineModle> getMachine(String userid,String groupid) throws SiteviewException{
		List<MachineModle> machines=new ArrayList<MachineModle>();
		List<String> per=new ArrayList<String>();
		boolean flag=true;
		if(!UserInfor.superuser.contains(userid)){
			getPermissions(userid, "Machine",per);
			flag=false;
		}
		Collection col=EccApiUtil.getBussCollection(StaticPam.ecc_table_machine_group, groupid, StaticPam.ecc_table_machine);
		Iterator   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=(BusinessObject) ite.next();
			String id=bo.get_RecId();
			if(!bo.get_Name().equalsIgnoreCase("RemoteMachine.Unix")&&!bo.get_Name().equalsIgnoreCase("RemoteMachine.Windows"))
				continue;
			if(!flag){
				flag=per.contains(id);
			}
			if(!flag)
				continue;
			MachineModle machinemodle=new MachineModle();
			machinemodle.setGroupid(groupid);
			machinemodle.setMachineid(id);
			machinemodle.setMachineip(bo.GetField(StaticPam.ecc_table_machine_ip).get_NativeValue().toString());
			machinemodle.setMachinetitle(bo.GetField(StaticPam.ecc_table_machine_title).get_NativeValue().toString());
			machinemodle.setStatus("");
			machines.add(machinemodle);
		}
		return machines;
	}
	
	/**
	 * 
	 * @param monitorid 监测器id
	 * @return 返回监测器日志
	 * @throws SiteviewException 
	 */
	public static List<MonitorLogModle> getMonitorLog(String monitorid) throws SiteviewException{
		List<MonitorLogModle> monitorlogs=new ArrayList<MonitorLogModle>();
		Collection col=EccApiUtil.getBussCollection(StaticPam.ecc_table_monitorlog_monitorid, monitorid, StaticPam.ecc_table_monitorlog);
		Iterator   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=(BusinessObject) ite.next();
			String id=bo.get_RecId();
			MonitorLogModle monitorlog=new MonitorLogModle();
			monitorlog.setGroupid(bo.GetField(StaticPam.ecc_table_monitorlog_groupid).get_NativeValue().toString());
			monitorlog.setMessage(bo.GetField(StaticPam.ecc_table_monitorlog_massage).get_NativeValue().toString());
			monitorlog.setMonitorid(monitorid);
			monitorlog.setMonitortitle(bo.GetField(StaticPam.ecc_table_monitorlog_monitortitle).get_NativeValue().toString());
			monitorlog.setStatus(bo.GetField(StaticPam.ecc_table_monitorlog_status).get_NativeValue().toString());
			monitorlog.setCreateData(bo.GetField(StaticPam.ecc_table_monitorlog_createdata).get_NativeValue().toString());
			monitorlogs.add(monitorlog);
		}
		return monitorlogs;
	}	
	/**
	 * @param userId 用户id
	 * @param type   要取的权限类型
	 * @return 该用户的权限
	 * @throws SiteviewException
	 */
	public static List<String> getPermissions(String userId,String type,List<String> permissions) throws SiteviewException{
		
		Map<String,String> map=new HashMap<String,String>();
		map.put(StaticPam.ecc_table_Per_UserId, userId);
		map.put(StaticPam.ecc_table_Per_PerType, type);
		
		Collection ico=EccApiUtil.getBussCollection(map, StaticPam.ecc_table_Per);
		Iterator ienum=ico.iterator();
		while(ienum.hasNext()){
			BusinessObject bo=(BusinessObject) ienum.next();
			permissions.add(bo.GetField("PermissionsId").get_NativeValue().toString());
		}
		return permissions;
	}
	/**
	 * @param userid  用户id
	 * @return 返回EccAlarm
	 * @throws SiteviewException
	 */
	public static List<AlarmRule> getAlarmRule(String userid) throws SiteviewException{
		List<AlarmRule> alarms=new ArrayList<AlarmRule>();
		boolean flag=true;
		if(!UserInfor.superuser.contains(userid)){
			flag=false;
		}
		Collection<BusinessObject> col=EccApiUtil.getBussCollection(StaticPam.ecc_table_EccAlarmRule);
		Iterator<BusinessObject>   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=ite.next();
			AlarmRule alarm=new AlarmRule();
			alarm.setAlarmEvent(bo.GetField(StaticPam.ecc_table_EccAlarmRul_AlarmEvent).get_NativeValue().toString());
			alarm.setAlarmName(bo.GetField(StaticPam.ecc_table_EccAlarmRul_AlarmName).get_NativeValue().toString());
			alarm.setAlarmType(bo.GetField(StaticPam.ecc_table_EccAlarmRul_AlarmType).get_NativeValue().toString());
			alarm.setRuleStatus(bo.GetField(StaticPam.ecc_table_EccAlarmRul_RuleStatus).get_NativeValue().toString());
			alarm.setRecid(bo.get_RecId());
			alarms.add(alarm);
		}
		return alarms;
	}
	
	/**
	 * @param userid  用户id
	 * @return 返回EccAlarm
	 * @throws SiteviewException
	 */
	public static List<AlarmLog> getAlarmLog(String userid,String alarmlog) throws SiteviewException{
		List<AlarmLog> alarms=new ArrayList<AlarmLog>();
		boolean flag=true;
		if(!UserInfor.superuser.contains(userid)){
			flag=false;
		}
		Collection<BusinessObject> col=EccApiUtil.getBussCollection(StaticPam.ecc_table_EccAlarmRule);
		Iterator<BusinessObject>   ite=col.iterator();
		while(ite.hasNext()){
			BusinessObject bo=ite.next();
			AlarmLog alarm=new AlarmLog();
			alarm.setAlarmname(bo.GetField(StaticPam.ecc_table_EccAlarmRul_AlarmName).get_NativeValue().toString());
			alarm.setAlarmtype(bo.GetField(StaticPam.ecc_table_EccAlarmRul_AlarmType).get_NativeValue().toString());
			alarm.setAlarmstatus(bo.GetField(StaticPam.ecc_table_EccAlarmRul_RuleStatus).get_NativeValue().toString());
			alarm.setAddress("");
			alarm.setAlarmtime("");
			alarm.setMonitorid("");
			alarm.setMonitortitle("");
			alarms.add(alarm);
		}
		return alarms;
	}
}
