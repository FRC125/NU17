package lib;

import java.util.LinkedList;

public class DebouncedBoolean implements DebouncedBooleanInterface {
  private static LinkedList<Boolean> queue;
  private static int windowSize;
  private int count;

  /**
   * Creates and initializes the queue.
   * 
   * @param windowSize Sets the size of values being looked at
   * @param initial Initializes the queue to a boolean type.
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

  /*
   * @see lib.DebouncedBooleanInterface#add(boolean)
   */
  @Override
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
  @Override
  public boolean get() {
    return count >= 0;
  }

}
