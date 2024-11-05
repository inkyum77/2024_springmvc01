package com.ict.sns.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ict.sns.KakaoVO.KakaoVO;

@RestController
public class KakaoUserInfoController {
	
	@RequestMapping(value = "/kakaoUserInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String kakaoUserInfo(HttpServletRequest request) {
		// 세션에 저장된 kvo 안에 access_token을 이용해서 사용자 정보 가져오기
	 	KakaoVO kvo =  (KakaoVO) request.getSession().getAttribute("kvo");
	 	String access_token = kvo.getAccess_token(); 
	 	
	 	String apiURL = "https://kapi.kakao.com/v2/user/me";
	 	String header = "Bearer " + access_token;
		
	 	Map<String, String> headers = new HashMap<String, String>();
	 	headers.put("Authorization", header);
//	 	headers.put("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	 	
		return kakaoRequest(apiURL, headers, request);
	}
	
	public String kakaoRequest(String apiURL, Map<String, String> headers, HttpServletRequest  request) {
		HttpURLConnection conn = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		
		try {
			URL url = new URL(apiURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			//헤더 설정
			for(Entry<String, String> k : headers.entrySet()) {
				conn.setRequestProperty(k.getKey(), k.getValue());
			}
			//응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				StringBuffer sb2 = new StringBuffer();
				while((line= br.readLine())!= null) {
					sb2.append(line);
				}
				String result = sb2.toString();
				System.out.println(result);
				
				return result;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				isr.close();
				br.close();
				conn.disconnect();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		return null;
	}
	
}
