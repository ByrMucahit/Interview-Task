package interviewTask.retailWebSite.business.abstracts;

import java.util.List;

import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface TransactionService {
	boolean payBill(JSONObject jsonInput, JSONObject jsonDiscount, int amount);
	float calculateAmountOfDiscount(int result, int discount);
	int counterOfBillPaidOverStatedYear(JSONObject jsonInput);
	DataResult<Person> counterOfDiscountBasedOnPercentage();
	String fillingBlankedField(String request, int length, String headerCharacter, int interval);
	String fillingBlankedNumberField(String request, int length);
	String fillingBlankedOptionalField(String request, String option1, String option2);
	JSONObject beAffiliated(JSONObject json);
	JSONObject changePassword(JSONObject jsonInput);
	void gettingListed(JSONObject jsonList);
	void printing(JSONObject jsonInput);
	int discountPrinter(JSONObject jsonInput);
}
