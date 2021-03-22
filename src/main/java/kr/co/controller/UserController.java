package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.domain.UserVO;
import kr.co.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/login")
	public void login(@ModelAttribute("user") UserVO user) {
		log.info("login...............");
	}
	
	@PostMapping("/login_success")
	public String login(@ModelAttribute("user")UserVO user ,HttpServletRequest request, 
			HttpServletResponse response, HttpSession session, Model model,
			@RequestParam("referer") String referer) {
		log.info("login_success................");
		user = userService.login(user);
		if(user != null && user.getUser_id() != null) {
			session = request.getSession();
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("user_pw", user.getUser_pw());
			session.setAttribute("user_number", user.getUser_number());
			log.info(referer);
			return "redirect:/";
		//	return "redirect:"+referer; >>어느곳에서 로그인눌러도 그자리에머물게 하는건데 아직모름ㅋ
 		}else {
			String message = "아이디나 비밀번호가 틀립니다. 다시 로그인해주세요.";
			model.addAttribute("message",message);
		}
		return "/user/login";
	}
	
	@GetMapping("/join")
	public String joinform(@ModelAttribute("user") UserVO user) {
		return "user/join";
	}
	
	@GetMapping("/join2") 
	@ResponseBody //화면으로 정보전달
	public boolean join(@RequestBody @RequestParam("user_id") @ModelAttribute("user_id") String user_id) {
		
		log.info("join2..............."+user_id);
		return userService.idcheck(user_id);
	}
	
	@PostMapping("/join_success") 
	public String joinSuccess(HttpSession session,@ModelAttribute("user") UserVO user) {
			userService.join(user);
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("user_number", user.getUser_number());
			return "user/join_success";
	}
	@GetMapping("/logout")
	public void logout(HttpServletRequest request) {
			request.getSession().invalidate();
	}
	
}

