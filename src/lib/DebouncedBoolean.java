package lib;

import java.util.LinkedList;

public class DebouncedBoolean implements DebouncedBooleanInterface {
  private LinkedList<Boolean> queue;
  private final int windowSize;
  private int count;

  /**
   * Creates and initializes the queue. 
   * @param size Sets the size of values being looked at
   * @param initial Initializes the queue to a boolean type.
   */
  public DebouncedBoolean(int size, boolean initial) {
    if (size <= 0) {
      throw new IllegalArgumentException(size + " is not a valid window size");
    }
    if (initial) {
      count = size;
    } else {
      count = -size;
    }
    windowSize = size;
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
