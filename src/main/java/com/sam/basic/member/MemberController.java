package com.sam.basic.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/myPage")
	public ModelAndView getDetail(HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("loginInfo");
		
		if(memberDto != null) {
			modelAndView.setViewName("/member/myPage");
			memberDto = memberService.getDetail(memberDto);
			modelAndView.addObject("memberDto", memberDto);
		}else {
			modelAndView.setViewName("redirect: /member/agree");
		}
		
		return modelAndView;
	}
	
	@GetMapping("/logout")
	public ModelAndView tryLogout(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView();
		httpSession.invalidate();
		modelAndView.setViewName("redirect: /");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView tryLogin(String memberId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberId", memberId);
		modelAndView.setViewName("/member/login");
		return modelAndView;
	}
	
	@PostMapping("/login")
	public ModelAndView tryLogin(MemberDto memberDto, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		String memberId = memberDto.getMemberId();
		memberDto = memberService.tryLogin(memberDto);
		if(memberDto != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("loginInfo", memberDto);
			
			modelAndView.addObject("message", "로그인에 성공 하였습니다");
			modelAndView.addObject("url", "/");
		}else {
			modelAndView.addObject("message", "로그인에 실패 하였습니다");
			modelAndView.addObject("url", "/member/login?memberId=" + memberId);
		}
		
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@GetMapping("/agree")
	public ModelAndView getAgree() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/member/agree");
		return modelAndView;
	}
	
	@GetMapping("/insert")
	public ModelAndView setInsert() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/insert");
		return modelAndView;
	}
	
	@PostMapping("/insert")
	public ModelAndView setInsert(MemberDto memberDto, MultipartFile image) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = memberService.setInsert(memberDto, image);
		String message;
		
		if(result > 0) {
			message = "등록이 완료 되었습니다";
		}else {
			message = "등록에 실패 하였습니다";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.addObject("url", "/");
		modelAndView.setViewName("/common/result");
		return modelAndView;
		
	}
}
