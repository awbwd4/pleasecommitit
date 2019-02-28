package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	
	BoardService service;
	
	//글 작성 get
	@RequestMapping(value = "/writer", method = RequestMethod.GET)
	public void getWrite() throws Exception{
		log.info("========================get write==========================================");
	}
	
	//글작성 post
	@PostMapping("/write")
	public String postWrite(BoardVO vo) throws Exception{
		log.info("========================post write==========================================");
		
			service.write(vo);
		return "redirect:/";
	}
	
	
}
