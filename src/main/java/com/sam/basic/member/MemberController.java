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
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("/delete")
	public ModelAndView setDelete(HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("loginInfo");
		
		int result = 0;
		if(memberDto != null) {
			result = memberService.setDelete(memberDto);
		}
		if(result > 0) {
			modelAndView.addObject("message", "삭제가 완료 되었습니다");
			httpSession.invalidate();
		}else {
			modelAndView.addObject("message", "삭제되지 않았습니다");
		}
		modelAndView.addObject("url", "/");
		
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@GetMapping("/update")
	public ModelAndView setUpdate()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("loginInfo");
		memberDto = memberService.getDetail(memberDto);
		
		modelAndView.addObject("memberDto", memberDto);
		modelAndView.setViewName("/member/update");
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView setUpdate(MemberDto memberDto, MultipartFile image)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		int result = memberService.setUpdate(memberDto,image);
		if(result > 0) {
			modelAndView.addObject("message", "수정이 완료 되었습니다");
		}else {
			modelAndView.addObject("message", "수정에 실패 하였습니다");
		}
		
		modelAndView.addObject("url", "./myPage");
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@GetMapping("/myPage")
	public ModelAndView getDetail() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("loginInfo");
		memberDto = memberService.getDetail(memberDto);
		
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
	public ModelAndView tryLogout() {
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
	public ModelAndView tryLogin(MemberDto memberDto) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		String memberId = memberDto.getMemberId();
		memberDto = memberService.tryLogin(memberDto);
		if(memberDto != null) {
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
			memberDto = memberService.tryLogin(memberDto);
			httpSession.setAttribute("loginInfo", memberDto);
			
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
