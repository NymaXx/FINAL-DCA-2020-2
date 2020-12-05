package model;

import processing.core.PApplet;

public class Player {
	private float posX;
	private float posY;
	private int radius;
	private int direction;
	private PApplet app;
	
	public Player(float posX, float posY, int radius, int direction, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
		this.direction = direction;
		this.app = app;
	}
	
	public void paint() {
		app.fill(255, 0, 255);
		app.ellipse(this.posX, this.posY, this.radius * 2, this.radius * 2);
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
