
public class TableObserver implements MyObserver{

	public void update(MyObservable arg0, Object arg) {
		
		System.out.println("\nTableObserver is changed by new Quote: "+ arg);
	}

}