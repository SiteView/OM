package com.siteview.om.commands;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import com.siteview.om.IncidentModle;

public class ShowIncidentEditInput implements IEditorInput{
	public IncidentModle inc;
	
	public ShowIncidentEditInput(IncidentModle inc){
		this.inc=inc;
	}
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "研发任务";
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "研发任务";
	}
	public IncidentModle getInc() {
		return inc;
	}
	public void setInc(IncidentModle inc) {
		this.inc = inc;
	}
}
