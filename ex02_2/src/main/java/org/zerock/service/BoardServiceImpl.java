package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Log4j
@Service
@AllArgsConstructor
//모든 파라미터(필드)를 이용하는 생성자를 만듦
public class BoardServiceImpl implements BoardService{
	
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	//private int a;
	
	/*@AllArgsConstructor 애노테이션을 붙여주면
	 * 이 클래스에 있는 모든 필드를 파라미터로 갖는
	 * 생성자가 자동으로 만들어진다.
	 * */
	
	
	
	

	@Override
	public void register(BoardVO board) {
		
		log.info("register................."+board);
		
		mapper.insertSelectKey(board);

	}

	@Override
	public BoardVO get(Long bno) {

		log.info("get................................"+bno);
	
		return mapper.read(bno);
	
	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify.............."+board);
		
		
		
		return mapper.update(board) == 1;
		//수정, 삭제가 이뤄지면 1이라는 값이 반환됨.
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove................................."+bno);
		
		return mapper.delete(bno) == 1;
		
	}

	/*
	@Override
	public List<BoardVO> getList() {

		log.info("getList.............................................");
		
		return mapper.getList();
		
	}
	*/
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("//////////////////////////////////////////////////////////getList with criteria : "+cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {

		log.info("/////////////////////////////////////////get total count/////////////////////////////////////////////");
		
		return mapper.getTotalCount(cri);
	}

}
