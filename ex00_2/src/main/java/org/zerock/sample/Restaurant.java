package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component // 해당 클래스가 스프링에서 객체로 만들어서 관리하는 대상임을 명시
@Data
public class Restaurant {

	//root-context.xml에 <component-scan> 태그 추가 : 스캔하여 bean으로 관리할 패키지 설정
	//패키지 내부에 @component가 붙어있는 클래스를 객체로 만들어서 bean으로 관리함.
	
	
	
	@Setter(onMethod_ = @Autowired)
	public Chef chef;
	
	
	
	
	
}
