package com.takeo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.dao.impl.BookDAOImpl;
import com.takeo.model.Book;

/**
 * Servlet implementation class BookInsertController
 */
public class BookInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Capture the data coming from client
		
		String bname=request.getParameter("bname");
		
		String btype=request.getParameter("btype");
		
		int price=Integer.parseInt(request.getParameter("bprice"));
		
		Book book=new Book(bname,btype,price);
		
		//Interface with database s/w to store the data
		
		BookDAOImpl daoImpl=new BookDAOImpl();
		
		int addbooks=daoImpl.addBooks(book);
		
		PrintWriter pw=response.getWriter();
		
		response.setContentType("text/html");
		
		if(addbooks !=0)
		{
			pw.println("Data Inserted Successfully");
			//pw.println("<a href=addBook.html>viewAllBooks</a>");
			
		}
		else
			pw.println("Data not Inserted Successfully");
			pw.println("<a href=addBook.html>AddBook</a>");
		
		
		
		
		
		
}

}
