package interviewTask.retailWebSite.core.concretes.utilities.results;

import org.json.JSONObject;

public class ErrorDataResult<T> extends DataResult<T>  {

	/* Constructor */
	public ErrorDataResult(JSONObject jsonInput, String message) {
		super(jsonInput, false, message);
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
