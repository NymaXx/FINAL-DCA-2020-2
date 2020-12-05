package model;

import java.util.Comparator;

public class SortByTime implements Comparator<GameInfo> {

	@Override
	public int compare(GameInfo o1, GameInfo o2) {
		// TODO Auto-generated method stub
		return o1.getTime() - o2.getTime();
	}

}
