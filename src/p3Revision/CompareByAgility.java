package p3Revision;

import java.util.Comparator;

public class CompareByAgility implements Comparator<TopTrumpCard>{

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		
		return o1.getAgility()-o2.getAgility();
	}

}
