package com.ict.edu04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxController {
	
	@GetMapping("/ajax_test_xml")
	public ModelAndView ajaxTest() {
		return new ModelAndView("day04/ajax_result");
	}
	
	@GetMapping("/ajax_test_json")
	public ModelAndView ajaxJsonTest() {
		return new ModelAndView("day04/ajax_json_result");
	}

	@GetMapping("/ajax_test_DB")
	public ModelAndView ajaxDBTest() {
		return new ModelAndView("day04/ajax_DB_result");
	}
}
