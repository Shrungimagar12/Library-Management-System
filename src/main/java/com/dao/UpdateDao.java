package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.Bean.UpdateBean;
import com.util.DBConnection;

public class UpdateDao {

	Connection con=null;	
	  public String userAuthentication(UpdateBean obj) throws ClassNotFoundException, SQLException 
	  {
		 con=DBConnection.getDbConnection(); 
		 String name=obj.getName();
	     String author=obj.getAuthor();
	     
	     
	     PreparedStatement ps= con.prepareStatement("update book set name=? where author=?");
	     ps.setString(1, name);
	     ps.setString(2, author);
	     
	     int i=ps.executeUpdate();
	     if(i>0) 
	     	 return "Success";
	     return "Invalid";
	  }//end method
}
