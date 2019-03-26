package com.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping(value = "/sample")
@Log4j
public class SampleController {

	
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	//produces 속성 : 해당 메서드가 생산하는 MIME 타입.
	public String getText() {
		
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
		
	}
	
	
	
	
}
