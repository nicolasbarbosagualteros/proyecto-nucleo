package co.edu.unbosque.util.exception;

import co.edu.unbosque.view.MainPanel;

public class ExceptionChecker {

	private MainPanel mainPanel;
	
	
	
	public void validateInput(float text_float) throws EmptyInputException {
		
		String text_String = Float.toString(text_float);
		
		if(text_String.equals("")) {
			throw new EmptyInputException();	
		}
	}
	
	
}
