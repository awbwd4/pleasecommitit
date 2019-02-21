package com.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
//해당 객체가 스프링 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시

@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	//이 메서드가 ()안에 들어가는 예외 타입을 처리한다는 것을 의미
	//Exception.class이므로 모든 예외에 대한 처리가 exception()만을 이용해 처리함.
	public String except(Exception ex, Model model) {
		
		log.error("Exception.........."+ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		
		return "error_page";
	}
	
	
	//404에러 처리 메소드
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		
		return "custom404";
	}
	
	
}
