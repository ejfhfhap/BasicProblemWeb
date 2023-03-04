package com.sam.basic.util;

public class Pager {
	private Integer problemListId;
	
	public Integer getProblemListId() {
		return problemListId;
	}
	public void setProblemListId(Integer problemListId) {
		this.problemListId = problemListId;
	}

	// ---------------------------- 페이저 작업
	private Integer totalDataCnt;
	private String searchKind;
	private String searchContent;
		
	public String getSearchKind() {
		if(searchKind == null) {
			searchKind = "problemListId";
		}
		return searchKind;
	}
	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}
	public String getSearchContent() {
		if(searchContent == null) {
			searchContent = "";
		}
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	private Integer startBlock;
	private Integer lastBlock;
	private Integer totalPageCnt;
	
	public void setBlockRange(Integer totalDataCnt) {
		int perBlockCnt = 5;
		totalPageCnt = totalDataCnt / getPerPageCnt();
		if(totalDataCnt % getPerPageCnt() != 0) {
			totalPageCnt++;
		}
		if(getCurPageNum() >= totalPageCnt) {
			curPageNum = totalPageCnt;
		}
		
		int curBlock = (getCurPageNum() / perBlockCnt);
		if(curPageNum % perBlockCnt != 0) {
			curBlock++;
		}
		startBlock = (curBlock - 1) * perBlockCnt + 1;
		lastBlock = (curBlock * perBlockCnt);
		
		if(lastBlock >= totalPageCnt) {
			lastBlock = totalPageCnt;
		}
	}
	
		
	public Integer getTotalDataCnt() {
		return totalDataCnt;
	}


	public void setTotalDataCnt(Integer totalDataCnt) {
		this.totalDataCnt = totalDataCnt;
	}


	public Integer getTotalPageCnt() {
		return totalPageCnt;
	}


	public void setTotalPageCnt(Integer totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public Integer getStartBlock() {
		return startBlock;
	}


	public void setStartBlock(Integer startBlock) {
		this.startBlock = startBlock;
	}


	public Integer getLastBlock() {
		return lastBlock;
	}


	public void setLastBlock(Integer lastBlock) {
		this.lastBlock = lastBlock;
	}




	// ------------- 각 페이지당 데이터 불러오기
	private Integer curPageNum;
	private Integer startRow;
	private Integer lastRow;
	private Integer perPageCnt;
	
	public void setStartLastRange() {
		startRow = (getCurPageNum() - 1) * getPerPageCnt() + 1;
		lastRow = getCurPageNum() * getPerPageCnt();
	}
	
	public Integer getPerPageCnt() {
		if(perPageCnt == null || perPageCnt < 1) {
			perPageCnt = 5;
		}
		return perPageCnt;
	}

	public void setPerPageCnt(Integer perPageCnt) {
		this.perPageCnt = perPageCnt;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getLastRow() {
		return lastRow;
	}

	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}

	public Integer getCurPageNum() {
		if(curPageNum == null || curPageNum < 1) {
			curPageNum = 1;
		}
		return curPageNum;
	}
	public void setCurPageNum(Integer curPageNum) {
		this.curPageNum = curPageNum;
	}
	
}
