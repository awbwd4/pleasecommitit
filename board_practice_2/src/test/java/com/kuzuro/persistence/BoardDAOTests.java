package com.kuzuro.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kuzuro.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTests {

	@Setter(onMethod_ = @Autowired)
	private BoardDAO dao;
	
	/*
	@Test
	public void testGetList() {
		dao.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newBie");
		
		dao.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		
		BoardVO board = dao.read(5);
		
		log.info(board);
		
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: "+dao.delete(3));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(5);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
	
		int count = dao.update(board);
		log.info("update count :  "+count);
	
	}
	*/
	
	@Test 
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새 글");
		board.setContent("새 내용");
		board.setWriter("newbie");
		
		dao.insert(board);
		
		log.info(board);
		
	}
	
	
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		
		
		board.setTitle("새 글 select key");
		board.setContent("새 내용 select key");
		board.setWriter("newbie select key");
		
		dao.insertSelectKey(board);
		
		log.info(board);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
