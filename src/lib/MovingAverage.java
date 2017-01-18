package lib;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private static Queue<Double> queue;
	private static double sampleSize;
	private double average;
	
	/** 
	 * Creates the average 
	 * @param size  used to create the average   
	 */
	public MovingAverage(int size){
		queue = new LinkedList<>();
		this.sampleSize = sampleSize;
		double num;
	}
	public static void update(double num){
		if(queue.size() == sampleSize){
			queue.remove();
		}
		queue.add(num);
	}
	
	/**
	 * @return Gets the current average.
	 */
	public double getAverage(double value){
		double prevSize = queue.size();
		double out = queue.size() == sampleSize ? queue.poll() : 0;
		queue.offer(value);
		return average = (average * prevSize - out + value) / queue.size();
	}
}
