package com.sam.basic.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sam.basic.util.Pager;

import oracle.jdbc.internal.OracleConnection.ChecksumMode;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<CommentDto> dtos = commentService.getList(pager);
		modelAndView.addObject("dtos", dtos);

		modelAndView.setViewName("/comment/list");
		return modelAndView;
	}
	
	
	@PostMapping("/insert")
	public ModelAndView setInsert(CommentDto commentDto)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		// 임시로 아이디 넣은거임 나중에 세션으로 바꿔야함
		commentDto.setWriter("강한나사랑");
		
		int result = commentService.setInsert(commentDto);
		if(result > 0) {
			modelAndView.addObject("message", "댓글이 추가 됐습니다");
		}else {
			modelAndView.addObject("message", "댓글이 추가되지 않았습니다");
		}
		modelAndView.addObject("url", "../problem/detail?problemListId=" + commentDto.getProblemListId());
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@PostMapping("/delete")
	public ModelAndView setDelete(CommentDto commentDto)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
	//	System.out.println(commentDto.getCommentId());
		int result = commentService.setDelete(commentDto);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("/ajax/result");
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView setUpdate(CommentDto commentDto)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		int result = commentService.setUpdate(commentDto);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("/ajax/result");
		return modelAndView;
	}
}
