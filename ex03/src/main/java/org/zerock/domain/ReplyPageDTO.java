package org.zerock.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
//@Getter
public class ReplyPageDTO {
	//댓글 목록과 전체 댓글의 수를 전달하기 위한 객체
	private int replyCnt;
	private List<ReplyVO> list;
	
	
}
