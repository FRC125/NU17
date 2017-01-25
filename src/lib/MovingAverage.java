package lib;

import java.util.LinkedList;

public class MovingAverage {
  private static LinkedList<Double> queue;
  private static int windowSize;
  private double curTotal;

  /**
   * Creates the average.
   * 
   * @param size Used to create the average.
   */
  public MovingAverage(int windowSize) {
    if (windowSize <= 0) {
      throw new IllegalArgumentException(windowSize + "is not a valid input");
    }
    queue = new LinkedList<Double>();
    this.windowSize = windowSize;
    curTotal = 0;
  }

  /**
   * Updates the queue by removing the first value and added a new one to the end of the queue.
   * 
   * @param num Value being added.
   */
  public void update(double val) {
    if (queue.size() == windowSize) {
      curTotal -= queue.removeFirst();
    }
    curTotal += val;
    queue.addLast(val);
  }

  /**
   * @return Gets the current average.
   */
  public double getAverage() {
    return curTotal / queue.size();
  }
}
