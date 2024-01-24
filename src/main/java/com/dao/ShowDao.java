package com.dao;
import java.sql.Statement;
import java.sql.*;
import com.Bean.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Bean.ShowBean;
import com.util.DBConnection;

public class ShowDao {

	Connection con=null;	
	  public String userAuthentication(ShowBean sobj) throws ClassNotFoundException, SQLException 
	  {
		 con=DBConnection.getDbConnection(); 
		 String name=sobj.getName();
	     String author=sobj.getAuthor();
	     String price=sobj.getPrice();
	     Statement st= con.createStatement();
	     ResultSet rs= st.executeQuery("select name,author,price from book");
	     while(rs.next()) {
	    	 System.out.println(" "+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
	     }
	     return "Success";
	  }

}  

