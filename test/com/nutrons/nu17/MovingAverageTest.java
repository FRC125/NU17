package com.nutrons.nu17;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import lib.MovingAverage;

public class MovingAverageTest {

	@Test
	public void saveValuesTest() {
		MovingAverage avg = new MovingAverage(3);
		avg.update(3);
		avg.update(3);
		avg.update(3);
		assertEquals(3.0, avg.getAverage());
	}

}
