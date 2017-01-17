package lib;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	private Queue<Integer> queue;
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
	
	/**
	 * @return Gets the current average.
	 */
	public double getAverage(int value){
		int prevSize = queue.size();
		int out = queue.size() == size ? queue.poll() : 0;
		queue.offer(value);
		return average = (average * prevSize - out + value) / queue.size();
	}
}