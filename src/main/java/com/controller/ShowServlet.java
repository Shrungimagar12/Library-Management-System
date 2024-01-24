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
import com.Bean.ShowBean;
import com.dao.ShowDao;


public class ShowServlet extends HttpServlet {
	
    public ShowServlet() {
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
			  ShowBean sobj= new ShowBean();
			  sobj.setName(name);
			  sobj.setAuthor(author);
			  sobj.setPrice(price);
			  RequestDispatcher rd1= request.getRequestDispatcher("./show.jsp");
			  RequestDispatcher rd2= request.getRequestDispatcher("./ShowDao.java");
			  
			  
			  ShowDao eobj= new ShowDao();
			  try 
			  {
				String str=eobj.userAuthentication(sobj);
				
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