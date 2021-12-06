package interviewTask.retailWebSite.business.abstracts;

import java.text.ParseException;
import java.util.List;

import org.json.JSONObject;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface TransactionService {
	/* Services */
	boolean payBill(JSONObject jsonInput, JSONObject jsonDiscount, int amount);
	float calculateAmountOfDiscount(int result, int discount);
	long counterOfBillPaidOverStatedYear(JSONObject jsonInput) throws ParseException;
	String fillingBlankedField(String request, int length, String headerCharacter, int interval);
	String fillingBlankedNumberField(String request, int length, String headerCharacter, String phone, int interval);
	String fillingBlankedOptionalField(String request, String option1, String option2);
	JSONObject beAffiliated(JSONObject json);
	JSONObject changePassword(JSONObject jsonInput);
	void gettingListed(JSONObject jsonList);
	void printing(JSONObject jsonInput);
	SuccessDataResult<List<Person>> discountPrinter(JSONObject jsonInput,JSONObject jsonDiscount);
	String fillBlankedMailSpace(String request);
	public SuccessDataResult<List<Person>> updateJson(JSONObject jsonInput, JSONObject jsonTempInput);
	public String fillingBlankedStringField(String request);
	public String fillingBlankedTelephoneNumber(String request, JSONObject jsonInput, int length, String headerCharacter,int interval,String alternativeNumber, String check);
	public String fillingBlankedDate(String request, int length, String name);
	public String fillingMultipleSelectionDate(String request, int length, int[] name);
}
