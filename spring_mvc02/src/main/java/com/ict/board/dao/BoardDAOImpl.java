package com.ict.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getBoardList(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardInsert(BoardVO bovo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBoardHit(String bo_idx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getBoardDetail(String bo_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLevUpdate(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAnsInsert(BoardVO bovo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBoardDelete(BoardVO bovo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBoardUpdate(BoardVO bovo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
