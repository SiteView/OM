package com.siteview.om.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.siteview.om.Activator;
import com.siteview.om.IncidentModle;
import com.siteview.om.OMAPIiml;

public class NewIncidentEdit extends EditorPart {
	public Text description;
	public Text usedtime;
	public Text results;
	public Text feedback;
	public Text user;
	public Combo function;
	public Combo type;
	public Combo product;
	public Text password;
	public DateTime starttime;
	public DateTime endtime;
	
	private static Map<String,List<String>> prd;
	private static List<String> intype;
	public NewIncidentEdit() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		prd=OMAPIiml.getProduct();
		intype=OMAPIiml.getIncidentType();
		this.setInput(input);
		this.setTitle(input.getName());
		this.setTitleToolTip(input.getToolTipText());
		this.setSite(site);
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
		parent.setLayout(new FormLayout());
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
		
		product = new Combo(parent, SWT.NONE);
		FormData fd_combo = new FormData();
		fd_combo.left=new FormAttachment(label,5);
		fd_combo.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_combo.bottom=new FormAttachment(product,20);
		fd_combo.right=new FormAttachment(50,-5);
		product.setLayoutData(fd_combo);
		
		Label label_1 = new Label(parent, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.left=new FormAttachment(50,5);
		fd_label_1.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_label_1.bottom=new FormAttachment(label_1,20);
		fd_label_1.right = new FormAttachment(label_1, 80);
		label_1.setLayoutData(fd_label_1);
		label_1.setText("\u529F\u80FD");
		
		function = new Combo(parent, SWT.NONE);
		FormData fd_combo_1 = new FormData();
		fd_combo_1.left = new FormAttachment(label_1, 5);
		fd_combo_1.top = new FormAttachment(label_3, 10,SWT.BOTTOM);
		fd_combo_1.right=new FormAttachment(100,-5);
		fd_combo_1.bottom=new FormAttachment(function,20);
		function.setLayoutData(fd_combo_1);
		if(prd!=null){
			Iterator<String> ite=prd.keySet().iterator();
			while(ite.hasNext()){
				product.add(ite.next());
			}
			product.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					List<String> list=prd.get(product.getText());
					function.removeAll();
					for(String s:list){
						function.add(s);
					}
					function.select(0);
				}
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			product.select(0);
			
			List<String> list=prd.get(product.getText());
			function.removeAll();
			for(String s:list){
				function.add(s);
			}
			function.select(0);
		}
		Label label_2 = new Label(parent, SWT.NONE);
		FormData fd_label_2 = new FormData();
		fd_label_2.top = new FormAttachment(label, 10);
		fd_label_2.left = new FormAttachment(0,5);
		fd_label_2.bottom=new FormAttachment(label_2,20);
		fd_label_2.right=new FormAttachment(label,0,SWT.RIGHT);
		label_2.setLayoutData(fd_label_2);
		label_2.setText("\u4EFB\u52A1\u7C7B\u578B");
		
		type = new Combo(parent, SWT.NONE);
		FormData fd_combo_2 = new FormData();
		fd_combo_2.top = new FormAttachment(label_2, 0,SWT.TOP);
		fd_combo_2.left = new FormAttachment(label_2, 5);
		fd_combo_2.bottom = new FormAttachment(label_2,0,SWT.BOTTOM);
		fd_combo_2.right=new FormAttachment(product,0,SWT.RIGHT);
		type.setLayoutData(fd_combo_2);
		for(String s:intype){
			type.add(s);
		}
		type.select(0);
		
		Label label_4 = new Label(parent, SWT.NONE);
		FormData fd_label_4 = new FormData();
		fd_label_4.left = new FormAttachment(0, 5);
		fd_label_4.top = new FormAttachment(label_2, 10,SWT.BOTTOM);
		fd_label_4.right = new FormAttachment(0,200);
		fd_label_4.bottom = new FormAttachment(label_4, 20);
		label_4.setLayoutData(fd_label_4);
		label_4.setText("\u4EFB\u52A1\u63CF\u8FF0");
		
