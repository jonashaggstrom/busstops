package com.jh.busstops.model;

public class BusLinesStopRank {
	private String rank;
	private String stops;
	private String busNo;
	private String stopNamesList;
	
	public BusLinesStopRank(String rank, String stops, String busNo, String stopNames) {
		this.rank=rank;
		this.stops=stops;
		this.busNo=busNo;
		this.stopNamesList=stopNames;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getStopsList() {
		return stopNamesList;
	}
	public void setStopsList(String stopsList) {
		this.stopNamesList = stopsList;
	}


}
