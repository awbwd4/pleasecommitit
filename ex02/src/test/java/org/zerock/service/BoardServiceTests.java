package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired })
	private BoardService service;
	//첫 테스트는 boardService 객체가 제대로 주입이 가능한지 확인하는 작업으로 싲가함.
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testResgister() {
		
	System.out.printf("\n\n");
	System.out.printf("test - 게시물 등록");
	System.out.printf("\n\n");
		
		
	BoardVO board = new BoardVO();
	board.setTitle("새로 작성하는 글");
	board.setContent("새로 작성하는 내용");
	board.setWriter("newBie");
	
	service.register(board);
	
	log.info("생성된 게시물의 번호 : "+ board.getBno());
	
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
		
	}
	
	
	@Test
	public void testGet() {
		
		System.out.printf("\n\n\n\n");
		System.out.println("test - 게시물 조회");
		System.out.printf("\n\n\n\n");
			
		log.info(service.get(1L));
	}

	@Test
	public void testDelete() {
		
		//게시물 번호의 존재 여부를 확인하고 테스트 할 것.
		log.info("REMOVE RESULT : "+ service.remove(2L));
		
	}

	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(1L);
		//수정할 게시물을 불러옴
		
		
		if (board == null) {
			return;
		}
		board.setTitle("제목 수정합니다. ");
		//수정된 게시물을 mapper를 통해 데이터베이스에 저장함.
		
		log.info("MODIFY RESULT: "+service.modify(board));
		
	}
	
	
	
	
	
}
