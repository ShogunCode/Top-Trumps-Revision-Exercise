package p3Revision;

import java.util.Comparator;

public class CompareStrongestCard implements Comparator<TopTrumpCard>{

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		return o1.getStrength()-o2.getStrength();
	}

}
