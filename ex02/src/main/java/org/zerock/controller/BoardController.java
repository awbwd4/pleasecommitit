package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
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
	
	
	
	////목록 불러오기
	@GetMapping("/list")
	public void list(Model model) {
		
		System.out.printf("\n\n\n");
		System.out.printf("board controller - 목록 조회 메서드 list() 실행");
		System.out.printf("\n\n\n");
		
		
		log.info("list");
		model.addAttribute("list", service.getList());
		
	}
	
	
	
	
	
	////등록///
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		/*
		 * String을 리턴 타입으로, RedirectAttributes를 파라미터로.
		 * -> 등록 작업이 끝난 후 다시 <목록 화면>으로 이동하기 위함.
		 * -> 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달하기 위해 RedirectAttributes를 이용.
		 * 
		 * */
		System.out.printf("\n\n\n");
		System.out.printf("board controller - 등록 메서드 register() 실행");
		System.out.printf("\n\n\n");
		
		log.info("register: "+board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/ist";
		/*리턴 시 'redirect:' 접두어를 사용 -> 이를 이용하면 스프링 mvc가
		* 내부적으로 response.sendRedirect()를 처리해줌.
		*/
	}
	
	

	//등록된 게시물 조회 처리.
	//조회 처리는 특별한 경우가 아니라면 get방식으로 처리한다.
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		System.out.printf("\n\n\n");
		System.out.printf("board controller - 조회 메서드 get() 실행");
		System.out.printf("\n\n\n");
		
		log.info("/get");
		model.addAttribute("board", service.get(bno));
		
	}
	
	
	//게시글 수정

	/* 등록 작업과 유사함. 변경된 내용을 수집, BoardVO 파라미터로 처리하고
	 * BoardService를 호출함.
	 * 수정작업을 시작하는 화면은 get방식으로 접근하지만,
	 * 실제작업은 post방식으로 동작 
	 * */
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		
		System.out.printf("\n\n\n");
		System.out.printf("board controller - 수정 메서드 modify() 실행");
		System.out.printf("\n\n\n");
		
		
		log.info("modify: "+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		//service.modify()는 수정 성공 여부를 boolean으로 처리함.
		//성공한 경우에만 RedirectAttributes에 추가함.
		return "redirect:/board/list";
	}
	
	
	//삭제 처리
	//삭제는 반드시 post방식으로만 처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, 
			RedirectAttributes rttr) {
		//삭제 후 페이지 이동이 필요 하므로 RedirectAttributes를 파라미터로 이동함.
		
		System.out.printf("\n\n\n");
		System.out.printf("board controller - 삭제 메서드 remove() 실행");
		System.out.printf("\n\n\n");
		
		
		log.info("remove......." + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
		//삭제 처리 후에 다시 목록 페이지로 이동.
	}
	
	
	
}
