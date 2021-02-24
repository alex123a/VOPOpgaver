package vop;

import java.util.Comparator;

public class MountainRangeComparator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain o1, Mountain o2) {
        int rangeCompare = o1.getRange().compareTo(o2.getRange());
        return rangeCompare > 0 ? 1 : rangeCompare < 0 ? -1 : o1.compareTo(o2);
    }
}
