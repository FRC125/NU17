package lib;

/**
 * A Debounced Boolean is used to keep track of a windowed size amount of booleans being added the window.
 */
public interface DebouncedBooleanInterface {
  /**
   * Adds the new boolean to the average and removes the least recent boolean if there would be more
   * than the windowSize value.
   * @param value Boolean being passed into the queue.
   */
  void add(boolean value);
  /**
   * @return Boolean that determines if the queue is true or false.
   */
  boolean get();
}
