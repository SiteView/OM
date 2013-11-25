package com.siteview.xmpp.om;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.siteview.ecc.util.OmApi;
import com.siteview.ecc.util.OmApiUtil;
import com.siteview.ecc.util.StaticPam;
import com.siteview.xmpp.util.XMPPActivator;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		java.lang.Thread xmpp = new XMPPActivator();
	    xmpp.start();
	    StaticPam.users=OmApiUtil.getUser();
	    StaticPam.selectcom=OmApi.getProduct();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
