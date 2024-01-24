package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Bean.BookBean;
import com.util.DBConnection;

public class BookDao {
	Connection con=null;	
	  public String userAuthentication(BookBean bobj) throws ClassNotFoundException, SQLException 
	  {
		 con=DBConnection.getDbConnection(); 
		 String name=bobj.getName();
	     String author=bobj.getAuthor();
	     String price=bobj.getPrice();
	     PreparedStatement ps= con.prepareStatement("insert into book values (?,?,?)");
	     ps.setString(1, name);
	     ps.setString(2, author);
	     ps.setString(3, price);
	     int i=ps.executeUpdate();
	     if(i>0) 
	     	 return "Success";
	     return "Invalid";
}
}