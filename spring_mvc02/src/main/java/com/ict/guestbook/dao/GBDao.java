package com.ict.guestbook.dao;

import java.util.List;

import com.ict.guestbook.vo.GuestBookVO;

public interface GBDao {
	//리스트
	public List<GuestBookVO> getGuestBookList();
	//삽입
	public int getGuestBookInsert(GuestBookVO gbvo);
	//상세보기
	public GuestBookVO getGuestBookDetail(String idx);
	//수정하기
	public int getGuestBookUpdate(GuestBookVO gbvo); 
	//삭제하기
	public int getGuestBookDelete(String idx);
}
