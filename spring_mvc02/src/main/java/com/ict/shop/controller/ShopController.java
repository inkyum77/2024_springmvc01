package com.ict.shop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.member.vo.MemberVO;
import com.ict.shop.service.ShopService;
import com.ict.shop.vo.CartVO;
import com.ict.shop.vo.ShopVO;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/top")
	public ModelAndView top() {
		return new ModelAndView("shop/top");
	}
	
	
	@GetMapping("/shop")
	public ModelAndView go_shop(@RequestParam("category") String category) {
		try {
			ModelAndView mv = new ModelAndView("shop/product_list");
			// 카테고리 기본 값
			if(category == null || category == "") {
				category = "ele002";
			}
			
			//DB에서 카테고리에 맞는 리스트 가져오기
			List<ShopVO> shop_list = shopService.getShopList(category);
			
			if(shop_list == null) {
				return null;
			} else {
				mv.addObject("shop_list", shop_list);
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@GetMapping("/shop_detail")
	public ModelAndView getShopDetail(@RequestParam("shop_idx") String shop_idx) {
		try {
			ModelAndView mv = new ModelAndView("shop/product_content");
			ShopVO svo = shopService.getShopDetail(shop_idx);
			if(svo != null) {
				mv.addObject("svo", svo);
				return mv;
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	

	@GetMapping("/shop_addCart")
	public ModelAndView getShopAddCart(
			@ModelAttribute("shop_idx") String shop_idx,
			HttpSession session) {
		try {
			String loginchk = (String) session.getAttribute("loginchk");
			if("ok".equals(loginchk)) {
				ModelAndView mv = new ModelAndView("redirect:/shop_detail");
				
				//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				//로그인한 정보를 가져오자
				// mvo인지 mvo2인지 잘 확인하자
				MemberVO mvo = (MemberVO) session.getAttribute("mvo");
				System.out.println("mvo = " + mvo);
				
				//제품 정보 가져오자
				ShopVO svo = shopService.getShopDetail(shop_idx);
				CartVO cartVO = new CartVO();
				
				
				//카트 리스트에 해당 제e와 로그인한 유저의 사용자 m_id가 있는지(수량1 증가) 없는지(카트에 추가) 체크
				cartVO = shopService.getCartChk(mvo.getM_id(), svo.getP_num());
				
				System.out.println(cartVO);
				
				//카트가 비어있는 경우, 수량을 1 추가한다.
				if(cartVO == null) {
					CartVO cavo = new CartVO();
					cavo.setP_num(svo.getP_num());
					cavo.setP_name(svo.getP_name());
					cavo.setP_price(String.valueOf(svo.getP_price()));
					cavo.setP_saleprice(String.valueOf(svo.getP_saleprice()));
					cavo.setM_id(mvo.getM_id());	
					
					int result = shopService.getCartInsert(cavo);
					
				} else {
					int result = shopService.getCartUpdate(cartVO);
				}
				
				return mv;
			} else {
				
				return new ModelAndView("shop/login_error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
			System.out.println(e);
		}
		return new ModelAndView("shop/login_error");
	}
	
	@GetMapping("/shop_showCart")
	public ModelAndView getShopShowCart(HttpSession session) {
		
		try {
			String loginchk = (String) session.getAttribute("loginchk");
			
			if("ok".equalsIgnoreCase(loginchk)) {
				
				
				ModelAndView mv = new ModelAndView("shop/cartList");
				
				//로그인한 사람의 정보를 가져와서 카트에 검색한 후 cartList에 넘기자
				MemberVO mvo = (MemberVO) session.getAttribute("mvo");
				
				
				System.out.println(mvo.getM_idx());
				List<CartVO> cart_list = shopService.getCartList(mvo.getM_id());
				
				//카트에 있다면 추가해주자
				if(cart_list != null) {
					mv.addObject("cart_list", cart_list);
				}
				
				return mv;
			} else {
				
				return new ModelAndView("shop/login_error");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("shop/login_error");
		}
	}
	
	
	@PostMapping("/cart_edit")
	public ModelAndView getShopCartEdit(CartVO cavo) {
		
		try {			
			ModelAndView mv = new ModelAndView("redirect:/shop_showCart");
			
			int result = shopService.getCartEdit(cavo);
			if(result > 0) {
				return mv;				
			}
			
			return null;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	@GetMapping("/cart_delete")
	public ModelAndView getShopCartDelete(String cart_idx) {
		try {			
			ModelAndView mv = new ModelAndView("redirect:/shop_showCart");
			
			int result = shopService.getCartDelete(cart_idx);
			if(result > 0) {
				return mv;
			}
			
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@GetMapping("/member_logout")
	public ModelAndView getMemberLogout(HttpSession session) {
		// 세션 초기화 전체 삭제
		session.invalidate();
		
		//필요한 내용만 삭제
		session.removeAttribute("loginchk");
		session.removeAttribute("mvo2");
		session.removeAttribute("admin");
		
		return null;
		
	}
	
	@GetMapping("/shop_add_product_page")
	public ModelAndView getAddProductPage() {
		
		return new ModelAndView("shop/product_insert");
	}
	
	@PostMapping("/shop_add_product")
	public ModelAndView getAddProduct(ShopVO svo, HttpServletRequest request) {
		
		try {
			ModelAndView mv = new ModelAndView("shop/product_insert");
			
			//파일 1
			String path = request.getSession().getServletContext().getRealPath("/resources/images");
			System.out.println(path);
			MultipartFile file1 = svo.getMp_image_L();
			
			if(file1.isEmpty()) {
				svo.setP_image_L("");
			} else {
				UUID uuid = UUID.randomUUID();
				String p_image_L = uuid.toString() + "_" + file1.getOriginalFilename();
				svo.setP_image_L(p_image_L);
				
				file1.transferTo(new File(path, p_image_L));
			}
			
			//파일 2
			MultipartFile file2 = svo.getMp_image_s();
			
			if(file2.isEmpty()) {
				svo.setP_image_s("");
			} else {
				UUID uuid = UUID.randomUUID();
				String p_image_s = uuid.toString() + "_" + file2.getOriginalFilename();
				svo.setP_image_s(p_image_s);
				
				file2.transferTo(new File(path, p_image_s));
			}
			
			
			
			int result = shopService.getProductInsert(svo);
			if(result > 0) {
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
