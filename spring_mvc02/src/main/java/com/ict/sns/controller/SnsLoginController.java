package com.ict.sns.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ict.sns.KakaoVO.KakaoVO;
import com.mysql.cj.Session;

@Controller
public class SnsLoginController {
	
	@GetMapping("/sns_login")
	public ModelAndView getSpringSns() {
		ModelAndView mv = new ModelAndView("sns/loginForm");
		return mv;
	}
	
	@RequestMapping("/kakaologin")	
	public ModelAndView kakaoLogin(HttpServletRequest request) {
		//인가 코드 받기
		String code = request.getParameter("code");
		System.out.println("code : " + code);
		
		// 2. 토근 받기(인가코드 필요)
		String requestURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST 요청
			conn.setRequestMethod("POST");
			
			conn.setDoOutput(true);
			
			// 헤더 요청
			conn.addRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			
			//본문
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			StringBuffer sb = new StringBuffer();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=e07bb4b8d5b0f2531b6c6721df5ac8eb");
			sb.append("&redirect_uri=http://localhost:8080/kakaologin");
			sb.append("&code=" + code);
			sb.append("&client_secret=AAv7JC8SEeWvi2O25iERwjW6LX3xNvkL");
			bw.write(sb.toString());
			bw.flush();
			
			//결과 코드가 200이면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				StringBuffer sb2 = new StringBuffer();
				while((line= br.readLine())!= null) {
					sb2.append(line);
				}
				String result = sb.toString();
				System.out.println(result);
				
				// 사용자 정보를 다른 컨트롤러에서 받기 위해 session에 저장한다.
				Gson gson = new Gson();
				KakaoVO kvo = gson.fromJson(result, KakaoVO.class);
				
				System.out.println(kvo.getAccess_token());
				System.out.println(kvo.getRefresh_token());
				System.out.println(kvo.getScope());
				System.out.println(kvo.getToken_type());
				
				request.getSession().setAttribute("kvo", kvo);
				
				return new ModelAndView("sns/result01");
			} else {
				// 오류 메시지 출력
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String line = "";
                StringBuffer sbError = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    sbError.append(line);
                }
                System.out.println("Error response: " + sbError.toString());
                return new ModelAndView("sns/error");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("sns/error");
		}
	}
	
	@GetMapping("/kakaologout")
	public ModelAndView kakaoLogout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("sns/loginForm");
		
	}
	
	@GetMapping("/naverlogin")
	public ModelAndView naverLogin(HttpServletRequest request) {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		System.out.println("code : " + code);
		System.out.println("state : " + state);
		
		return new ModelAndView("sns/loginForm");
	}
}
