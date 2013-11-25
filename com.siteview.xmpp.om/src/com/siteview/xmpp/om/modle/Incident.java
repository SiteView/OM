package com.siteview.xmpp.om.modle;

import java.io.Serializable;
/**
 * @author lihua.zhong
 * 研发任务对象
 */
public class Incident implements Serializable{
	private static final long serialVersionUID = 1L;
	private String User;
	private String Owner;
	private String Pwd;
	private String Category;
	private String SubCategory;
	private String TypeOfIncident;
	private String Subject;
	private String caseStartTime;
	private String caseEndTime;
	private String CostTime;
	private String Resolution;
	private String SelfFeedback;
	private String CreatedDateTime;//创建时间
	private String CommentAndFeedback;//评论与反馈
	private boolean IsCommentUpdata;//已经查看
	private String RecId;
	
	public Incident(){}
	
	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		Pwd = pwd;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getSubCategory() {
		return SubCategory;
	}

	public void setSubCategory(String subCategory) {
		SubCategory = subCategory;
	}

	public String getTypeOfIncident() {
		return TypeOfIncident;
	}

	public void setTypeOfIncident(String typeOfIncident) {
		TypeOfIncident = typeOfIncident;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getCaseStartTime() {
		return caseStartTime;
	}

	public void setCaseStartTime(String caseStartTime) {
		this.caseStartTime = caseStartTime;
	}

	public String getCaseEndTime() {
		return caseEndTime;
	}

	public void setCaseEndTime(String caseEndTime) {
		this.caseEndTime = caseEndTime;
	}

	public String getCostTime() {
		return CostTime;
	}

	public void setCostTime(String costTime) {
		CostTime = costTime;
	}

	public String getResolution() {
		return Resolution;
	}

	public void setResolution(String resolution) {
		Resolution = resolution;
	}

	public String getSelfFeedback() {
		return SelfFeedback;
	}

	public void setSelfFeedback(String selfFeedback) {
		SelfFeedback = selfFeedback;
	}

	public String getCommentAndFeedback() {
		return CommentAndFeedback;
	}

	public void setCommentAndFeedback(String commentAndFeedback) {
		CommentAndFeedback = commentAndFeedback;
	}

	public boolean isIsCommentUpdata() {
		return IsCommentUpdata;
	}

	public void setIsCommentUpdata(boolean IsCommentUpdata) {
		this.IsCommentUpdata = IsCommentUpdata;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getRecId() {
		return RecId;
	}

	public void setRecId(String recId) {
		RecId = recId;
	}

	public String getCreatedDateTime() {
		return CreatedDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
}
