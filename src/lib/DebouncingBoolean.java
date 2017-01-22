package lib;
import java.util.LinkedList;
public class DebouncingBoolean {
	private static LinkedList<Boolean> queue;
	private static int windowSize;
	private boolean state;
	
	public DebouncingBoolean(int windowSize){
		this.windowSize = windowSize;
		queue = new LinkedList<Boolean>();
	}
	public void init(int start ){
		while(queue.size() < windowSize){
			if (start > 0){
				queue.add(true);
			}
			else{
			queue.add(false);
			}
		}
	}
	public void feed(int val){
		if (queue.size() == windowSize){
			if (val > 0){
				queue.removeFirst();
				queue.addLast(true);
			}
			else{
				queue.removeFirst();
				queue.addLast(false);
			}
		}
	}
}
