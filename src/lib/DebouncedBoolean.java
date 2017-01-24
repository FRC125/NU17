package lib;
import java.util.LinkedList;
public class DebouncedBoolean implements DebouncedBooleanInterface{
	private static LinkedList<Boolean> queue;
	private static int windowSize;
	private int count;
	
	/**
	 * 
	 * @param windowSize sets size for the queue
	 * @param x boolean passed to initialize the queue
	 */
	public DebouncedBoolean(int windowSize, boolean initial){
		if(initial){
			this.windowSize = windowSize;
		}
		this.windowSize = -windowSize;
		queue = new LinkedList<Boolean>();
			
	}
	
	/**
	 * @param b boolean passed to be added into the queue
	 */
	public void add(boolean b){
			queue.removeFirst();
			queue.addLast(b);
			count++;
		if(b){
			count++;
		}
		count--;
	}
	/**
	 * @return count boolean that determines if the queue is true or false
	 */
	public boolean get(){
		return count > 0;
		
	}
}
