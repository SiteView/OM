package com.siteview.xmpp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smackx.filetransfer.FileTransfer;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;
public class XMPPAccountManager {
	/*
	 * ��������
	 */
	public static XMPPConnection getConnection(String id,int port) throws XMPPException{
		ConnectionConfiguration config = new ConnectionConfiguration(id, port);
//		config.setSecurityMode(Se);
		/** �Ƿ����ð�ȫ��֤ */
		config.setSASLAuthenticationEnabled(false);
//		/** �Ƿ����õ��� */
		config.setDebuggerEnabled(true);
		return new XMPPConnection(config);
	}
	/*
	 * �����˻�
	 */
	public static boolean createAccount(XMPPConnection connection,String regUserName,String regUserPwd){
		try {
			connection.getAccountManager().createAccount(regUserName, regUserPwd);
			return true;
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * ɾ���û�
	 */
	public static boolean deleteAccount(XMPPConnection connection){
		try {
			connection.getAccountManager().deleteAccount();
			return true;
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * �޸�����
	 */
	public static boolean changePassword(XMPPConnection connection,String pwd){
		try {
			connection.getAccountManager().changePassword(pwd);
			return true;
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * ����������
	 */
	public static List<RosterGroup> getGroups(Roster roster){
		List<RosterGroup> groupsList=new ArrayList<RosterGroup>();
//		Collection<RosterGroup> rosterGroup=roster.getGroups();
		Iterator<RosterGroup> i=roster.getGroups();
		while(i.hasNext())
			groupsList.add(i.next());
		return groupsList;
	}
	/*
	 * ������Ӧ����������г�Ա
	 */
	public static List<RosterEntry> getEntriesByGroup(Roster roster,String groupName){
		List<RosterEntry> EntriesList=new ArrayList<RosterEntry>();
		RosterGroup rosterGroup=roster.getGroup(groupName);
//		Collection<RosterEntry> rosterEntry=rosterGroup.getEntries();
		Iterator<RosterEntry> i=rosterGroup.getEntries();
		while(i.hasNext())
			EntriesList.add(i.next());
		return EntriesList;
	}
	/*
	 * ���������û���Ϣ
	 */
	public static List<RosterEntry> getAllEntries(Roster roster){
		List<RosterEntry> EntriesList = new ArrayList<RosterEntry>(); 
//		Collection<RosterEntry> rosterEntry = roster.getEntries();
		Iterator<RosterEntry> i = roster.getEntries(); 
		while (i.hasNext()) 
			 EntriesList.add(i.next()); 
		 return EntriesList;
	}
	/*
	 * ���ͺ�������
	 */
	public static void createEntry(XMPPConnection connection,String user,String nickName) throws XMPPException{
		  Roster roster = connection.getRoster();  
	      roster.createEntry(user, nickName, null);  
	}
	/*
	 * �����ļ�
	 */
//	  public static void sendFile(String user,java.io.File file,XMPPConnection connection )  throws Exception{
//	        FileTransferManager manager = new FileTransferManager(connection);
//	        OutgoingFileTransfer transfer = manager.createOutgoingFileTransfer(user);
//	        long timeOut = 1000000;
//	        long sleepMin = 3000;
//	        long spTime = 0;
//	        int rs = 0;  
//	            transfer.sendFile(file, "pls re file!");
//	            rs = transfer.getStatus().compareTo(org.jivesoftware.smackx.filetransfer.FileTransfer.Status.COMPLETE);
//	            while(rs!=0){
//	                rs = transfer.getStatus().compareTo(FileTransfer.Status.COMPLETE);
//	                 spTime = spTime + sleepMin;
//	                 if(spTime>timeOut){return ;}
//	                Thread.sleep(sleepMin);
//	             }
//	  }
	public static void main(String[] args) throws XMPPException {
//		/** ����connection���� */
//		Connection connection = getConnection("127.0.0.1",5222);
//		/** �������� */
//		connection.connect();
//		/** ��¼ */
//		connection.login("zhonglihua", "siteview1");
//		connection.getChatManager().addChatListener(new ChatManagerListener() {
//			public void chatCreated(Chat arg0, boolean arg1) {
//				if(!arg1){
//					try {
//						arg0.sendMessage("i name is zhonglihua");
//					} catch (XMPPException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
		final XMPPActivator xmppa=new XMPPActivator();
		xmppa.init();
//		XMPPActivator.setStatus(true, "Activati",xmppa.connection);
		
//		  try {
//			   final String cmd="wmic /namespace:\\\\root\\WMI path MSAcpi_ThermalZoneTemperature get CurrentTemperature";
//			   Process p = Runtime.getRuntime().exec(cmd);
//			   p.getOutputStream().close();//��䲻д�Ͳ�ִ��   
//			   Scanner sc=new Scanner(p.getInputStream());
//			   sc.next();
//			   float t=(sc.nextInt()-2732f)/10f;
//			   sc.close();
//			   System.out.println("��ǰCPU�¶�:"+t);
//			   p.waitFor();
//			  } catch (Exception e) {
//			   e.printStackTrace();
//			  }
//		xmppa.connection.addPacketListener(new PacketListener() {
//			public void processPacket(Packet arg0) {
//				
//			}
//		}, new PacketFilter() {
//			public boolean accept(Packet arg0) {
//				System.out.println(arg0.getPacketID()+"----xmls");
//				if(arg0 instanceof Message){
//					Message message=(Message) arg0;
//					System.out.println(message.getBody());
//				}else if(arg0 instanceof StreamInitiation){
//					StreamInitiation stream=(StreamInitiation) arg0;
//					System.out.println(stream.toXML());
//				}
//				System.out.println(arg0.getClass());
//				return false;
//			}
//		});
//		xmppa.connection.getChatManager().addChatListener(new ChatManagerListener() {
//			public void chatCreated(Chat chat, boolean arg1) {
//				if(!arg1){
//					chat.addMessageListener(xmppa.messageListener);
//				}
//			}
//		});
//		xmppa.connection.disconnect();
	}
	
	public static Packet setMessage(String user){
		Packet packet=new Message();
//		packet.setDefaultXmlns("hello,i'm here");
		packet.setTo(user);
		return packet;
	}
}
