import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AddOrder {

	protected Shell shlAddNewOrder;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddOrder window = new AddOrder();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAddNewOrder.open();
		shlAddNewOrder.layout();
		while (!shlAddNewOrder.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAddNewOrder = new Shell();
		shlAddNewOrder.setSize(450, 300);
		shlAddNewOrder.setText("Add New Order");

	}

}
