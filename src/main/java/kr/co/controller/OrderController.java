package kr.co.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.domain.BookVO;
import kr.co.domain.OrderVO;
import kr.co.service.OrderService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/order/*")

public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/list")
	public void list(OrderVO order, BookVO book, Model model, HttpSession session) {
		log.info("OrderLIST.............");
		int user_number = (int)session.getAttribute("user_number");
		model.addAttribute("user_number", user_number);
		model.addAttribute("orderList", orderService.readOrderList(user_number));
		model.addAttribute("bookList", orderService.readBookList(user_number));
		session.setAttribute("orderList", orderService.readOrderList(user_number));
		session.setAttribute("bookList", orderService.readOrderList(user_number));
	}
	@PostMapping("/list")
	public String goList(OrderVO order, BookVO book, Model model, HttpSession session) {
		log.info("Order List....................!!!!!!");
		int user_number = (int)session.getAttribute("user_number");
		model.addAttribute("user_number", user_number);
		model.addAttribute("orderList", orderService.readOrderList(user_number));
		model.addAttribute("bookList", orderService.readBookList(user_number));
		return "/order/list";
	}
	@RequestMapping(value="oneBookOrder", method = {RequestMethod.GET, RequestMethod.POST})
	public String addOrder(@RequestParam("book_id")int book_id, HttpServletRequest request) {
		log.info("addOrder................");
		orderService.oneBookadd(book_id);
		return "/order/oneBookOrder";
	}
}
