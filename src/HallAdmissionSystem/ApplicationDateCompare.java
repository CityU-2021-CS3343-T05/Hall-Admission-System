package HallAdmissionSystem;

import java.util.*;

public class ApplicationDateCompare implements Comparator<Application>{

	@Override
	public int compare(Application a1, Application a2) {
		return a1.getApplyTime().compareTo(a2.getApplyTime());
	}

}
