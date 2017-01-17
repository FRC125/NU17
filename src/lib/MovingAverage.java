package lib;

public class MovingAverage {
	private double[] readings;
	private int sampleSize;
	private int index = 0;
	
	/** 
	 * Creates the average 
	 * @param sampleSize size used to create the average   
	 */
	public MovingAverage(int sampleSize){
		readings = new double[sampleSize];
		this.sampleSize = sampleSize;
	}
	
	/**
	 * Adds to the average
	 * @param reading information received from input
	 */
	private void update(double reading){
		readings[index % sampleSize] = reading;
		index++;
	}
	
	/**
	 * @return Gives the current average.
	 */
	public double getAverage(){
		double sum = 0.0;
		for ( double value : readings){
			sum += value;
		}return sum / sampleSize;
	}
}
	