package com.siteview.ecc.modle;
/**
 * 
 * @author liahua.zhong
 * xmpp������������  ��Ecc��/�ֶ� ����
 */
public class StaticPam {
	public static String _good="0000:";//xmpp��������״̬
	public static String _error="0001:";//xmpp���ش���
	public static String error_login="error_user_password";//�û��������������
	public static String error_key="error_request";//�������
	public static String error_nologin="not_login";//û�е�¼
	
	public static String username="user";//xmpp_�û�id
	public static String password="pwd";//xmpp_�û�����
	public static String parentid="parentid";//xmpp_����id
	public static String type="type";
	
	public static String good_longin="";
	
	public static String groupname="groupname";//xmpp_����
	public static String groupid="groupid";//xmpp_��id
	public static String machineip="machineip";//xmpp_�豸ip
	public static String machineid="machineid";//xmpp_�豸id
	
	public static String monitorid="monitorid";//xmpp_�����id
	public static String monitortype="monitortype";//xmpp_���������
	
	public static String monitormessage="monitormessage";//xmpp_�������־
	public static String monitorstatus="monitorstatus";//xmpp_�����״̬
	public static String monitortitle="monitortitle";//xmpp_���������
	
	
	public static String bo_id="RecId";//ҵ�����id
	public static String ecc_table_Per="Permissions";//Ȩ�ޱ��
	public static String ecc_table_Per_UserId="UserId";//Ȩ�ޱ���û�id
	public static String ecc_table_Per_PerType="PermissionsType";//Ȩ������(Group/Machine/Monitor)
	
	public static String ecc_table_group="EccGroup";//��
	public static String ecc_table_group_par="ParentGroupId";//����id
	public static String ecc_table_group_groupname="GroupName";//����
	public static String ecc_table_group_groupdes="Description";//������
	
	public static String ecc_table_eccdyn="EccDyn";//��ʱ״̬��
	public static String ecc_table_eccdyn_category="category";//״ֵ̬
	public static String ecc_table_eccdyn_groupid="groupid";//��ʱ������id
	public static String ecc_table_eccdyn_monitorid="monitorid";//��ʱ���м����id
	
	public static String ecc_table_machine="RemoteMachine";//�豸
	public static String ecc_table_machine_ip="ServerAddress";//�豸ip
	public static String ecc_table_machine_group="Groups";//�豸����id
	public static String ecc_table_machine_title="Title";//�豸�ı���
	
	public static String ecc_table_monitor="EccMonitor";//�����
	public static String ecc_table_monitor_type="EccMonitorType";//���������
	public static String ecc_table_monitor_group="Groups";//�������id
	public static String ecc_table_monitor_machine="Machine";//��������豸id
	public static String ecc_table_monitor_title="Title";//��������⣻
	
	public static String ecc_table_monitorlog="MonitorLog";//�������־
	public static String ecc_table_monitorlog_monitorid="MonitorId";//�������־�ļ����id
	public static String ecc_table_monitorlog_monitortitle="MonitorName";//�������־�м��������
	public static String ecc_table_monitorlog_status="MonitorStatus";//�������־��״̬
	public static String ecc_table_monitorlog_massage="MonitorMassage";//�������־��Ϣ
	public static String ecc_table_monitorlog_createdata="CreatedDateTime";//����
	public static String ecc_table_monitorlog_groupid="ownerID";//
	
}
