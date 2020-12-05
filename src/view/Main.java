package view;

import controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private ControllerMain controllerMain;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(800, 950);
	}
	
	public void setup() {
		background(255, 128, 0);
		controllerMain = new ControllerMain(this);
		controllerMain.loadInformation();
	}
	
	public void draw() {
		controllerMain.paint();
	}
	
	public void keyPressed() {
		
	}

}
