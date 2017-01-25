package lib;

import java.util.LinkedList;

public class DebouncedBoolean implements DebouncedBooleanInterface {
  private static LinkedList<Boolean> queue;
  private static int windowSize;
  private int count;

  /**
   * 
   * @param windowSize Sets size for the queue.
   * @param initial Boolean passed to initialize the queue.
   */
  public DebouncedBoolean(int windowSize, boolean initial) {
    if (initial) {
      count = windowSize;
    } else {
      count = -windowSize;
    }
    this.windowSize = windowSize;
    queue = new LinkedList<Boolean>();

  }

  /**
   * @param value Boolean passed to be added into the queue.
   */
  public void add(boolean value) {
    if (queue.size() == windowSize) {
      queue.removeFirst();
      queue.addLast(value);
    } else {
      queue.addLast(value);
    }
    if (value) {
      count++;
    } else {
      count--;
    }
  }

  /**
   * @return Boolean that determines if the queue is true or false.
   */
  public boolean get() {
    return count >= 0;

  }
}
