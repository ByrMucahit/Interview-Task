package interviewTask.retailWebSite.core.concretes.utilities.results;

import org.json.JSONObject;

public class DataResult<T> extends Result {

private T data;
	
	public DataResult(JSONObject jsonInput, boolean success, String message) {
		super(success, message);
		this.data = (T) jsonInput;
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
}
