import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;

import java.awt.Dialog;

import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.internal.ole.win32.COM;

public class AddOrder {

	protected Shell shlAddNewOrder;
	private Text txtNumStrings;
	private Text txtNumFrets;
	private Text txtColor;
	private Text txtSpecInstr;
	private Text txtCustName;
	private ComboViewer cboVwrType;
	private ComboViewer cboVwrStyle;
	private ComboViewer cboVwrBodyMaterial;
	private ComboViewer cboVwrNeckMaterial;
	private ComboViewer cboVwrFretboardMaterial;
	private ComboViewer cboVwrNeckRadius;
	private ComboViewer cboVwrFinishType;
	private ComboViewer cboVwrTuningPegs;

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
	
	//Methods (Non-GUI)
	/**
	 * Create a new CustOrder object and store all the necessary fields (after user clicks "btnSubmit").
	 */
	private void AddNewOrder() {
		CustOrder newOrderSet = new CustOrder();
		MessageBox err = new MessageBox(shlAddNewOrder);
		
		try {
			newOrderSet.setNumFrets(Integer.parseInt(txtNumFrets.getText()));
		}
		catch(Exception ex){
			err.setMessage("You must enter a numeric amount for frets.");
			err.open();
			//return;
		}
		
		try {
			newOrderSet.setNumStrings(Integer.parseInt(txtNumStrings.getText()));
		}
		catch(Exception ex) {
			err.setMessage("You must enter a numeric amount for strings.");
			err.open();
		}
		
		newOrderSet.setBodyMaterial(cboVwrBodyMaterial.getCombo().getText());
		newOrderSet.setColor(txtColor.getText());
		newOrderSet.setFinishType(cboVwrFinishType.getCombo().getText());
		newOrderSet.setFretboardMaterial(cboVwrFretboardMaterial.getCombo().getText());
		newOrderSet.setNeckMaterial(cboVwrNeckMaterial.getCombo().getText());
		newOrderSet.setNeckRadius(cboVwrNeckRadius.getCombo().getText());
		newOrderSet.setStyle(cboVwrStyle.getCombo().getText());
		newOrderSet.setTuningPegs(cboVwrTuningPegs.getCombo().getText());
		newOrderSet.setType(cboVwrType.getCombo().getText());
		
		
		
	}
	
	//GUI Methods
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
		shlAddNewOrder.setSize(721, 494);
		shlAddNewOrder.setText("Add New Order");
		shlAddNewOrder.setLayout(new FormLayout());
		
		Composite composite_0 = new Composite(shlAddNewOrder, SWT.NONE);
		composite_0.setLayout(null);
		FormData fd_composite_0 = new FormData();
		fd_composite_0.top = new FormAttachment(0, 10);
		composite_0.setLayoutData(fd_composite_0);
		
		Label lblNewLabel = new Label(composite_0, SWT.NONE);
		lblNewLabel.setBounds(10, 80, 34, 20);
		lblNewLabel.setText("Type:");
		
		Label lblOfStrings = new Label(composite_0, SWT.NONE);
		lblOfStrings.setBounds(160, 80, 134, 20);
		lblOfStrings.setText("# of Strings:");
		
		Label lblBodyforn = new Label(composite_0, SWT.NONE);
		lblBodyforn.setBounds(339, 80, 139, 20);
		lblBodyforn.setText("Style:");
		
		Label lblMaterial = new Label(composite_0, SWT.NONE);
		lblMaterial.setBounds(527, 80, 151, 20);
		lblMaterial.setText("Body Wood/Material:");
		
		cboVwrType = new ComboViewer(composite_0, SWT.NONE);
		Combo cboType = cboVwrType.getCombo();
		cboType.setBounds(10, 106, 106, 28);
		cboType.setItems(new String[] {"Electric", "Acoustic", "Bass"});
		
		txtNumStrings = new Text(composite_0, SWT.BORDER);
		txtNumStrings.setBounds(160, 106, 134, 28);
		
