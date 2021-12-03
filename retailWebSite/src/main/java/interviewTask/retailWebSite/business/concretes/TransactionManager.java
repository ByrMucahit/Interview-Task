package interviewTask.retailWebSite.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Person;

public class TransactionManager implements TransactionService {
	
	Controller checkpoint = new Controller();
	Scanner myObj = new Scanner(System.in);
	LocalDateTime currentDate = LocalDateTime.now();
	
	@Override
	public String payBill(JSONObject jsonInput, JSONObject jsonDiscount, int amount) {
		int tempDiscount = 0;
		int result = 0;
		
		System.out.println("Discount: "+ jsonInput +"\n" + "Object: "+ jsonDiscount+ "\n"+ "Amount: "+ amount);
		
		
		
		
		
		return null;
	}

	@Override
	public DataResult<Person> calculateAmountOfDiscount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int counterOfBillPaidOverStatedYear(JSONObject jsonInput) {
		int countOfDay= 0;
		
		if(Integer.valueOf(Integer.valueOf(jsonInput.getString("year"))- currentDate.getYear()) > 0) {
		
			countOfDay =  (Integer.valueOf(jsonInput.getString("mounth")) - currentDate.getMonthValue()) * 365;
			countOfDay += currentDate.getMonthValue()*30;
			countOfDay +=  currentDate.getDayOfMonth();
		}
		else {
			countOfDay += currentDate.getMonthValue()*30;
			countOfDay +=  currentDate.getDayOfMonth();
		}
		
		return countOfDay;
	}

	@Override
	public DataResult<Person> counterOfDiscountBasedOnPercentage() {
		
		
		return null;
	}

	@Override
	public String fillingBlankedField(String request, int length, String headerCharacter, int interval) {
		boolean flag= true;
		String response = null;
		
		while(flag) {
			System.out.println(request);
			response = myObj.nextLine();
			
			if(checkpoint.characterController(response)) {
				flag = false;
				if(length != 0 ) {
					flag = checkpoint.characterLengthController(response, length);	
					if(headerCharacter != null)
					{
						flag = checkpoint.properChartacterController(response, headerCharacter,interval);	
					}
				}
			}
		}
		return response;
	}
	
	
	@Override
	public String fillingBlankedNumberField(String request, int length) {
		boolean flag= true;
		String response = null;
		
		while(flag) {
			System.out.println(request);
			response = myObj.nextLine();
			
			if(checkpoint.stringCharacterController(response) || Integer.valueOf(response) > length) {
				flag = true;
				System.out.println("It's invalid that you have just written");
			}
			else {
				flag = false;
			}
		}
		return response;
	
		
	}

	
	

	@Override
	public String beAffiliated() {
		
		String temp = fillingBlankedField("Please ENTER social identfier. It's required. It should be consist of 11 character",11,null,0);
		
		
		return temp;
	}

	
}
