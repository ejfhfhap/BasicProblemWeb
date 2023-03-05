package com.sam.basic.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.basic.util.DaoInterface;
import com.sam.basic.util.Pager;

@Repository
public class CommentDao{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sam.basic.comment.";
	
	public CommentDto getDetail(CommentDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CommentDto> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public int setInsert(CommentDto dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setInsert", dto);
	}

	public int setUpdate(CommentDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setDelete(CommentDto dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getListCnt(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getListCnt", pager);
	}
	
}
