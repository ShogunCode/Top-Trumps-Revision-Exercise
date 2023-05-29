package p3Revision;

import java.util.Comparator;

public class CompareByAverage implements Comparator <TopTrumpCard>{

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		int o1Average = (o1.getAgility()+o1.getIntelligence()+o1.getSpeed()+o1.getStrength());
		int o2Average = (o2.getAgility()+o2.getIntelligence()+o2.getSpeed()+o2.getStrength());
		return o1Average-o2Average;
	}

}
