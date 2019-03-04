package com.kuzuro.service;

import java.util.List;

import com.kuzuro.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(int bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(int bno);
	
	public List<BoardVO> getList();

}
