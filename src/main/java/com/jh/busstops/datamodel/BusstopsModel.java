package com.jh.busstops.datamodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class BusstopsModel {
	private String replaceModel="[model]";
	private String replaceKey="[key]";
	private String withLineModel="line";
	private String withLineStopsModel="stop";
	private String withLineJourModel="jour";
	
	private void printTopTen() {
		
		Map<Integer, ArrayList<String>> topTenMap= BusLineInfo.getTopTen();
		System.out.println("topTenMap.size(): " + topTenMap.size() );
		Iterator<Entry<Integer, ArrayList<String>>> it = topTenMap.entrySet().iterator();
		int place = 1;
		System.out.println("Top:");
		while(it.hasNext()) {
			Entry<Integer,ArrayList<String>> entry= it.next();
			String allNames= Arrays.toString(entry.getValue().toArray());
			System.out.println("" + place + ": Bus: "+ entry.getKey() + " No Of Stops: " + entry.getValue().size() + " stopnames: " + allNames);
			place++;
		}
	}
	

	protected boolean loadBusLines() {
		boolean res=true;
		//System.out.println("Running BusstopsModel.loadBusLines()...........");
		String conUrl = TrafiklabConstants.TRAFIKLAB_BUS_LINE_DATA_URL.replace(replaceKey, TrafiklabConstants.TRAFIKLAB_KEY);
		//String conUrl= TrafiklabConstants.TRAFIKLAB_BUS_LINE_DATA_URL_LOCAL;
		//System.out.println(""+conUrl);
		StringBuilder response = new StringBuilder();

		String busLinesJsonArraysString=null;
		try {
			URL url =new URL(conUrl);
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
				res=false;
			}

		} 
		catch (IOException e) {
			System.out.println("Caught IOException:" + e.getMessage());
			res=false;
		}
		String formattedResponse=response.toString().replace('\"', '\'');
		int startIndex=formattedResponse.indexOf("[");
		//System.out.println("startIndex: " +startIndex);
		int endIndex=formattedResponse.indexOf("]");
		//System.out.println("endIndex: " +endIndex);
	    busLinesJsonArraysString = formattedResponse.substring(startIndex, endIndex+1);

		//System.out.println("Length: " +busLinesJsonArraysString.length());
		//System.out.println("Start:" + busLinesJsonArraysString.toString().substring(0, 100));
		//System.out.println("End:" + busLinesJsonArraysString.toString().substring(busLinesJsonArraysString.length()-100));

		BusLineInfo.busLines = new Gson().fromJson(busLinesJsonArraysString, BusLine[].class);
		for(int i=0; i< BusLineInfo.busLines.length; i++) {
			int lineNo=Integer.parseInt(BusLineInfo.busLines[i].getLineNumber());
			if(!BusLineInfo.busLineMap.containsKey(lineNo)) {
				BusLineInfo.busLineMap.put(lineNo, BusLineInfo.busLines[i]);
			}
		}
		return res;
	}

	protected boolean loadStopPoints() {
		boolean res = true;
		//System.out.println("Running BusstopsModel.loadStopPoints()...........");
		String conUrl = TrafiklabConstants.TRAFIKLAB_STOP_DATA_URL.replace(replaceKey, TrafiklabConstants.TRAFIKLAB_KEY);
		//String conUrl= TrafiklabConstants.TRAFIKLAB_STOP_DATA_URL_LOCAL;
		//System.out.println(""+conUrl);
		StringBuilder response = new StringBuilder();

		String stopPointsJsonArraysString=null;
		try {
			URL url =new URL(conUrl);
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
				res=false;
			}

		} 
		catch (IOException e) {
			System.out.println("Caught IOException:" + e.getMessage());
			res=false;
		}
		String formattedResponse=response.toString().replace('\"', '\'');
		int startIndex=formattedResponse.indexOf("[");
		//System.out.println("startIndex: " +startIndex);
		int endIndex=formattedResponse.indexOf("]");
		//System.out.println("endIndex: " +endIndex);
	    stopPointsJsonArraysString = formattedResponse.substring(startIndex, endIndex+1);

		//System.out.println("Length: " +stopPointsJsonArraysString.length());
		//System.out.println("Start:" + stopPointsJsonArraysString.toString().substring(0, 100));
		//System.out.println("End:" + stopPointsJsonArraysString.toString().substring(stopPointsJsonArraysString.length()-100));
		BusLineInfo.stopPoints = new Gson().fromJson(stopPointsJsonArraysString, StopPoint[].class);
		
		BusLineInfo.stopIdToStopNamesMap.clear();
		for(int i=0; i< BusLineInfo.stopPoints.length; i++) {
			int stopPointNo=Integer.parseInt(BusLineInfo.stopPoints[i].getStopPointNumber());
			if(!BusLineInfo.stopIdToStopNamesMap.containsKey(stopPointNo)) {
				BusLineInfo.stopIdToStopNamesMap.put(stopPointNo, BusLineInfo.stopPoints[i].getStopPointName());
			}
		}
		
		return res;
	}

	protected boolean loadJourneyStopPoints() {
		boolean res=true;
		String conUrl =  TrafiklabConstants.TRAFIKLAB_JOUR_DATA_URL.replace(replaceKey, TrafiklabConstants.TRAFIKLAB_KEY);
		//String conUrl =  TrafiklabConstants.TRAFIKLAB_JOUR_DATA_URL_LOCAL;
		//System.out.println("conUrl2"+conUrl);
		StringBuilder response = new StringBuilder();
		String pointsOnLineArrayString=null;
		try {
			URL url =new URL(conUrl);
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
				res=false;
				System.out.println("Caught Exception while reading:" + e.getMessage());
			}

		} 
		catch (IOException e) {
			res=false;
			System.out.println("Caught IOException:" + e.getMessage());
		}
		String formattedResponse=response.toString().replace('\"', '\'');
		int startIndex=formattedResponse.indexOf("[");
		//System.out.println("startIndex: " +startIndex);
		int endIndex=formattedResponse.indexOf("]");
		//System.out.println("endIndex: " +endIndex);
	    pointsOnLineArrayString = formattedResponse.substring(startIndex, endIndex+1);

		//System.out.println("Length: " +pointsOnLineArrayString.length());
		//System.out.println("Start:" + pointsOnLineArrayString.toString().substring(0, 300));
		//System.out.println("End:" + pointsOnLineArrayString.toString().substring(pointsOnLineArrayString.length()-300));
		BusLineInfo.pointsOnLines = new Gson().fromJson(pointsOnLineArrayString, PointsOnLine[].class);
		for(int i=0; i< BusLineInfo.pointsOnLines.length; i++) {
			//System.out.println(BusLineInfo.pointsOnLines[i].toString());
			int lineNo=Integer.parseInt(BusLineInfo.pointsOnLines[i].getLineNumber());
			if(BusLineInfo.busLineMap.containsKey(lineNo)) {
				//System.out.println("Found bus no: " + lineNo);
				int pointNo=Integer.parseInt(BusLineInfo.pointsOnLines[i].getJourneyPatternPointNumber());
				//System.out.println("StopPoint no: " + pointNo);
				String stopName = BusLineInfo.stopIdToStopNamesMap.get(pointNo);
				if(stopName!=null) {
					//System.out.println("StopName: " + stopName);
					ArrayList<String> stopNamesForBus = BusLineInfo.stopNamesForBusMap.get(lineNo);
					if(stopNamesForBus==null) {
						stopNamesForBus = new ArrayList<>();
						BusLineInfo.stopNamesForBusMap.put(lineNo, stopNamesForBus);
					}
					if(!stopNamesForBus.contains(stopName)) {
						//System.out.println("Adding StopName: " + stopName +" for bus: " + lineNo);
						stopNamesForBus.add(stopName);
					}
				}
			}
		}
		return res;
	}
}
