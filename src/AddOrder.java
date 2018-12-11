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
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(7, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Type:");
		new Label(composite, SWT.NONE);
		
		Label lblOfStrings = new Label(composite, SWT.NONE);
		lblOfStrings.setText("# of Strings:");
		new Label(composite, SWT.NONE);
		
		Label lblBodyforn = new Label(composite, SWT.NONE);
		lblBodyforn.setText("Style:");
		new Label(composite, SWT.NONE);
		
		Label lblMaterial = new Label(composite, SWT.NONE);
		lblMaterial.setText("Body Wood/Material");
		
		ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setItems(new String[] {"Electric", "Acoustic", "Bass"});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 64;
		text.setLayoutData(gd_text);
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_2 = new ComboViewer(composite, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setItems(new String[] {"Archtop", "Flat-top", "Dreadnaught", "Semi-Hollowbody", "Solid-Body", "Backpacker", "Parlor", "Classical", "Jumbo", "Backpacker"});
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_3 = new ComboViewer(composite, SWT.NONE);
		Combo combo_3 = comboViewer_3.getCombo();
		combo_3.setItems(new String[] {"Maple", "Oak", "Mahogany", "Rosewood", "Spruce", "Agathis", "Basswood", "Alder", "Polycarbonate", "Steel", "Walnut", "Swamp Ash", "Rosewood"});
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblShapeform = new Label(composite, SWT.NONE);
		lblShapeform.setText("# of Frets:");
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setText("Neck Wood/Material:");
		new Label(composite, SWT.NONE);
		
		Label lblFretboardMaterial = new Label(composite, SWT.NONE);
		lblFretboardMaterial.setText("Fretboard Material:");
		new Label(composite, SWT.NONE);
		
		Label lblNeckRadius = new Label(composite, SWT.NONE);
		lblNeckRadius.setText("Neck Radius:");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_1 = new ComboViewer(composite, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setItems(new String[] {"Rosewood", "Maple", "Ebony", "Walnut", "Mahogany", "Canary", "Cocobolo", "Korina", "Bocote", "Koa"});
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_4 = new ComboViewer(composite, SWT.NONE);
		Combo combo_4 = comboViewer_4.getCombo();
		combo_4.setItems(new String[] {"Rosewood", "Maple", "Ebony", "Kingwood", "Canary", "Cocobolo", "Bocote", "Bubinga"});
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_5 = new ComboViewer(composite, SWT.NONE);
		Combo combo_5 = comboViewer_5.getCombo();
		combo_5.setItems(new String[] {"7-1/4\"", "9-1/2\"", "10\"", "12\"", "14\"", "16\"", "20\""});
		combo_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblColor = new Label(composite, SWT.NONE);
		lblColor.setText("Color:");
		new Label(composite, SWT.NONE);
		
		Label lblFinishType = new Label(composite, SWT.NONE);
		lblFinishType.setText("Finish Type:");
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setText("Tuning Pegs:");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_6 = new ComboViewer(composite, SWT.NONE);
		Combo combo_6 = comboViewer_6.getCombo();
		combo_6.setItems(new String[] {"Polymer", "Nitrocellulose", "None"});
		combo_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		ComboViewer comboViewer_7 = new ComboViewer(composite, SWT.NONE);
		Combo combo_7 = comboViewer_7.getCombo();
		combo_7.setItems(new String[] {"Inline, standard", "2-row, standard", "Inline, locking", "2-row, locking"});
		combo_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Composite composite_1 = new Composite(shlAddNewOrder, SWT.NONE);
		fd_composite.bottom = new FormAttachment(100, -141);
		composite_1.setLayout(new GridLayout(1, false));
		FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(composite, 6);
		fd_composite_1.left = new FormAttachment(0, 10);
		fd_composite_1.bottom = new FormAttachment(100, -10);
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
		fd_composite_2.right = new FormAttachment(composite, 0, SWT.RIGHT);
		fd_composite_2.bottom = new FormAttachment(composite_1, 0, SWT.BOTTOM);
		fd_composite_2.top = new FormAttachment(composite, 6);
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
