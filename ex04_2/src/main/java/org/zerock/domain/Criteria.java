package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Criteria {
	
	private int pageNum;//페이지 넘버 기본값
	//private final int amount = 10;//한 페이지 당 몇 개의 데이터를 보여줄 것인지
	private int amount;//한 페이지 당 몇 개의 데이터를 보여줄 것인지
	
	
	private String type;//검색 조건
	private String keyword;//검색 키워드
	
	
	
	
	public Criteria() {
		this(1,10);
	}


	public Criteria(int pageNum, int amount) {

		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
	
	public String[] getTypeArr() {
		
		return type == null? new String[] {}:type.split("");
		
		//type값이 널일때 새로운 String 타입 배열객체 생성 후 리턴
		//null이 아니면 split?? 구분자 없음?
		//T,C,W셋을 조합해서 쓸 수 있음. 
	}
	
	
	
	/* UriComponentsBuilder
	 * 여러개의 파라미터들을 연결해서 URL의 형태로 만들어주는 기능
	 * */
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	
	}
	
	

}
