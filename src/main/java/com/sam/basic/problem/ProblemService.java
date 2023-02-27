package com.sam.basic.problem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.basic.util.Pager;

@Service
public class ProblemService {
	@Autowired
	private ProblemDao problemDao;
	
	public List<ProblemDto> getList(Pager pager){
		pager.setBlockRange(problemDao.getListCnt(pager));
		pager.setStartLastRange();
		
		return problemDao.getList(pager); 
	}
}
