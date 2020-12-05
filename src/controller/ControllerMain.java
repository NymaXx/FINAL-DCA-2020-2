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
	}
	
	public void paint() {
		this.logic.handleScreen();
	}
	
	public void keyEvents() {
		this.logic.handleKeyPressed();
	}
}
