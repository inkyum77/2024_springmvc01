package com.ict.edu04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ict.edu04.service.AjaxMemberService;
import com.ict.edu04.vo.AjaxMemberVO;

@RestController
public class AjaxDBController {
	
	@Autowired
	private AjaxMemberService ajaxMemberService;
	
	@RequestMapping(value = "/ajax_db_list", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String getAjaxList() {
		List<AjaxMemberVO> list = ajaxMemberService.getMemberList();
		
		if(list != null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<members>");
			for(AjaxMemberVO k : list) {
				sb.append("<member>");
				sb.append("<m_idx>" + k.getM_idx() + "</m_idx>");
				sb.append("<m_idx>" + k.getM_idx() + "</m_idx>");
				sb.append("<m_idx>" + k.getM_idx() + "</m_idx>");
				sb.append("<m_idx>" + k.getM_idx() + "</m_idx>");
				sb.append("<m_idx>" + k.getM_idx() + "</m_idx>");
			}
		}
		return null;
	}
}
