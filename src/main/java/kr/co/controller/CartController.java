package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.domain.BookVO;
import kr.co.domain.CartVO;
import kr.co.domain.UserVO;
import kr.co.service.CartService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/cart/*")

public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/list")
	public void list(CartVO cart, HttpSession session, Model model) {
		cart.getUser_number();
//		BookVO bookvo = new BookVO();
		session.setAttribute("user_number", cart.getUser_number());
		cartService.readlist(cart.getUser_number());
		log.info("list....................");
		
	}
	@PostMapping("/addCart")
	public String addCart(@ModelAttribute("cartvo") CartVO cartvo,
						  HttpSession session,
						  HttpServletRequest request, HttpServletResponse resonse) {
	
		String isAready = cartService.findcartbook(cartvo);
		System.out.println("isAread = " + isAready);
		
		if(isAready.equals("true")) {
			log.info("true!!!!!!");
			cartService.addModify(cartvo);
		}else { 
			cartService.addcart(cartvo);
			log.info("false!!!!");
			
		}return "/cart/cart_add";
	}
	
	

}
