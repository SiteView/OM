package com.siteview.kernel.xmpp.command;

import com.siteview.xmpp.util.XMPPActivator;

public class GatewayController {
	public static GatawayStatuEnum GATEWAY_STATUS = GatawayStatuEnum.WAIT;
	public static void start() throws Exception{
		GatewayController.GATEWAY_STATUS = GatawayStatuEnum.START;
		java.lang.Thread xmpp = new XMPPActivator();
	    xmpp.start();
		System.out.println("������Gateway����.");
	}
	public static void stop() throws Exception{
		GatewayController.GATEWAY_STATUS = GatawayStatuEnum.STOP;
		System.out.println("�ر���Gateway����.");
	}
}
