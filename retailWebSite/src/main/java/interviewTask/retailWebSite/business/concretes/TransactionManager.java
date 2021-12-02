package interviewTask.retailWebSite.business.concretes;

import java.util.Scanner;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public class TransactionManager implements TransactionService {
	
	Controller checkpoint = new Controller();
	Scanner myObj = new Scanner(System.in);
	
	
	@Override
	public DataResult<Person> payBill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Person> calculateAmountOfDiscount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Person> counterOfBillPaidOverStatedYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Person> counterOfDiscountBasedOnPercentage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillingBlankedField(String request, int length, String headerCharacter) {
		boolean flag= true;
		String response = null;
		
		while(flag) {
			System.out.println(request);
			response = myObj.nextLine();
			
			if(checkpoint.characterController(response)) {
				flag= false;
			}
			else {
				if(length != 0 && headerCharacter != null) {
					System.out.println("header Character"+headerCharacter);
					flag = checkpoint.characterLengthController(response, length, headerCharacter );
				}
				else {
					flag = true;
				}
				
			}
		}
		return response;
	}

}
