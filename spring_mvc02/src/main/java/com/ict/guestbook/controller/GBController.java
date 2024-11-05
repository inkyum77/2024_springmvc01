package com.ict.guestbook.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.guestbook.service.GBService;
import com.ict.guestbook.service.GBServiceImpl;
import com.ict.guestbook.vo.GuestBookVO;

@Controller
public class GBController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private GBService gBService;
	
	@GetMapping("/gb_list")
	public ModelAndView getGuestbookList() {
		ModelAndView mv = new ModelAndView("guestbook/list");
		List<GuestBookVO> gb_list = gBService.getGuestBookList();
		mv.addObject("list", gb_list);
		System.err.println(gb_list);
		return mv;
	}
	
	@GetMapping("/gb_write_page")
	public ModelAndView guestbookWritePage() {
		return new ModelAndView("guestbook/write");
	}
	
	@GetMapping("/gb_detail")
	public ModelAndView getGuestbookDetail(@RequestParam("gb_idx") String gb_idx) {
		ModelAndView mv = new ModelAndView("guestbook/detail");
		GuestBookVO gbvo = gBService.getGuestBookDetail(gb_idx);
		mv.addObject("gbvo", gbvo);
		
		return mv;
	}
	

	
	@PostMapping("/gb_write")
	public ModelAndView getGuestBookWrite(GuestBookVO gbvo, HttpServletRequest request) {
		try {
			ModelAndView mv = new ModelAndView("redirect:/gb_list");
			
			//파일 정보 넘어오는지 확인
			System.out.println("파일정보 : " + gbvo.getParameter_file().getOriginalFilename());
			System.out.println(gbvo.getGb_writer());
			//summernote 정보 확인
			System.out.println("서머노트 정보 : " + gbvo.getGb_content());
			
			String path = request.getSession().getServletContext().getContextPath();
			MultipartFile file = gbvo.getParameter_file();
			
			if(file.isEmpty()) {
				gbvo.setGb_file("");
			} else {
				UUID uuid = UUID.randomUUID();
				String f_name = uuid.toString() + "_" + file.getOriginalFilename();
				gbvo.setGb_file(f_name);
				
				file.transferTo(new File(path, f_name));
			}
			
			//비밀번호 암호화
			
			String pwd = passwordEncoder.encode(gbvo.getGb_pwd());
			gbvo.setGb_pwd(pwd);
			
			int result = gBService.getGuestBookInsert(gbvo);
			if(result > 0) {
				return mv;
			}
			
			return new ModelAndView("/guestbook/error");
		
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("/guestbook/error");
		}
		
	}
	
	@GetMapping("/gb_down")
	public void guestbookDown(HttpServletRequest request, HttpServletResponse response) {
		try {
			String f_name = request.getParameter("f_name");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + f_name);
			String r_path = URLEncoder.encode(f_name, "UTF-9");
			
			//브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename =" + r_path);
			
			File file = new File(new String(path.getBytes(), "UTF-8"));
			FileInputStream in = new FileInputStream(file);
			
			OutputStream out = response.getOutputStream();
			
			FileCopyUtils.copy(in, out);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@PostMapping("/gb_delete_page")
	public ModelAndView getDeletePage(@ModelAttribute("gb_idx") String gb_idx) {
		return new ModelAndView("guestbook/delete");
	}

	@PostMapping("/gb_update_page")
	public ModelAndView getUpdatePage(@ModelAttribute("gb_idx") String gb_idx) {
		ModelAndView mv = new ModelAndView("guestbook/update");
		
		GuestBookVO gbvo = gBService.getGuestBookDetail(gb_idx);
		
		mv.addObject("gbvo", gbvo);
		
		return mv;
	}
	
	@PostMapping("/gb_delete")
	public ModelAndView getGuestBookDelete(GuestBookVO gbvo) {
		ModelAndView mv = new ModelAndView("redirect:/gb_list");
		
		GuestBookVO gbvo2 = gBService.getGuestBookDetail(gbvo.getGb_idx());
		
		//jsp에서 입력한 password
		String pwd = gbvo.getGb_pwd();
		//db에서 가져온 암호화 된 password		
		String pwd2 = gbvo2.getGb_pwd();
		
		if(passwordEncoder.matches(pwd, pwd2)) {
			
		}
		return null;
	}
	
	@PostMapping("/gb_update")
	public ModelAndView guestBookUpdate(GuestBookVO gbvo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/gb_list");
		
		GuestBookVO gbvo2 = gBService.getGuestBookDetail(gbvo.getGb_idx());
		
		//jsp에서 입력한 password
		String pwd = gbvo.getGb_pwd();
		//db에서 가져온 암호화 된 password		
		String pwd2 = gbvo2.getGb_pwd();
		
		if(passwordEncoder.matches(pwd, pwd2)) {
			try {
				String path = request.getSession().getServletContext().getRealPath("resources/upload");
				MultipartFile file = gbvo.getParameter_file();
				String old_f_name = gbvo.getOld_f_name();
				
				//첨부파일 유무
				if(file.isEmpty()) {
					gbvo.setGb_file(old_f_name);
				} else {
					UUID uuid = UUID.randomUUID();
					String f_name = uuid.toString() + "_" + file.getOriginalFilename();
					gbvo.setGb_file(f_name);
					
					file.transferTo(new File(path, f_name));
				}
				
				//암호화
				pwd = passwordEncoder.encode(gbvo.getGb_pwd());
				gbvo.setGb_pwd(pwd);
				
				int result = gBService.getGuestBookUpdate(gbvo);
				if(result > 0) {
					mv.setViewName("redirect:/gb_detail?gb_idx=" + gbvo.getGb_idx());
					return mv;
				}
				
				
				return new ModelAndView("guestbook/error");
			} catch(Exception e) {
				System.out.println(e);
				return new ModelAndView("guestbook/error");
			}
		}
		
		
		return new ModelAndView("guestbook/error");
		
				
	}
}
