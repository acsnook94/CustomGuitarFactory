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
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.util.Date;
import org.eclipse.swt.widgets.Control;

/**
 * This class is used to display a window which will allow the user to add a new customized guitar order (for customer)
 * 
 * @author Andrew Snook
 */
public class AddOrder {
	//Class Fields
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
	protected static boolean editMode;
	protected static CustOrder curr;
	
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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlAddNewOrder = new Shell();
		shlAddNewOrder.setSize(721, 494);
		shlAddNewOrder.setText("Add/Edit Order");
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
		txtNumStrings.setText("0");
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
		txtNumFrets.setText("0");
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
		composite_0.setTabList(new Control[]{txtCustName, cboType, txtNumStrings, cboStyle, cboBodyMaterial, txtNumFrets, cboNeckMaterial, cboFretboardMaterial, cboNeckRadius, txtColor, cboFinishType, cboTuningPegs});
		composite_2.setLayout(null);
		FormData fd_composite_2 = new FormData();
		fd_composite_2.top = new FormAttachment(composite_1, 0, SWT.TOP);
		fd_composite_2.right = new FormAttachment(100, -10);
		fd_composite_2.left = new FormAttachment(composite_1, 6);
		fd_composite_2.bottom = new FormAttachment(100, -10);
		composite_2.setLayoutData(fd_composite_2);
		
		Button btnSubmit = new Button(composite_2, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			//Calls a method to save new/changed order data after user clicks "Submit" btn
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddEditOrder();
			}
		});
		
		btnSubmit.setBounds(70, 73, 120, 42);
		btnSubmit.setText("Submit");
		
		Button btnCancel = new Button(composite_2, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			//Exits the Add/Edit Items screen w/o saving data when "Cancel" btn is clicked
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAddNewOrder.close();
			}
		});
		
		btnCancel.setBounds(206, 73, 120, 42);
		btnCancel.setText("Cancel");
		
		/* If "editMode" is true, then an iterator will be used to retrieve all current data for the selected order table row
			(from MainWindow) and use it to pre-populate the text/combo boxes on Add/Edit Order window */
		if(editMode) {
			java.util.Iterator<CustOrder> iterator = Startup.orderQueue.iterator();
			while(iterator.hasNext()) {
				curr = iterator.next();
				
				if(curr.getOrderId() == MainScreen.selectedOrderId) {
					break;
				}
			}
			
			getCboVwrBodyMaterial().getCombo().setText(curr.getBodyMaterial());
			getCboVwrFinishType().getCombo().setText(curr.getFinishType());
			getCboVwrFretboardMaterial().getCombo().setText(curr.getFretboardMaterial());
			getCboVwrNeckMaterial().getCombo().setText(curr.getNeckMaterial());
			getCboVwrNeckRadius().getCombo().setText(curr.getNeckRadius());
			getCboVwrStyle().getCombo().setText(curr.getStyle());
			getCboVwrTuningPegs().getCombo().setText(curr.getTuningPegs());
			getCboVwrType().getCombo().setText(curr.getType());
			txtColor.setText(curr.getColor());
			txtCustName.setText(curr.getCustName());
			txtNumFrets.setText(Integer.toString(curr.getNumFrets()));
			txtNumStrings.setText(Integer.toString(curr.getNumStrings()));
			txtSpecInstr.setText(curr.getSpecInstr());
		}	
	}
	
	//Methods (Non-GUI)
		/**
		 * Create a new CustOrder object and store all the necessary fields (after user clicks "btnSubmit").
		 * The CustOrder is then pushed to the ordering queue.
		 */
		private void AddEditOrder() {
			CustOrder newOrderSet = new CustOrder();
			MessageBox err;
			boolean error = false;
			
			//Set user-set numerical fields first (may fail due to invalid input)
			try {
				if(!editMode) {
					newOrderSet.setNumFrets(Integer.parseInt(txtNumFrets.getText()));
				}
				else {
					curr.setNumFrets(Integer.parseInt(txtNumFrets.getText()));
				}
			}
			catch(Exception ex){
				error = true;
				err = new MessageBox(shlAddNewOrder);
				err.setMessage("You must enter a numeric amount for frets.");
				err.open();
				//return;
			}
			
			try {
				if(!editMode) {
					newOrderSet.setNumStrings(Integer.parseInt(txtNumStrings.getText()));
				}
				else {
					curr.setNumStrings(Integer.parseInt(txtNumStrings.getText()));
				}
			}
			catch(Exception ex) {
				error = true;
				err = new MessageBox(shlAddNewOrder);
				err.setMessage("You must enter a numeric amount for strings.");
				err.open();
			}
			
			//If no error occurred above this
			if(!error) {
				//Set all other order form fields
				if(!editMode) {
					newOrderSet.setBodyMaterial(cboVwrBodyMaterial.getCombo().getText());
					newOrderSet.setColor(txtColor.getText());
					newOrderSet.setFinishType(cboVwrFinishType.getCombo().getText());
					newOrderSet.setFretboardMaterial(cboVwrFretboardMaterial.getCombo().getText());
					newOrderSet.setNeckMaterial(cboVwrNeckMaterial.getCombo().getText());
					newOrderSet.setNeckRadius(cboVwrNeckRadius.getCombo().getText());
					newOrderSet.setStyle(cboVwrStyle.getCombo().getText());
					newOrderSet.setTuningPegs(cboVwrTuningPegs.getCombo().getText());
					newOrderSet.setType(cboVwrType.getCombo().getText());
					newOrderSet.setSpecInstr(txtSpecInstr.getText());
					newOrderSet.setCustName(txtCustName.getText());
					newOrderSet.setOrderStatus("Pending");
					newOrderSet.setOrderId(Startup.orderQueue.size() + 1);
					newOrderSet.setLastUpdated(new Date());
				
					Startup.orderQueue.add(newOrderSet);	//Push the new CustOrder to the ordering queue
					Startup.window.getTblVwrOrder().refresh();
					
					//If currently selected filter for order table is "All" or "Pending", update order count label
					if(Startup.window.getCboStatusFilters().getText().equals("All") 
							|| Startup.window.getCboStatusFilters().getText().equals("Pending")){
						Startup.window.getLblNumOrdersVal().setText(Integer.toString(Startup.orderQueue.size()));
					}
					
				}
				else {
					curr.setBodyMaterial(cboVwrBodyMaterial.getCombo().getText());
					curr.setColor(txtColor.getText());
					curr.setFinishType(cboVwrFinishType.getCombo().getText());
					curr.setFretboardMaterial(cboVwrFretboardMaterial.getCombo().getText());
					curr.setNeckMaterial(cboVwrNeckMaterial.getCombo().getText());
					curr.setNeckRadius(cboVwrNeckRadius.getCombo().getText());
					curr.setStyle(cboVwrStyle.getCombo().getText());
					curr.setTuningPegs(cboVwrTuningPegs.getCombo().getText());
					curr.setType(cboVwrType.getCombo().getText());
					curr.setSpecInstr(txtSpecInstr.getText());
					curr.setCustName(txtCustName.getText());
					curr.setLastUpdated(new Date());
					
					editMode = false;
					curr = null;
				}
				
				shlAddNewOrder.close();
				Startup.window.getTblVwrOrder().refresh();
			}	
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
