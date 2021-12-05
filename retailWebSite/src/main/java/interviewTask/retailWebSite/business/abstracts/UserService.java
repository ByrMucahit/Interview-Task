package interviewTask.retailWebSite.business.abstracts;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface UserService {
	/* Services */
	DataResult<List<Person>> personIdentifier(JSONObject jsonInput);
	String userIdGenerator(JSONObject jsonInput);
	DataResult<List<Person>> userRemoving(JSONObject jsonInput);
}
