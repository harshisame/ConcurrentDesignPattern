
public class ThreeDObserver implements MyObserver{

	public void update(MyObservable arg0, Object arg) {
	
		System.out.println("\n3DObserver is changed by new Quote: "+ arg);
	}

}

