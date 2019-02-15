package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime(); //어노테이션 방식
	
	////////////Mapper인터페이스와 XML을 같이 이용해보기 위해서 
	//추가적인 메서드 선언
	
	
	public String getTime2(); 
	//xml방식 : 실제 SQL은 XML을 이용해서 처리할 것.
	
}
