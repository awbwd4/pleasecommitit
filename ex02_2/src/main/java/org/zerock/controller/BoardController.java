package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
//   '/board'로 시작하는 모든 처리를 BoardController가 하도록 지정함.
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	/*
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
		
	}
	*/
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list : "+cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		//게시글 목록을 조회할때 아래에 페이징 처리가 돼있어야 하므로 
		//list메소드에서 PageDTO도 처리해준다. 
		//근데 total이 123 : 전체 데이터수를 구하는 처리가 아직 이뤄지지 않았으므로
		//임의로 123을 줌.
	}
	
	
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		 /* RedirectAttributes 파라미터 : 등록 작업이 끝난 후 다시 목록으로 이동하기 위함.
		 * 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달하기 위해서
		 * RedirectAttributes를 이용
		 * */
		
		log.info("register: "+board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
//		return "redirect:/board/list";
		return "redirect:/board/list";
		
		//redirect 접두어 : 스프링 mvc가 내부적으로 response.sendRedirect()를 처리해줌.
	}
	
	
	 @GetMapping("/register") 
	 public void register() {
		 
		 //board/register 를 요청하면 이 컨트롤러를 통해 바로 register.jsp로 이동
		 
		 //<form role="action" action="board/register" method="post">
		 //위의 form태그를 통해 컨트롤러의 post방식 register 실행
	 
	 }
	
	
	
	
	
	
	
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("/get or modifi");
		model.addAttribute("board", service.get(bno));
		//수정, 삭제가 가능한 화면으로 이동.
	}
	
	@PostMapping("modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("modify : "+ board);
		
		if(service.modify(board)) {
			/*service.modify()는 수정여부를 boolean으로 처리
			 * 이를 이용해서 성공한 경우에만
			 * RedirectAttributes에 추가함.
			 * */
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,
			RedirectAttributes rttr) {
		
		log.info("remove...................."+bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");}
		

		return "redirect:/board/list";
				
	}
	
	
	
}
