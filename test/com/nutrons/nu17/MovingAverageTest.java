package com.nutrons.nu17;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import lib.MovingAverage;
import lib.MovingAverageInterface;

public class MovingAverageTest {

  @Test
  public void sameValuesTest() {
    MovingAverageInterface avg = new MovingAverage(3);
    avg.update(3.0);
    assertEquals(3.0, avg.getAverage());
    avg.update(3.0);
    assertEquals(3.0, avg.getAverage());
    avg.update(3.0);
    assertEquals(3.0, avg.getAverage());
  }

  @Test
  public void negativeValue() {
    MovingAverageInterface avg = new MovingAverage(6);
    avg.update(3.0);
    assertEquals(3.0, avg.getAverage());
    avg.update(7.0);
    assertEquals(5.0, avg.getAverage());
    avg.update(6.0);
    assertEquals(5.333333333333333, avg.getAverage());
    avg.update(8.0);
    assertEquals(6.0, avg.getAverage());
    avg.update(-9.0);
    assertEquals(3.0, avg.getAverage());
    avg.update(10.0);
    assertEquals(4.166666666666667, avg.getAverage());
  }

  @Test
  public void allNegative() {
    MovingAverageInterface avg = new MovingAverage(4);
    avg.update(-5.0);
    assertEquals(-5.0, avg.getAverage());
    avg.update(-6.0);
    assertEquals(-5.5, avg.getAverage());
    avg.update(-3.0);
    assertEquals(-14.0 / 3, avg.getAverage());
    avg.update(-8.0);
    assertEquals(-5.5, avg.getAverage());
    avg.update(-9.0);
    assertEquals(-6.5, avg.getAverage());
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeExceptionTest() {
    MovingAverageInterface avg = new MovingAverage(-1);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void zeroExceptionTest() {
    MovingAverageInterface zero = new MovingAverage(0);
  }

  @Test
  public void Zerovalue() {
    MovingAverageInterface avg = new MovingAverage(3);
    avg.update(8.0);
    assertEquals(8.0, avg.getAverage());
    avg.update(0.0);
    assertEquals(4.0, avg.getAverage());
    avg.update(9.0);
    assertEquals(5.666666666666667, avg.getAverage());
  }
}
