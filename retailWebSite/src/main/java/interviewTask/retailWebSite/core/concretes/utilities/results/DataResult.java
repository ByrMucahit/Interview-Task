package interviewTask.retailWebSite.core.concretes.utilities.results;

import org.json.JSONObject;

public class DataResult<T> extends Result {

private T data;
private int userId;
	
	public DataResult(JSONObject jsonInput, int userId ,boolean success, String message) {
		super(success, message);
		this.data = (T) jsonInput;
		this.userId = userId;
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	
	
	public T getData() {
		return this.data;
	}
	
	public int getUserId() {
		return this.userId;
	}
}
