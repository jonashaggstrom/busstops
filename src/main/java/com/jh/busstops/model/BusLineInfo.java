package com.jh.busstops.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BusLineInfo {
	//public static Map<Integer,Integer> nrOfStopsForBusMap = new HashMap<Integer,Integer>();

	
	public static BusLine[] busLines = null;
	public static Map<Integer, BusLine> busLineMap = new HashMap<>();
	public static StopPoint[] stopPoints = null;
	public static PointsOnLine[] pointsOnLines=null;
	public static Map<Integer,String> stopIdToStopNamesMap = new HashMap<Integer,String>();
	
	public static Map<Integer, ArrayList<Integer>> stopIdsForBusMap = new HashMap<Integer,ArrayList<Integer>>();
	public static Map<Integer, ArrayList<String>> stopNamesForBusMap = new HashMap<Integer,ArrayList<String>>();
	
	
	public static Map<Integer, ArrayList<String>> getTopTen() {
		System.out.println("stopNamesForBusMap.size(): " + stopNamesForBusMap.size());
		StopsComparator nrOfStopsComparator = new StopsComparator();
		Map<Integer, ArrayList<String>> topTen =
				stopNamesForBusMap.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue(nrOfStopsComparator.reversed()))
			       .limit(10)
			       .collect(Collectors.toMap(
			          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return topTen;

	}

}
