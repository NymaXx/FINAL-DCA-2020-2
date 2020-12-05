package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	private Player player;
	private String[] data;
	private ArrayList<Car> carList;
	private PApplet app;
	
	public Logic(PApplet app) {
		this.data = app.loadStrings("../../data/data.txt");
		this.app = app;
	}
	
	public void loadData() {
		System.out.println(this.data[0]);
	}
	
	public void paintScenario() {
		// Pintar carretera
		app.fill(0);
		app.rect(0, 100, 800, 70);
		app.rect(0, 240, 800, 70);
		app.rect(0, 380, 800, 70);
		app.rect(0, 520, 800, 70);
		app.rect(0, 660, 800, 70);
		app.rect(0, 800, 800, 70);
	}
	
	public void paintCharacters() {
		
	}
}
