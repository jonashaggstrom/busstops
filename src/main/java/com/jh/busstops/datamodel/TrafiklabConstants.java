package com.jh.busstops.datamodel;

public class TrafiklabConstants {
	public static final String TRAFIKLAB_BASE_URL = "api.sl.se/api2";
	public static final String TRAFIKLAB_LINE_DATA_URL = "https://api.sl.se/api2/LineData.json?model=[model]&key=[key]";
	public static final String TRAFIKLAB_BUS_LINE_DATA_URL = "https://api.sl.se/api2/LineData.json?model=Line&key=[key]&DefaultTransportModeCode=BUS";
	public static final String TRAFIKLAB_BUS_LINE_DATA_URL_LOCAL = "file:///C://Users//jonas//eclipse-workspace//lines.json";
	public static final String TRAFIKLAB_JOUR_DATA_URL ="https://api.sl.se/api2/LineData.json?model=jour&key=[key]&DefaultTransportModeCode=BUS";
	public static final String TRAFIKLAB_JOUR_DATA_URL_LOCAL = "file:///C://Users//jonas//eclipse-workspace//jour.json";
	public static final String TRAFIKLAB_STOP_DATA_URL ="https://api.sl.se/api2/LineData.json?model=stop&key=[key]";
	public static final String TRAFIKLAB_STOP_DATA_URL_LOCAL = "file:///C://Users//jonas//eclipse-workspace//stop.json";
	public static final String TRAFIKLAB_KEY ="1d0894cf1c2341ada00e5b4b17a6bf23";
	public static final String fullBusLines="https://api.sl.se/api2/LineData.json?model=line&key=1d0894cf1c2341ada00e5b4b17a6bf23&DefaultTransportModeCode=BUS";
	
	/*
<ResponseOfPwsResult xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<StatusCode>0</StatusCode>
	<ExecutionTime>630</ExecutionTime>
	<ResponseData>
		<Version xmlns="http://api.sl.se/api/pws">2022-12-08 00:05</Version>
		<Type xmlns="http://api.sl.se/api/pws">Line</Type>
		<Line xmlns="http://api.sl.se/api/pws">
			<LineNumber>1</LineNumber>
			<LineDesignation>1</LineDesignation>
			<DefaultTransportMode>blåbuss</DefaultTransportMode>
			<DefaultTransportModeCode>BUS</DefaultTransportModeCode>
			<LastModifiedUtcDateTime>2007-08-24 00:00:00.000</LastModifiedUtcDateTime>
			<ExistsFromDate>2007-08-24 00:00:00.000</ExistsFromDate>
		</Line>
	</ResponseData>
</ResponseOfPwsResult>

<ResponseOfPwsResult xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<StatusCode>0</StatusCode>
	<ExecutionTime>423</ExecutionTime>
	<ResponseData>
		<Version xmlns="http://api.sl.se/api/pws">2022-12-08 00:05</Version>
		<Type xmlns="http://api.sl.se/api/pws">JourneyPatternPointOnLine</Type>
		<JourneyPatternPointOnLine xmlns="http://api.sl.se/api/pws">
			<LineNumber>548</LineNumber>
			<DirectionCode>1</DirectionCode>
			<JourneyPatternPointNumber>51621</JourneyPatternPointNumber>
			<LastModifiedUtcDateTime>2012-06-23 00:00:00.000</LastModifiedUtcDateTime>
			<ExistsFromDate>2012-06-23 00:00:00.000</ExistsFromDate>
		</JourneyPatternPointOnLine>
	</ResponseData>
	</ResponseOfPwsResult>
*/
}
