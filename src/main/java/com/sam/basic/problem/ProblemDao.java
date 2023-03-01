package com.sam.basic.problem;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.basic.util.Pager;

@Repository
public class ProblemDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sam.basic.problem.";
	
	public List<ProblemDto> getList(Pager pager){
		return sqlSession.selectList(NAMESPACE + "getList",pager);
	}
	public int getListCnt(Pager pager) {
		return sqlSession.selectOne(NAMESPACE + "getListCnt", pager);
	}
	public ProblemDto getDetail(ProblemDto problemDto) {
		return sqlSession.selectOne(NAMESPACE + "getDetail", problemDto);
	}
	public int setProblemInsert(ProblemDto problemDto) {
		return sqlSession.insert(NAMESPACE + "setProblemInsert", problemDto);
	}
	public int setProblemImageInsert(ProblemImageDto problemImageDto) {
		return sqlSession.insert(NAMESPACE + "setProblemImageInsert", problemImageDto);
	}
	public ProblemImageDto getImageDetail(ProblemImageDto problemImageDto) {
		return sqlSession.selectOne(NAMESPACE + "getImageDetail", problemImageDto);
	}
}
