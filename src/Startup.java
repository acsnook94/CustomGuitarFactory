import java.util.LinkedList;
import java.util.Queue;

/**
 * The main/start-up class for this application 
 * 
 * @author Andrew Snook
 */
public class Startup {
	//Will hold all orders (instances of CustOrder)
	protected static Queue<CustOrder> orderQueue;
	protected static MainScreen window;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		orderQueue = new LinkedList<>();
		
		try {
			window = new MainScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
