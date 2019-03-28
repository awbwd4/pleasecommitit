package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {

	/*	@AllArgsConstructor
		@NoArgsConstructor
	 * 비어있는 생성자와 모든 속성을 사용하는 생성자를 둘 다 만듦
	 * */
	
	
	private Integer mno;
	private String firstName;
	private String lastName;
	
	
	
}
