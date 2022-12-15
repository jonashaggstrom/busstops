package com.jh.busstops.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.busstops.model.BusLinesStopRank;
import com.jh.busstops.model.BusstopsModel;
import com.jh.busstops.service.BusStopsService;

@Controller
public class BusstopsControllerJsp {
//    @Autowired
//    private BusStopsService busStopsService;
    @Autowired
    private static BusstopsModel bsmodel = new BusstopsModel();


    @RequestMapping(value= "/busstopsjsp", method= RequestMethod.GET)
    @ResponseBody
    public List<BusLinesStopRank> displayRanking(@RequestParam(defaultValue = "defaultkey") String key)
    {
    	return bsmodel.getBusLineStopRanks(key);
    }
}
