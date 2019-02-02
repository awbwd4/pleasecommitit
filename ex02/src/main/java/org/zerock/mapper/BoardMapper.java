package org.zerock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;


public interface BoardMapper {

	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	//BoardMapper.xml에 sql문이 처리되었으므로 
	//이 SQL은 삭제함.

	
	
	public void insert(BoardVO board);
	//단순히 시퀀스의 다음 값을 구해서 insert할 때 사용함.
	//insert문은 단순ㄴ히 몇 건의 데이터가 변경 되었는지만을 알려주기 때문에
	//추가된 데이터의 PK값을 알 수 없음.
	//but, 1번의 sql 처리만으로 작업이 완료됨.
	
	public void insertSelectKey(BoardVO board);
	/*
	 * insertSelectKey()는 @SelectKey라는 mybatis어노테이션을 사용
	 * @selectkey는 주로 pk값을 미리(before) sql을 통해서 처리해두고
	 * 특정한 이름으로 결과를 보관하는 방식
	 * 
	 * xml의 sql문을 보면 @insert할 때
	 * #{bno}와 같이 이미 처리된 결과를 이용함.
	 * 
	 * */
	
	
	//insert된 데이터를 조회 -> pk를 이용해서 처리함.
	public BoardVO read(Long bno);
	
	
	public int delete(Long bno);
	/* 리턴타입 int : 정상적으로 데이터가 삭제되면 1이상의 값을 갖도록
	 * */	
	
	public int update(BoardVO board);
	
	
	
}
