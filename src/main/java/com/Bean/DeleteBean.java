package com.Bean;

public class DeleteBean {

	private String name;
	
	  
	  public DeleteBean() 
	  {
		  super();
	  }
	  public DeleteBean(String name) 
	  {
		super();
		this.name = name;
		
	  }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DeleteBean [name=" + name +"]";
	}
	  }// end class


