package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import processing.core.PApplet;

public class Logic implements Runnable {
	private Player player;
	private int screen;
	private Timer timer;
	private Button resetBtn;
	private Button infoBtn;
	private Button sortDateBtn;
	private Button sortTimeBtn;
	private Button returnBtn;
	private boolean isPlaying;
	private int roads;
	private String finalText;
	private int[] rowMultiplier = { -1, 1 };
	private int[] rowMultiplierAlt = { 0, 1, 2 };
	private String[] data;
	private ArrayList<Car> carList;
	private ArrayList<GameInfo> gameInfoList;
	private PApplet app;

	public Logic(PApplet app) {
		this.screen = 0;
		this.isPlaying = true;
		this.timer = new Timer(0, true);
		this.resetBtn = new Button(300, 450, 200, 50, "Reiniciar", app);
		this.infoBtn = new Button(300, 500, 200, 50, "Ver datos", app);
		this.sortDateBtn = new Button(0, 700, 266, 50, "Ordenar por fecha", app);
		this.sortTimeBtn = new Button(266, 700, 266, 50, "Ordenar por tiempo", app);
		this.returnBtn = new Button(532, 700, 266, 50, "Regresar", app);
		this.roads = 6;
		this.finalText = "";
		this.data = app.loadStrings("../../data/data.txt");
		this.carList = new ArrayList<Car>();
		this.gameInfoList = new ArrayList<GameInfo>();
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

			try {
				float posX = Float.parseFloat(lineArray[2]);
				float posY = Float.parseFloat(lineArray[3]);

				if (type.contains("personaje")) {
					player = new Player(posX, posY + 5, 20, direction, app);
				}

				if (type.contains("carro")) {

					if (posY == 200 && direction > 0) {
						carList.add(new Car(posX, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX + 100, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX - 100, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX + 200, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX - 300, posY, 100, 50, direction, this.app));
					}

					if (posY == 200 && direction < 0) {
						carList.add(new Car(posX, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX + 100, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX + 300, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX + 200, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX - 300, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX - 400, posY - 100, 100, 50, direction, this.app));
					}

					if (posY == 400 && direction > 0) {
						carList.add(new Car(posX, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX + 250, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX + 350, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX + 550, posY, 100, 50, direction, this.app));
						carList.add(new Car(posX - 100, posY, 100, 50, direction, this.app));
					}

					if (posY == 400 && direction < 0) {
						carList.add(new Car(posX, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX - 250, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX - 450, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX - 100, posY - 100, 100, 50, direction, this.app));
						carList.add(new Car(posX + 100, posY - 100, 100, 50, direction, this.app));
					}

					if (direction < 0) {
						carList.add(new Car(posX, 500, 100, 50, direction, this.app));
						carList.add(new Car(posX - 100, 500, 100, 50, direction, this.app));
						carList.add(new Car(posX + 250, 500, 100, 50, direction, this.app));
					}

					if (direction > 0) {
						carList.add(new Car(posX, 600, 100, 50, direction, this.app));
						carList.add(new Car(posX + 150, 600, 100, 50, direction, this.app));
						carList.add(new Car(posX - 200, 600, 100, 50, direction, this.app));
					}
				}

			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Algunos datos números del txt no son válidos");
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
					// car.setPosY(car.getPosY() + (100 * rowMultiplier[secondRowRandomY]));
				}
			}

			if (car.getPosY() == 400) {
				if (car.direction < 0) {
					// car.setPosY(car.getPosY() + (100 * rowMultiplierAlt[fourthRowRandomY]));
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
			winning();
			break;

		case 1:
			app.background(0);
			app.fill(255);
			app.textAlign(app.CENTER, app.CENTER);
			app.textSize(40);
			app.text(this.finalText, 400, 750 / 2);
			this.resetBtn.paint();
			this.infoBtn.paint();
			break;

		case 2:
			app.background(0);
			paintGameInfoList();
			this.sortDateBtn.paint();
			this.sortTimeBtn.paint();
			this.returnBtn.paint();
			;
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
		app.fill(0);
		app.text("Tiempo: " + this.timer.getCount(), 780, 0);
	}

	public void paintGameInfoList() {
		for (int i = 0; i < this.gameInfoList.size(); i++) {
			app.strokeWeight(1);
			app.fill(255, 0, 255);
			app.rect(0, 0 + (50 * i), 800, 50);
			app.fill(255);
			app.textSize(20);
			app.textAlign(app.LEFT, app.TOP);
			app.text(i + 1 + ". Fecha: " + this.gameInfoList.get(i).getDate() + " / Tiempo: "
					+ this.gameInfoList.get(i).getTime(), 10, 10 + (50 * i));
			app.noStroke();
		}

	}

	public void moveCars() {
		for (int i = 0; i < this.carList.size(); i++) {
			this.carList.get(i).move();
			this.carList.get(i).resetPosX();
		}
	}

	public void winning() {
		if (this.player.getPosY() > 650) {
			Date date = new Date();
			this.gameInfoList.add(new GameInfo(date, timer.getCount()));
			this.screen = 1;
			this.finalText = "¡Ganaste! :D";
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

			if (playerX + playerRadius >= carX && playerX - playerRadius <= carX + carW
					&& playerY - playerRadius >= carY && playerY + playerRadius <= carY + carH) {
				this.screen = 1;
				this.isPlaying = false;
				this.timer.setRunning(false);
				Date date = new Date();
				this.gameInfoList.add(new GameInfo(date, timer.getCount()));
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

			if (app.mouseX >= this.infoBtn.getPosX() && app.mouseX <= this.infoBtn.getPosX() + this.infoBtn.getWidth()
					&& app.mouseY >= this.infoBtn.getPosY()
					&& app.mouseY <= this.infoBtn.getPosY() + this.infoBtn.getHeight()) {
				screen = 2;
			}
			break;

		case 2:
			if (app.mouseX >= this.returnBtn.getPosX()
					&& app.mouseX <= this.returnBtn.getPosX() + this.returnBtn.getWidth()
					&& app.mouseY >= this.returnBtn.getPosY()
					&& app.mouseY <= this.returnBtn.getPosY() + this.returnBtn.getHeight()) {
				screen = 1;
			}

			if (app.mouseX >= this.sortDateBtn.getPosX()
					&& app.mouseX <= this.sortDateBtn.getPosX() + this.sortDateBtn.getWidth()
					&& app.mouseY >= this.sortDateBtn.getPosY()
					&& app.mouseY <= this.sortDateBtn.getPosY() + this.sortDateBtn.getHeight()) {
				sortByDate();
			}

			if (app.mouseX >= this.sortTimeBtn.getPosX()
					&& app.mouseX <= this.sortTimeBtn.getPosX() + this.sortTimeBtn.getWidth()
					&& app.mouseY >= this.sortTimeBtn.getPosY()
					&& app.mouseY <= this.sortTimeBtn.getPosY() + this.sortTimeBtn.getHeight()) {
				sortByTime();
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

		}
	}

	public void sortByDate() {
		Collections.sort(this.gameInfoList, new SortByDate());
	}

	public void sortByTime() {
		Collections.sort(this.gameInfoList, new SortByTime());
	}
}
