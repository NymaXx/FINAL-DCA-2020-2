package model;

import java.util.Date;

public class GameInfo {
	
	private Date date;
	private int time;
	
	public GameInfo(Date date, int time) {
		this.date = date;
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
