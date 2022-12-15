package com.jh.busstops.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

//import org.javatuples.Pair;

import com.google.gson.Gson;

public class BusstopsModel {

	private static final String replaceKey="[key]";

	public Map<Integer, BusLine> loadBusLines(String key) {
		//System.out.println("Running BusstopsModel.loadBusLines()...........");
		//System.out.println(""+busLineUrl);
		StringBuilder response = new StringBuilder();

		String busLinesJsonArraysString=null;
		try {
			// String busLineUrl=this.getClass().getClassLoader().getResource("lines.json").toString();
			String busLineUrl=TrafiklabConstants.TRAFIKLAB_BUS_LINE_DATA_URL.replace(replaceKey, key);
			URL url =new URL(busLineUrl);
			//HttpURLConnection con =(HttpURLConnection) url.openConnection();
			URLConnection con =(URLConnection) url.openConnection();
			//
			//con.setRequestMethod("GET");
			//
			con.setRequestProperty("Content-Type", "application/json");
			//con.setRequestProperty("Content-Length", "20");
			//
			con.setRequestProperty("Accept", "application/json");
			//
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			//
		    
			try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
			} catch (Exception e) {
				System.out.println("Caught Exception while reading:" + e.getMessage());
				return null;
			}

		} 
		catch (IOException e) {
			System.out.println("Caught IOException:" + e.getMessage());
			return null;
		}
		//String formattedResponse=response.toString().replace('\"', '\'');
		String formattedResponse=response.toString();
		int startIndex=formattedResponse.indexOf("[");
		//System.out.println("startIndex: " +startIndex);
		int endIndex=formattedResponse.indexOf("]");
		//System.out.println("endIndex: " +endIndex);
	    busLinesJsonArraysString = formattedResponse.substring(startIndex, endIndex+1);

		//System.out.println("Length: " +busLinesJsonArraysString.length());
		//System.out.println("Start:" + busLinesJsonArraysString.toString().substring(0, 100));
		//System.out.println("End:" + busLinesJsonArraysString.toString().substring(busLinesJsonArraysString.length()-100));

