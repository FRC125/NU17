package lib;

import java.util.LinkedList;

public class DebouncedBoolean implements DebouncedBooleanInterface {
  private static LinkedList<Boolean> queue;
  private static int windowSize;
  private int count;

  /**
   *  Creates the average.
   * @param windowSize Sets window for the queue.
   * @param initial Boolean passed to initialize the queue.
   */
  public DebouncedBoolean(int windowSize, boolean initial) {
    if (windowSize <= 0) {
      throw new IllegalArgumentException(windowSize + " is not a valid window size");
    }
    if (initial) {
      count = windowSize;
    } else {
      count = -windowSize;
    }
    this.windowSize = windowSize;
    queue = new LinkedList<Boolean>();

  }

  /* 
   * @see lib.DebouncedBooleanInterface#add()
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

  /* 
   * @see lib.DebouncedBooleanInterface#get()
   */
  public boolean get() {
    return count >= 0;

  }
}
