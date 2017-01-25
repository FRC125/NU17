package lib;


/**
 * 
 * @author khenr A moving average is used to keep track of a windowed average that has values
 *         constantly being added and removed.
 */
public interface MovingAverageInterface {

  /**
   * Removes the first value from the average and adds a new one to the average. A value is only
   * removed if values greater than the windowSize are being added.
   * 
   * @param val Value being added to the average.
   */
  void update(double val);

  /**
   * @return Returns the current average.
   */
  double getAverage();

}
