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
	
	
}
