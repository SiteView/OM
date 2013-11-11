package com.siteview.om.commands;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.siteview.om.Activator;
import com.siteview.om.IncidentModle;
import com.siteview.om.OMAPIiml;

public class ShowIncidentEdit extends EditorPart {
	public Text description;
	public Text usedtime;
	public Text results;
	public Text feedback;
	public Text user;
	public Text function;
	public Text type;
	public Text product;
	public Text password;
	public Text starttime;
	public Text endtime;
	public IncidentModle inc;
	public Text comm;
	public ShowIncidentEdit() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		inc=((ShowIncidentEditInput)input).getInc();
		this.setSite(site);
		this.setInput(input);
		this.setTitle(input.getName());
		this.setTitleToolTip(input.getToolTipText());
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new FormLayout());
//		if(inc.isIsCommentUpdata()){
//			OMAPIiml.readComm("RecId", inc.getRecId());
//			inc.setIsCommentUpdata(false);
//		}
		Label label_3 = new Label(parent, SWT.NONE);
		FormData fd_label_3 = new FormData();
		fd_label_3.left = new FormAttachment(0,5);
		fd_label_3.right = new FormAttachment(0,80);
		fd_label_3.top = new FormAttachment( 0, 5);
		fd_label_3.bottom = new FormAttachment(label_3, 20);
		label_3.setLayoutData(fd_label_3);
		label_3.setText("\u8D1F\u8D23\u4EBA");
		
		user = new Text(parent, SWT.BORDER|SWT.READ_ONLY);
		FormData fd_combo_3 = new FormData();
		fd_combo_3.left = new FormAttachment(label_3, 5);
		fd_combo_3.top = new FormAttachment(label_3, 0, SWT.TOP);
		fd_combo_3.right = new FormAttachment(50, -5);
		fd_combo_3.bottom=new FormAttachment(0,30);
		user.setLayoutData(fd_combo_3);
		user.setText(Activator.user==null?"":Activator.user);
		
		Label label_0 = new Label(parent, SWT.NONE);
		FormData fd_label_0 = new FormData();
		fd_label_0.left = new FormAttachment(50, 5);
		fd_label_0.right = new FormAttachment(label_0,80);
		fd_label_0.top = new FormAttachment( 0, 5);
		fd_label_0.bottom = new FormAttachment(0, 20);
		label_0.setLayoutData(fd_label_0);
		label_0.setText("密码");
		
		password = new Text(parent, SWT.PASSWORD|SWT.BORDER|SWT.READ_ONLY);
		FormData fd_password = new FormData();
		fd_password.left = new FormAttachment(label_0, 5);
		fd_password.top = new FormAttachment(0, 5);
		fd_password.right = new FormAttachment(100, -5);
		fd_password.bottom=new FormAttachment(0,30);
		password.setLayoutData(fd_password);
		password.setText(Activator.password==null?"":Activator.password);
		
		Label label = new Label(parent, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 5);
		fd_label.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_label.bottom=new FormAttachment(label,20);
		fd_label.right = new FormAttachment(0, 80);
		label.setLayoutData(fd_label);
		label.setText("\u4EA7\u54C1");
		
		product = new Text(parent, SWT.NONE|SWT.READ_ONLY);
		FormData fd_combo = new FormData();
		fd_combo.left=new FormAttachment(label,5);
		fd_combo.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_combo.bottom=new FormAttachment(product,20);
		fd_combo.right=new FormAttachment(50,-5);
		product.setLayoutData(fd_combo);
		product.setText(inc.getCategory());
		
		Label label_1 = new Label(parent, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.left=new FormAttachment(50,5);
		fd_label_1.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_label_1.bottom=new FormAttachment(label_1,20);
		fd_label_1.right = new FormAttachment(label_1, 80);
		label_1.setLayoutData(fd_label_1);
		label_1.setText("\u529F\u80FD");
		
		function = new Text(parent, SWT.NONE|SWT.READ_ONLY);
		FormData fd_combo_1 = new FormData();
		fd_combo_1.left = new FormAttachment(label_1, 5);
		fd_combo_1.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_combo_1.right=new FormAttachment(100,-5);
		fd_combo_1.bottom=new FormAttachment(function,20);
		function.setLayoutData(fd_combo_1);
		function.setText(inc.getSubCategory());
		
		Label label_2 = new Label(parent, SWT.NONE);
		FormData fd_label_2 = new FormData();
		fd_label_2.top = new FormAttachment(label, 10);
		fd_label_2.left = new FormAttachment(0,5);
		fd_label_2.bottom=new FormAttachment(label_2,20);
		fd_label_2.right=new FormAttachment(label,0,SWT.RIGHT);
		label_2.setLayoutData(fd_label_2);
		label_2.setText("\u4EFB\u52A1\u7C7B\u578B");

		type = new Text(parent, SWT.NONE|SWT.READ_ONLY);
		FormData fd_combo_2 = new FormData();
		fd_combo_2.top = new FormAttachment(label_2, 0,SWT.TOP);
		fd_combo_2.left = new FormAttachment(label_2, 5);
		fd_combo_2.bottom = new FormAttachment(label_2,0,SWT.BOTTOM);
		fd_combo_2.right=new FormAttachment(product,0,SWT.RIGHT);
		type.setLayoutData(fd_combo_2);
		type.setText(inc.getTypeOfIncident());
		
		Label label_4 = new Label(parent, SWT.NONE);
		FormData fd_label_4 = new FormData();
		fd_label_4.left = new FormAttachment(0, 5);
		fd_label_4.top = new FormAttachment(label_2, 10,SWT.BOTTOM);
		fd_label_4.right = new FormAttachment(0,200);
		fd_label_4.bottom = new FormAttachment(label_4, 20);
		label_4.setLayoutData(fd_label_4);
		label_4.setText("\u4EFB\u52A1\u63CF\u8FF0");
		
		description = new Text(parent, SWT.BORDER|SWT.WRAP |SWT.MULTI|SWT.READ_ONLY);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 5);
		fd_text.top = new FormAttachment(label_4,0,SWT.BOTTOM);
		fd_text.right = new FormAttachment(100, -5);
		fd_text.bottom = new FormAttachment(description, 80);
		description.setLayoutData(fd_text);
		description.setText(inc.getSubject());
		
		Label label_5 = new Label(parent, SWT.NONE);
		FormData fd_label_5 = new FormData();
		fd_label_5.left = new FormAttachment(0, 5);
		fd_label_5.top = new FormAttachment(description, 10,SWT.BOTTOM);
		fd_label_5.right = new FormAttachment(0,80);
		fd_label_5.bottom = new FormAttachment(label_5, 30);
		label_5.setLayoutData(fd_label_5);
		label_5.setText("\u5F00\u59CB\u65F6\u95F4");
		
		starttime = new Text(parent, SWT.TIME|SWT.READ_ONLY);
		FormData fd_dateTime = new FormData();
		fd_dateTime.left = new FormAttachment(label_5, 5, SWT.RIGHT);
		fd_dateTime.top = new FormAttachment(label_5, 0, SWT.TOP);
		fd_dateTime.right = new FormAttachment(50, -5);
		fd_dateTime.bottom = new FormAttachment(label_5, 0, SWT.BOTTOM);
		starttime.setLayoutData(fd_dateTime);
		String str=inc.getCaseStartTime();
		starttime.setText(str.substring(str.indexOf(" ")+1));
		
		Label label_6 = new Label(parent, SWT.NONE);
		FormData fd_label_6 = new FormData();
		fd_label_6.left = new FormAttachment(50, 5);
		fd_label_6.top = new FormAttachment(starttime, 0,SWT.TOP);
		fd_label_6.right = new FormAttachment(label_6,80);
		fd_label_6.bottom = new FormAttachment(label_6, 30);
		label_6.setLayoutData(fd_label_6);
		label_6.setText("\u7ED3\u675F\u65F6\u95F4");
		
		endtime = new Text(parent, SWT.TIME|SWT.READ_ONLY);
		FormData fd_dateTime_1 = new FormData();
		fd_dateTime_1.top = new FormAttachment(label_6, 0,SWT.TOP);
		fd_dateTime_1.left = new FormAttachment(label_6,10,SWT.RIGHT);
		fd_dateTime_1.right = new FormAttachment(100,-5);
		fd_dateTime_1.bottom = new FormAttachment(label_6, 0,SWT.BOTTOM);
		endtime.setLayoutData(fd_dateTime_1);
		str=inc.getCaseEndTime();
		endtime.setText(str.substring(str.indexOf(" ")+1));
		
		Label label_7 = new Label(parent, SWT.NONE);
		FormData fd_label_7 = new FormData();
		fd_label_7.top = new FormAttachment(label_5, 10,SWT.BOTTOM);
		fd_label_7.left = new FormAttachment(0, 5);
		fd_label_7.right = new FormAttachment(0, 80);
		fd_label_7.bottom = new FormAttachment(label_7,20);
		label_7.setLayoutData(fd_label_7);
		label_7.setText("花费时间");
		
		usedtime = new Text(parent, SWT.BORDER|SWT.READ_ONLY);
		FormData fd_text_1 = new FormData();
		fd_text_1.left = new FormAttachment(label_7,5,SWT.RIGHT);
		fd_text_1.top = new FormAttachment(label_7, 0,SWT.TOP);
		fd_text_1.right = new FormAttachment(50, -5);
		fd_text_1.bottom = new FormAttachment(usedtime, 25);
		usedtime.setLayoutData(fd_text_1);
		usedtime.setText(inc.getCostTime());
		
		Label label_8 = new Label(parent, SWT.NONE);
		FormData fd_label_8 = new FormData();
		fd_label_8.top = new FormAttachment(label_7, 10,SWT.BOTTOM);
		fd_label_8.left = new FormAttachment(0, 5);
		fd_label_8.right = new FormAttachment(label_8, 200);
		fd_label_8.bottom = new FormAttachment(label_8,20);
		label_8.setLayoutData(fd_label_8);
		label_8.setText("\u5904\u7406\u7ED3\u679C");
		
		results = new Text(parent, SWT.BORDER|SWT.WRAP |SWT.MULTI|SWT.READ_ONLY);
		FormData fd_text_2 = new FormData();
		fd_text_2.top = new FormAttachment(label_8, 0,SWT.BOTTOM);
		fd_text_2.left = new FormAttachment(0, 5);
		fd_text_2.right = new FormAttachment(100, -5);
		fd_text_2.bottom = new FormAttachment(results, 50);
		results.setLayoutData(fd_text_2);
		results.setText(inc.getResolution());
		
		Label label_9 = new Label(parent, SWT.NONE);
		FormData fd_label_9 = new FormData();
		fd_label_9.top = new FormAttachment(results, 10,SWT.BOTTOM);
		fd_label_9.left = new FormAttachment(0, 5);
		fd_label_9.right = new FormAttachment(0,200);
		fd_label_9.bottom = new FormAttachment(label_9,20);
		label_9.setLayoutData(fd_label_9);
		label_9.setText("评论");
		
		comm = new Text(parent, SWT.BORDER|SWT.READ_ONLY);
		FormData fd_text_3 = new FormData();
		fd_text_3.top = new FormAttachment(label_9, 0);
		fd_text_3.left = new FormAttachment(0, 5);
		fd_text_3.right = new FormAttachment(100, -5);
		fd_text_3.bottom = new FormAttachment(comm, 80);
		comm.setLayoutData(fd_text_3);
		comm.setText(inc.getCommentAndFeedback());
		
		Label label_10 = new Label(parent, SWT.NONE);
		FormData fd_label_10 = new FormData();
		fd_label_10.top = new FormAttachment(comm, 10,SWT.BOTTOM);
		fd_label_10.left = new FormAttachment(0, 5);
		fd_label_10.right = new FormAttachment(0,200);
		fd_label_10.bottom = new FormAttachment(label_10,20);
		label_10.setLayoutData(fd_label_10);
		label_10.setText("\u81EA\u6211\u53CD\u9988");
		
		 feedback= new Text(parent, SWT.BORDER|SWT.WRAP |SWT.MULTI);
		FormData fd_comm = new FormData();
		fd_comm.top = new FormAttachment(label_10, 0);
		fd_comm.left = new FormAttachment(0, 5);
		fd_comm.right = new FormAttachment(100, -5);
		fd_comm.bottom = new FormAttachment(feedback, 80);
		feedback.setLayoutData(fd_comm);
		feedback.setText(inc.getSelfFeedback());
		
		Button send = new Button(parent, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.left = new FormAttachment(100, -50);
		fd_btnNewButton.top = new FormAttachment(feedback, 10);
		fd_btnNewButton.right = new FormAttachment(100, 0);
		send.setLayoutData(fd_btnNewButton);
		send.setText("Send");
		send.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				String feedba=feedback.getText().trim();
				String message="";
				if(!feedba.equalsIgnoreCase(inc.getSelfFeedback().trim())){
					message=OMAPIiml.savafeedback(inc.getRecId(), feedba);
				}
				MessageDialog.openConfirm(null, "提交任务", message);
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

}
