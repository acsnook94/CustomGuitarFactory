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
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

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
	protected static int selectedOrderId = -1; 
	private TableViewer tblVwrOrder;
	private static OrderStatusFilter filtCurr = null;
	
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
		OrderStatusFilter filtPending = new OrderStatusFilter("Pending");
		OrderStatusFilter filtProd = new OrderStatusFilter("In Production");
		OrderStatusFilter filtShipped = new OrderStatusFilter("Shipped");
		OrderStatusFilter filtCompleted = new OrderStatusFilter("Completed");
		OrderStatusFilter filtCancelled = new OrderStatusFilter("Cancelled");
		
		shlCustomGuitarOrdering = new Shell();
		shlCustomGuitarOrdering.setSize(780, 533);
		shlCustomGuitarOrdering.setText("Custom Guitar Ordering System");
		shlCustomGuitarOrdering.setLayout(new FormLayout());
		
		Composite composite_0 = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		FormData fd_composite_0 = new FormData();
		fd_composite_0.bottom = new FormAttachment(100, -10);
		fd_composite_0.right = new FormAttachment(100, -8);
		fd_composite_0.top = new FormAttachment(0, 47);
		composite_0.setLayoutData(fd_composite_0);
		
		Composite composite_1 = new Composite(shlCustomGuitarOrdering, SWT.NONE);
		fd_composite_0.left = new FormAttachment(composite_1, 1);
		TableColumnLayout tcl_composite_1 = new TableColumnLayout();
		composite_1.setLayout(tcl_composite_1);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(100, -10);
		fd_composite_1.right = new FormAttachment(100, -138);
		fd_composite_1.top = new FormAttachment(0, 47);
		fd_composite_1.left = new FormAttachment(0, 10);
		
		Group grpButtons = new Group(composite_0, SWT.NONE);
		grpButtons.setBounds(10, -10, 117, 426);
		
		Button btnEditOrder = new Button(grpButtons, SWT.NONE);
		btnEditOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox err;
				if(selectedOrderId != -1) {
					AddOrder edit = new AddOrder();
					AddOrder.editMode = true;
					edit.open();
				}
				else{
					err = new MessageBox(shlCustomGuitarOrdering);
					err.setMessage("You must select an order from the table first.");
					err.open();
				}
			}
				
		});
		
		btnEditOrder.setLocation(10, 72);
		btnEditOrder.setSize(97, 45);
		btnEditOrder.setText("Edit Order");
		
		Button btnAddOrder = new Button(grpButtons, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			//Opens the Add/Edit Order screen when "AddOrder" btn is clicked
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddOrder addOrder = new AddOrder();
				AddOrder.editMode = false;
				addOrder.open();
			}
		});
		btnAddOrder.setLocation(10, 123);
		btnAddOrder.setSize(97, 45);
		btnAddOrder.setText("Add Order");
		
		Button btnExit = new Button(grpButtons, SWT.NONE);
		btnExit.setLocation(10, 389);
		btnExit.setSize(97, 30);
		btnExit.addSelectionListener(new SelectionAdapter() {
			//Program will exit here when the "Exit" btn is clicked
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
				//Opens the "UpdateOrder" dialog box
				if(selectedOrderId != -1) {
					UpdateOrder uOrder = new UpdateOrder(shlCustomGuitarOrdering, 0);
					uOrder.open();
				}
				else {
					//User failed to select a row before clicking "Update Order" btn
					MessageBox err = new MessageBox(shlCustomGuitarOrdering);
					err.setMessage("You must select an order from the table first.");
					err.open();
				}
					
			}
		});
		
		btnUpdateOrder.setText("Update Status");
		btnUpdateOrder.setBounds(10, 21, 97, 45);
		
		Button btnNewButton = new Button(grpButtons, SWT.WRAP);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblVwrOrder.addFilter(filtPending);
				filtCurr = filtPending;
			}
		});
		btnNewButton.setBounds(10, 210, 90, 62);
		btnNewButton.setText("Test Pending Filter");
		
		Button btnTestCancelFilter = new Button(grpButtons, SWT.WRAP);
		btnTestCancelFilter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblVwrOrder.removeFilter(filtCurr);
				filtCurr = null;
			}
		});
		btnTestCancelFilter.setText("Test Cancel Filter");
		btnTestCancelFilter.setBounds(17, 296, 90, 62);
		composite_1.setLayoutData(fd_composite_1);
		
		tblVwrOrder = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tblVwrOrder.addSelectionChangedListener(new ISelectionChangedListener() {	
			//Updates class variable "selectedOrderId" whenever user clicks on a new table row
			public void selectionChanged(SelectionChangedEvent arg0) {
				TableItem[] selection = tblVwrOrder.getTable().getSelection();
				selectedOrderId = Integer.parseInt(selection[0].getText(0));
			}
		});
		
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
		tcl_composite_1.setColumnData(tblclmnLastUpdated, new ColumnPixelData(200, true, true));
		tblclmnLastUpdated.setText("Last Updated");	
		
		Combo cboStatusFilters = new Combo(shlCustomGuitarOrdering, SWT.NONE);
		FormData fd_cboStatusFilters = new FormData();
		fd_cboStatusFilters.bottom = new FormAttachment(composite_1, -9);
		fd_cboStatusFilters.right = new FormAttachment(100, -138);
		fd_cboStatusFilters.left = new FormAttachment(100, -346);
		cboStatusFilters.setLayoutData(fd_cboStatusFilters);
		cboStatusFilters.setItems(new String[] {"Pending", "In Production", "Shipped", "Complete", "Cancelled"});
		
		Label lblStatusFilters = new Label(shlCustomGuitarOrdering, SWT.NONE);
		FormData fd_lblStatusFilters = new FormData();
		fd_lblStatusFilters.top = new FormAttachment(cboStatusFilters, 3, SWT.TOP);
		fd_lblStatusFilters.right = new FormAttachment(cboStatusFilters, -13);
		lblStatusFilters.setLayoutData(fd_lblStatusFilters);
		lblStatusFilters.setText("Filter by:");
	}
	
	/**
	 * This class is used to filter the ordering queue table on MainScreen, depending on which filter item is selected.
	 * 
	 * @author Andrew Snook
	 */
	private static class OrderStatusFilter extends ViewerFilter{
		private String word;
		
		public OrderStatusFilter(String word) {
			this.word = word;
		}
		
		@Override
		public boolean select(Viewer vwr, Object elemParent, Object elem) {
			CustOrder order = (CustOrder)elem;
			if(order.getOrderStatus().equals(this.word)) {
				return true;
			}
			
			return false;
		}
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
	
	//TABLEVIEWER PROVIDERS
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
	//END TABLEVIEWER PROVIDERS
	
	//Getters
	protected TableViewer getTblVwrOrder() {
		return tblVwrOrder;
	}
}


