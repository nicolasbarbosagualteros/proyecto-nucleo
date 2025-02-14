package co.edu.unbosque.util.exception;

import co.edu.unbosque.view.MainPanel;

public class ExceptionChecker {

	private MainPanel mainPanel;
	
	
	
	public void validateInput(String text) throws EmptyInputException {
		
		
		if(text.equals("")) {
			throw new EmptyInputException();	
		}
	}
	
	
}
