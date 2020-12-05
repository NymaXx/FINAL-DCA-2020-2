package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	private Player player;
	private int screen;
	private String[] data;
	private ArrayList<Car> carList;
	private PApplet app;

	public Logic(PApplet app) {
		this.screen = 0;
		this.data = app.loadStrings("../../data/data.txt");
		this.carList = new ArrayList<Car>();
		this.app = app;
	}

	public void loadData() {

		for (int i = 0; i < data.length; i++) {
			String[] lineArray = data[i].split(",");

			String type = lineArray[0];
			int direction = Integer.parseInt(lineArray[1]);
			float posX = Float.parseFloat(lineArray[2]);
			float posY = Float.parseFloat(lineArray[3]);

			if (lineArray[0].contains("personaje")) {
				player = new Player(posX, posY + 45, 35, direction, this.app);
			}
		}
	}

	public void handleScreen() {
		switch (this.screen) {
		case 0:
			paintScenario();
			paintCharacters();
			break;

		case 1:
			break;

		case 2:
			break;
		}
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
		player.paint();
	}
	
	public void handleKeyPressed() {
		switch(this.screen) {
		case 0:
			this.player.move(66, 904, 70, 730);
			break;

		case 1:
			break;

		case 2:
			break;
		}
	}
}
