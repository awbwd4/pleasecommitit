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
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
