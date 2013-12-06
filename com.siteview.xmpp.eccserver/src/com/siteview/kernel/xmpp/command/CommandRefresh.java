package com.siteview.kernel.xmpp.command;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

public class CommandRefresh {
	public static void refresh(){
		ICommandService commandservice = (ICommandService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		commandservice.refreshElements("com.siteview.kernel.xmpp.command.GatewayStartCommand",null);
		commandservice.refreshElements("com.siteview.kernel.xmpp.command.GatewayStopCommand",null);
	}
}
