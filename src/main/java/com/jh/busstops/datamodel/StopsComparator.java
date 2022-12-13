package com.jh.busstops.datamodel;

import java.util.ArrayList;
import java.util.Comparator;

public class StopsComparator implements Comparator<ArrayList<String>> {
	@Override
	public int compare(ArrayList<String> firstList, ArrayList<String> secondList) {
		return Integer.compare(firstList.size(), secondList.size());
	}
}