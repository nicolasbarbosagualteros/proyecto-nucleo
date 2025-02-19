package co.edu.unbosque.util.exception;

import co.edu.unbosque.view.MainPanel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class ExceptionChecker {

	private MainPanel mainPanel;
	
	
	
	public void validateInput(String text) throws EmptyInputException {
		if(text.equals("")) {
			throw new EmptyInputException();	
		}
	}

	public void validateNumber(String texto) {
		Pattern p = Pattern.compile("^\\d+$");
		Matcher m = p.matcher(texto);
		if (!m.matches()) {
			JOptionPane.showMessageDialog(null, "Please enter numbers only.",
					"Invalid input", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
