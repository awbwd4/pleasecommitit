package com.zerock.domain;

import lombok.Data;

@Data
/*lombock의 @Data를 쓰게 되면 getter/setter, equals(), toString()
 * 등의 메서드가 자동으로 생성된다
 * 따라서 SampleController의 메서드가 SampleDTO를 파라미터로 쓰면
 * 자동으로 Setter 메서드가 동작 -> 파라미터를 자동으로 수집함.
 * 
 * @Data가 없다면 getName(), setName()등을 직접 구현해주어야 함.
 * 
 * */
public class SampleDTO {

	private String name;
	private int age;
	
}
