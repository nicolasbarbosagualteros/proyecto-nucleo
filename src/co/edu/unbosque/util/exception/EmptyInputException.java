package co.edu.unbosque.util.exception;

import co.edu.unbosque.view.PopUpWindow;

public class EmptyInputException extends Exception{
	
	PopUpWindow pop = new PopUpWindow();
	public EmptyInputException() {
		super();
		pop.empty();
	}
}
