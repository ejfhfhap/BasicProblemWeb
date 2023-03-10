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
		problemDao.setProblemCntAdd(problemDto);
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
	
	public ProblemDto setGoodCntAdd(ProblemDto problemDto) {
		int result = problemDao.setGoodCntAdd(problemDto);
		return problemDao.getDetail(problemDto);
	}
	public ProblemDto setBadCntAdd(ProblemDto problemDto) {
		int result = problemDao.setBadCntAdd(problemDto);
		return problemDao.getDetail(problemDto);
	}
	
	// problemListId, answer
	public boolean setAnsSubmit(ProblemDto problemDto) {
		// ????????? ?????? ??????
		MemberDto memberDto = (MemberDto)httpSession.getAttribute("loginInfo");
		problemDto.setMemberId(memberDto.getMemberId());
		
		// ????????? ????????? ????????? ????????????
		String answer = problemDao.getDetail(problemDto).getAnswer();
		ProblemDto isTryMember = problemDao.getProblemTryMemberDetail(problemDto);
		
		// ????????????
		if(answer.equals(problemDto.getAnswer())) {
			problemDto.setIsSolve(1);
			// ??????????????? ????????? ????????????
			if(isTryMember == null) {
				problemDao.setProblemTryMemberInsert(problemDto);
			}else {
				problemDao.setProblemTryMemberUpdate(problemDto);
			}
			return true;
		}
		// ????????????
		else {
			// ????????? ?????? ????????? ???????????? ??????
			if(isTryMember == null) {
				problemDto.setIsSolve(2);
				problemDao.setProblemTryMemberInsert(problemDto);
			}
			return false;
		}
	}
}
