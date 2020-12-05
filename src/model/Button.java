package model;

import processing.core.PApplet;

public class Button {
	private float posX;
	private float posY;
	private float width;
	private float height;
	private String description;
	private PApplet app;
	
	public Button(float posX, float posY, float width, float height, String description, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.description = description;
		this.app = app;
	}
	
	public void paint() {
		app.fill(255);
		app.rect(this.posX, this.posY, this.width, this.height);
		app.fill(30);
		app.textAlign(app.CENTER, app.CENTER);
		app.textSize(20);
		app.text(this.description, this.posX + this.width /2, this.posY + this.height /2 - 2);
		
		if(app.mouseX >= this.posX && app.mouseX <= this.posX + this.width && app.mouseY >= this.posY && app.mouseY <= this.posY + this.height) {
			app.cursor(app.HAND);
		} else {
			app.cursor(app.ARROW);
		}
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
