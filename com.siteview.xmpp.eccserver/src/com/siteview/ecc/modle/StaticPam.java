package com.siteview.ecc.modle;
/**
 * 
 * @author liahua.zhong
 * xmpp交互参数定义  、Ecc表/字段 定义
 */
public class StaticPam {
	public static String _good="0000:";//xmpp返回正常状态
	public static String _error="0001:";//xmpp返回错误
	public static String error_login="error_user_password";//用户名或者密码错误
	public static String error_key="error_request";//请求错误
	public static String error_nologin="not_login";//没有登录
	
	public static String username="user";//xmpp_用户id
	public static String password="pwd";//xmpp_用户密码
	public static String parentid="parentid";//xmpp_父组id
	public static String type="type";
	
	public static String good_longin="";
	
	public static String groupname="groupname";//xmpp_组名
	public static String groupid="groupid";//xmpp_组id
	public static String machineip="machineip";//xmpp_设备ip
	public static String machineid="machineid";//xmpp_设备id
	
	public static String monitorid="monitorid";//xmpp_监测器id
	public static String monitortype="monitortype";//xmpp_监测器类型
	
	public static String monitormessage="monitormessage";//xmpp_监测器日志
	public static String monitorstatus="monitorstatus";//xmpp_监测器状态
	public static String monitortitle="monitortitle";//xmpp_监测器标题
	
	
	public static String bo_id="RecId";//业务对象id
	public static String ecc_table_Per="Permissions";//权限表格
	public static String ecc_table_Per_UserId="UserId";//权限表格用户id
	public static String ecc_table_Per_PerType="PermissionsType";//权限类型(Group/Machine/Monitor)
	
	public static String ecc_table_group="EccGroup";//组
	public static String ecc_table_group_par="ParentGroupId";//父组id
	public static String ecc_table_group_groupname="GroupName";//组名
	public static String ecc_table_group_groupdes="Description";//组描述
	
	public static String ecc_table_eccdyn="EccDyn";//临时状态表
	public static String ecc_table_eccdyn_category="category";//状态值
	public static String ecc_table_eccdyn_groupid="groupid";//临时表中组id
	public static String ecc_table_eccdyn_monitorid="monitorid";//临时表中监测器id
	
	public static String ecc_table_machine="RemoteMachine";//设备
	public static String ecc_table_machine_ip="ServerAddress";//设备ip
	public static String ecc_table_machine_group="Groups";//设备的组id
	public static String ecc_table_machine_title="Title";//设备的标题
	
	public static String ecc_table_monitor="EccMonitor";//监测器
	public static String ecc_table_monitor_type="EccMonitorType";//监测器类型
	public static String ecc_table_monitor_group="Groups";//监测器组id
	public static String ecc_table_monitor_machine="Machine";//监测器的设备id
	public static String ecc_table_monitor_title="Title";//监测器标题；
	
	public static String ecc_table_monitorlog="MonitorLog";//监测器日志
	public static String ecc_table_monitorlog_monitorid="MonitorId";//监测器日志的监测器id
	public static String ecc_table_monitorlog_monitortitle="MonitorName";//监测器日志中监测器标题
	public static String ecc_table_monitorlog_status="MonitorStatus";//监测器日志的状态
	public static String ecc_table_monitorlog_massage="MonitorMassage";//监测器日志信息
	public static String ecc_table_monitorlog_createdata="CreatedDateTime";//创建
	public static String ecc_table_monitorlog_groupid="ownerID";//
	
}
