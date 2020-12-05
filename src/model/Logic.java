package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic implements Runnable {
	private Player player;
	private int screen;
	private Timer timer;
	private Button resetBtn;
	private boolean isPlaying;
	private int roads;
	private String finalText;
	private int[] rowMultiplier = { -1, 1 };
	private int[] rowMultiplierAlt = { 0, 1, 2 };
	private String[] data;
	private ArrayList<Car> carList;
	private PApplet app;

	public Logic(PApplet app) {
		this.screen = 0;
		this.isPlaying = true;
		this.timer = new Timer(0, true);
		this.resetBtn = new Button(300, 450, 200, 50, "Reiniciar", app);
		this.roads = 6;
		this.finalText = "";
		this.data = app.loadStrings("../../data/data.txt");
		this.carList = new ArrayList<Car>();
		this.app = app;
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				if (this.isPlaying) {
					moveCars();
				}
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	public void loadData() {
		for (int i = 0; i < data.length; i++) {
			String[] lineArray = data[i].split(",");
			String type = lineArray[0];
			int direction = Integer.parseInt(lineArray[1]);
			float posX = Float.parseFloat(lineArray[2]);
			float posY = Float.parseFloat(lineArray[3]);

			if (type.contains("personaje")) {
				player = new Player(posX, posY + 5, 20, direction, app);
			}

			if (type.contains("carro")) {

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));

				carList.add(new Car(posX, posY, 100, 50, direction, this.app));
			}
		}
	}

	public void setCars() {
		for (int i = 0; i < this.carList.size(); i++) {
			Car car = this.carList.get(i);
			int randomX = (int) app.random(2, 3);
			int randomY = (int) app.random(-2, 3);

			int secondRowRandomY = (int) app.random(0, rowMultiplier.length);
			int fourthRowRandomY = (int) app.random(0, rowMultiplierAlt.length);

			car.setPosX(car.getPosX() + (100 * randomX));

			if (car.getPosY() == 200) {
				if (car.direction < 0) {
					car.setPosY(car.getPosY() + (100 * rowMultiplier[secondRowRandomY]));
				}
			}

			if (car.getPosY() == 400) {
				if (car.direction < 0) {
					car.setPosY(car.getPosY() + (100 * rowMultiplierAlt[fourthRowRandomY]));
				}
			}
		}
	}

	public void handleScreen() {
		switch (this.screen) {
		case 0:
			app.cursor(app.ARROW);
			paintScenario();
			paintCharacters();
			paintTime();

			try {
				collision();
			} catch (DeathException e) {
				// TODO: handle exception
				finalText = e.getMessage();
				e.printStackTrace();
			}
			break;

		case 1:
			app.fill(255);
			app.textAlign(app.CENTER, app.CENTER);
			app.textSize(40);
			app.background(0);
			app.text(this.finalText, 400, 750 / 2);
			this.resetBtn.paint();
			break;

		case 2:
			break;
		}
	}

	public void paintScenario() {
		// Pintar carretera
		app.fill(0);
		for (int i = 0; i < roads; i++) {
			app.rect(0, 100 + (100 * i), 800, 50);
		}
	}

	public void paintCharacters() {
		player.paint();
		for (int i = 0; i < this.carList.size(); i++) {
			this.carList.get(i).paint();
		}
	}

	public void paintTime() {
		app.textAlign(app.RIGHT, app.TOP);
		app.textSize(35);
		app.fill(255);
		app.text("Tiempo: " + this.timer.getCount(), 780, 0);
	}

	public void moveCars() {
		for (int i = 0; i < this.carList.size(); i++) {
			this.carList.get(i).move();
			this.carList.get(i).resetPosX();
		}
	}

	public void collision() throws DeathException {

		float playerX = player.getPosX();
		float playerY = player.getPosY();
		float playerRadius = player.getRadius();

		for (int i = 0; i < carList.size(); i++) {

			Car car = (Car) carList.get(i);
			float carX = car.getPosX();
			float carY = car.getPosY();
			float carW = car.getWidth();
			float carH = car.getHeight();

			if (playerX - playerRadius >= carX && playerX + playerRadius <= carX + carW
					&& playerY - playerRadius >= carY && playerY + playerRadius <= carY + carH) {
				this.screen = 1;
				this.isPlaying = false;
				this.timer.setRunning(false);
				throw new DeathException("Perdiste :(");
			}
		}
	}

	public void handleMousePressed() {
		switch (this.screen) {
		case 1:
			if (app.mouseX >= this.resetBtn.getPosX()
					&& app.mouseX <= this.resetBtn.getPosX() + this.resetBtn.getWidth()
					&& app.mouseY >= this.resetBtn.getPosY()
					&& app.mouseY <= this.resetBtn.getPosY() + this.resetBtn.getHeight()) {
				this.screen = 0;
				this.isPlaying = true;
				this.timer = new Timer(0, true);
				this.finalText = "";
				this.data = app.loadStrings("../../data/data.txt");
				this.carList = new ArrayList<Car>();
				this.data = app.loadStrings("../../data/data.txt");
				this.carList = new ArrayList<Car>();
				loadData();
				setCars();
			}
			break;

		default:
			break;
		}
	}

	public void handleKeyPressed() {
		switch (this.screen) {
		case 0:
			this.player.move(50, 700, 50, 750);
			break;

		case 1:
			break;

		case 2:
			break;
		}
	}

}
