package com.ict.member.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.member.service.MemberService;
import com.ict.member.vo.MemberVO;


@Controller
public class MemberContoller {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/member_login_page")
	public ModelAndView getLoginPage() {
		return new ModelAndView("shop/login_form");
	}
	
	@GetMapping("/join_page")
	public ModelAndView getJoinPage() {
		return new ModelAndView("shop/join_form");
	}
	
	@PostMapping("/join")
	public ModelAndView getMemberJoin(MemberVO mvo) {
		System.out.println(mvo.getM_name());
		try {
			ModelAndView mv = new ModelAndView("shop/login_form");
			
			String pwd = passwordEncoder.encode(mvo.getM_pw());
			
			MemberVO mvo2 = new MemberVO();
			mvo2.setM_id(mvo.getM_id());
			mvo2.setM_pw(pwd);
			mvo2.setM_name(mvo.getM_name());
			mvo2.setM_age(mvo.getM_age());
			
			int result = memberService.getMemberJoin(mvo2);
			
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping("/login")
	public ModelAndView getMemberLogin(MemberVO mvo, HttpSession session) {
		
		try {
			ModelAndView mv = new ModelAndView();
			System.out.println("m_id : " + mvo.getM_id());
			
			// member 로그인 정보
			MemberVO mvo2 =  memberService.getMemberInfo(mvo.getM_id());
			
			String front_pw = mvo.getM_pw();
			String back_pw = mvo2.getM_pw();
			
			// 입력한 아이디의 값이 db에 없으면
			if(mvo2 == null) {
				return new ModelAndView("shop/login_error");
			// 있으면
			} else {
				
				//비밀번호 확인
				if(passwordEncoder.matches(front_pw, back_pw)) {
					
					//성공
					session.setAttribute("loginchk", "ok");
					mv.setViewName("shop/top");
					
					if(mvo2.getM_id().equalsIgnoreCase("admin")) {
						session.setAttribute("admin", "ok");
					} else {
						session.setAttribute("admin", "no");
					}
					session.setAttribute("mvo", mvo2);
					return mv;	
			
				} else {
					// 비밀번호가 안 맞아서 로그인 실패
					// request에 값을 저장해서 loginForm에서 로그인 실패를 alert 할 수 있다.
					return new ModelAndView("shop/login_error");
				
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("shop/login_error");
	}

}
