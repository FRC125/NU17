package lib;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private Queue<Double> queue;
	private int size;
	private double average;
	
	/** 
	 * Creates the average 
	 * @param size  used to create the average   
	 */
	public MovingAverage(int size){
		queue = new LinkedList<>();
		this.size = size;
	}
	public double update(){
		
	}
	
	/**
	 * @return Gets the current average.
	 */
	public double getAverage(double value){
		double prevSize = queue.size();
		double out = queue.size() == size ? queue.poll() : 0;
		queue.offer(value);
		return average = (average * prevSize - out + value) / queue.size();
	}
}
