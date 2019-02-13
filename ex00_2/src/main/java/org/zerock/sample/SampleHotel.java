package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
//allargsconstructor : 인스턴스 변수로 선언된 모든것을 파라미터로 받는 생성자 작성
public class SampleHotel {

	private Chef chef;
	
	/*//autowired없이 생성자 선언으로 의존주입을 하는 방식
	 * public SampleHotel(Chef chef) { this.chef = chef; }
	 */
	

	
	
	
	
	
}
