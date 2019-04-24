package com.spring.web.entity;


public class User {
	private int id;
	private byte[] base64;//
	
	/*private String name;*/
	
	public User() {

	}

	public byte[] getBase64() {
		return base64;
	}

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
*/
	public void setBase64(byte[] base64) {
		this.base64 = base64;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
