package com.ict.edu04.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu04.vo.AjaxMemberVO;

@Repository
public class AjaxMemberDAOImpl implements AjaxMemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<AjaxMemberVO> getMemberList() {
		return sqlSessionTemplate.selectList("ajaxmembers.getMembersList");
	}
	@Override
	public String getMemberIdChk(String m_id) {
		// 있으면 1, 없으면 0
		int result = sqlSessionTemplate.selectOne("ajaxmembers.getMemberIdChk", m_id);
		return String.valueOf(result);
	}
	
	
	@Override
	public AjaxMemberVO getMemberDetail(String m_idx) {
		return null;
	}
	@Override
	public String getMemberDelete(String m_idx) {
		return "";
	}
	@Override
	public String getMemberInsert(AjaxMemberVO mvo) {
		// 자동 commit
		int result = sqlSessionTemplate.insert("ajaxmembers.getMemberInsert", mvo);
		return String.valueOf(result);
	}
	@Override
	public String getMemberUpdate(AjaxMemberVO mvo) {
		// TODO Auto-generated method stub
		return "";
	}
	public AjaxMemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
}
