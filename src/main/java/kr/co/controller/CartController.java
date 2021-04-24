package kr.co.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("listSize", cartService.readBookList(user_number).size());
		session.setAttribute("cartList", cartService.readCartList(user_number));
		session.setAttribute("bookList", cartService.readBookList(user_number));
//		int totalPrice = book.getBook_price() *  cart.getAmount();
//		model.addAttribute("totalPrice", totalPrice);
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
	
	// 메인 카트 추가
	@PostMapping("/addCart")
		public String addCart(@ModelAttribute("cartvo")CartVO cartvo, Model model) {
			log.info("addCart......................");
			String isAlready = cartService.findcartbook(cartvo);

			if(isAlready.equals("true")) {
				log.info("장바구니에 이미 존재하는 상품");
				cartService.addModify(cartvo);
			}else { 
				log.info("장바구니에 상품 추가");
				cartService.addcart(cartvo);
			}return "/cart/cart_add";
	}
	
	// cart에서 수량변경버튼눌렀을때 >> list.jsp에서 ajax사용    function modifyAmount(id,amount)
	@PostMapping("/modify")
	public String modify(@RequestParam("cartAmount") int cartAmount,
						 @RequestParam("book_id") int book_id, HttpSession session) {
		log.info("modify...............");
		log.info("book_id : " + book_id);
		int user_number = (int)session.getAttribute("user_number");
		CartVO cartvo = new CartVO();
		cartvo.setUser_number(user_number);
		cartvo.setBook_id(book_id);
		log.info("changeAmount.......");
		cartvo.setAmount(cartAmount);
		if(cartAmount < 1) {
			log.info("amount<1");
			cartvo.setAmount(1);
		}
		if(cartAmount >50) {
			log.info("amount>50");
			cartvo.setAmount(50);
		}
		cartService.amountModify(cartvo);
		return "redirect:/cart/list";
	}
	
	@ResponseBody
	@PostMapping("/remove")
	public String remove(@RequestParam("book_id")int book_id,HttpServletRequest request) {
		log.info("remove...............");
		log.info("book_id : " + book_id);
		cartService.remove(book_id);
		return "redirect:/cart/list";
	}
	
	@ResponseBody
	@PostMapping("/selectRemove")
	public String selectRemove(@RequestParam List<Integer> indexArray, 
							   HttpServletRequest request, HttpSession session) {
		log.info("selectRemove...............");
		int user_number = (int)session.getAttribute("user_number");
		List<Integer> newbook_id= new ArrayList<Integer>();
		//받아온 index 확인
		for(int i=0;i<indexArray.size();i++) {
			if(indexArray.get(i) != null) {
				log.info("book_id : " + cartService.readCartList(user_number).get(i).getBook_id());
				newbook_id.add(cartService.readCartList(user_number).get(i).getBook_id());
			}
		}
		for(int i=0;i<newbook_id.size();i++) {
			cartService.remove(newbook_id.get(i));
		}
		return "redirect:/cart/list";
	}
	
}
