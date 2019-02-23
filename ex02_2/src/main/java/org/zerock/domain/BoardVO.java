package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data // getter, setter, toString을 쓰기 위해
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	
}
