import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This class is used to display a window containing an order queue table, along with buttons which allow the user 
 * to view, edit, and add new orders.
 * 
 * @author Andrew Snook
 */
public class MainScreen {
	//Class Fields
	protected Shell shlCustomGuitarOrdering;
	private Table tblOrder;
	protected static int selectedOrderId; 
	private TableViewer tblVwrOrder;
	
	//Non-GUI Methods
	//TODO
	
	//GUI Methods
	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
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
		
		Button btnEditOrder = new Button(grpButtons, SWT.NONE);
		btnEditOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddOrder edit = new AddOrder();
				AddOrder.editMode = "edit";
				edit.open();
				
			}
		});
		btnEditOrder.setLocation(10, 72);
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
				//Get order ID from the current selected order row in table
				try {
					TableItem[] selection = tblOrder.getSelection();
					selectedOrderId = Integer.parseInt(selection[0].getText(0));
					UpdateOrder uOrder = new UpdateOrder(shlCustomGuitarOrdering, 0);
					uOrder.open();
				}
				catch(Exception ex) {
					MessageBox err = new MessageBox(shlCustomGuitarOrdering);
					err.setMessage("You must select an order first.");
					err.open();
				}
					
			}
		});
		
		btnUpdateOrder.setText("Update Status");
		btnUpdateOrder.setBounds(10, 21, 97, 45);
		fd_composite_1.top = new FormAttachment(0, 10);
		fd_composite_1.bottom = new FormAttachment(100, -10);
		composite_1.setLayoutData(fd_composite_1);
		
		tblVwrOrder = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tblOrder = tblVwrOrder.getTable();
		tblOrder.setLinesVisible(true);
		tblOrder.setHeaderVisible(true);
		tblVwrOrder.setContentProvider(new CustOrderContentProvider());
		tblVwrOrder.setLabelProvider(new CustOrderLabelProvider());
		tblVwrOrder.setInput(Startup.orderQueue.toArray());
		
		TableColumn tblclmnOrderId = new TableColumn(tblOrder, SWT.LEFT);
		tcl_composite_1.setColumnData(tblclmnOrderId, new ColumnPixelData(95, true, true));
		tblclmnOrderId.setText("Order ID");
		
		TableColumn tblclmnCustomerName = new TableColumn(tblOrder, SWT.LEFT);
		tcl_composite_1.setColumnData(tblclmnCustomerName, new ColumnPixelData(176, true, true));
		tblclmnCustomerName.setText("Customer Name");
		
		TableColumn tblclmnOrderStatus = new TableColumn(tblOrder, SWT.LEFT);
		tcl_composite_1.setColumnData(tblclmnOrderStatus, new ColumnPixelData(123, true, true));
		tblclmnOrderStatus.setText("Order Status");
		
		TableColumn tblclmnLastUpdated = new TableColumn(tblOrder, SWT.LEFT);
		tcl_composite_1.setColumnData(tblclmnLastUpdated, new ColumnPixelData(130, true, true));
		tblclmnLastUpdated.setText("Last Updated");
	}
	
	/**
	 * Used to provide data to the order queue table
	 * @author Andrew Snook
	 */
	private static class CustOrderContentProvider implements IStructuredContentProvider {
		
		public Object[] getElements(Object inputElement) {
			return Startup.orderQueue.toArray();
		}
		
		public void dispose() {
		}
		
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	/**
	 * Used to determine the fields displayed by each table column
	 * @author Andrew Snook
	 */
	private static class CustOrderLabelProvider implements ITableLabelProvider{
		@Override
		public void addListener(ILabelProviderListener listener) {
		}
		
		@Override
		public void dispose() {
		}
		
		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}
		
		@Override
		public void removeListener(ILabelProviderListener listener) {
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		
		@Override
		public String getColumnText(Object element, int columnIndex) {
			CustOrder co = (CustOrder) element;
			switch (columnIndex) {
			case 0:
				return Integer.toString(co.getOrderId());
			case 1:
				return co.getCustName();
			case 2:
				return co.getOrderStatus();
			case 3:
				return co.getLastUpdated().toString();
			}
			
			return "";
		}
	}
	
	//Getters
	protected TableViewer getTblVwrOrder() {
		return tblVwrOrder;
	}
}


