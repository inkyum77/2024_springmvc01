package com.ict.guestbook.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.guestbook.vo.GuestBookVO;

@Repository
public class GBDaoImpl implements GBDao{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<GuestBookVO> getGuestBookList() {
		
		return sqlSessionTemplate.selectList("guestbook.list");
	}

	@Override
	public int getGuestBookInsert(GuestBookVO gbvo) {
		
		return sqlSessionTemplate.insert("guestbook.insert", gbvo);
	}

	@Override
	public GuestBookVO getGuestBookDetail(String gb_idx) {
		return sqlSessionTemplate.selectOne("guestbook.detail", gb_idx);
	}

	@Override
	public int getGuestBookUpdate(GuestBookVO gbvo) {
		return sqlSessionTemplate.update("guestbook.update", gbvo);
	}

	@Override
	public int getGuestBookDelete(String gb_idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
