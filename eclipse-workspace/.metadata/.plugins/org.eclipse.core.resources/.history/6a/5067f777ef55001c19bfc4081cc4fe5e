package interviewTask.retailWebSite.business.abstracts;

import java.util.List;

import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface CardService {

	String cardIdGenerator(JSONObject jsonInput);
	String cardNumberGenerator(JSONObject jsonInput);
	String cardSecurityNumberGenerator(JSONObject jsonInput);
	String cardPasswordGenerator();
	boolean checkPreviousPasswordConflict(JSONObject jsonInput, String password);
	public SuccessDataResult<List<Person>>  changeYourCard(JSONObject jsonInput);
}
