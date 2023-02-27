package com.sam.basic.problem;

public class ProblemDto {
	private Integer problemListId;
	private String title;
	private String content;
	private String answer;
	private String difficulty;
	private String writer;
	private Integer goodCnt;
	private Integer badCnt;
	private Integer cnt;
	
	public Integer getProblemListId() {
		return problemListId;
	}
	public void setProblemListId(Integer problemListId) {
		this.problemListId = problemListId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getGoodCnt() {
		return goodCnt;
	}
	public void setGoodCnt(Integer goodCnt) {
		this.goodCnt = goodCnt;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getBadCnt() {
		return badCnt;
	}
	public void setBadCnt(Integer badCnt) {
		this.badCnt = badCnt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	
	
}
