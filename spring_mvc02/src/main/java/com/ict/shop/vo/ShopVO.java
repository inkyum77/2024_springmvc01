package com.ict.shop.vo;

import org.springframework.web.multipart.MultipartFile;

public class ShopVO {
	
	private String shop_idx, category, p_num, p_name, p_company, p_image_s, p_image_L, p_content, p_date;
	private int p_price, p_saleprice;
	public String getP_image_L() {
		return p_image_L;
	}

	public void setP_image_L(String p_image_L) {
		this.p_image_L = p_image_L;
	}

	public MultipartFile getMp_image_L() {
		return mp_image_L;
	}

	public void setMp_image_L(MultipartFile mp_image_L) {
		this.mp_image_L = mp_image_L;
	}
	private MultipartFile mp_image_s, mp_image_L;
	
	
	public MultipartFile getMp_image_s() {
		return mp_image_s;
	}

	public void setMp_image_s(MultipartFile mp_image_s) {
		this.mp_image_s = mp_image_s;
	}

	public int getPercent() {
		double per = (p_price - p_saleprice) * 100 / p_price;
		return (int) per;
	}
	
	public String getShop_idx() {
		return shop_idx;
	}
	public void setShop_idx(String shop_idx) {
		this.shop_idx = shop_idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_company() {
		return p_company;
	}
	public void setP_company(String p_company) {
		this.p_company = p_company;
	}
	public String getP_image_s() {
		return p_image_s;
	}
	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_saleprice() {
		return p_saleprice;
	}
	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}
}
