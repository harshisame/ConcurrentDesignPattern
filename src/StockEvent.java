public class StockEvent {
	
	public static void main(String[] args) {
		
			
		MyObservable observable = new MyObservable();
		observable.setChanged();
		
		PieChartObserver o1 = new PieChartObserver();;
		TableObserver o2 = new TableObserver();
		ThreeDObserver o3 = new ThreeDObserver();
		observable.addObserver(o1);
		observable.addObserver(o2);
		observable.addObserver(o3);
		
		observable.addObserver( (MyObservable o, Object obj)->
		{
			System.out.println(obj);
			
		
		} );
		
		observable.notifyObserver("\nHello World!");
	
	}
	
	
}
