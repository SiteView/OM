package com.siteview.om.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.siteview.om.Activator;
import com.siteview.om.IncidentModle;
import com.siteview.om.OMAPIiml;
import com.siteview.om.util.ToolsUtil;

public class ShowAllIncident extends ViewPart {
	public List<IncidentModle> incidents;
	public static Map<IncidentModle,ShowIncidentEditInput> map=new HashMap<IncidentModle,ShowIncidentEditInput>();
	Tree tree;
	Image icon_new=new Image(null, ToolsUtil.getRealPath("icons/ok.png"));
	Image icon=new Image(null, ToolsUtil.getRealPath("icons/error.png"));
	public ShowAllIncident() {
	}

	public void createPartControl(Composite parent) {
		incidents=OMAPIiml.getIncidents(Activator.user, Activator.password);
		tree=new Tree(parent,SWT.NONE); 
		if(incidents!=null)
		for(IncidentModle inc:incidents){
			TreeItem treeItem=new TreeItem(tree, SWT.NONE);
			String createData=inc.getCreatedDateTime();
			createData=createData.substring(0,createData.indexOf(" "));
			String des=inc.getSubject();
			treeItem.setText(createData+" : "+des);
			treeItem.setData(inc);
			boolean update=inc.isIsCommentUpdata();
			if(update){
				treeItem.setImage(icon_new);
			}else{
				treeItem.setImage(icon);
			}
		}
		tree.addListener(SWT.MouseDoubleClick, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Point p=new Point(event.x,event.y);
				TreeItem t=tree.getItem(p);
				final IncidentModle inc=(IncidentModle) t.getData();
				ShowIncidentEditInput showIncidentEditInput=null;
				showIncidentEditInput=map.get(inc);
				if(showIncidentEditInput==null){
					showIncidentEditInput=new ShowIncidentEditInput(inc);
					map.put(inc, showIncidentEditInput);
				}
				IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorPart edit=page.findEditor(showIncidentEditInput);
				try {
					if(edit==null){
						page.openEditor(showIncidentEditInput, "com.siteview.om.showIncident");
					}else{
						page.activate(edit);
					}
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				if(inc.isIsCommentUpdata()){
					t.setImage(icon);
					Display.getCurrent().syncExec(new Runnable() {
						public void run() {
							OMAPIiml.readComm("RecId", inc.getRecId());
							inc.setIsCommentUpdata(false);
						}
					});
				}
			}
		});
	}

	public void setFocus() {
	}

}
