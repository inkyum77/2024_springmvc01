package com.ict.edu05.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
	@GetMapping("/email")
	public ModelAndView emailForm() {
		return new ModelAndView("email_form");
	}
		
	
	@PostMapping("/email_send")
	public ModelAndView sendMail(@RequestParam("email") String email, HttpServletRequest request) {
		try {
			ModelAndView mv = new ModelAndView("day05/email_chk_form");
			Random random = new Random();
			String randomNumber = String.valueOf(random.nextInt(10000000));
			
			if(randomNumber.length() < 6) {
				int substract = 6 - randomNumber.length();
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<substract; i++) {
					sb.append("0");
				}
				sb.append(randomNumber);
				randomNumber = sb.toString();
			}
			
			System.out.println("임시번호 : " + randomNumber);
			
			// 해당 임시번호를 DB에 저장하기 또는 세션에 저장하기
			request.getSession().setAttribute("email_chk", randomNumber);
			
			//EmailService 호출해서 사용하기
			return mv;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping("/email_send_chk")
	public ModelAndView sendMailChk(@RequestParam("authNumber") String authNumber, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("day05/email_form");
		String sessionNumber = (String)request.getSession().getAttribute("sessionNumber");
		
		if(authNumber.equalsIgnoreCase("sessionNumber")) {
			mv.addObject("chk", "1");
		}
		return mv;
	}
}
