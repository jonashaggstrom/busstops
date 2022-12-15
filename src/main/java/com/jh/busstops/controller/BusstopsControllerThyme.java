package com.jh.busstops.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jh.busstops.model.BusstopsModel;

@Controller
public class BusstopsControllerThyme {
	private static BusstopsModel bsmodel = new BusstopsModel();
	

	@GetMapping("/busstopsthyme")
	public String busstopsThyme(@RequestParam(defaultValue = "defaultkey") String key, Model model) {
	
		System.out.println("key:"+ key);
		Map<Integer, ArrayList<String>> topTenMap= bsmodel.getTopTen(key);
		
		Iterator<Entry<Integer, ArrayList<String>>> it = topTenMap.entrySet().iterator();
		int place = 1;
		while(it.hasNext()) {
			Entry<Integer,ArrayList<String>> entry= it.next();
			model.addAttribute("stopnames" + place, Arrays.toString(entry.getValue().toArray()));
			model.addAttribute("stops" + place, entry.getValue().size());
			model.addAttribute("busno" + place, entry.getKey());
			place++;
		}
		
		return "busstopsThyme";
	}

}