package lib;


/**
 * 
 * @author khenr
 * A moving average is used to keep track of a windowed average that has values 
 * constantly being added and removed.
 */
public interface MovingAverageInterface {

  /**
   * Updates the queue by removing the first value and added a new one to the end of the queue.
   * 
   * @param val Value being added.
   */
  void update(double val);

  /**
   * @return Gets the current average.
   */
  double getAverage();

}
