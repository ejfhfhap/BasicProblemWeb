package com.sam.basic.util;

import java.util.List;

public interface ObjectDao {
	public List<Object> getList() throws Exception;
	public int setInsert(Object dto) throws Exception;
	public int setUpdate(Object dto)throws Exception;
	public int setDelete(Object dto)throws Exception;
}
