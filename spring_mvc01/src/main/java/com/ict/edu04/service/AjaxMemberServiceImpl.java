package com.ict.edu04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu04.dao.AjaxMemberDAO;
import com.ict.edu04.vo.AjaxMemberVO;

@Service
public class AjaxMemberServiceImpl implements AjaxMemberService{

	@Autowired
	private AjaxMemberDAO ajaxMemberDAO;
	
	@Override
	public List<AjaxMemberVO> getMemberList() {
		return ajaxMemberDAO.getMemberList();
	}

	@Override
	public AjaxMemberVO getMemberDetail(String m_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemberInsert(AjaxMemberVO mvo) {
		return ajaxMemberDAO.getMemberInsert(mvo);
	}

	@Override
	public String getMemberDelete(String m_idx) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMemberUpdate(AjaxMemberVO mvo) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMemberIdChk(String m_id) {
		return ajaxMemberDAO.getMemberIdChk(m_id);
	}
}