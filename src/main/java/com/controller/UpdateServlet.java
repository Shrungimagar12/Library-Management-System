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

import com.Bean.UpdateBean;
import com.dao.UpdateDao;




public class UpdateServlet extends HttpServlet {
	
    public UpdateServlet() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String name=request.getParameter("name");
			  String author=request.getParameter("author");
			  
			 
			  PrintWriter out= response.getWriter();
			  UpdateBean obj= new UpdateBean();
			  obj.setName(name);
			  obj.setAuthor(author);
			 
			  RequestDispatcher rd1= request.getRequestDispatcher("./update.jsp");
			  RequestDispatcher rd2= request.getRequestDispatcher("./update.html");
			  
			  
			  UpdateDao uobj= new UpdateDao();
			  try 
			  {
				String str=uobj.userAuthentication(obj);
				
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