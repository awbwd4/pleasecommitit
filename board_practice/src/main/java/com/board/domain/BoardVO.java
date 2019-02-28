package com.board.domain;

import java.util.Date;

import lombok.Data;

/*
 * bno number not null,
 * title varchar2(30) not null,
 * content varchar2(2000) not null, 
 * writer varchar2(30) not null, 
 * regDate date default sysdate,
 * viewCnt number default 0,
 */
@Data //getter setter toString 만들기 귀찮아서 lombok사용
public class BoardVO {

	
	
	
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int cntView;
	
	
	
	
	
	
	
	
	
	
	
}
