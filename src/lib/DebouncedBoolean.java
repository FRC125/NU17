package lib;
import java.util.LinkedList;
public class DebouncedBoolean implements DebouncedBooleanInterface{
	private static LinkedList<Boolean> queue;
	private static int windowSize;
	private boolean count;
	
	/**
	 * 
	 * @param windowSize sets size for the queue
	 * @param x boolean passed to initialize the queue
	 */
	public DebouncedBoolean(int windowSize,  boolean x){
		this.windowSize = windowSize;
		queue = new LinkedList<Boolean>();
			if (x){
				queue.add(x);
				count = true;
			}
			else{
			queue.add(x);
			count = false;
			}
		}
	}
	
	/**
	 * @param b boolean passed to be added into the queue
	 */
	public void add(boolean b){
		if (b){
			queue.removeFirst();
			queue.addLast(b);
			count = true;
		}
		else{
			queue.removeFirst();
			queue.addLast(b);
			count = false;
		}
	}
	/**
	 * @return count boolean that determines if the queue is true or false
	 */
	public boolean get(){
		return count > 0;
		
	}
}
