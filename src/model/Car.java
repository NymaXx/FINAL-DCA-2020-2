package model;

import processing.core.PApplet;

public class Car extends Character {
	
	private float width;
	private float height;
	
	public Car(float posX, float posY, float width, float height, int direction, PApplet app) {
		super(posX, posY, direction, app);
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}
	
	public void paint() {
		app.fill(255, 0, 0);
		app.rect(this.posX, this.posY, this.width, this.height);
	}
	
	public void move() {
		this.posX += this.direction;
	}
	
	public void resetPosX() {
		if(this.posX < 0 - this.width - 1) {
			this.posX = 800 + this.width;
		}
		
		if(this.posX > 800 + this.width + 1) {
			this.posX = 0 - this.width;
		}
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
}
