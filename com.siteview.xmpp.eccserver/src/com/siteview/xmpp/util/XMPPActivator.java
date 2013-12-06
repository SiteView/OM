package com.siteview.xmpp.util;

import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.SSLXMPPConnection;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;

public class XMPPActivator extends Thread{
	static String id = "xmpp.siteview.com";
	static int port = 5223;
//	static String userName = "redirector";
	public static String userName = "eccdemo";
	static String userPwd = "siteview";
	public static XMPPConnection connection;
	public static PacketFilter messagefilter;
	public static PacketListener messageListener;
	public RecFileTransferListener fileTransferListener;
	public void run() {
		final XMPPActivator xmppa=new XMPPActivator();
		try {
			xmppa.init();
		} catch (XMPPException e) {
			e.printStackTrace();
		}
//		XMPPActivator.setStatus(true, "Activati",connection);
	}
	public void init() throws XMPPException {
		XMPPConnection con = new SSLXMPPConnection(id, port);
		con.login(userName, userPwd);
		connection = con;
		if(connection==null){
			try {
				this.wait(10000);
				init();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		messageListener = new MyMessageListener(connection);
		messagefilter=new PacketTypeFilter(Message.class);
		fileTransferListener=new RecFileTransferListener();
		FileTransferManager transferManager = new FileTransferManager(connection);
		transferManager.addFileTransferListener(fileTransferListener);
		connection.addPacketListener(messageListener, messagefilter);
		connection.addConnectionListener(new ConnectionListener() {
			public void connectionClosedOnError(Exception arg0) {
				final XMPPActivator xmppa=new XMPPActivator();
				try {
//					FileTool.setlogfile("RouterKeyFile/logfile",  Convert.ToDateString(new Date())+":"+"自动登录");
					xmppa.init();
				} catch (XMPPException e) {
					e.printStackTrace();
				}
//				XMPPActivator.setStatus(true, "Activati",connection);
			}
			
			public void connectionClosed() {
				final XMPPActivator xmppa=new XMPPActivator();
				try {
					xmppa.init();
//					FileTool.setlogfile("RouterKeyFile/logfile",  Convert.ToDateString(new Date())+":"+"自动登录");
				} catch (XMPPException e) {
					e.printStackTrace();
				}
//				XMPPActivator.setStatus(true, "Activati",connection);
			}
		});
	}
	/*
	 * 设置自己的状态
	 */
	public static void setStatus(boolean available, String status,
			XMPPConnection connection) {
		Presence.Type type = available ? Type.AVAILABLE : Type.UNAVAILABLE;
		Presence presence = new Presence(type);
		presence.setStatus(status);
		connection.sendPacket(presence);
	}
//	public static void getMonitorFormVpn(Instance ins){
//		final String instanceid=ins.getInstanceId();
//		getMonitorFormVpn(instanceid);
//	}
//	
//	public static void getMonitorFormVpn(String instanceid){
//		 if(connection==null||!connection.isConnected()){
//			 final XMPPActivator xmppa=new XMPPActivator();
//				try {
//					xmppa.init();
//				} catch (XMPPException e) {
//					e.printStackTrace();
//				}
////				XMPPActivator.setStatus(true, "Activati",connection);
//		 }
//         Chat newChat = connection.createChat(instanceid+"@"+id+"/vpnserver");
//         try {
//			newChat.sendMessage("get_vpnserverinfo:");
//		} catch (XMPPException e) {
//			e.printStackTrace();
//		}
//	 }
	public static void getAccess(){
		
	}
}
