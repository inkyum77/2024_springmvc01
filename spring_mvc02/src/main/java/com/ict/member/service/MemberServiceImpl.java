package com.ict.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.member.dao.MemberDAO;
import com.ict.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO getMemberInfo(String m_id) {
		return memberDAO.getMemberInfo(m_id);
	}

	@Override
	public int getMemberJoin(MemberVO mvo) {
		return memberDAO.getMemberJoin(mvo);
	}
	
}
