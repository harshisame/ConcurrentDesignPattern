
public class PieChartObserver implements MyObserver{

	public void update(MyObservable arg0, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("\nPieChartObserver is changed by new Quote: "+ arg);
	}

}
