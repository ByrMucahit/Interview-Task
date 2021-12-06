package main.java.interviewTask.retailSystem.core.concretes.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
	
	/* Constructor */
	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	/* Constructor 2*/
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	/* Constructor 3*/
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
	/* Constructor 4*/
	public SuccessDataResult() {
		super(null, true);
	}
}


/* Description:
 * -------------
 * purpose of this class is controller on data that has been token without any fault.
 * 
 * Parameters :
 * -------------
 * It has same parameters with own superclass.
 * 
 * Return:
 * None
 *  
 */
