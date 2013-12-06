package com.siteview.kernel.xmpp.command;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;


public class GatewayStopCommand extends AbstractHandler implements IElementUpdater{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Display currentDisplay = Display.getCurrent();
		
		if(GatewayController.GATEWAY_STATUS == GatawayStatuEnum.WAIT||GatewayController.GATEWAY_STATUS ==GatawayStatuEnum.STOP){
			MessageDialog.openError(currentDisplay.getActiveShell(),"提示信息","当前状态不允许执行.");
			return null;
		}
		
		ProgressMonitorDialog progress = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());  
		try {
			progress.run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException,
						InterruptedException {
					monitor.beginTask("开始执行...", IProgressMonitor.UNKNOWN);
			        if(monitor.isCanceled()) return; 
			        monitor.worked(1);  
			        try {
			        	GatewayController.stop();
						monitor.subTask("执行完毕。");
				        monitor.worked(100);  
				        monitor.done();  
				        currentDisplay.asyncExec(new Runnable() {
							@Override
							public void run() {
								CommandRefresh.refresh();
							}
						});
			        } catch (Exception e) {
						monitor.subTask("发生错误.");
						monitor.worked(100);  
						monitor.done(); 
						throw new InvocationTargetException(e);
					}
				}
			});
		}
		catch(InvocationTargetException ie){
			MessageDialog.openError(currentDisplay.getActiveShell(),"提示信息","异常:"+ie.getMessage());
			ie.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void updateElement(UIElement element, Map parameters) {
		if(GatewayController.GATEWAY_STATUS == GatawayStatuEnum.START){
			this.setBaseEnabled(true);
		}
		else{
			this.setBaseEnabled(false);
		}
	}
}
