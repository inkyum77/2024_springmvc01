package com.ict.edu06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu06.service.LoginService;
import com.ict.edu06.vo.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// 로그인 폼으로 이동
	@GetMapping("/login_loginForm")
	public ModelAndView getLoginForm() {
		return new ModelAndView("day06/login_loginForm");
	}
	
	//회원가입 폼으로 이동
	@GetMapping("/login_joinForm")
	public ModelAndView getJoinForm() {
		return new ModelAndView("day06/login_joinForm");
	}
	
	
	// 회원가입
	@PostMapping("/login_join")
	public ModelAndView getLoginJoin(LoginVO lvo) {
		try {
			ModelAndView mv = new ModelAndView("day06/login_loginForm");
			
			//비밀번호 암호화
			String m_pw = passwordEncoder.encode(lvo.getM_pw());
			lvo.setM_pw(m_pw);
			
			int result = loginService.LoginJoin(lvo);
			if(result > 0) {
				mv.addObject("result", "1");
			}else {
				mv.addObject("result", "0");
			}
			return mv;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	@PostMapping("/login_login")
	public ModelAndView getLogin(LoginVO lvo) {
		ModelAndView mv = new ModelAndView("index");
		try {
			//1. 아이디 가지고 db 갔다 오기
			LoginVO loginVO = loginService.LoginChk(lvo);
			
			if(loginVO != null) {
				String userM_pw = lvo.getM_pw();
				
				if(passwordEncoder.matches(userM_pw, loginVO.getM_pw())) {
					mv.setViewName("index");
					return mv;
				} else {
					mv.addObject("loginchk", "아이디나 비밀번호가 틀렸습니다.");
					
				}
			}
			//2. 사용자가 입력한 암호 암호화하기
			//3. 두 암호를 비교해서 같으면 성공 다르면 실패
		} catch (Exception e) {
			System.err.println(e);
		}
		return mv;
	}
}
