package model;

public class Timer implements Runnable {

	private int count;
	private boolean isRunning;
	
	public Timer(int count, boolean isRunning) {
		this.count = count;
		this.isRunning = isRunning;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.isRunning) {
			try {
				increaseCount();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void increaseCount() {
		this.count++;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
}

