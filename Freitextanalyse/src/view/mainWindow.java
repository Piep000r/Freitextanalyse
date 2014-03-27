package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class mainWindow {

	protected Shell shlFreitextanalyse;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainWindow window = new mainWindow();
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
		shlFreitextanalyse.open();
		shlFreitextanalyse.layout();
		while (!shlFreitextanalyse.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFreitextanalyse = new Shell();
		shlFreitextanalyse.setSize(689, 300);
		shlFreitextanalyse.setText("Freitextanalyse");
		
		Group group = new Group(shlFreitextanalyse, SWT.NONE);
		group.setBounds(528, 10, 135, 82);
		
		Button btnRadioButton = new Button(group, SWT.RADIO);
		btnRadioButton.setBounds(0, 10, 90, 16);
		btnRadioButton.setText("Radio Button");
		
		Button btnRadioButton_1 = new Button(group, SWT.RADIO);
		btnRadioButton_1.setBounds(0, 38, 90, 16);
		btnRadioButton_1.setText("Radio Button");
		
		Label lblNewLabel = new Label(shlFreitextanalyse, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 55, 15);
		lblNewLabel.setText("New Label");
		
		text = new Text(shlFreitextanalyse, SWT.BORDER);
		text.setBounds(10, 105, 486, 146);
		
		Button btnNewButton = new Button(shlFreitextanalyse, SWT.NONE);
		btnNewButton.setBounds(528, 226, 75, 25);
		btnNewButton.setText("New Button");

	}
}