		description = new Text(parent, SWT.BORDER|SWT.WRAP |SWT.MULTI);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 5);
		fd_text.top = new FormAttachment(label_4,0,SWT.BOTTOM);
		fd_text.right = new FormAttachment(100, -5);
		fd_text.bottom = new FormAttachment(description, 80);
		description.setLayoutData(fd_text);
		
		Label label_5 = new Label(parent, SWT.NONE);
		FormData fd_label_5 = new FormData();
		fd_label_5.left = new FormAttachment(0, 5);
		fd_label_5.top = new FormAttachment(description, 10,SWT.BOTTOM);
		fd_label_5.right = new FormAttachment(0,80);
		fd_label_5.bottom = new FormAttachment(label_5, 30);
		label_5.setLayoutData(fd_label_5);
		label_5.setText("\u5F00\u59CB\u65F6\u95F4");
		
		starttime = new DateTime(parent, SWT.TIME);
		FormData fd_dateTime = new FormData();
		fd_dateTime.left = new FormAttachment(label_5, 5, SWT.RIGHT);
		fd_dateTime.top = new FormAttachment(label_5, 0, SWT.TOP);
		fd_dateTime.right = new FormAttachment(50, -5);
		fd_dateTime.bottom = new FormAttachment(label_5, 0, SWT.BOTTOM);
		starttime.setLayoutData(fd_dateTime);
		starttime.setHours(9);
		starttime.setMinutes(0);
		starttime.setSeconds(0);
		
		Label label_6 = new Label(parent, SWT.NONE);
		FormData fd_label_6 = new FormData();
		fd_label_6.left = new FormAttachment(50, 5);
		fd_label_6.top = new FormAttachment(starttime, 0,SWT.TOP);
		fd_label_6.right = new FormAttachment(label_6,80);
		fd_label_6.bottom = new FormAttachment(label_6, 30);
		label_6.setLayoutData(fd_label_6);
		label_6.setText("\u7ED3\u675F\u65F6\u95F4");
		
		endtime = new DateTime(parent, SWT.TIME);
		FormData fd_dateTime_1 = new FormData();
		fd_dateTime_1.top = new FormAttachment(label_6, 0,SWT.TOP);
		fd_dateTime_1.left = new FormAttachment(label_6,10,SWT.RIGHT);
		fd_dateTime_1.right = new FormAttachment(100,-5);
		fd_dateTime_1.bottom = new FormAttachment(label_6, 0,SWT.BOTTOM);
		endtime.setLayoutData(fd_dateTime_1);
		endtime.setHours(14);
		endtime.setMinutes(0);
		endtime.setSeconds(0);
		
		Label label_7 = new Label(parent, SWT.NONE);
		FormData fd_label_7 = new FormData();
		fd_label_7.top = new FormAttachment(label_5, 10,SWT.BOTTOM);
		fd_label_7.left = new FormAttachment(0, 5);
		fd_label_7.right = new FormAttachment(0, 80);
		fd_label_7.bottom = new FormAttachment(label_7,20);
		label_7.setLayoutData(fd_label_7);
		label_7.setText("花费时间");
		
		usedtime = new Text(parent, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.left = new FormAttachment(label_7,5,SWT.RIGHT);
		fd_text_1.top = new FormAttachment(label_7, 0,SWT.TOP);
		fd_text_1.right = new FormAttachment(50, -5);
		fd_text_1.bottom = new FormAttachment(usedtime, 25);
		usedtime.setLayoutData(fd_text_1);
		usedtime.setText("4");
		usedtime.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				String usedTimeString=usedtime.getText();
				 String check = "^[1-4]$";
				 Pattern regex = Pattern.compile(check); 
				 if(!regex.matcher(usedTimeString).matches())
					 usedtime.setText("4");
			}
		});
		
		Label label_8 = new Label(parent, SWT.NONE);
		FormData fd_label_8 = new FormData();
		fd_label_8.top = new FormAttachment(label_7, 10,SWT.BOTTOM);
		fd_label_8.left = new FormAttachment(0, 5);
		fd_label_8.right = new FormAttachment(label_8, 200);
		fd_label_8.bottom = new FormAttachment(label_8,20);
		label_8.setLayoutData(fd_label_8);
		label_8.setText("\u5904\u7406\u7ED3\u679C");
		
		results = new Text(parent, SWT.BORDER|SWT.WRAP |SWT.MULTI);
		FormData fd_text_2 = new FormData();
		fd_text_2.top = new FormAttachment(label_8, 0,SWT.BOTTOM);
		fd_text_2.left = new FormAttachment(0, 5);
		fd_text_2.right = new FormAttachment(100, -5);
		fd_text_2.bottom = new FormAttachment(results, 80);
		results.setLayoutData(fd_text_2);
		
		Label label_9 = new Label(parent, SWT.NONE);
		FormData fd_label_9 = new FormData();
		fd_label_9.top = new FormAttachment(results, 10,SWT.BOTTOM);
		fd_label_9.left = new FormAttachment(0, 5);
		fd_label_9.right = new FormAttachment(0,200);
		fd_label_9.bottom = new FormAttachment(label_9,20);
		label_9.setLayoutData(fd_label_9);
		label_9.setText("\u81EA\u6211\u53CD\u9988");
		
		feedback = new Text(parent, SWT.BORDER|SWT.WRAP |SWT.MULTI);
		FormData fd_text_3 = new FormData();
		fd_text_3.top = new FormAttachment(label_9, 0);
		fd_text_3.left = new FormAttachment(0, 5);
		fd_text_3.right = new FormAttachment(100, -5);
		fd_text_3.bottom = new FormAttachment(feedback, 100);
		feedback.setLayoutData(fd_text_3);
		
		Button send = new Button(parent, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.left = new FormAttachment(100, -50);
		fd_btnNewButton.top = new FormAttachment(feedback, 10);
		fd_btnNewButton.right = new FormAttachment(100, 0);
		send.setLayoutData(fd_btnNewButton);
		send.setText("Send");
		send.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				String username=user.getText().trim();
				String passwordname=password.getText().trim();
				String productname=product.getText().trim();
				String functionname=function.getText().trim();
				String typename=type.getText().trim();
				String desname=description.getText().trim();
				String starttimename="";
				starttimename+=starttime.getHours()+":";
				starttimename+=starttime.getMinutes()+":";
				starttimename+=starttime.getSeconds();
				String endtimename="";
				endtimename+=endtime.getHours()+":";
				endtimename+=endtime.getMinutes()+":";
				endtimename+=endtime.getSeconds();
				String userdtimename=usedtime.getText();
				String rus=results.getText().trim();
				String feedba=feedback.getText().trim();
				if(username.length()==0||passwordname.length()==0||productname.length()==0||functionname.length()==0
						||typename.length()==0||desname.length()==0||userdtimename.length()==0||rus.length()==0){
					MessageDialog.openConfirm(new Shell(), "错误", "除自我反馈，其他项必须填值");
					return;
				}
				StringBuffer str=new StringBuffer();
				str.append("Owner="+username+";");
				str.append("User="+username+";");
				str.append("Pwd="+passwordname+";");
				str.append("Category="+productname+";");
				str.append("SubCategory="+functionname+";");
				str.append("TypeOfIncident="+typename+";");
				str.append("Subject="+desname+";");
				str.append("caseStartTime="+starttimename+";");
				str.append("caseEndTime="+endtimename+";");
				str.append("CostTime="+userdtimename+";");
				str.append("Resolution="+rus+";");
				str.append("SelfFeedback="+feedba+";");
				String message=OMAPIiml.savaOm(str.toString());
				IncidentModle in=new IncidentModle();
				in.setCaseEndTime(endtimename);
				in.setCaseStartTime(starttimename);
				in.setCategory(productname);
				in.setCostTime(userdtimename);
				in.setOwner(username);
				in.setPwd(passwordname);
				in.setResolution(rus);
				in.setSelfFeedback(feedba);
				in.setSubCategory(functionname);
				in.setSubject(desname);
				in.setTypeOfIncident(typename);
				in.setUser(username);
				Date date=new Date();
				SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
				if(message.startsWith("Failure")){
					MessageDialog.openConfirm(new Shell(), "保存任务","保存任务失败:"+message);
					return;
				}else if(message.startsWith("Success")){
					TreeItem tree=new TreeItem(ShowAllIncident.tree, SWT.NONE);
					String ss=simp.format(date);
					tree.setText(ss+" : "+desname);
					tree.setImage(ShowAllIncident.icon);
					in.setRecId(message.substring(message.indexOf(":")+1));
					tree.setData(in);
					if(MessageDialog.openQuestion(new Shell(), "保存任务","保存任务成功，是否继续新建任务?")){
						description.setText("");
						results.setText("");
						feedback.setText("");
					}else{
						IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
						page.closeEditor(page.findEditor(NewIncident.newinc), false);
					}
				}
				
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
