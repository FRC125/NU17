package lib;

public class MovingAverage {
	private double[] readings;
	private int numSamples;
	private int index = 0;
	
	/** 
	 * Creates the average 
	 * @param numSample used to create the average   
	 */
	public MovingAverage(int numSample){
		readings = new double[numSample];
		this.numSamples = numSample;
	}
	
	/**
	 * Adds to the average
	 * @param reading information received from input
	 */
	private void update(final double reading){
		readings[index % numSamples] = reading;
		index++;
	}
	
	/**
	 * @return Gives the current average.
	 */
	public double getAverage(){
		double sum = 0.0;
		for ( double value : readings){
			sum += value;
		}
		return sum / numSamples;
	}
}