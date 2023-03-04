package com.sam.basic.problem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sam.basic.util.Pager;

//@CrossOrigin(origins="*", allowedHeaders = "*")
@Controller
@RequestMapping("/problem/**")
public class ProblemController {
	
	@Autowired
	private ProblemService problemService;
	
	@ModelAttribute("boardName")
	public String getUrlName() {
		return "problem";
	}
	
	@GetMapping("/list")
	public ModelAndView getList(Pager pager) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ProblemDto> dtos = problemService.getList(pager);
		modelAndView.addObject("problemDtos", dtos);
		modelAndView.addObject("pager", pager);
		
		modelAndView.setViewName("/problem/list");
		return modelAndView;
	}
	
	@GetMapping("/detail")
	public ModelAndView getDetail(ProblemDto problemDto) {
		ModelAndView modelAndView = new ModelAndView();
		
		problemDto = problemService.getDetail(problemDto);
		modelAndView.addObject("problemDto", problemDto);
		
		
		modelAndView.setViewName("/problem/detail");
		return modelAndView;
	}
	
	@GetMapping("/insert")
	public ModelAndView setProblemInsert() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/problem/insert");
		return modelAndView;
	}
	@PostMapping("/insert")
	public ModelAndView setProblemInsert(ProblemDto problemDto,MultipartFile[] images) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = problemService.setProblemInsert(problemDto, images);
		modelAndView.setViewName("redirect: ./list");
		
		return modelAndView;
	} 
	
	@GetMapping("/fileDown")
	public ModelAndView getFileDown(ProblemImageDto problemImageDto) {
		ModelAndView modelAndView = new ModelAndView();
		
		problemImageDto = problemService.getImageDetail(problemImageDto);
		if(problemImageDto != null) {
			modelAndView.addObject("problemImageDto", problemImageDto);
			modelAndView.setViewName("fileDownView");
		}else {
			modelAndView.addObject("message", "올바르지 않는 파일 입니다");
			modelAndView.addObject("url", "./list");
			
			modelAndView.setViewName("/common/result");
		}
		
		return modelAndView;
	}
	
	@PostMapping("/goodCntAdd")
	public ModelAndView setGoodCntAdd(ProblemDto problemDto) {
		ModelAndView modelAndView = new ModelAndView();
		problemDto = problemService.setGoodCntAdd(problemDto);
		modelAndView.addObject("result", problemDto.getGoodCnt());
		
		modelAndView.setViewName("/ajax/result");
		return modelAndView;
	}
	
	@PostMapping("/badCntAdd")
	public ModelAndView setBadCntAdd(ProblemDto problemDto) {
		ModelAndView modelAndView = new ModelAndView();
		problemDto = problemService.setBadCntAdd(problemDto);
		modelAndView.addObject("result", problemDto.getBadCnt());
		
		modelAndView.setViewName("/ajax/result");
		return modelAndView;
	}
}
