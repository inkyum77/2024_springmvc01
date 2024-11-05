package com.ict.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.guestbook.dao.GBDao;
import com.ict.guestbook.vo.GuestBookVO;

@Service
public class GBServiceImpl implements GBService{
	
	@Autowired
	private GBDao gBDao;

	@Override
	public List<GuestBookVO> getGuestBookList() {
		return gBDao.getGuestBookList();
	}

	@Override
	public int getGuestBookInsert(GuestBookVO gbvo) {
		return gBDao.getGuestBookInsert(gbvo);
	}

	@Override
	public GuestBookVO getGuestBookDetail(String gb_idx) {
		return gBDao.getGuestBookDetail(gb_idx);
	}

	@Override
	public int getGuestBookUpdate(GuestBookVO gbvo) {
		return gBDao.getGuestBookUpdate(gbvo);
	}

	@Override
	public int getGuestBookDelete(String gb_idx) {
		return 0;
	}
	
}
