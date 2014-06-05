package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class mainWindow {

	protected Shell shlFreitextanalyse;
	private Text text;
	private Text text_1;
	private Button caseSensitiveon;
	private Button caseSensitiveoff;
	private Button verneinung;
	private Button definition;

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
		group.setBounds(509, 47, 170, 127);
		
		Button btnRadioButton = new Button(group, SWT.RADIO);
		btnRadioButton.setBounds(0, 16, 146, 16);
		btnRadioButton.setText("Case Sensitive OFF");
		caseSensitiveoff = btnRadioButton;
		
		Button btnRadioButton_1 = new Button(group, SWT.RADIO);
		btnRadioButton_1.setBounds(0, 63, 146, 16);
		btnRadioButton_1.setText("Verneinung");
		verneinung = btnRadioButton_1;
		
		Button btnDefinition = new Button(group, SWT.RADIO);
		btnDefinition.setBounds(0, 85, 91, 18);
		btnDefinition.setText("Definition");
		definition = btnDefinition;
		
		Button btnRadioButton_2 = new Button(group, SWT.RADIO);
		btnRadioButton_2.setBounds(0, 39, 134, 18);
		btnRadioButton_2.setText("Case Sensitive ON");
		caseSensitiveon = btnRadioButton_2;
		
		Label lblNewLabel = new Label(shlFreitextanalyse, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 341, 25);
		lblNewLabel.setText("Frage: Was versteht man unter einer IP-Adresse?");
		
		text = new Text(shlFreitextanalyse, SWT.BORDER);
		text.setBounds(10, 124, 486, 127);
		
		
		Button btnNewButton = new Button(shlFreitextanalyse, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkText();
			}
		});
		btnNewButton.setBounds(509, 226, 120, 25);
		btnNewButton.setText("Prüfen");
		
		text_1 = new Text(shlFreitextanalyse, SWT.BORDER);
		text_1.setBounds(95, 47, 401, 45);
		
		Label lblSchlagwrter = new Label(shlFreitextanalyse, SWT.NONE);
		lblSchlagwrter.setBounds(10, 50, 95, 25);
		lblSchlagwrter.setText("Schlagwörter:");
		
		Label lblAntwort = new Label(shlFreitextanalyse, SWT.NONE);
		lblAntwort.setBounds(10, 104, 59, 14);
		lblAntwort.setText("Antwort:");

	}
	
	public void checkText(){
		
			String hitWords[] = text_1.getText().split(",");
			String Answer[] = text.getText().split(" ");
		
		
		if(definition.getSelection()){
			if(text_1.getText().equals(text.getText())){
				System.out.println("Die Antwort entspricht der Definition!");
			}else{
				System.out.println("Die Antwort entspricht nicht der Definition!");
			}
			
		}
		
		// Ausgabe der Schlagwörter zum Debuggen
		//System.out.println("Debug: Schlagwörter: ");
		for (int i=0; i<hitWords.length;i++){
			if(hitWords[i].endsWith(".") || hitWords[i].endsWith(",")|| hitWords[i].endsWith("!")|| hitWords[i].endsWith("?")|| hitWords[i].endsWith(";")|| hitWords[i].endsWith(" "))
				hitWords[i] = hitWords[i].substring(hitWords[i].length()-1, hitWords[i].length());
			//System.out.println("Debug: " + hitWords[i]);
		}
		
		System.out.println();
		
		// Antworttext in String array packen und satzzeichen abschneiden
		//System.out.println("Debug: Antwort: ");
		for (int i=0; i<Answer.length;i++){
			if(Answer[i].endsWith(".") || Answer[i].endsWith(",")|| Answer[i].endsWith("!")|| Answer[i].endsWith("?")|| Answer[i].endsWith(";")|| Answer[i].endsWith(" "))
				Answer[i] = Answer[i].substring(Answer[i].length()-1, Answer[i].length());
			//System.out.println("Debug: " + Answer[i]);  // Ausgabe zu Debugging Zwecken
		}
		
		System.out.println();
		int counter = 0;
		
		// Ausgaben zum debuggen
//		System.out.println("Debug: Answer[0] =" + Answer[0]);
//		System.out.println("Debug: hitWords[0] =" + hitWords[0]);
		
		for (int i=0;i<hitWords.length;i++){
			for(int j=0; j<Answer.length;j++){
				// Case-Sensitive
				if(caseSensitiveoff.getSelection()){
					// prüfung ohne case-sensitivity
					counter = 0;
					if(Answer[j].equalsIgnoreCase(hitWords[i])){
						System.out.println("Das Schlagwort '" + Answer[j] + "' kommt in dem Text vor!");
						counter++;
					}else{
						System.out.println("Das Schlagwort '" + Answer[j] + "' kommt nicht in dem Text vor!");
					}
				}
				if(caseSensitiveon.getSelection()){
					// prüfung mit case-sensitivity
					counter = 0;
					if(Answer[j].equals(hitWords[i])){
						System.out.println("Das Schlagwort '" + Answer[j] + "' kommt in dem Text vor!");
						counter++;
					}else{
						System.out.println("Das Schlagwort '" + Answer[j] + "' kommt nicht in dem Text vor!");
					}
				}
				
				// verneinung ohne case-sensitivity
				if(verneinung.getSelection()){
					counter = 0;
					String verneint = "nicht " + Answer[j];
					if(hitWords.length>1){
						if(!verneint.equalsIgnoreCase(hitWords[i-1] + hitWords[i])){
							System.out.println("Das Schlagwort 'nicht " + Answer[j] + "' kommt nicht in dem Text vor!");
							//counter++;
						}else{
							System.out.println("Das Schlagwort '" + Answer[j] + "' kommt in dem Text vor!");
							counter++;
						}
					}else{
						String word = "nicht " + hitWords[i];
						if(!verneint.equalsIgnoreCase(word)){
							System.out.println("Das Schlagwort 'nicht " + Answer[j] + "' kommt nicht in dem Text vor!");
							//counter++;
						}else{
							System.out.println("Das Schlagwort '" + Answer[j] + "' kommt in dem Text vor!");
							counter++;
						}
					}
				}
			}
		}
		
		if (!definition.getSelection() && !verneinung.getSelection()){
			// Auswertung
			System.out.println("Es kommen " + counter + " von " + hitWords.length + " Schlagwörtern in der Antwort vor!");
			
			// Übereinstimmung in % angeben
			System.out.println("Dies entspricht einer Übereinstimmung von " + ((100/hitWords.length)*counter) + "%");
		}
		counter = 0;
	}
}
