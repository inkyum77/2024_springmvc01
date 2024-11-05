package com.ict.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.bbs.vo.BbsVO;
import com.ict.bbs.vo.CommVO;

@Repository
public class BbsDAOImpl implements BbsDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BbsVO> getBbsList() {
		return sqlSessionTemplate.selectList("bbs.list");
	}

	@Override
	public int getBbsInsert(BbsVO bvo) {
		return sqlSessionTemplate.insert("bbs.insert", bvo);
	}

	@Override
	public BbsVO getBbsDetail(String b_idx) {
		return sqlSessionTemplate.selectOne("bbs.detail", b_idx);
	}

	@Override
	public int getBbsDelete(String b_idx) {
		return sqlSessionTemplate.update("bbs.bbs_delete", b_idx);
	}

	@Override
	public int getBbsUpdate(BbsVO bvo) {
		return sqlSessionTemplate.update("bbs.bbs_update", bvo);
	}

	@Override
	public int getHitUpdate(String b_idx) {
		return sqlSessionTemplate.update("bbs.hit_update", b_idx);
	}

	@Override
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("bbs.count");
	}

	@Override
	public List<BbsVO> getBbsList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sqlSessionTemplate.selectList("bbs.paging", map);
	}

	@Override
	public List<CommVO> getCommentList(String b_idx) {
		return sqlSessionTemplate.selectList("bbs.clist", b_idx);
	}

	@Override
	public int getCommentInsert(CommVO cvo) {
		return sqlSessionTemplate.insert("cinsert", cvo);
	}

	@Override
	public int getCommentDelete(String c_idx) {
		return sqlSessionTemplate.delete("bbs.cdelete" ,c_idx);
	}
	
}
