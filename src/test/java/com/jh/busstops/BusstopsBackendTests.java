package com.jh.busstops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.jh.busstops.model.*;

@SpringBootTest
class BusstopsBackendTests extends BusstopsModel{
	
	@Test
	void testModel() {
		String key="1d0894cf1c2341ada00e5b4b17a6bf23";
		Assert.notEmpty(loadBusLines(key), "Buslines where not loaded succesfully");
		//Assert.isTrue(loadBusLines(), "Buslines where not loaded succesfully");
		Assert.notEmpty(loadStopPoints(key), "StopPoints where not loaded succesfully");
		Assert.notEmpty(loadJourneyStopPoints(key), "JourneyStopPoints where not succesfully loaded");
	}

}
