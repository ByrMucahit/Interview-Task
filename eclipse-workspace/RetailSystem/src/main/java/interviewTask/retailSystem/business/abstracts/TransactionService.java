package main.java.interviewTask.retailSystem.business.abstracts;

import main.java.interviewTask.retailSystem.core.concretes.utilities.results.DataResult;
import main.java.interviewTask.retailSystem.entites.concretes.Person;

public interface TransactionService {
	DataResult<Person> payBill();
	DataResult<Person> calculateAmountOfDiscount();
	DataResult<Person> counterOfBillPaidOverStatedYear();
	DataResult<Person> counterOfDiscountBasedOnPercentage();
}
