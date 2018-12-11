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

public class UpdateOrder extends Dialog {

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
		
		Composite composite = new Composite(shlUpdateOrderStatus, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 179);
		fd_composite.right = new FormAttachment(0, 434);
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(1, false));
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Please choose new order status:");
		
		ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setItems(new String[] {"Pending", "In Production", "Complete", "Shipped", "Cancelled"});
		GridData gd_combo = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
		gd_combo.widthHint = 305;
		combo.setLayoutData(gd_combo);
		new Label(composite, SWT.NONE);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		GridData gd_btnNewButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 98;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Save");

	}
}
