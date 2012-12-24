/**
 * 
 */
package com.paradigmcreatives.samplesql;


public class Comment {
	
	 String name;
	 private long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
	    return name;
	    
	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
