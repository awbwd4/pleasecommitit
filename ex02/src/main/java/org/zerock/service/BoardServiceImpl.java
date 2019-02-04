package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Service//서비스 계층임을 나타냄. 

//로그 작성을 위한 어노테이션들
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;//스프링 4.3이상에서 자동 처리
	
	/* 스프링 4.3부터는 단일 파라미터를 받는 생성자의 경우
	 * 필요한 파라미터를 자동으로 주입할 수 있음.
	 * 
	 * @AllArgsConstructor는 모든 파라미터를 이용하는 생성자를 만듦
	 * 
	 * 
	 * */
	
	
	
	
	@Override
	public void register(BoardVO board) {

		log.info("register......"+board);
	
		mapper.insertSelectKey(board);
		//mapper의 insertSelectKey()를 이용해서  생성된 게시물의
		//번호를 확인할 수 있도록 함.
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get................"+bno);
		
		return mapper.read(bno);
	}

	
	
	/*
	 * 삭제/수정은 메서드의 리턴 타입을 void로 설계할 수도 있지만 
	 * 엄격하게 처리하기 위해서 boolean으로 처리하는게 일반적
	 * */
	
	
	
	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify........."+board);
	
		return mapper.update(board) == 1;
		//update가 성공했을 때 mapper.xml의 sql은 1을 리턴함.
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove............"+bno);
	
		return mapper.delete(bno) == 1;
	}

	
	@Override
	public List<BoardVO> getList() {

		log.info("getList.......................");
		
		return mapper.getList();
	}

}
