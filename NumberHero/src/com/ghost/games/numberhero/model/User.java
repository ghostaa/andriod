package com.ghost.games.numberhero.model;
/**
 * @author 阎东鹏
 * @Title: main
 * @Description: TODO
 * @throws 2014-2-12下午08:48:23 
 */
public class User {
	private int id;
	private String name;
	
	
	
	
	public User() {
		super();
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
}


