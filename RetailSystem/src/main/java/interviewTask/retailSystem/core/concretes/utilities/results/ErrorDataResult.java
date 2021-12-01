package main.java.interviewTask.retailSystem.core.concretes.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	
	/* Constructor */
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}
	
	/* Constructor 2 */
	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	/* Constructor 3 */
	public ErrorDataResult(String message) {
		super(null, false, message);
	}
	
	/* Constructor 4 */
	public ErrorDataResult() {
		super(null, false);
	}
}

/* Description:
 * -------------
 * purpose of this class is controller on data that has been token with any fault.
 * 
 * Parameters :
 * -------------
 * It has same parameters with own superclass.
 * 
 * Return:
 * None
 *  
 */
