package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private SampleService service;
	
	@Test
	public void testClass() {
		//프록시 객체가 정상적으로 만들어져 있는지 테스트
		
		System.out.printf("\n\n\n");
		System.out.printf("프록시 클래스 테스트");
		System.out.printf("\n\n\n");
		log.info(service);
		log.info(service.getClass().getName());
		
		//SampleService객체를 실행하는 것
		//이 객체에 advice가 지정돼 있으므로 이 advice는 알아서 실행됨.
		//->단순히 SampleService객체가 실행되는 것이 아니라
		//생성된 Proxy 클래스의 인스턴스가 됨.
	
	}
	
	@Test
	public void testAdd() throws Exception{
		//타겟객체의 joinpoint 확인
		System.out.printf("\n\n\n");
		System.out.printf("타겟 객체의 joinpoint 확인");
		System.out.printf("\n\n\n");
		
		log.info(service.doAdd("123", "456"));
	}
	//ㅁㄻㄴㅇㄻㅇㄻㅇㄴㅇㅁㄴㄻㅇㄻㄹㅇㅁㄴㅇㄹ
	/*ㅁㅇㄴㄻㅇㄴㄻㅇㅁㅇ
	@Test
	public void testAddError() throws Exception{
		//타겟객체의 joinpoint 확인
		System.out.printf("\n\n\n");
		System.out.printf("afterthrwing 테스트");
		System.out.printf("\n\n\n");
		
		log.info(service.doAdd("123", "abc"));
	}
	*/
	
	
	
}
