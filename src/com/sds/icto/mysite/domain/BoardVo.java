package com.sds.icto.mysite.domain;

import java.util.Date;

public class BoardVo {

private int no;
private String title;
private String content;
private Long member_no;
private String member_name;
private int view_cnt;
private Date reg_date;

public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Long getMember_no() {
	return member_no;
}
public void setMember_no(Long member_no) {
	this.member_no = member_no;
}
public String getMember_name() {
	return member_name;
}
public void setMember_name(String member_name) {
	this.member_name = member_name;
}
public int getView_cnt() {
	return view_cnt;
}
public void setView_cnt(int view_cnt) {
	this.view_cnt = view_cnt;
}
public Date getReg_date() {
	return reg_date;
}
public void setReg_date(Date reg_date) {
	this.reg_date = reg_date;
}



}
