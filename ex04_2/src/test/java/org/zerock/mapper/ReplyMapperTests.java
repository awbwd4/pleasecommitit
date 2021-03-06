package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	private Long[] bnoArr = {5046501L,5046502L,5046503L,5046504L,
			5046505L,5046506L,5046507L,5046508L,5046509L		
	};
	
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	/*
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i ->{
			
			ReplyVO vo = new ReplyVO();
			
			//게시물 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트"+i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
		});
		
	}
	 */
	/*
	@Test
	public void testRead() {
		
		Long targetRno = 21L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("==============================댓글 삭제 테스트 수행=================================");
		long targetRno = 21L;
		
		int deleted = mapper.delete(targetRno);
		
		log.info("deleted : "+deleted);
		
	}
	
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 22L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("updated Reply");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT : "+count);
		
	}
	 */
	
	
	/*
	@Test
	public void testList() {
		
		Criteria cri = new Criteria();
	
		//5046501L
		List<ReplyVO> replies 
			= mapper.getListWithPaging(cri, bnoArr[0]);
	
		replies.forEach(reply -> log.info(reply));
	}
	 */
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(2, 10);
		
		//5046509L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 5046509L);
		
		replies.forEach(reply -> log.info(reply));
		
		
	}
	
	@Test
	public void testCount() {
		
		long bno = 5046509L;
		
		int count = mapper.getCountByBno(bno);
		
		log.info(bno+"번 게시글 댓글 수==============================count : "+count);
		
	}
	
	
	
	
}
