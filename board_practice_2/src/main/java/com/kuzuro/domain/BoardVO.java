package com.kuzuro.domain;

import java.util.Date;

public class BoardVO {

	/*
	 bno number not null,
	    title varchar2(30) not null,
	    content varchar2(2000) not null,
	    writer varchar2(30) not null,
	    regDate date default sysdate,
	    viewCnt number default 0,
	    primary key(bno)
	*/
	
	

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int cntView;
	
	
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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



	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public int getCntView() {
		return cntView;
	}


	public void setCntView(int cntView) {
		this.cntView = cntView;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDate="
				+ regDate + ", cntView=" + cntView + "]";
	}
	
	
}
