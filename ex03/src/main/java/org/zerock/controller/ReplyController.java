package org.zerock.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
	
	
	
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE}	)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
	
		/* 댓글 등록 :
		 *  - 전송방식 : post
		 *  - 브라우저에서 서버로 전송: json타입으로 입력
		 *  - 서버는 처리 결과를 브라우저에 알려줌 : string type
		 * 
		 * RequestBody : 브라우저에서 전송된 댓글-json데이터를 ReplyVO 타입으로 변환하도록 지정.
		 * 
		 * */
		log.info("ReplyVO: "+vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT: "+insertCount);
		
		return insertCount == 1
			?   new ResponseEntity<>("success", HttpStatus.OK)
			  : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			// 댓글이 추가된 후 나온 숫자를 확인해서 그 결과를 반환함. 
	}
	
	
	
	
	//댓글 목록.
	@GetMapping(value="/pages/{bno}/{page}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
		
		
		//게시글의 댓글 목록과 댓글의 수가 담긴 ReplyPageDTO를 뷰로 전송
		log.info("getList..................................");
		Criteria cri = new Criteria(page, 10);
		
		
		log.info("get Reply List bno : "+bno);
		log.info(cri);
		
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
	
	// 댓글 조회
	@GetMapping(value="/{rno}",
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		
		log.info("get: "+rno);
		
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	
	//댓글 삭제
	@DeleteMapping(value="/{rno}",
			//consumes = {"application/json"},
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		log.info("remove : "+rno);
		
		
		return service.remove(rno) == 1
			? new ResponseEntity<>("success", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//댓글 수정
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{rno}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<String> modify(
						@RequestBody ReplyVO vo,
						@PathVariable("rno") Long rno){
		
		vo.setRno(rno);
		
		log.info("rno : "+rno);
		log.info("modify : "+vo);
	
		return service.modify(vo) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	

	public ResponseEntity<ReplyPageDTO> getList2(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
		
		Criteria cri = new Criteria(page, 10);
		
		log.info("get rely list bno : "+bno);
		
		log.info("cri:"+cri);
		
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
	
	
}
