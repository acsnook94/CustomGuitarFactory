import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the main/start-up class for this application 
 * 
 * @author Andrew Snook
 */
public class Startup {
	//Will hold all orders (instances of CustOrder)
	protected static Queue<CustOrder> orderQueue;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		orderQueue = new LinkedList<>();
		
		try {
			MainScreen window = new MainScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
