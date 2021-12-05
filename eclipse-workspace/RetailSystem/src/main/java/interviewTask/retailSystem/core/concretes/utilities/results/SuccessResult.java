package main.java.interviewTask.retailSystem.core.concretes.utilities.results;

public class SuccessResult extends Result{
	
	/* Constructor 1 */
	public SuccessResult() {
		super(true);
	}
	
	/* Constructor 2 */
	public SuccessResult(String message) {
		super(true, message);
	}
}


/*
 * Description:
 * -------------
 * purpose of this class's  data controller successfully. It's derivated by superclass named Result.
 * 
 * Parameters:
 * -------------
 * It has same parameters with own superclass.
 * 
 * Return:
 * -------------
 * None
 *  */
 