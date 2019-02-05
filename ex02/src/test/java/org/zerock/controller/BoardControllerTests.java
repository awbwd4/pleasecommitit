package org.zerock.controller;

import org.junit.Before;
//import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
//@AllArgsConstructor
public class BoardControllerTests {

	//컨트롤러 테스트
	@Setter(onMethod_ = @Autowired )
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	/*mock : 가짜의
	 * 가짜 mvc.
	 * 가짜로 url과 파라미터 등을 브라우저에서 사용하는 것처럼 만들어서 
	 * controller를 실행해 볼 수 있음.
	*/
	
	
	//@Before(value = "")
	//모든 테스트 전에 매번 실행되는 메서드
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap()
				
				);
	}

	//등록 테스트
	@Test
	public void testRegister()throws Exception{
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/board/register")//post 방식으로 전달함.
				.param("title", "테스트 새 글 제목")//전달해야 하는 파라미터들을 지정해 줌.<input> 태그와 유사
				.param("content","테스트 새글 내용")
				.param("writer", "user00")
				)
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}


	//조회 테스트
	@Test
	public void testGet() throws Exception{
		
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView().getModelMap());
	}

	
	//수정 테스트
	@Test
	public void testModify() throws Exception{
		
		String resultPage = mockMvc
			.perform(MockMvcRequestBuilders.post("/board/modify")
			.param("bno", "1")
			.param("title", "수정된 테스트 새글 제목")
			.param("content", "수정된 테스트 새글 내용")
			.param("writer", "user00"))
		.andReturn().getModelAndView().getViewName();
		
		
	  log.info(resultPage);
		
	}
	
	
	//삭제 테스트
	@Test
	public void testRemove() throws Exception{
		//삭제 전 데이터 베이스에서 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "53")
				).andReturn().getModelAndView().getViewName();
		//mockMvc를 이용해서 파라미터를 전달하 ㄹ때에는 문자열로만 처리해야함.
		
		
		log.info(resultPage);
		
	}
	
	
	
	
	
	
}