		BusLine[] busLines = new Gson().fromJson(busLinesJsonArraysString, BusLine[].class);
		Map<Integer, BusLine> busLineMap = new HashMap<>();
		for(int i=0; i< busLines.length; i++) {
			int lineNo=Integer.parseInt(busLines[i].getLineNumber());
			if(!busLineMap.containsKey(lineNo)) {
				busLineMap.put(lineNo, busLines[i]);
			}
		}
		return busLineMap;
	}

	public Map<Integer,String> loadStopPoints(String key) {
		//System.out.println("Running BusstopsModel.loadStopPoints()...........");
		//System.out.println(""+stopDataUrl);
		StringBuilder response = new StringBuilder();

		String stopPointsJsonArraysString=null;
		try {
			//String stopDataUrl=this.getClass().getClassLoader().getResource("stop.json").toString();
			String stopDataUrl=TrafiklabConstants.TRAFIKLAB_STOP_DATA_URL.replace(replaceKey, key);
			URL url =new URL(stopDataUrl);
			//HttpURLConnection con =(HttpURLConnection) url.openConnection();
			URLConnection con =(URLConnection) url.openConnection();
			//
			//con.setRequestMethod("GET");
			//
			con.setRequestProperty("Content-Type", "application/json");
			//con.setRequestProperty("Content-Length", "20");
			//
			con.setRequestProperty("Accept", "application/json");
			//
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			//
		    
			try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
			} catch (Exception e) {
				System.out.println("Caught Exception while reading:" + e.getMessage());
				return null;
			}

		} 
		catch (IOException e) {
			System.out.println("Caught IOException:" + e.getMessage());
			return null;
		}
		//String formattedResponse=response.toString().replace('\"', '\'');
		String formattedResponse=response.toString();
		int startIndex=formattedResponse.indexOf("[");
		//System.out.println("startIndex: " +startIndex);
		int endIndex=formattedResponse.indexOf("]");
		//System.out.println("endIndex: " +endIndex);
	    stopPointsJsonArraysString = formattedResponse.substring(startIndex, endIndex+1);

		//System.out.println("Length: " +stopPointsJsonArraysString.length());
		//System.out.println("Start:" + stopPointsJsonArraysString.toString().substring(0, 100));
		//System.out.println("End:" + stopPointsJsonArraysString.toString().substring(stopPointsJsonArraysString.length()-100));
	    StopPoint[] stopPoints = new Gson().fromJson(stopPointsJsonArraysString, StopPoint[].class);
	    Map<Integer,String> stopIdToStopNamesMap = new HashMap<>();
		for(int i=0; i< stopPoints.length; i++) {
			int stopPointNo=Integer.parseInt(stopPoints[i].getStopPointNumber());
			if(!stopIdToStopNamesMap.containsKey(stopPointNo)) {
				stopIdToStopNamesMap.put(stopPointNo, stopPoints[i].getStopPointName());
			}
		}
		
		return stopIdToStopNamesMap;
	}

	public Map<Integer, ArrayList<String>> loadJourneyStopPoints(String key) {
		//System.out.println("conUrl"+jourDataUrl);
		StringBuilder response = new StringBuilder();
		String pointsOnLineArrayString=null;
		try {
			
			//String jourDataUrl=this.getClass().getClassLoader().getResource("jour.json").toString();
			String jourDataUrl=TrafiklabConstants.TRAFIKLAB_JOUR_DATA_URL.replace(replaceKey, key);
			URL url =new URL(jourDataUrl);
			//HttpURLConnection con =(HttpURLConnection) url.openConnection();
			URLConnection con =(URLConnection) url.openConnection();
			//
			//con.setRequestMethod("GET");
			//
			con.setRequestProperty("Content-Type", "application/json");
			//
			con.setRequestProperty("Accept", "application/json");
			//
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			//

			try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
			} catch (Exception e) {
				System.out.println("Caught Exception while reading:" + e.getMessage());
				return null;
			}

		} 
		catch (IOException e) {
			System.out.println("Caught IOException:" + e.getMessage());
			return null;
		}
		//String formattedResponse=response.toString().replace('\"', '\'');
		String formattedResponse=response.toString();
		int startIndex=formattedResponse.indexOf("[");
		//System.out.println("startIndex: " +startIndex);
		int endIndex=formattedResponse.indexOf("]");
		//System.out.println("endIndex: " +endIndex);
	    pointsOnLineArrayString = formattedResponse.substring(startIndex, endIndex+1);

		//System.out.println("Length: " +pointsOnLineArrayString.length());
		//System.out.println("Start:" + pointsOnLineArrayString.toString().substring(0, 300));
		//System.out.println("End:" + pointsOnLineArrayString.toString().substring(pointsOnLineArrayString.length()-300));
	    PointsOnLine[] pointsOnLines = new Gson().fromJson(pointsOnLineArrayString, PointsOnLine[].class);
	    Map<Integer, ArrayList<String>> stopNamesForBusMap = new HashMap<Integer,ArrayList<String>>();
	    Map<Integer,String> stopIdToStopNamesMap = loadStopPoints(key);
	    Map<Integer, BusLine> busLineMap = loadBusLines(key);
		for(int i=0; i< pointsOnLines.length; i++) {
			//System.out.println(pointsOnLines[i].toString());
			int lineNo=Integer.parseInt(pointsOnLines[i].getLineNumber());
			if(busLineMap.containsKey(lineNo)) {
				//System.out.println("Found bus no: " + lineNo);
				int pointNo=Integer.parseInt(pointsOnLines[i].getJourneyPatternPointNumber());
				//System.out.println("StopPoint no: " + pointNo);
				String stopName = stopIdToStopNamesMap.get(pointNo);
				if(stopName!=null) {
					//System.out.println("StopName: " + stopName);
					ArrayList<String> stopNamesForBus = stopNamesForBusMap.get(lineNo);
					if(stopNamesForBus==null) {
						stopNamesForBus = new ArrayList<>();
						stopNamesForBusMap.put(lineNo, stopNamesForBus);
					}
					if(!stopNamesForBus.contains(stopName)) {
						//System.out.println("Adding StopName: " + stopName +" for bus: " + lineNo);
						stopNamesForBus.add(stopName);
					}
				}
			}
		}
		return stopNamesForBusMap;
	}
	
	public Map<Integer, ArrayList<String>> getTopTen(String key) {
		StopsComparator nrOfStopsComparator = new StopsComparator();
		Map<Integer, ArrayList<String>> topTen =
				loadJourneyStopPoints(key).entrySet().stream()
			       .sorted(Map.Entry.comparingByValue(nrOfStopsComparator.reversed()))
			       .limit(10)
			       .collect(Collectors.toMap(
			          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return topTen;

	}
	
	public List<BusLinesStopRank> getBusLineStopRanks(String key) {
		List<BusLinesStopRank> topTenList = new ArrayList<BusLinesStopRank>();
		Map<Integer, ArrayList<String>> topTenMap = getTopTen(key);

		Iterator<Entry<Integer, ArrayList<String>>> it = topTenMap.entrySet().iterator();
		int j=0;
		while(it.hasNext()) {
			Map.Entry<Integer,ArrayList<String>> entry = it.next();
			ArrayList<String> value = (ArrayList<String>) entry.getValue();
			topTenList.add(new BusLinesStopRank(String.valueOf(j+1), String.valueOf(value.size()), entry.getKey().toString(), String.valueOf(value)));
			j++;
		}
		return topTenList;
	}
}
