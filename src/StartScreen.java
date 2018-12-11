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
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.widgets.Group;

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
		shlCustomGuitarOrdering.setSize(780, 477);
		shlCustomGuitarOrdering.setText("Custom Guitar Ordering System");
		shlCustomGuitarOrdering.setLayout(new FormLayout());
		
		Composite composite_1 = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0, 10);
		fd_composite_1.bottom = new FormAttachment(100, -10);
		fd_composite_1.right = new FormAttachment(100, -8);
		composite_1.setLayoutData(fd_composite_1);
		
		Composite composite = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		fd_composite_1.left = new FormAttachment(composite, 1);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(100, -138);
		fd_composite.left = new FormAttachment(0, 10);
		
		Group group = new Group(composite_1, SWT.NONE);
		group.setBounds(10, -7, 117, 426);
		
		Button btnViewOrder = new Button(group, SWT.NONE);
		btnViewOrder.setLocation(10, 80);
		btnViewOrder.setSize(97, 45);
		btnViewOrder.setText("View Order");
		
		Button btnEditOrder = new Button(group, SWT.NONE);
		btnEditOrder.setLocation(10, 136);
		btnEditOrder.setSize(97, 45);
		btnEditOrder.setText("Edit Order");
		
		Button btnAddOrder = new Button(group, SWT.NONE);
		btnAddOrder.setLocation(10, 22);
		btnAddOrder.setSize(97, 45);
		btnAddOrder.setText("Add Order");
		
		Button btnExit = new Button(group, SWT.NONE);
		btnExit.setLocation(10, 389);
		btnExit.setSize(97, 30);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setText("Exit");
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnOrderId = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(tblclmnOrderId, new ColumnPixelData(95, true, true));
		tblclmnOrderId.setText("Order ID");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCustomerName = tableViewerColumn_1.getColumn();
		tcl_composite.setColumnData(tblclmnCustomerName, new ColumnPixelData(176, true, true));
		tblclmnCustomerName.setText("Customer Name");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnOrderStatus = tableViewerColumn_2.getColumn();
		tcl_composite.setColumnData(tblclmnOrderStatus, new ColumnPixelData(123, true, true));
		tblclmnOrderStatus.setText("Order Status");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLastUpdated = tableViewerColumn_3.getColumn();
		tcl_composite.setColumnData(tblclmnLastUpdated, new ColumnPixelData(130, true, true));
		tblclmnLastUpdated.setText("Last Updated");

	}
}
