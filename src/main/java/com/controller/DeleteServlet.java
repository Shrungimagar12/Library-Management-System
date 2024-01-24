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

import com.Bean.DeleteBean;
import com.dao.DeleteDao;


public class DeleteServlet extends HttpServlet {
	
    public DeleteServlet() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String name=request.getParameter("name");
			  
			 
			  PrintWriter out= response.getWriter();
			  DeleteBean robj= new DeleteBean();
			  robj.setName(name);
			  
			  RequestDispatcher rd1= request.getRequestDispatcher("./delete.jsp");
			  RequestDispatcher rd2= request.getRequestDispatcher("./delete.html");
			  
			  
			  DeleteDao tobj= new DeleteDao();
			  try 
			  {
				String str=tobj.userAuthentication(robj);
				
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