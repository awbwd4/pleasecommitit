package com.kuzuro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuzuro.domain.BoardVO;
import com.kuzuro.persistence.BoardDAO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;



@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardDAO dao;
	
	@Override
	public void register(BoardVO board) {
		log.info("==============================register====================================");
	
		dao.insert(board);
	}

	@Override
	public BoardVO get(int bno) {
		
		log.info("get......................................."+bno);
		
		return dao.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify.................."+board);
		
		return dao.update(board) == 1;
	}

	@Override
	public boolean remove(int bno) {

		log.info("remove........................"+bno);
		
		return dao.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		log.info("getList.....................");
		
		return dao.getList();
	}

	
	
	
	
}
