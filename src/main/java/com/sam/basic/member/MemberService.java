package com.sam.basic.member;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sam.basic.util.FileManager;

@Service
public class MemberService{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private HttpSession httpSession;
	
	public MemberDto getDetail(MemberDto memberDto) throws Exception{
		return memberDao.getDetail(memberDto);
	}
	public int setInsert(MemberDto dto, MultipartFile image) throws Exception {
		// TODO Auto-generated method stub
		ServletContext servletContext = httpSession.getServletContext();
		String realPath = servletContext.getRealPath("/resources/upload/member");
		String fileName = FileManager.saveFile(image, realPath);
		System.out.println(realPath);
		dto.setFileName(fileName);
		dto.setOriName(image.getOriginalFilename());
		
		return memberDao.setInsert(dto);
	}
	public MemberDto tryLogin(MemberDto memberDto)throws Exception{
		MemberDto checkDto = memberDao.getDetail(memberDto);
		if(checkDto != null && checkDto.getPw().equals(memberDto.getPw())) {
			return checkDto;
		}else {
			return null;
		}
	}
	
	
}
