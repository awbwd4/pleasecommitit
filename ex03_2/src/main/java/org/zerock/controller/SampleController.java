package org.zerock.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value="/getText", 
			produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		log.info("MIME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value = "/getSample"
			/*
			,
			produces = {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE}
	*/
	)
	public SampleVO getSample() {
		
		return new SampleVO(112, "스타", "로드");
	
	}
	
	
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1,10)
			.mapToObj(i -> new SampleVO(i, i+"First", i+"Last"))
			.collect(Collectors.toList());
		
	}
	
	
	@GetMapping(value="getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		//responseEntity : 데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도
		//HTTP의 상태코드와 에러 메시지 등을 데이터와 함께 전달 가능
		//요청한 쪽에서는 데이터를 받을 때 해당 데이터가 정상적인지 비정상적인지 구분 할 수 있음. 
		
		SampleVO vo = new SampleVO(0, "" + height, ""+weight);
		//전달할 데이터
		
		
		ResponseEntity<SampleVO> result = null;
		//정상 데이터인지 아닌지 판별하기 위해, ResponseEntity객체에 상태와 데이터(vo)를 담아서
		//요청한 쪽으로 보낸다. 
		
		if (height<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		log.info("========================내용 확인=================================");
		log.info("firstName : "+height+"  // lastName : "+weight);
		log.info("========================내용 확인=================================");
		
		return result;
	}
	
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) {
		//URL 자체에 데이터를 식별할 수 있는 정보들을 표현, 이 정보들을 컨트롤러 메서드의 파라미터로 사용.
		//파라미터 값은 기본형이될 수 없고, 참조형이어야 한다. 
		
		
		return new String[] {"category : "+cat, "productid : "+pid};
		
	}
	
	@PostMapping("/ticket")
	//@RequestBody는 말 그대로 요청한(request) 내용(body)을 처리함 
	//->일반적인 파라미터 전달방식 사용 불가
	public Ticket convert(@RequestBody Ticket ticket) {
		
		//requestBody : json 데이터를 원하는 타입의 객체로 변환해야 하는 경우에 주로 사용.
		//여기서는 json으로 전달되는 데이터를 받아서 ticket 타입으로 변
		log.info("convert.........................ticket"+ticket);
		
		
		return ticket;
	}
}
