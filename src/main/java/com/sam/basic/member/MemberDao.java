package com.sam.basic.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.basic.util.ObjectDao;

@Repository
public class MemberDao implements ObjectDao{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sam.basic.member.";
	
	public MemberDto getDetail(MemberDto memberDto) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getDetail",memberDto);
	}
	
	@Override
	public List<Object> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setInsert(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setInsert", dto);
	}

	@Override
	public int setUpdate(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
