package lib;


/**
 * 
 * @author khenr A moving average is used to keep track of a windowed average that has values
 *         constantly being added and removed.
 */
public interface MovingAverageInterface {

  /**
   * Removes the first value from the average ands a new one to the average.
   * 
   * @param val Value being added to the average.
   */
  void update(double val);

  /**
   * @return Returns the current average.
   */
  double getAverage();

}
