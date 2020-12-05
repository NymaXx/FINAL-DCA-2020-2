package model;

import processing.core.PApplet;

public class Car {
	private float posX;
	private float posY;
	private float width;
	private float height;
	private int direction;
	private PApplet app;
	
	public Car(float posX, float posY, float width, float height, int direction) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.direction = direction;
	}
	
	public void paint() {
		app.fill(255, 0, 0);
		app.rect(this.posX, this.posY, this.width, this.height);
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
