package com.jh.busstops.datamodel;

/*
 * <JourneyPatternPointOnLine xmlns="http://api.sl.se/api/pws">
<LineNumber>548</LineNumber>
<DirectionCode>1</DirectionCode>
<JourneyPatternPointNumber>51621</JourneyPatternPointNumber>
<LastModifiedUtcDateTime>2012-06-23 00:00:00.000</LastModifiedUtcDateTime>
<ExistsFromDate>2012-06-23 00:00:00.000</ExistsFromDate>
</JourneyPatternPointOnLine>
 */
public class PointsOnLine {
	private String LineNumber;
	private String DirectionCode;
	private String JourneyPatternPointNumber;
	private String LastModifiedUtcDateTime;
	private String ExistsFromDate;
	public String getLineNumber() {
		return LineNumber;
	}
	public void setLineNumber(String lineNumber) {
		LineNumber = lineNumber;
	}
	public String getDirectionCode() {
		return DirectionCode;
	}
	public void setDirectionCode(String directionCode) {
		DirectionCode = directionCode;
	}
	public String getJourneyPatternPointNumber() {
		return JourneyPatternPointNumber;
	}
	public void setJourneyPatternPointNumber(String journeyPatternPointNumber) {
		JourneyPatternPointNumber = journeyPatternPointNumber;
	}
	public String getLastModifiedUtcDateTime() {
		return LastModifiedUtcDateTime;
	}
	public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
		LastModifiedUtcDateTime = lastModifiedUtcDateTime;
	}
	public String getExistsFromDate() {
		return ExistsFromDate;
	}
	public void setExistsFromDate(String existsFromDate) {
		ExistsFromDate = existsFromDate;
	}
    public String toString() {
        return String.format("LineNumber:%s,DirectionCode:%s,JourneyPatternPointNumber:%s,LastModifiedUtcDateTime:%s,ExistsFromDate:%s", LineNumber, DirectionCode, JourneyPatternPointNumber, LastModifiedUtcDateTime,ExistsFromDate);
    }
}
