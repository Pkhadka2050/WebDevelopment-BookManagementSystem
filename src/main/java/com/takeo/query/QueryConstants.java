package com.takeo.query;

public interface QueryConstants {
	
	String BOOk_INSERT_QUERY="insert into bookinfo(bname,btype,bprice)values(?,?,?)";
	
	String BOOK_RETREIVE_QUERY="select * from bookinfo";
	
	String BOOK_RETREIVE_SPECIFIC_QUERY="select * from bookinfo where bid=?";
	
	String BOOK_DELETE_QUERY="delete from book where bid=?";
	
	String BOOK_UPDATE_QUERY="update bookinfo set bname=?,btype=?,bprice=? where bid=?";

}
