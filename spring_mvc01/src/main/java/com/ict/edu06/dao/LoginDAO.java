package com.ict.edu06.dao;

import com.ict.edu06.vo.LoginVO;

public interface LoginDAO {
	public LoginVO LoginChk(LoginVO lvo) throws Exception;
	
	public int LoginJoin(LoginVO lvo) throws Exception;
}
