package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/"
		+ "spring/root-context.xml")
@Log4j
public class ReplyPageDTOtests {

	@Setter(onMethod_ = @Autowired)
	private ReplyService service;
	
	
	@Test
	public void testExist() {
		log.info("==============================================댓글 서비스 테스트1 : "+service);
		assertNotNull(service);
	}
	
	
	@Test
	public void testgetListPage() {
		service.getListPage(new Criteria(1,10), 5046509L);
	}
	
	
	
	
	
}
