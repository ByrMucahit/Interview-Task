package interviewTask.retailWebSite.core.concretes.utilities.results;

public class Result {

	/* Common Variable*/
	private boolean success;
	private String message;
	
	/* Constructor */
	public Result(boolean success) {
		this.success = success;
	}
	
	/* Constructor 2 */
	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
	
	/* Is Success */
	public boolean isSuccess() {
		return this.success;
	}
	
	/* Message */
	public String getMesage() {
		return this.message;
	}
}

/*
 * Description:
 * -------------
 * It's a superclass that is controller while taking data. It has two option for response to who wants getting data as show below;
 * 1. It can send just boolean value named success;
 * 2. It can send either boolean value named success ,and string value named message. 
 * 
 * Parameters:
 * -------------
 * success: It's boolean value such as flag. It can be either getting true when something happened successfully and getting false when something happened fault.
 * message: It's a string value. It can included message related happening.
 * 
 * Return:
 * -----------
 * this.success: It's a boolean value. It can be true or false.
 * this.message: It's a string value. It can be any string value, It's being generally warning.
 *  */
