package model;

import processing.core.PApplet;

public class Character {
	
	protected float posX;
	protected float posY;
	protected int direction;
	protected PApplet app;
	
	public Character(float posX, float posY, int direction, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
		this.app = app;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}

