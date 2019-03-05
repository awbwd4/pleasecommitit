package com.kuzuro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kuzuro.domain.BoardVO;
import com.kuzuro.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("=====================================controller : list=====================================");
		
		model.addAttribute("list", service.getList());
		
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") int bno, Model model) {
		
		log.info("/get");
		model.addAttribute("board", service.get(bno));
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("modifiy:"+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
			
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		
		log.info(bno+"remove..................................................................................................");
		
		if(service.remove(bno)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
	
}
