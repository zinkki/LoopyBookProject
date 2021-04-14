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
	public void list(CartVO cart, BookVO book,Model model,HttpSession session) {
		log.info("list....................");
		int user_number = (int)session.getAttribute("user_number");
		model.addAttribute("user_numer", user_number);
		model.addAttribute("cartList", cartService.readCartList(user_number));
		model.addAttribute("bookList", cartService.readBookList(user_number));
		session.setAttribute("cartList", cartService.readCartList(user_number));
		session.setAttribute("bookList", cartService.readBookList(user_number));
		int totalPrice = book.getBook_price() *  cart.getAmount();
		model.addAttribute("totalPrice", totalPrice);
	}
	@PostMapping("/list")
	public String goList(CartVO cart, BookVO book,Model model,HttpSession session) {
		log.info("listttt....................");
		int user_number = (int)session.getAttribute("user_number");
		model.addAttribute("user_numer", user_number);
		model.addAttribute("cartList", cartService.readCartList(user_number));
		model.addAttribute("bookList", cartService.readBookList(user_number));
		return "/cart/list";
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
