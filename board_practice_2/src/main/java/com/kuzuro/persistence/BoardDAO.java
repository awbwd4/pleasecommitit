package com.kuzuro.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kuzuro.domain.BoardVO;

public interface BoardDAO {

	//@Select("select * from myBoard where bno > 0")
	public List<BoardVO> getList();
	
	
	
}
