package interviewTask.retailWebSite.business.abstracts;

import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public interface TransactionService {
	DataResult<Person> payBill();
	DataResult<Person> calculateAmountOfDiscount();
	DataResult<Person> counterOfBillPaidOverStatedYear();
	DataResult<Person> counterOfDiscountBasedOnPercentage();
	String fillingBlankedField(String request, int length, String headerCharacter);

}
