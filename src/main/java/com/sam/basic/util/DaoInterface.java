package com.sam.basic.util;

import java.util.List;

public interface DaoInterface {
	
		public Object getDetail(Object dto) throws Exception;
		public List<Object> getList(Pager pager) throws Exception;
		public int setInsert(Object dto) throws Exception;
		public int setUpdate(Object dto) throws Exception;
		public int setDelete(Object dto) throws Exception;
}
