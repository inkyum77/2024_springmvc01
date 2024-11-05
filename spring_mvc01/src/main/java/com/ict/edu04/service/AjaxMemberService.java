package com.ict.edu04.service;

import java.util.List;

import com.ict.edu04.vo.AjaxMemberVO;

public interface AjaxMemberService {
	public List<AjaxMemberVO> getMemberList();
	public String getMemberIdChk(String m_id) ;
	public AjaxMemberVO getMemberDetail(String m_idx);
	public String getMemberInsert(AjaxMemberVO mvo);
	public String getMemberDelete(String m_idx);
	public String getMemberUpdate(AjaxMemberVO mvo);
	
}
