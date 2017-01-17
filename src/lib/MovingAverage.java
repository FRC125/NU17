package lib;

public class MovingAverage {
	private double[] readings;
	private int size;
	private int index = 0;
	
	/** 
	 * Creates the average 
	 * @param numSample sample used to create the average   
	 */
	public MovingAverage(int size){
		readings = new double[size];
		this.size = size;
	}
	
	/**
	 * Adds to the average
	 * @param reading information received from input
	 */
	private void update(final double reading){
		readings[index % size] = reading;
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
		return sum / size;
	}
}