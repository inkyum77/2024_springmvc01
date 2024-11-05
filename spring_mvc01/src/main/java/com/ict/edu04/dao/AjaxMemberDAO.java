package com.ict.edu04.dao;

import java.util.List;

import com.ict.edu04.vo.AjaxMemberVO;


public interface AjaxMemberDAO {
	public List<AjaxMemberVO> getMemberList();
	public String getMemberIdChk(String m_id) ;
	public AjaxMemberVO getMemberDetail(String m_idx);
	public String getMemberInsert(AjaxMemberVO mvo);
	public String getMemberDelete(String m_idx);
	public String getMemberUpdate(AjaxMemberVO mvo);
}
