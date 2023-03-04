package com.sam.basic.comment;

public class CommentDto {
	private Integer commentId;
	private Integer problemListId;
	private String content;
	private Integer goodCnt;
	private Integer badCnt;
	private String writer;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getProblemListId() {
		return problemListId;
	}
	public void setProblemListId(Integer problemListId) {
		this.problemListId = problemListId;
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
	
}
