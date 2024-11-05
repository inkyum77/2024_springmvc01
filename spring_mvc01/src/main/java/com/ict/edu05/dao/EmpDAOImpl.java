package com.ict.edu05.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu05.vo.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO{
	
	//root.context에 넣는 방법도 있음
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<EmpVO> getList() throws Exception {
		
		return sqlSessionTemplate.selectList("emp.list");
	}
	@Override
	public List<EmpVO> getSearch(String deptno) throws Exception {
		
		return sqlSessionTemplate.selectList("emp.search", deptno);
	}
	@Override
	public List<EmpVO> getSearch(String idx, String keyword) throws Exception {
		//mybatis에서 파라미터가 2개 이상일 때는 vo를 이용하거나, map을 사용하는 방법이 있다.
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("idx", idx);
		return sqlSessionTemplate.selectList("emp.dynamic2", map);
	}
	@Override
	public List<EmpVO> getSearch(EmpVO empvo) throws Exception {

		return sqlSessionTemplate.selectList("emp.dynamic", empvo);
	}
	
	
}
