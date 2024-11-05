package com.ict.member.dao;

import com.ict.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO getMemberInfo(String m_id);
	public int getMemberJoin(MemberVO mvo);
}
