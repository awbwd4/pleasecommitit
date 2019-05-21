package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor//디폴트 생성자를 만든다
public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
	
}
