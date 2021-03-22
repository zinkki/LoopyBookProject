package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.NoticeVO;
import kr.co.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/notice/*")
@RequiredArgsConstructor
public class NoticeController {

	private final NoticeService noticeService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list.....");
		model.addAttribute("list", noticeService.getList());
	}
//	@PostMapping("/register")
//	public String register(NoticeVO notice, RedirectAttributes ra) {
//		log.info("register.......");
//		log.info("register : "+notice.getNotice_title()+"......");
//		int seq_bno = noticeService.registerSelectKey(notice);
//		ra.addAttribute("result", seq_bno);
//		ra.addFlashAttribute("result", seq_bno);
//		return "redirect:/notice/get?bno=" + seq_bno;
//	}
	
}
