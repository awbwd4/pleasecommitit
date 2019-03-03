package com.kuzuro.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kuzuro.domain.BoardVO;

public interface BoardDAO {

	//@Select("select * from myBoard where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(int bno);
	
	public int delete(int bno);
	
	public int update(BoardVO board);
	
	
	/*
	 * 인터페이스와 xml을 함께 쓰면?
	 * 다른데에서 호출하는것은 매퍼의 인터페이스에 있는 메소드이지만
	 * 실제 sql 작업은 xml에서 이루어진다!!
	 * 
	 * */
	
}
