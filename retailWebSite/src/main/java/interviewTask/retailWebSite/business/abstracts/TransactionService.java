package interviewTask.retailWebSite.business.abstracts;

import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface TransactionService {
	String payBill(JSONObject jsonInput, JSONObject jsonDiscount, int amount);
	DataResult<Person> calculateAmountOfDiscount();
	int counterOfBillPaidOverStatedYear(JSONObject jsonInput);
	DataResult<Person> counterOfDiscountBasedOnPercentage();
	String fillingBlankedField(String request, int length, String headerCharacter, int interval);
	String fillingBlankedNumberField(String request, int length);
	String beAffiliated();

}
