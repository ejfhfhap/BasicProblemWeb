package com.sam.basic.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


@Repository
public class MemberDao{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sam.basic.member.";
	
	public MemberDto getDetail(MemberDto memberDto) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getDetail",memberDto);
	}
	
	public List<Object> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int setInsert(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setInsert", dto);
	}

	public int setUpdate(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "setUpdate", dto);
	}

	public int setDelete(Object dto) throws Exception {
		return sqlSession.delete(NAMESPACE + "setDelete", dto);
	}
	
}
