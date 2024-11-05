package com.ict.member.service;

import com.ict.member.vo.MemberVO;

public interface MemberService {
	public MemberVO getMemberInfo(String m_id);
	public int getMemberJoin(MemberVO mvo);
	
}
