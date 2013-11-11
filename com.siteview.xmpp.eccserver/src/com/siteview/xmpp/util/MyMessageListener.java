package com.siteview.xmpp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;

import com.siteview.ecc.server.EccServer;
public class MyMessageListener implements PacketListener{
	public static Properties prop = null;
	public static String form=XMPPActivator.userName+"@xmpp.siteview.com/MiddServer";
	public static XMPPConnection connection;
	public MyMessageListener(XMPPConnection connection) {
		this.connection=connection;
	}
	
	public void processPacket(Packet arg0) {
		final Message message=(Message) arg0;
		new Thread() {
			public void run() {
				Message m=new Message();
				try{
					String packetId=message.getPacketID();
					String s=message.getBody();
					System.out.println("from:--"+message.getPacketID()+"---"+message.getBody());
					if(s==null)return;
					m.setFrom(form);
					m.setPacketID(packetId);
					m.setTo(message.getFrom());
					m.setType(Message.Type.CHAT);
					if(!s.contains(":")){
						m.setBody("error:format");
					}else{
						String key=s.substring(0,s.indexOf(":")).trim();
						String value=FileTool.getReturnStr(FileTool.getRoot()+"src/key_value.properties", key);
						EccServer class1=(EccServer) Class.forName(value).newInstance();
						String body=class1.update(message.getFrom(),s.substring(s.indexOf(":")+1));
						m.setBody(body);
					connection.sendPacket(m);
					System.out.println("send:--"+m.getPacketID()+"---"+m.getBody());
					}
				}catch (Exception e) {
//					m.setBody(EccServer.error_unknowerror);
					System.out.println("send:--"+m.getPacketID()+"---"+m.getBody());
					connection.sendPacket(m);
				}
			}
		}.start();
	}
	
	public static String getReturnStr(String filePath, String parm) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			prop = new Properties();
			prop.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(parm);
	}
	
	public static String getRoot(){
		 String path=null;
		  try {
		    path = FileLocator.toFileURL(Platform.getBundle("com.siteview.awsControl").getEntry("")).getPath();
		    path = path.substring(path.indexOf("/") + 1, path.length());
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return path+"/src";
	}
	/*
	 * ´«ÊäÎÄ¼þ
	 */
	public static void sendFile(String user, java.io.File file,
			XMPPConnection connection) throws Exception {
		FileTransferManager manager = new FileTransferManager(connection);
		OutgoingFileTransfer transfer = manager
				.createOutgoingFileTransfer(user);
		long timeOut = 1000000;
		long sleepMin = 3000;
		long spTime = 0;
		int rs = 0;
		transfer.sendFile(file, file.getName());
		rs=transfer.getStatus().equals(org.jivesoftware.smackx.filetransfer.FileTransfer.Status.COMPLETE)?0:1;
//		rs = transfer.getStatus().compareTo(
//			org.jivesoftware.smackx.filetransfer.FileTransfer.Status.COMPLETE);
		
		while (rs != 0) {
//			rs = transfer.getStatus().compareTo(FileTransfer.Status.COMPLETE);
			rs=transfer.getStatus().equals(org.jivesoftware.smackx.filetransfer.FileTransfer.Status.COMPLETE)?0:1;
			spTime = spTime + sleepMin;
			if (spTime > timeOut) {
				return;
			}
			Thread.sleep(sleepMin);
		}
	}
}
