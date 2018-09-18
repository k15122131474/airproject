package com.sfa.model;

public class UserInfo {
	private String id;
	private String tUserId;
	private String pwd;
	private String tUserName;
    private String tCname;
    private String tMobile;
    private String tEmail;
	private String tGender;
	private String tRole;
	private String tStatus;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String gettUserName() {
		return tUserName;
	}
	public void settUserName(String tUserName) {
		this.tUserName = tUserName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String gettCname() {
		return tCname;
	}
	public void settCname(String tCname) {
		this.tCname = tCname;
	}
	public String gettMobile() {
		return tMobile;
	}
	public void settMobile(String tMobile) {
		this.tMobile = tMobile;
	}
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	public String gettGender() {
		return tGender;
	}
	public void settGender(String tGender) {
		this.tGender = tGender;
	}
	public String gettRole() {
		return tRole;
	}
	public void settRole(String tRole) {
		this.tRole = tRole;
	}
	public String gettStatus() {
		return tStatus;
	}
	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}
	public String gettUserId() {
		return tUserId;
	}
	public void settUserId(String tUserId) {
		this.tUserId = tUserId;
	}

}
