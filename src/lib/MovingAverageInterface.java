package lib;


/**
 * A moving average is used to keep track of a windowed average that has values constantly being
 * added and removed.
 */
public interface MovingAverageInterface {

  /**
   * Adds the new value to the average and removes the least recent value if there would be more
   * than windowSize value.
   * 
   * @param val Value being added to the average.
   */
  void update(double val);

  /**
   * @return Returns the current average.
   */
  double getAverage();
}
