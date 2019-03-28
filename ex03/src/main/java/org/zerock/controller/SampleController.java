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
	
	
	@GetMapping("product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		
		//@pathVariable : url상에 경로의 일부를 파라미터로 사용 가능
		
		return new String[] {"category: "+cat, "productid: " + pid};
	
	}

	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		/*RequsetBody
		 * 전달된 요청(request)의 내용(body)을 이용해서 해당 파라미터의 타입으로 변환 요구
		 * ->말 그대로 요청한 내용을 처리하기 때문에 일반적인 파라미터 전달방식 사용 불가
		 * ->postmapping사용
		 * 
		 * */
		
		
		log.info("convert............ticket" + ticket);
		
		return ticket;
	}
	
	
}


















