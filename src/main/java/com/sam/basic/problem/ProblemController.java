package com.sam.basic.problem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sam.basic.util.Pager;

@Controller
@RequestMapping("/problem/**")
public class ProblemController {
	
	@Autowired
	private ProblemService problemService;
	
	@GetMapping("/list")
	public ModelAndView getList(Pager pager) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ProblemDto> dtos = problemService.getList(pager);
		modelAndView.addObject("dtos", dtos);
		modelAndView.addObject("pager", pager);
		
		modelAndView.setViewName("/problem/list");
		return modelAndView;
	}
}
