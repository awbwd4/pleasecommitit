package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		this.endPage 
		 = (int) (Math.ceil(cri.getPageNum()/10.0))*10;
		/*현재 페이지 넘버가 2라면
		 * cri.getPageNum은 2를 리턴
		 * 
		 * Math.ceil(2/10.0)은 0.2를 소숫점에서 올림함
		 * 따라서 1을 리턴
		 * 
		 * this.endPage = 10;
		 * 
		 * */
		
		this.startPage = endPage - 9;
		
		int realEnd 
			= (int)(Math.ceil((total*1.0)/cri.getAmount()));
		/*
		 * 실제 마지막 페이지
		 * 
		 * 데이터의 총량total을 한페이지에 출력할 데이터의 양 getAmount로 나눈 뒤
		 * 올림 처리함. 
		 * 데이터의 총량 165개, 한 페이지당 10개의 데이터를 출력한다면
		 * 16.5 -> 소숫점 올림하므로 17.
		 * 따라서 마지막 페이지의 숫자는 17.
		 * 
		 * */
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		//startPage가 1보다 크다면 이전페이지는 startPage가 됨.
		
		this.next = this.endPage < realEnd;
	
	}
	
	
}
