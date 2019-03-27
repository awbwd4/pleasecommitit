package com.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerock.domain.SampleVO;

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
	
	
	@GetMapping(value = "/getSample",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
						MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+" First", i+" Last"))
				.collect(Collectors.toList());
		//내부적으로 1부터 10 미만까지의 루프를 처리하면서 SampleVO 객체를 만듦 -> List<SampleVO>로 만들어냄.
	}
	
	@GetMapping(value ="/getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<>();
		
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		
		return map;
	}
	
	@GetMapping(value="/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(double height, double weight){
		//ResponseEntity는 데이터와 함께 http 헤더의 상태 메시지를 같이 전달하는 용도로 쓰임.
		
		
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		
		
		
		return result;
	}
	
	
}
