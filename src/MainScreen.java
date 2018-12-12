import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MainScreen {
	//Class Fields
	protected Shell shlCustomGuitarOrdering;
	private Table tblOrder;
	
	//Non-GUI Methods
//	private void refreshQueue() {
//		
//	}
	
	//GUI Methods
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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlCustomGuitarOrdering = new Shell();
		shlCustomGuitarOrdering.setSize(780, 477);
		shlCustomGuitarOrdering.setText("Custom Guitar Ordering System");
		shlCustomGuitarOrdering.setLayout(new FormLayout());
		
		Composite composite_0 = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		FormData fd_composite_0 = new FormData();
		fd_composite_0.top = new FormAttachment(0, 10);
		fd_composite_0.bottom = new FormAttachment(100, -10);
		fd_composite_0.right = new FormAttachment(100, -8);
		composite_0.setLayoutData(fd_composite_0);
		
		Composite composite_1 = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		fd_composite_0.left = new FormAttachment(composite_1, 1);
		TableColumnLayout tcl_composite_1 = new TableColumnLayout();
		composite_1.setLayout(tcl_composite_1);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.right = new FormAttachment(100, -138);
		fd_composite_1.left = new FormAttachment(0, 10);
		
		Group grpButtons = new Group(composite_0, SWT.NONE);
		grpButtons.setBounds(10, -10, 117, 426);
		
		Button btnRefresh = new Button(grpButtons, SWT.NONE);
		btnRefresh.setLocation(10, 20);
		btnRefresh.setSize(97, 45);
		btnRefresh.setText("Refresh");
		
		Button btnEditOrder = new Button(grpButtons, SWT.NONE);
		btnEditOrder.setLocation(10, 122);
		btnEditOrder.setSize(97, 45);
		btnEditOrder.setText("Edit Order");
		
		Button btnAddOrder = new Button(grpButtons, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddOrder addOrder = new AddOrder();
				addOrder.open();
			}
		});
		btnAddOrder.setLocation(10, 231);
		btnAddOrder.setSize(97, 45);
		btnAddOrder.setText("Add Order");
		
		Button btnExit = new Button(grpButtons, SWT.NONE);
		btnExit.setLocation(10, 389);
		btnExit.setSize(97, 30);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setText("Exit");
		
		Button btnUpdateOrder = new Button(grpButtons, SWT.NONE);
		btnUpdateOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UpdateOrder uOrder = new UpdateOrder(shlCustomGuitarOrdering, 0);
				uOrder.open();
			}
		});
		btnUpdateOrder.setText("Update Status");
		btnUpdateOrder.setBounds(10, 71, 97, 45);
		fd_composite_1.top = new FormAttachment(0, 10);
		fd_composite_1.bottom = new FormAttachment(100, -10);
		composite_1.setLayoutData(fd_composite_1);
		
		TableViewer tblVwrOrder = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tblOrder = tblVwrOrder.getTable();
		tblOrder.setLinesVisible(true);
		tblOrder.setHeaderVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tblVwrOrder, SWT.NONE);
		TableColumn tblclmnOrderId = tableViewerColumn.getColumn();
		tcl_composite_1.setColumnData(tblclmnOrderId, new ColumnPixelData(95, true, true));
		tblclmnOrderId.setText("Order ID");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tblVwrOrder, SWT.NONE);
		TableColumn tblclmnCustomerName = tableViewerColumn_1.getColumn();
		tcl_composite_1.setColumnData(tblclmnCustomerName, new ColumnPixelData(176, true, true));
		tblclmnCustomerName.setText("Customer Name");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tblVwrOrder, SWT.NONE);
		TableColumn tblclmnOrderStatus = tableViewerColumn_2.getColumn();
		tcl_composite_1.setColumnData(tblclmnOrderStatus, new ColumnPixelData(123, true, true));
		tblclmnOrderStatus.setText("Order Status");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tblVwrOrder, SWT.NONE);
		TableColumn tblclmnLastUpdated = tableViewerColumn_3.getColumn();
		tcl_composite_1.setColumnData(tblclmnLastUpdated, new ColumnPixelData(130, true, true));
		tblclmnLastUpdated.setText("Last Updated");
		tblVwrOrder.setContentProvider(new CustOrderContentProvider());
		tblVwrOrder.setInput(Startup.orderQueue);

	}
	
	/**
	 * Used to provide data to the order queue table
	 * 
	 * @author Andrew Snook
	 */
//	class CustOrderContentProvider implements IStructuredContentProvider{
//
//		@Override
//		public Object[] getElements(Object arg0) {
//			// TODO Auto-generated method stub
//			return Startup.orderQueue.toArray();
//		}
//		
//	}
	
}