		cboVwrStyle = new ComboViewer(composite_0, SWT.NONE);
		Combo cboStyle = cboVwrStyle.getCombo();
		cboStyle.setBounds(339, 106, 139, 28);
		cboStyle.setItems(new String[] {"Archtop", "Flat-top", "Dreadnaught", "Semi-Hollowbody", "Solid-Body", "Backpacker", "Parlor", "Classical", "Jumbo", "Backpacker"});
		
		cboVwrBodyMaterial = new ComboViewer(composite_0, SWT.NONE);
		Combo cboBodyMaterial = cboVwrBodyMaterial.getCombo();
		cboBodyMaterial.setBounds(527, 106, 134, 28);
		cboBodyMaterial.setItems(new String[] {"Maple", "Oak", "Mahogany", "Rosewood", "Spruce", "Agathis", "Basswood", "Alder", "Polycarbonate", "Steel", "Walnut", "Swamp Ash", "Rosewood"});
		
		Label lblShapeform = new Label(composite_0, SWT.NONE);
		lblShapeform.setBounds(10, 149, 65, 20);
		lblShapeform.setText("# of Frets:");
		
		Label lblNewLabel_1 = new Label(composite_0, SWT.NONE);
		lblNewLabel_1.setBounds(160, 149, 151, 20);
		lblNewLabel_1.setText("Neck Wood/Material:");
		
		Label lblFretboardMaterial = new Label(composite_0, SWT.NONE);
		lblFretboardMaterial.setBounds(339, 149, 139, 20);
		lblFretboardMaterial.setText("Fretboard Material:");
		
		Label lblNeckRadius = new Label(composite_0, SWT.NONE);
		lblNeckRadius.setBounds(527, 149, 134, 20);
		lblNeckRadius.setText("Neck Radius:");
		
		txtNumFrets = new Text(composite_0, SWT.BORDER);
		txtNumFrets.setBounds(10, 175, 106, 28);
		
		cboVwrNeckMaterial = new ComboViewer(composite_0, SWT.NONE);
		Combo cboNeckMaterial = cboVwrNeckMaterial.getCombo();
		cboNeckMaterial.setBounds(160, 175, 134, 28);
		cboNeckMaterial.setItems(new String[] {"Rosewood", "Maple", "Ebony", "Walnut", "Mahogany", "Canary", "Cocobolo", "Korina", "Bocote", "Koa"});
		
		cboVwrFretboardMaterial = new ComboViewer(composite_0, SWT.NONE);
		Combo cboFretboardMaterial = cboVwrFretboardMaterial.getCombo();
		cboFretboardMaterial.setBounds(339, 175, 139, 27);
		cboFretboardMaterial.setItems(new String[] {"Rosewood", "Maple", "Ebony", "Kingwood", "Canary", "Cocobolo", "Bocote", "Bubinga"});
		
		cboVwrNeckRadius = new ComboViewer(composite_0, SWT.NONE);
		Combo cboNeckRadius = cboVwrNeckRadius.getCombo();
		cboNeckRadius.setBounds(527, 175, 134, 28);
		cboNeckRadius.setItems(new String[] {"7-1/4\"", "9-1/2\"", "10\"", "12\"", "14\"", "16\"", "20\""});
		
		Label lblColor = new Label(composite_0, SWT.NONE);
		lblColor.setBounds(10, 232, 39, 20);
		lblColor.setText("Color:");
		
		Label lblFinishType = new Label(composite_0, SWT.NONE);
		lblFinishType.setBounds(160, 232, 134, 20);
		lblFinishType.setText("Finish Type:");
		
		Label lblNewLabel_2 = new Label(composite_0, SWT.NONE);
		lblNewLabel_2.setBounds(339, 232, 139, 20);
		lblNewLabel_2.setText("Tuning Pegs:");
		
		txtColor = new Text(composite_0, SWT.BORDER);
		txtColor.setBounds(10, 258, 106, 28);
		
