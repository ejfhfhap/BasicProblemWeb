package com.sam.basic.problem;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sam.basic.member.MemberDto;
import com.sam.basic.util.FileManager;
import com.sam.basic.util.Pager;

@Service
public class ProblemService {
	@Autowired
	private ProblemDao problemDao;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private HttpSession httpSession;
	
	public List<ProblemDto> getList(Pager pager){
		pager.setBlockRange(problemDao.getListCnt(pager));
		pager.setStartLastRange();
		
		return problemDao.getList(pager); 
	}
	public ProblemDto getDetail(ProblemDto problemDto) {
		return problemDao.getDetail(problemDto);
	}
	public int setProblemInsert(ProblemDto problemDto, MultipartFile[] images) throws Exception {
		
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("loginInfo");
		problemDto.setWriter(memberDto.getMemberId());
		
		int result = problemDao.setProblemInsert(problemDto);
		
		for(MultipartFile image: images) {
			String realPath = servletContext.getRealPath("/resources/upload/problem");
			String fileName = FileManager.saveFile(image, realPath);
			
			ProblemImageDto problemImageDto = new ProblemImageDto();
			problemImageDto.setProblemListId(problemDto.getProblemListId());
			problemImageDto.setImageName(fileName);
			problemImageDto.setOriImageName(image.getOriginalFilename());
			
			result = problemDao.setProblemImageInsert(problemImageDto);
		}
		
		return result;
	}
	public ProblemImageDto getImageDetail(ProblemImageDto problemImageDto) {
		return problemDao.getImageDetail(problemImageDto);
	}
}
