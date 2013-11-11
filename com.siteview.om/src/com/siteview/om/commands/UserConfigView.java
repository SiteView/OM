package com.siteview.om.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.siteview.om.Activator;
import com.siteview.om.util.ToolsUtil;

public class UserConfigView extends Dialog{
	private Text text;
	private Text text_1;
/**
 * @author lihua.zhong
 * 用户配置界面
 */
	protected UserConfigView(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		Composite com=(Composite) super.createDialogArea(parent);
		com.setLayout(new FormLayout());
		
		Label label = new Label(com, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(0, 21);
		fd_label.left = new FormAttachment(0, 10);
		label.setLayoutData(fd_label);
		label.setText("\u7528\u6237\u540D\uFF1A");
		
		text = new Text(com, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(label, 300, SWT.RIGHT);
		fd_text.top = new FormAttachment(0, 15);
		fd_text.left = new FormAttachment(label, 46);
		text.setLayoutData(fd_text);
		text.setText(Activator.user==null?"":Activator.user);
		
		Label label_1 = new Label(com, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.top = new FormAttachment(label, 30);
		fd_label_1.left = new FormAttachment(label, 0, SWT.LEFT);
		label_1.setLayoutData(fd_label_1);
		label_1.setText("\u5BC6\u7801\uFF1A");
		
		text_1 = new Text(com, SWT.BORDER|SWT.PASSWORD);
		FormData fd_text_1 = new FormData();
		fd_text_1.right = new FormAttachment(label_1, 312, SWT.RIGHT);
		fd_text_1.top = new FormAttachment(text, 30);
		fd_text_1.left = new FormAttachment(label_1, 58);
		text_1.setLayoutData(fd_text_1);
		text_1.setText(Activator.password==null?"":Activator.password);
		return com;
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		// TODO Auto-generated method stub
		if(buttonId==Dialog.OK){
			String user=text.getText();
			String password=text_1.getText();
			File file=new File(ToolsUtil.getRealPath("src/userconfig"));
			BufferedWriter buffw;
			try {
				buffw = new BufferedWriter(new FileWriter(file));
				buffw.write("user="+user);
				buffw.newLine();
				buffw.write("password="+password);
				Activator.user=user;
				Activator.password=password;
				buffw.flush();
				buffw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		super.buttonPressed(buttonId);
	}
}
