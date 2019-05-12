package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {

		log.info(" service : register "+vo+"...............................................");
		
		//댓글 등록.
		//댓글이 등록되면, 게시글 목록에서 보여지는 댓글의 수 replycnt도 1 증가한다.
		boardMapper.updateReplyCnt(vo.getBno(),1);
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {

		log.info("service : get   "+rno+".................................");
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {

		log.info("service : modify    "+vo+"......................................");
		
		
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {

		log.info("service : remove      "+rno+".................................");
		
		ReplyVO vo = mapper.read(rno);
		//입력된 rno를 사용해 삭제될 댓글 객체 생성 -> 해당 댓글이 속한 게시글의 번호 bno를 구하기 위함
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		//게시글 목록에서 보여질 댓글 수 -1
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		log.info("service : get Reply of a Board      "+bno+".................................");
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno)
				//매퍼에서 해당 게시글의 댓글 목록과 댓글 수를 가져와서 replyPageDTO에 담음.
		);
	}

	
	
	
	
	
}
