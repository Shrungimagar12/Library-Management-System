package com.Bean;

public class ShowBean {

	private String name;
	private String author;
	private String price;
	  
	  public ShowBean() 
	  {
		  super();
	  }
	  public ShowBean(String name, String author, String price) 
	  {
		super();
		this.name = name;
		this.author = author;
		this.price=price;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShowBean [name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	  }// end class


