package p3Revision;

import java.util.Comparator;

public class CompareByAlaphabet implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
