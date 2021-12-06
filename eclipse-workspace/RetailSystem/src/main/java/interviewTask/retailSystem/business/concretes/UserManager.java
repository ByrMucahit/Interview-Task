package main.java.interviewTask.retailSystem.business.concretes;





import main.java.interviewTask.retailSystem.business.abstracts.UserService;
import main.java.interviewTask.retailSystem.core.concretes.utilities.results.DataResult;
import main.java.interviewTask.retailSystem.entites.concretes.Person;

public class UserManager implements UserService{
	
	JSONObject jo = new JSONObject();
	jo.put("name", "jon doe");
	jo.put("age", "22");
	jo.put("city", "chicago");

	ja.put(jo);

	@Override
	public DataResult<Person> personIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Person> userIdGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

}
