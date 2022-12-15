package com.jh.busstops.service;
import java.util.List;

import com.jh.busstops.model.BusLinesStopRank;
import com.jh.busstops.model.BusstopsModel;
public class BusStopsService {
	private static BusstopsModel bsmodel = new BusstopsModel();
//	private static Pair<Integer, ArrayList<String>>[] busLineMaxStops= BusstopsModel.getTopTenArray();

    public List<BusLinesStopRank> retrieveRanking(String key) {
        return bsmodel.getBusLineStopRanks(key);
    }

}
