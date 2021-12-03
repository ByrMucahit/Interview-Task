package interviewTask.retailWebSite.business.abstracts;

import org.json.JSONArray;
import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface UserService {

	JSONObject personIdentifier(JSONObject jsonInput);
	String userIdGenerator(JSONObject jsonInput);
	JSONObject userRemoving(JSONObject jsonInput);
}
