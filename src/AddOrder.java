import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class AddOrder {

	protected Shell shlAddNewOrder;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

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
		shlAddNewOrder.setSize(721, 434);
		shlAddNewOrder.setText("Add New Order");
		shlAddNewOrder.setLayout(new FormLayout());
		
		Composite composite = new Composite(shlAddNewOrder, SWT.NONE);
		composite.setLayout(null);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 34, 20);
		lblNewLabel.setText("Type:");
		
		Label lblOfStrings = new Label(composite, SWT.NONE);
		lblOfStrings.setBounds(160, 10, 134, 20);
		lblOfStrings.setText("# of Strings:");
		
		Label lblBodyforn = new Label(composite, SWT.NONE);
		lblBodyforn.setBounds(339, 10, 139, 20);
		lblBodyforn.setText("Style:");
		
		Label lblMaterial = new Label(composite, SWT.NONE);
		lblMaterial.setBounds(527, 10, 151, 20);
		lblMaterial.setText("Body Wood/Material:");
		
		ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(10, 35, 106, 28);
		combo.setItems(new String[] {"Electric", "Acoustic", "Bass"});
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(160, 36, 134, 26);
		
		ComboViewer comboViewer_2 = new ComboViewer(composite, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setBounds(339, 35, 139, 28);
		combo_2.setItems(new String[] {"Archtop", "Flat-top", "Dreadnaught", "Semi-Hollowbody", "Solid-Body", "Backpacker", "Parlor", "Classical", "Jumbo", "Backpacker"});
		
		ComboViewer comboViewer_3 = new ComboViewer(composite, SWT.NONE);
		Combo combo_3 = comboViewer_3.getCombo();
		combo_3.setBounds(527, 35, 134, 28);
		combo_3.setItems(new String[] {"Maple", "Oak", "Mahogany", "Rosewood", "Spruce", "Agathis", "Basswood", "Alder", "Polycarbonate", "Steel", "Walnut", "Swamp Ash", "Rosewood"});
		
		Label lblShapeform = new Label(composite, SWT.NONE);
		lblShapeform.setBounds(10, 79, 65, 20);
		lblShapeform.setText("# of Frets:");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(160, 79, 151, 20);
		lblNewLabel_1.setText("Neck Wood/Material:");
		
		Label lblFretboardMaterial = new Label(composite, SWT.NONE);
		lblFretboardMaterial.setBounds(339, 79, 139, 20);
		lblFretboardMaterial.setText("Fretboard Material:");
		
		Label lblNeckRadius = new Label(composite, SWT.NONE);
		lblNeckRadius.setBounds(527, 79, 134, 20);
		lblNeckRadius.setText("Neck Radius:");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(10, 105, 106, 26);
		
		ComboViewer comboViewer_1 = new ComboViewer(composite, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(160, 104, 134, 28);
		combo_1.setItems(new String[] {"Rosewood", "Maple", "Ebony", "Walnut", "Mahogany", "Canary", "Cocobolo", "Korina", "Bocote", "Koa"});
		
		ComboViewer comboViewer_4 = new ComboViewer(composite, SWT.NONE);
		Combo combo_4 = comboViewer_4.getCombo();
		combo_4.setBounds(339, 104, 139, 28);
		combo_4.setItems(new String[] {"Rosewood", "Maple", "Ebony", "Kingwood", "Canary", "Cocobolo", "Bocote", "Bubinga"});
		
		ComboViewer comboViewer_5 = new ComboViewer(composite, SWT.NONE);
		Combo combo_5 = comboViewer_5.getCombo();
		combo_5.setBounds(527, 104, 134, 28);
		combo_5.setItems(new String[] {"7-1/4\"", "9-1/2\"", "10\"", "12\"", "14\"", "16\"", "20\""});
		
		Label lblColor = new Label(composite, SWT.NONE);
		lblColor.setBounds(10, 162, 39, 20);
		lblColor.setText("Color:");
		
		Label lblFinishType = new Label(composite, SWT.NONE);
		lblFinishType.setBounds(160, 162, 134, 20);
		lblFinishType.setText("Finish Type:");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(339, 162, 139, 20);
		lblNewLabel_2.setText("Tuning Pegs:");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(10, 188, 106, 26);
		
		ComboViewer comboViewer_6 = new ComboViewer(composite, SWT.NONE);
		Combo combo_6 = comboViewer_6.getCombo();
		combo_6.setBounds(160, 187, 134, 28);
		combo_6.setItems(new String[] {"Polymer", "Nitrocellulose", "None"});
		
		ComboViewer comboViewer_7 = new ComboViewer(composite, SWT.NONE);
		Combo combo_7 = comboViewer_7.getCombo();
		combo_7.setBounds(339, 187, 139, 28);
		combo_7.setItems(new String[] {"Inline, standard", "2-row, standard", "Inline, locking", "2-row, locking"});
		
		Composite composite_1 = new Composite(shlAddNewOrder, SWT.NONE);
		fd_composite.bottom = new FormAttachment(composite_1, -6);
		fd_composite.left = new FormAttachment(composite_1, 0, SWT.LEFT);
		composite_1.setLayout(new GridLayout(1, false));
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(100, -10);
		fd_composite_1.top = new FormAttachment(0, 252);
		fd_composite_1.left = new FormAttachment(0, 10);
		fd_composite_1.right = new FormAttachment(100, -352);
		composite_1.setLayoutData(fd_composite_1);
		
		Label lblSpecialInstructions = new Label(composite_1, SWT.NONE);
		lblSpecialInstructions.setText("Special Instructions:");
		
		text_3 = new Text(composite_1, SWT.BORDER | SWT.WRAP);
		GridData gd_text_3 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text_3.widthHint = 324;
		gd_text_3.heightHint = 85;
		text_3.setLayoutData(gd_text_3);
		
		Composite composite_2 = new Composite(shlAddNewOrder, SWT.NONE);
		composite_2.setLayout(null);
		FormData fd_composite_2 = new FormData();
		fd_composite_2.bottom = new FormAttachment(100, -10);
		fd_composite_2.top = new FormAttachment(composite, 6);
		fd_composite_2.right = new FormAttachment(100, -10);
		fd_composite_2.left = new FormAttachment(composite_1, 6);
		composite_2.setLayoutData(fd_composite_2);
		
		Button btnNewButton_1 = new Button(composite_2, SWT.NONE);
		btnNewButton_1.setBounds(70, 73, 120, 42);
		btnNewButton_1.setText("Submit");
		
		Button btnCancel = new Button(composite_2, SWT.NONE);
		btnCancel.setBounds(206, 73, 120, 42);
		btnCancel.setText("Cancel");

	}
}
