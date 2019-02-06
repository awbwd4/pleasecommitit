package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //이 클래스의 객체가 aspect를 구현한 것음을 나타냄.
@Log4j //	
@Component //aop와는 관계 없지만, 스프링에서 bean으로 인식하기 위해서 사용함.
public class LogAdvice {
	//로그 어드바이스 모음
	
	
	
	
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		
		log.info("==============================");
		
	}

	
	
	
	//Pointcut인 @Before 설정시에 args를 적용하여, joinPoint에 어떤 파라미터가 들어가는지 확인 	가능
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String,String)) "
			+ "&& args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		
		log.info("str1 : "+str1);
		log.info("str2 : "+str2);
	}
	
	
	
	@AfterThrowing(pointcut = 
			"execution(* org.zerock.service.SampleService*.*(..))"
			,throwing="exception")
	public void logException(Exception exception) {
	
		log.info("Exception................!!!");
		log.info("exception : "+exception);
		
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
	
		long start = System.currentTimeMillis();
		
		log.info("Target : "+pjp.getTarget());
		log.info("Param : "+Arrays.toString(pjp.getArgs()));
		
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		log.info("Time: "+ (end-start));
		
		return result;
	}
	
	

}
