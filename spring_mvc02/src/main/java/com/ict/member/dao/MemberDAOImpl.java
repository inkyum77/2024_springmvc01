package com.ict.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public MemberVO getMemberInfo(String m_id) {
		return sqlSessionTemplate.selectOne("member.login", m_id);
	}

	@Override
	public int getMemberJoin(MemberVO mvo) {
		return sqlSessionTemplate.insert("member.join", mvo);
	}
	
}
