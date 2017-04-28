package com.common;

import java.util.Comparator;
import java.util.Map;

public class MapComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Map.Entry<String, Integer> age1, Map.Entry<String, Integer> age2) {
		
		return age1.getValue().compareTo(age2.getValue());
	}

}
