package com.ict.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.bbs.dao.BbsDAO;
import com.ict.bbs.vo.BbsVO;
import com.ict.bbs.vo.CommVO;

@Service
public class BbsServiceImpl implements BbsService{
    
	@Autowired 
	private BbsDAO bbsDAO;
	
	// 리스트
    public List<BbsVO> getBbsList (){
    	
		return null;
    }
    
    // 삽입
    public int getBbsInsert(BbsVO bvo) {
		return bbsDAO.getBbsInsert(bvo);
	}
    
    // 상세보기
    public BbsVO getBbsDetail(String b_idx) {
		return bbsDAO.getBbsDetail(b_idx);
	}
    
    // 원글 삭제
    public int getBbsDelete(String b_idx) {
		return bbsDAO.getBbsDelete(b_idx);
	}
    
    // 원글 수정 
    public int getBbsUpdate(BbsVO bvo) {
		return bbsDAO.getBbsUpdate(bvo);
	}
    
    // 조회수 업데이트
    public int getHitUpdate(String b_idx) {
		return bbsDAO.getHitUpdate(b_idx);
	}
    // 페이징 처리 - 전체 게시물의 수
    public int getTotalCount() {
    	
		return bbsDAO.getTotalCount();
	}
    
    // 페이징 처리을 위한 리스트 
    public List<BbsVO> getBbsList(int offset, int limit) {
    	
		return bbsDAO.getBbsList(offset, limit);
	}
    
    // 댓글 가져오기
    public List<CommVO> getCommentList(String b_idx) {
		return bbsDAO.getCommentList(b_idx);
	}
    // 댓글 삽입
    public int getCommentInsert(CommVO cvo) {
		return bbsDAO.getCommentInsert(cvo);
	}
    // 댓글 삭제
    public int getCommentDelete(String c_idx) {
		return bbsDAO.getCommentDelete(c_idx);
	} 
}
