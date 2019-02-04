package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;


@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		//Exception 클래스 타입의 예외를 처리하는 메소드
		//Exception 클래스 타입을 다루고 있으므로, 
		//모든 타입의 예외는 이 exception()메소드에서 해결한다.
		
		//특정 타입의 예외를 다루고 싶으면 Exception.class 대신에
		//구체적인 예외의 클래스를 지정해야 함.
		
		log.error("Exception......"+ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		
		
		return "error_page";
		//리턴값이 문자열이므로 jsp ㅍ일의 경로가 됨.
		//즉 error_page.jsp
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";
	}
	
	
	
	
	
}
