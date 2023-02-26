package com.sam.basic.member;

import java.sql.Date;

public class MemberDto {
	private String memberId;
	private Integer roleNum;
	private String pw;
	private String myIntro;
	private String email;
	private Date makeDate;
	private String fileName;
	private String oriName;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Integer getRoleNum() {
		return roleNum;
	}
	public void setRoleNum(Integer roleNum) {
		this.roleNum = roleNum;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMyIntro() {
		return myIntro;
	}
	public void setMyIntro(String myIntro) {
		this.myIntro = myIntro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	
	
	
}
