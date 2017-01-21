import static org.junit.Assert.*;

import org.junit.Test;

import lib.MovingAverage;

public class MovingAverageTest {

	@Test
	public void movingAverageValuesTest() {
		MovingAverage avg = new MovingAverage(3);
		avg.update(3);
		avg.update(3);
		avg.update(3);
		assertEquals(3, avg.getAverage());
	}

}
