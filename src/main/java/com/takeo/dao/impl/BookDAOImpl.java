package com.takeo.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.takeo.config.JdbcUtility;
import com.takeo.dao.BookDAO;
import com.takeo.model.Book;
import com.takeo.query.QueryConstants;


public class BookDAOImpl implements BookDAO {
	
	private Connection  con;
	private PreparedStatement ps;
	private ResultSet rs;

	public int addBooks(Book book) {
		// TODO Auto-generated method stub
		
		//register a driver- Establish a connection with db
		int count =0;
		
		try {
			con=JdbcUtility.getConnection();
			
			//Prepared Statement
			ps=con.prepareStatement(QueryConstants.BOOk_INSERT_QUERY);
			
			ps.setString(1, book.getBname());
			ps.setString(2, book.getBtype());
			ps.setInt(3, book.getBprice());
			
			 count= ps.executeUpdate();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
			try {
				JdbcUtility.closeConnection(con, ps);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return count;
	}

	public List<Book> viewAllBooks() {
		// TODO Auto-generated method stub
		List<Book> addBooks=new ArrayList<>();
		
		try {
			con=JdbcUtility.getConnection();
			
			//prepared Statement
			ps=con.prepareStatement(QueryConstants.BOOK_RETREIVE_QUERY);
			
			//ExecuteQuery
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int bid=rs.getInt(1);
				String bname=rs.getString(2);
				String btype=rs.getString(3);
				int bprice=rs.getInt(4);
				
				Book book=new Book(bid,bname,btype,bprice);
				
				addBooks.add(book);
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return addBooks;
	}

	public Book viewBook(int bid) {
		// TODO Auto-generated method stub
		Book book=null;
		
		try {
			con=JdbcUtility.getConnection();
			
			//prepared Statement
			
			ps=con.prepareStatement(QueryConstants.BOOK_RETREIVE_SPECIFIC_QUERY);
			
			ps.setInt(1, bid);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String type=rs.getString(3);
				int price=rs.getInt(4);
				
				book=new Book(id,name,type,price);
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return book;
	}

	public int deleteBook(int bid) {
		// TODO Auto-generated method stub
		Book book=null;
		int count=0;
		
		try {
			con=JdbcUtility.getConnection();
			
			//prepared Statement
			
			ps=con.prepareStatement(QueryConstants.BOOK_RETREIVE_SPECIFIC_QUERY);
			
			ps.setInt(1, bid);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String type=rs.getString(3);
				int price=rs.getInt(4);
				
				book=new Book(id,name,type,price);
			}
			
			if(book !=null)
			{
				//delete the Existing record
				ps=con.prepareStatement(QueryConstants.BOOK_DELETE_QUERY);
				ps.setInt(1, book.getBid());
				
				count=ps.executeUpdate();
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return count;
	}

	public int upateBook(int bid,Book book) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		return 0;
	}

}
