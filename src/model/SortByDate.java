package model;

import java.util.Comparator;

public class SortByDate implements Comparator<GameInfo> {

	@Override
	public int compare(GameInfo o1, GameInfo o2) {
		// TODO Auto-generated method stub
		if (o1.getDate().before(o2.getDate())) {
			return -1;
		} else if (o1.getDate().after(o2.getDate())) {
			return 1;
		} else {
			return 0;
		}
	}

}
