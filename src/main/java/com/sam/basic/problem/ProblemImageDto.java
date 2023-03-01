package com.sam.basic.problem;

public class ProblemImageDto {
	private Integer problemImageId;
	private Integer problemListId;
	private String imageName;
	private String oriImageName;
	
	public Integer getProblemImageId() {
		return problemImageId;
	}
	public void setProblemImageId(Integer problemImageId) {
		this.problemImageId = problemImageId;
	}
	public Integer getProblemListId() {
		return problemListId;
	}
	public void setProblemListId(Integer problemListId) {
		this.problemListId = problemListId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getOriImageName() {
		return oriImageName;
	}
	public void setOriImageName(String oriImageName) {
		this.oriImageName = oriImageName;
	}
	
	
}
