package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.Bean.BookBean;
import com.dao.BookDao;


public class BookServlet extends HttpServlet {
	
    public BookServlet() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String name=request.getParameter("name");
			  String author=request.getParameter("author");
			  String price=request.getParameter("price");
			 
			  PrintWriter out= response.getWriter();
			  BookBean bobj= new BookBean();
			  bobj.setName(name);
			  bobj.setAuthor(author);
			  bobj.setPrice(price);
			  RequestDispatcher rd1= request.getRequestDispatcher("./book.jsp");
			  RequestDispatcher rd2= request.getRequestDispatcher("./addbookfrm.html");
			  
			  
			  BookDao dobj= new BookDao();
			  try 
			  {
				String str=dobj.userAuthentication(bobj);
				
				 if(str.equals("Success"))
				 {
					 rd1.forward(request, response);
				 }
				 else
				 {
					 out.print(""+str);
					 rd2.include(request, response);
				 }
			  }
			  catch (ClassNotFoundException | SQLException e) 
			  {
				e.printStackTrace();
			  }
	}

}