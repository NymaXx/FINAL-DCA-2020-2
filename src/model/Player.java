package model;

import processing.core.PApplet;

public class Player extends Character{
	
	private int radius;
	
	public Player(float posX, float posY, int radius, int direction, PApplet app) {
		super(posX, posY, direction, app);
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}
	
	public void paint() {
		app.fill(255, 0, 255);
		app.ellipse(this.posX, this.posY, this.radius * 2, this.radius * 2);
	}
	
	public void move(int top, int bottom, int left, int right) {
		if(app.keyCode == app.UP && this.posY > top) {
			this.posY -= 50;
		}
		
		if(app.keyCode == app.DOWN && this.posY < bottom) {
			this.posY += 50;
		}
		
		if(app.keyCode == app.LEFT && this.posX > left) {
			this.posX -= 50;
		}
		
		if(app.keyCode == app.RIGHT && this.posX < right) {
			this.posX += 50;
		}
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
