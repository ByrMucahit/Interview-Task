package interviewTask.retailWebSite.core.concretes.utilities.results;

import org.json.JSONObject;

public class SuccessDataResult<T> extends DataResult<T> {

	/* Constructor */
	public SuccessDataResult(JSONObject jsonInput, int userId, String message) {
		super(jsonInput,userId, true, message);
	}
	
	/* Constructor */
	public SuccessDataResult(JSONObject jsonInput, JSONObject jsonDiscount, int userId, String message) {
		super(jsonInput,jsonDiscount,userId, true, message);
	}
	
	/* Constructor 2*/
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	/* Constructor 3*/
	public SuccessDataResult(String message, int userId) {
		super(null,userId, true, message);
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
