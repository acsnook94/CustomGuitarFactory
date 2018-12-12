import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * This class is used to display a window which allows the user to update the status of an existing order.
 * @author Andrew Snook
 */
public class UpdateOrder extends Dialog {
	//Class Fields
	protected Object result;
	protected Shell shlUpdateOrderStatus;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UpdateOrder(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlUpdateOrderStatus.open();
		shlUpdateOrderStatus.layout();
		Display display = getParent().getDisplay();
		while (!shlUpdateOrderStatus.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlUpdateOrderStatus = new Shell(getParent(), getStyle());
		shlUpdateOrderStatus.setSize(450, 224);
		shlUpdateOrderStatus.setText("Update Order Status");
		shlUpdateOrderStatus.setLayout(new FormLayout());
		
		Composite composite_0 = new Composite(shlUpdateOrderStatus, SWT.NONE);
		FormData fd_composite_0 = new FormData();
		fd_composite_0.bottom = new FormAttachment(0, 179);
		fd_composite_0.right = new FormAttachment(0, 434);
		fd_composite_0.top = new FormAttachment(0, 10);
		fd_composite_0.left = new FormAttachment(0, 10);
		composite_0.setLayoutData(fd_composite_0);
		composite_0.setLayout(new GridLayout(1, false));
		new Label(composite_0, SWT.NONE);
		
		Label lblNewStatus = new Label(composite_0, SWT.NONE);
		lblNewStatus.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewStatus.setText("Please choose new order status:");
		
		ComboViewer cboVwrNewStatus = new ComboViewer(composite_0, SWT.NONE);
		Combo cboNewStatus = cboVwrNewStatus.getCombo();
		cboNewStatus.setItems(new String[] {"Pending", "In Production", "Complete", "Shipped", "Cancelled"});
		GridData gd_cboNewStatus = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
		gd_cboNewStatus.widthHint = 305;
		cboNewStatus.setLayoutData(gd_cboNewStatus);
		new Label(composite_0, SWT.NONE);
		
		Button btnSaveStatus = new Button(composite_0, SWT.NONE);
		btnSaveStatus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		GridData gd_btnSaveStatus = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnSaveStatus.widthHint = 98;
		btnSaveStatus.setLayoutData(gd_btnSaveStatus);
		btnSaveStatus.setText("Save");
	}
	
}
