package com.ict.guestbook.vo;

import org.springframework.web.multipart.MultipartFile;

public class GuestBookVO {
	//db와 같은 이름
	private String gb_idx, gb_subject, gb_writer, gb_email, gb_pwd, gb_file, gb_content, gb_date, old_f_name;
	
	//파라미터와 같은 이름이어야 한다.
	private MultipartFile parameter_file;

	public String getOld_f_name() {
		return old_f_name;
	}

	public void setOld_f_name(String old_f_name) {
		this.old_f_name = old_f_name;
	}

	public String getGb_idx() {
		return gb_idx;
	}

	public void setGb_idx(String gb_idx) {
		this.gb_idx = gb_idx;
	}

	public String getGb_subject() {
		return gb_subject;
	}

	public void setGb_subject(String gb_subject) {
		this.gb_subject = gb_subject;
	}

	public String getGb_writer() {
		return gb_writer;
	}

	public void setGb_writer(String gb_writer) {
		this.gb_writer = gb_writer;
	}

	public String getGb_email() {
		return gb_email;
	}

	public void setGb_email(String gb_email) {
		this.gb_email = gb_email;
	}

	public String getGb_pwd() {
		return gb_pwd;
	}

	public void setGb_pwd(String gb_pwd) {
		this.gb_pwd = gb_pwd;
	}

	public String getGb_file() {
		return gb_file;
	}

	public void setGb_file(String gb_file) {
		this.gb_file = gb_file;
	}

	public String getGb_content() {
		return gb_content;
	}

	public void setGb_content(String gb_content) {
		this.gb_content = gb_content;
	}

	public String getGb_date() {
		return gb_date;
	}

	public void setGb_date(String gb_date) {
		this.gb_date = gb_date;
	}

	public MultipartFile getParameter_file() {
		return parameter_file;
	}

	public void setParameter_file(MultipartFile parameter_file) {
		this.parameter_file = parameter_file;
	}


}
