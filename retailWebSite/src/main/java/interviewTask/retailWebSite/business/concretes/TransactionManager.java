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
	public JSONObject payBill(JSONObject jsonInput, JSONObject jsonDiscount, int amount) {
		int tempDiscount = 0;
		JSONObject jsonTemp;
		boolean flag;
		float greaterThan=0;
		float amountOfDiscount = 0;
		System.out.println("Discount: "+ jsonDiscount  +"\n" + "Object: "+jsonInput + "\n"+ "Amount: "+ amount);
		int result= amount;
		
		System.out.println(jsonDiscount.getString("indirim"));
		tempDiscount = Integer.valueOf(jsonDiscount.getString("indirim"));
		
		if(tempDiscount == 5) {
			
			jsonInput.put("mounth", String.valueOf(currentDate.getMonthValue()));
			jsonInput.put("year", String.valueOf(currentDate.getYear()));
			jsonInput.put("day", String.valueOf(currentDate.getDayOfMonth()));
			System.out.println("long: "+ jsonInput);
		}
		
		
		flag = checkpoint.amountOfBillController(result);
		
		if(flag == true) {
			greaterThan = calculateAmountOfDiscount(result, 200);
			
			System.out.println("greater than "+ greaterThan);
			result -= (greaterThan*5);
			
		}
		
		
		
		
		System.out.println("--- PAYMENT SUMMARY---");
		System.out.println("-----------------------");
		System.out.println("--> amount is :"+ amount);
		
		if(checkpoint.deviceController(jsonInput)) {
			result = (amount*(100 - tempDiscount))/100;
			if(greaterThan != 0) {
				System.out.println("--> You're paying amount is greates than 200 that's why  also you gain :"+ (greaterThan*5));
			}
			System.out.println("--> Applied Discount is:"+ tempDiscount);
			System.out.println("--> amount paid is :"+ result +" "+"with using"+" "+ jsonInput.getString("typeOfCard")+" "+"CARD");
			System.out.println("--> Lefted your discount is: "+ jsonInput.getString("amountOfDiscountUsage"));
			System.out.println("-----------------------");
		}else {
			System.out.println("--> amount paid is :"+ result +" "+"with using"+" "+ jsonInput.getString("typeOfCard")+" "+"CARD");
			
			System.out.println("-----------------------");
		}
			
		
		return jsonInput;
	}

	@Override
	public float calculateAmountOfDiscount(int result, int discount) {
		
		float temp;
		
		temp = result / discount;
		System.out.println("temp"+ temp);
		return temp;
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
		int flagNumber ;
		
		while(flag) {
			flagNumber = 0;
			System.out.println(request);
			response = myObj.nextLine();
			
			if(checkpoint.characterController(response)) {
				flagNumber += 1;
				
			}
			else {
				System.out.println("Please, you write based on format.");
			}
			
			
			if(length != 0 ) {
				flag = checkpoint.characterLengthController(response, length);	
				if(!flag) {
					flagNumber += 1;
				}
				else {
					System.out.println("Please, enter proper input correctly. ");
				}
				
				if(headerCharacter != null)
				{
					flag = checkpoint.properChartacterController(response, headerCharacter,interval);
					if(!flag) {
						flagNumber += 1;
					}
					else {
						System.out.println("Warning! Please enter correctly.");
					}
				}
			}
			else {
				flagNumber += 2;
			}
			
			if(flagNumber == 3) {
				flag = false;
			}
			else {
				flag = true;
			}
		
		}
		return response;
	}
	
	
	@Override
	public String fillingBlankedNumberField(String request, int length) {
		boolean flag= true;
		String response = null;
		int flagNumber;
		
		while(flag) {
			flagNumber = 0;
			
			System.out.println(request);
			response = myObj.nextLine();
			System.out.println("response: "+response);
			if(checkpoint.stringCharacterController(response)) {
				System.out.println("It's invalid that you have just written. It has just integer value");
			}
			else {
				flagNumber += 1;
				
			}
			if(response.length() != length && length != 0) {	
				System.out.println("Input should consist of"+" "+length+" "+ "character");
			}
			else {
				flagNumber += 1;
				
			}
			
			if(flagNumber == 2) {
				flag = false;
			}
			else {
				flag = true;
			}
		}
		return response;
	
		
	}

	
	

	@Override
	public JSONObject beAffiliated(JSONObject json) {
		
		boolean flag;
		String temp = fillingBlankedNumberField("Please ENTER social identfier. It's required. It should be consist of 11 character",11);
		
		flag = checkpoint.customerController(json);
		
		if(flag)
		{
			System.out.println("You're already affiliated");
		}
		else {
			json.put("socialIdentityNumber",temp);
			json.put("typeOfCustomer","affiliated");
			System.out.println("You're afailated");
		}
		
		
		return json;
	}
	
	
	

	@Override
	public JSONObject changePassword(JSONObject jsonInput) {
		String response ;
		String tempResponse;
		boolean flag;
		
		response = fillingBlankedNumberField("Please enter current password?",4);
		flag = checkpoint.passwordController(response, jsonInput.getString("cardPassword"));
		if(flag) {
			
			response = fillingBlankedNumberField("Please enter new password",4);
			tempResponse = fillingBlankedNumberField("Please enter new password again",4);
			flag = checkpoint.passwordController(response, tempResponse);
			
			if(flag) {
				
			
			if(checkpoint.passwordController(response,jsonInput.getString("cardPassword")))
				System.out.println("Password could not be same with previous password, Password hasn't been changed");
			
			else {
				
				jsonInput.put("cardPassword", response);
				System.out.println("Password has been changed. You can check it out in account detail.");
			}
			
			}
			else {
				System.out.println("You shoulde enter both password correctly.");
			}
		}
		else {
			System.out.println("You have entered password not corectly.");
		}
		
		return jsonInput;
	}

	@Override
	public String fillingBlankedOptionalField(String request, String option1, String option2) {
		boolean flag= true;
		String response = null;
		int flagNumber ;
		
		while(flag) {
			flagNumber = 0;
			System.out.println(request);
			response = myObj.nextLine();
			
			if(response.equals(option1) || response.equals(option2)) {
				flag = false;
			}
			else {
				flag = true;
				System.out.println("Please input one of"+" "+option1+" "+"or"+" "+option2);
			}

		}
		return response;
		
	}
	
	
	

	
}
