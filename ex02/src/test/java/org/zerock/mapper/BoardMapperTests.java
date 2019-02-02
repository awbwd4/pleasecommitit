package org.zerock.mapper;

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
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
	
	@Test
	public void testInsert() {
		System.out.printf("\n\n\n");
		System.out.println("삽입 테스트 시작");
		System.out.printf("\n\n\n");
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
	
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertKey() {
		System.out.printf("\n\n\n");
		System.out.println("key 삽입 테스트 시작");
		System.out.printf("\n\n\n");
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	
	@Test
	public void testRead() {
		
		System.out.printf("\n\n\n");
		System.out.println("조회 테스트 시작");
		System.out.printf("\n\n\n");
		
		
		//존재하는 게시물 번호로 테스트함.
		BoardVO board = mapper.read(5L);
		
		log.info(board);
		
	}
	
	
	@Test
	public void testDelete() {
		
		
		System.out.printf("\n\n\n");
		System.out.println("삭제 테스트 시작");
		System.out.printf("\n\n\n");
		
		
		log.info("*******************삭제 delete count : "+mapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {
		System.out.printf("\n\n\n");
		System.out.println("업데이트 테스트 시작");
		System.out.printf("\n\n\n");
		//read()를 이용해서 가져온 BoardVO 객체의 일부를 수정하는 방식이자만
		//직접 BoardVO 객체를 생성해서 처리할 수 있음.
		
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("********************업데이트 update count : "+count);
		
	}
	
	
}
