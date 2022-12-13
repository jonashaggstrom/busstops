package com.jh.busstops.datamodel;

import java.util.ArrayList;

public class BusLine {
	
	private String LineNumber;
    private String LineDesignation;
    private String DefaultTransportMode;
    private String LastModifiedUtcDateTime;
    private String ExistsFromDate;
	
    public String getLineNumber() {
		return LineNumber;
	}

	public void setLineNumber(String LineNumber) {
		this.LineNumber = LineNumber;
	}
	public String getLineDesignation() {
		return LineDesignation;
	}
	public void setLineDesignation(String LineDesignation) {
		this.LineDesignation = LineDesignation;
	}
	public String getDefaultTransportMode() {
		return DefaultTransportMode;
	}
	public void setDefaultTransportMode(String DefaultTransportMode) {
		this.DefaultTransportMode = DefaultTransportMode;
	}
	public String getLastModifiedUtcDateTime() {
		return LastModifiedUtcDateTime;
	}
	public void setLastModifiedUtcDateTime(String LastModifiedUtcDateTime) {
		this.LastModifiedUtcDateTime = LastModifiedUtcDateTime;
	}
	public String getExistsFromDate() {
		return ExistsFromDate;
	}
	public void setExistsFromDate(String ExistsFromDate) {
		this.ExistsFromDate = ExistsFromDate;
	}

    public String toString() {
        return String.format("lineNumber:%s,lineDesignation:%s,defaultTransportMode:%s,existsFromDate:%s", LineNumber, LineDesignation, DefaultTransportMode, ExistsFromDate);
    }
}
