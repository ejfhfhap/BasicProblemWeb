package com.sam.basic.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.basic.util.Pager;

@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public List<CommentDto> getList(Pager pager) throws Exception{
		pager.setBlockRange(commentDao.getListCnt(pager));
		pager.setStartLastRange();
		return commentDao.getList(pager);
	}
	public int setInsert(CommentDto commentDto)throws Exception{
		return commentDao.setInsert(commentDto);
	}
}
