import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MyObservable {
	
	private CopyOnWriteArrayList<MyObserver> observers;
	private boolean changed;
	private ReentrantLock alock;
	
	public MyObservable() {
		alock = new ReentrantLock();
	}
	
	public void addObserver(MyObserver o){
		if (observers == null)
	        {
	                observers = new CopyOnWriteArrayList<MyObserver>();
	        }
	        else if (observers.contains(o))
	        {
	                return;
	        }
	        observers.add(o);
	}
	
	public void deleteObserver(MyObserver o){
			if (observers == null)
	        {
	                return;
	        }
	        int idx = observers.indexOf(o);
	        if (idx != -1)
	        {
	                observers.remove(idx);
	        }
	}
	
	protected void setChanged(){
		changed = true;
	}
	
	protected void clearChanged(){
		changed = false;	
	}
	
	public Boolean hasChanged(){
		return changed;
	}
	
	public void notifyObserver(Object obj){
		alock.lock();
		System.out.println("\nLocked");
		if( !changed ) return;
		changed = true;
		
		java.util.Iterator<MyObserver> it = observers.iterator();
		while( it.hasNext() ){
		it.next().update(this, obj); }
		
		alock.unlock();
		System.out.println("\nUnlocked");
	}
	
	public void notifyObserver(){
		notifyObserver(null);
	}

}
