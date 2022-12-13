package com.jh.busstops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.jh.busstops.datamodel.*;

@SpringBootTest
class BusstopsBackendTests extends BusstopsModel{
	
	@Test
	void testModel() {
		Assert.isTrue(loadBusLines(), "Buslines where not loaded succesfully");
		Assert.isTrue(loadStopPoints(), "StopPoints where not loaded succesfully");
		Assert.isTrue(loadJourneyStopPoints(), "JourneyStopPoints where not succesfully loaded");
	}

}
