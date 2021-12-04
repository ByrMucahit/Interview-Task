package interviewTask.retailWebSite.business.abstracts;

import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Card;

public interface CardService {

	String cardIdGenerator(JSONObject jsonInput);
	String cardNumberGenerator(JSONObject jsonInput);
	String cardSecurityNumberGenerator(JSONObject jsonInput);
	String cardPasswordGenerator(JSONObject jsonInput);
	boolean checkPreviousPasswordConflict(JSONObject jsonInput, String password);
}