		cboVwrFinishType = new ComboViewer(composite_0, SWT.NONE);
		Combo cboFinishType = cboVwrFinishType.getCombo();
		cboFinishType.setBounds(160, 258, 134, 28);
		cboFinishType.setItems(new String[] {"Polymer", "Nitrocellulose", "None"});
		
		cboVwrTuningPegs = new ComboViewer(composite_0, SWT.NONE);
		Combo cboTuningPegs = cboVwrTuningPegs.getCombo();
		cboTuningPegs.setBounds(339, 258, 139, 28);
		cboTuningPegs.setItems(new String[] {"Inline, standard", "2-row, standard", "Inline, locking", "2-row, locking"});
		
		Composite composite_1 = new Composite(shlAddNewOrder, SWT.NONE);
		fd_composite_0.bottom = new FormAttachment(composite_1, -6);
		fd_composite_0.left = new FormAttachment(composite_1, 0, SWT.LEFT);
		
		Label lblCustomerName = new Label(composite_0, SWT.NONE);
		lblCustomerName.setBounds(10, 13, 119, 20);
		lblCustomerName.setText("Customer Name:");
		
		txtCustName = new Text(composite_0, SWT.BORDER);
		txtCustName.setBounds(135, 10, 343, 28);
		composite_1.setLayout(new GridLayout(1, false));
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(100, -10);
		fd_composite_1.top = new FormAttachment(0, 311);
		fd_composite_1.left = new FormAttachment(0, 10);
		fd_composite_1.right = new FormAttachment(100, -352);
		composite_1.setLayoutData(fd_composite_1);
		
		Label lblSpecialInstructions = new Label(composite_1, SWT.NONE);
		lblSpecialInstructions.setText("Special Instructions:");
		
		txtSpecInstr = new Text(composite_1, SWT.BORDER | SWT.WRAP);
		GridData gd_txtSpecInstr = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtSpecInstr.widthHint = 324;
		gd_txtSpecInstr.heightHint = 85;
		txtSpecInstr.setLayoutData(gd_txtSpecInstr);
		
		Composite composite_2 = new Composite(shlAddNewOrder, SWT.NONE);
		fd_composite_0.right = new FormAttachment(composite_2, 0, SWT.RIGHT);
		composite_2.setLayout(null);
		FormData fd_composite_2 = new FormData();
		fd_composite_2.top = new FormAttachment(composite_1, 0, SWT.TOP);
		fd_composite_2.right = new FormAttachment(100, -10);
		fd_composite_2.left = new FormAttachment(composite_1, 6);
		fd_composite_2.bottom = new FormAttachment(100, -10);
		composite_2.setLayoutData(fd_composite_2);
		
		Button btnSubmit = new Button(composite_2, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO
				AddNewOrder();
			}
		});
		btnSubmit.setBounds(70, 73, 120, 42);
		btnSubmit.setText("Submit");
		
		Button btnCancel = new Button(composite_2, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddNewOrder.close();
			}
		});
		btnCancel.setBounds(206, 73, 120, 42);
		btnCancel.setText("Cancel");
	}
		
	//ComboViewer getters/setters
	protected ComboViewer getCboVwrType() {
		return cboVwrType;
	}
	protected ComboViewer getCboVwrStyle() {
		return cboVwrStyle;
	}
	protected ComboViewer getCboVwrBodyMaterial() {
		return cboVwrBodyMaterial;
	}
	protected ComboViewer getCboVwrNeckMaterial() {
		return cboVwrNeckMaterial;
	}
	protected ComboViewer getCboVwrFretboardMaterial() {
		return cboVwrFretboardMaterial;
	}
	protected ComboViewer getCboVwrNeckRadius() {
		return cboVwrNeckRadius;
	}
	protected ComboViewer getCboVwrFinishType() {
		return cboVwrFinishType;
	}
	protected ComboViewer getCboVwrTuningPegs() {
		return cboVwrTuningPegs;
	}
	
}
