package com.ghost.games.numberhero.model;


/**
 * @author ÑÖ¶«Åô
 * @Title: main
 * @Description: TODO
 * @throws 2014-2-12ÏÂÎç08:49:13 
 */
public class Record {
	
	private int id;
	private long times;
	private int userid;
	
	
	
	
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Record( long times, int userid) {
		super();
		this.times = times;
		this.userid = userid;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public long getTimes() {
		return times;
	}


	public void setTimes(long times) {
		this.times = times;
	}


	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}


