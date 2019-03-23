package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Criteria {
	
	private int pageNum;//페이지 넘버 기본값
	//private final int amount = 10;//한 페이지 당 몇 개의 데이터를 보여줄 것인지
	private int amount;//한 페이지 당 몇 개의 데이터를 보여줄 것인지
	
	
	public Criteria() {
		this(1,10);
	}


	public Criteria(int pageNum, int amount) {

		this.pageNum = pageNum;
		this.amount = amount;
	}
	/*
	public Criteria() {
		this(1, 10);
	}
	
	
	public Criteria(int pageNum, int amount) {
		
		this.pageNum = pageNum;
		this.amount = amount;
		
	}
	*/
	

}
