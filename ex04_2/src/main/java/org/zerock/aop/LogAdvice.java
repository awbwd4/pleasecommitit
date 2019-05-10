package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.AfterTransaction;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {

	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("advice의 joinpoint 실행 전==============================");
	}
	/*
	 * */
	
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		
		log.info("str1 : "+str1);
		log.info("str2 : "+str2);
		
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* org.zerock.service.SampleService*.*(..))", 
			throwing="exception")
	public void logException(Exception exception) {
		
		//@afterThrowing : 지정된 대상이 예외를 발생한 후에 동작하면서 문제를 찾을 수 있도록 도와줌.
		
		log.info("Exception....!");
		log.info("exception: "+exception);
	}
	
	
	@After("execution(* org.zerock.service.SampleService*.*(..))")
	public void logAfter() {
		log.info("advice의 joinpoint 실행 후==============================");
	}
	
	
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		
		long start = System.currentTimeMillis();
		
		log.info("Target : "+pjp.getTarget());
		log.info("Param : "+Arrays.deepToString(pjp.getArgs()));
		
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long end = System.currentTimeMillis();
		
		log.info("Time : "+(end-start));
		
		return result;
		
	}
	
	
}
