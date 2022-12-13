package com.jh.busstops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.jh.busstops.datamodel.BusLineInfo;
import com.jh.busstops.datamodel.BusstopsModel;

@Controller
public class BusstopsController extends BusstopsModel {

	@GetMapping("/busstops")
	public String busstops(Model model) {

		loadBusLines();
		loadStopPoints();
		loadJourneyStopPoints();
		
		Map<Integer, ArrayList<String>> topTenMap= BusLineInfo.getTopTen();
		System.out.println("topTenMap.size(): " + topTenMap.size() );
		Iterator<Entry<Integer, ArrayList<String>>> it = topTenMap.entrySet().iterator();
		int place = 1;
		System.out.println("Top:");
		while(it.hasNext()) {
			Entry<Integer,ArrayList<String>> entry= it.next();
			String allNames= Arrays.toString(entry.getValue().toArray());
			model.addAttribute("busno" + place, entry.getKey());
			model.addAttribute("stops" + place, entry.getValue().size());
			model.addAttribute("stopnames" + place, allNames);
			System.out.println("" + place + ": Bus: "+ entry.getKey() + " No Of Stops: " + entry.getValue().size() + " stopnames: " + allNames);
			place++;
		}
		
		return "busstops";
	}

}