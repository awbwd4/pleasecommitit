package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
///org.zerock.controller 패키지는 
//servlet-context.xml에 스캔하도록 등록되어 있음
	
/*
 * BoardController는 
 * BoardService에 대해 의존적이므로
 * @AllArgsConstructor를 이용해 생성자를 만들고
 * 자동주입하도록 함.
 * */
	
	
	private BoardService service;
	//@AllArgsConstructor 어노테이션을 통해
	//이 필드에 BoardService 객체의 생성자가
	//자동주입된다.
	
	//이렇게 생성자를 자동주입하지 않을경우
	//@Setter(onMethod_ = {@Autowired})를
	//이용해서 처리한다.
	
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
		
	}
	
	
	
	
	
	
}
