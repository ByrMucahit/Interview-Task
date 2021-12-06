package interviewTask.retailWebSite.core.concretes.utilities.results;


public class ErrorResult extends Result {

	/* constructor */
	public ErrorResult() {
		super(false);
	}
	
	/* constructor 2 */
	public ErrorResult(String message) {
		super(false, message);
	}
}


/*
 * Description:
 * -------------
 * purpose of this class's fault data controller. It's derivated by superclass named Result.
 * 
 * Parameters:
 * -------------
 * It has same parameters with own superclass.
 * 
 * Return:
 * -------------
 * None
 *  */
 