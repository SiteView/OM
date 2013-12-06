package com.siteview.xmpp.eccserver;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.siteview.xmpp.util.XMPPActivator;

public class Activator implements BundleActivator {

	public static final String PLUGIN_ID = "com.siteview.xmpp.eccserver";
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
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
