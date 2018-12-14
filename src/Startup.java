import java.util.LinkedList;
import java.util.Queue;

/**
 * The main/start-up class for this application 
 * 
 * @author Andrew Snook
 */
public class Startup {
	protected static Queue<CustOrder> orderQueue;	//Will hold all orders
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
