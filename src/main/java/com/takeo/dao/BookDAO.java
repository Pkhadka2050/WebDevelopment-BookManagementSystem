package com.takeo.dao;

import java.util.List;

import com.takeo.model.Book;

public interface BookDAO {
	
	public int addBooks(Book book);
	
	List<Book> viewAllBooks();
	
	Book viewBook(int bid);
	
	int deleteBook(int bid);
	
	int upateBook(int bid, Book book);

}
