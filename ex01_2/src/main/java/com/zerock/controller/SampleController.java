package com.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
//requestMapping 어노테이션 : 현재 클래스의 모든 메서드들의 기본적인 URL경로가 됨.
// sample/aaa 모양새의 모든 URL은 sampleController에서 처리된다.
@Log4j
public class SampleController {

	/*
	 * sample/aaa의 형태로 요청이 들어옴 -> 일단 dispatcher servlet으로 요청이 간다
	 *  그 후 handlerMapping이 이 요청을 처리할 sampleController를 찾아줌
	 *  이 후 handlerAdapter가 sampleController를 구동함.
	 *  이제 이 SampleController가 해당 요청을 처리함 
	 *  Controller는 개발자가 직접 구현함.
	 * */

	@RequestMapping("")
	public void basic() {
		
		log.info("basic=================================================");
		
	}
	
	
	@RequestMapping(value = "/basic", 
			method = {RequestMethod.GET, RequestMethod.POST})
	//get과 post방식 모두를 지원해야 하는 경우 배열로 처리.
	public void basicGet() {
		log.info("basic Get==============================");
	}
	
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		
		log.info("basic get only get===============================");
		//getmapping의 경우 get방식에만 사용할 수 있으므로,
		//간편하기는 하지만 기능에 대한 제한이 많음
		
	}
	
	
	@GetMapping("/ex01")
	//Get방식이므로 파라미터에 넣기위해 필요한 정보는 URL에 추가함.
	public String ex01(SampleDTO dto) {
		
		log.info(""+dto);
		
		return "ex01";
		
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
			@RequestParam("age") int age) {
		
		log.info("name : "+ name);
		log.info("age : "+ age);
	
		return "ex02";	
	}
	
	@GetMapping("/ex02List")
	public String ex02List(
			@RequestParam("ids")ArrayList<String> ids) {
		/*ids라는 이름의 파라미터가 여러개 전달되어도
		* ArrayList<String>이 생성되어 자동으로 수집됨.
		*/
		
		
		log.info("ids : "+ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		
		log.info("array ids : " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	
	
	
	
	
}
