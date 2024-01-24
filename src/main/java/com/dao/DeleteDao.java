package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Bean.DeleteBean;
import com.util.DBConnection;

public class DeleteDao {
	Connection con=null;	
	  public String userAuthentication(DeleteBean robj) throws ClassNotFoundException, SQLException 
	  {
		 con=DBConnection.getDbConnection(); 
		 String name=robj.getName();
	     
	     PreparedStatement ps= con.prepareStatement("delete from book where name=?");
	     ps.setString(1, name);
	     
	     int i=ps.executeUpdate();
	     if(i>0) 
	     	 return "Success";
	     return "Invalid";
}
}