package lib;

import java.util.LinkedList;

public class MovingAverage implements MovingAverageInterface {
  private static LinkedList<Double> queue;
  private static int windowSize;
  private double curTotal;

  /**
   * Creates the average.
   * 
   * @param windowSize Used to create the average.
   */
  public MovingAverage(int windowSize) {
    if (windowSize <= 0) {
      throw new IllegalArgumentException(windowSize + "is not a valid input");
    }
    queue = new LinkedList<Double>();
    this.windowSize = windowSize;
    curTotal = 0;
  }

  /* (non-Javadoc)
   * @see lib.MovingAverageInterface#update(double)
   */
  @Override
  public void update(double val) {
    if (queue.size() == windowSize) {
      curTotal -= queue.removeFirst();
    }
    curTotal += val;
    queue.addLast(val);
  }

  /* (non-Javadoc)
   * @see lib.MovingAverageInterface#getAverage()
   */
  @Override
  public double getAverage() {
    return curTotal / queue.size();
  }
}
