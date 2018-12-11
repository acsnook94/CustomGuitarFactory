import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StartScreen {

	protected Shell shlCustomGuitarOrdering;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StartScreen window = new StartScreen();
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
		shlCustomGuitarOrdering.open();
		shlCustomGuitarOrdering.layout();
		while (!shlCustomGuitarOrdering.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCustomGuitarOrdering = new Shell();
		shlCustomGuitarOrdering.setSize(770, 447);
		shlCustomGuitarOrdering.setText("Custom Guitar Ordering System");
		shlCustomGuitarOrdering.setLayout(new FormLayout());
		
		Composite composite = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(0, 619);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(1, false));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_table.heightHint = 364;
		gd_table.widthHint = 574;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnOrderId = new TableColumn(table, SWT.NONE);
		tblclmnOrderId.setWidth(120);
		tblclmnOrderId.setText("Order ID");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(182);
		tblclmnNewColumn.setText("Customer Name");
		
		TableColumn tblclmnStatus = new TableColumn(table, SWT.NONE);
		tblclmnStatus.setWidth(122);
		tblclmnStatus.setText("Status");
		
		TableColumn tblclmnLastUpdated = new TableColumn(table, SWT.NONE);
		tblclmnLastUpdated.setWidth(171);
		tblclmnLastUpdated.setText("Last Updated");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("null");
		
		Composite composite_1 = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		fd_composite.bottom = new FormAttachment(composite_1, 0, SWT.BOTTOM);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.right = new FormAttachment(100, -10);
		fd_composite_1.left = new FormAttachment(composite, 6);
		fd_composite_1.top = new FormAttachment(0, 10);
		fd_composite_1.bottom = new FormAttachment(100, -10);
		composite_1.setLayoutData(fd_composite_1);
		
		Button btnExit = new Button(composite_1, SWT.NONE);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 344, 97, 30);
		btnExit.setText("Exit");
		
		Button btnAddOrder = new Button(composite_1, SWT.NONE);
		btnAddOrder.setText("Add Order");
		btnAddOrder.setBounds(10, 10, 97, 45);
		
		Button btnViewOrder = new Button(composite_1, SWT.NONE);
		btnViewOrder.setText("View Order");
		btnViewOrder.setBounds(10, 112, 97, 45);
		
		Button btnEditOrder = new Button(composite_1, SWT.NONE);
		btnEditOrder.setText("Edit Order");
		btnEditOrder.setBounds(10, 61, 97, 45);

	}
}
