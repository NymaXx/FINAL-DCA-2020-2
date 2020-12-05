package controller;

import model.Logic;
import processing.core.PApplet;

public class ControllerMain {
	
	private Logic logic;
	private PApplet app;
	
	public ControllerMain(PApplet app) {
		this.logic = new Logic(app);
		this.app = app;
	}
	
	public void loadInformation() {
		this.logic.loadData();
		this.logic.setCars();
	}
	
	public void paint() {
		this.logic.handleScreen();
	}
	
	public void mousePressedEvents() {
		this.logic.handleMousePressed();
	}
	
	public void keyEvents() {
		this.logic.handleKeyPressed();
	}
}
