package com.Bean;

public class UpdateBean {

	private String name;
	private String author;
	
	  
	  public UpdateBean() 
	  {
		  super();
	  }
	  public UpdateBean(String name, String author) 
	  {
		super();
		this.name = name;
		this.author = author;
		
	  }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "UpdateBean [name=" + name + ", author=" + author + "]";
	}

}
