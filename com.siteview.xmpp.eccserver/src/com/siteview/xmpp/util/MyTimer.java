package com.siteview.xmpp.util;

import java.util.TimerTask;

public class MyTimer extends TimerTask{
	java.lang.Thread xmpp = new XMPPActivator();
	@Override
	public void run() {
		// TODO Auto-generated method stub
	    ((XMPPActivator)xmpp).init();
	}

}
