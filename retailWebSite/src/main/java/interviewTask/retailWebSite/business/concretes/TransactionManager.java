package interviewTask.retailWebSite.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
import interviewTask.retailWebSite.entities.concretes.Person;


public class TransactionManager implements TransactionService {
	
	
	Controller checkpoint = new Controller();
	Scanner myObj = new Scanner(System.in);
	LocalDateTime currentDate = LocalDateTime.now();
	
	 final int daylimit=31;//final variable  
	 final int mountlimit=12;//final variable  
	 final int yearLimit=currentDate.getYear();//final variable  
	
	@Override
	public boolean payBill(JSONObject jsonObject, JSONObject jsonDiscount, int amount) {
		int tempDiscount = 0 ;
		JSONObject jsonTemp;
		boolean flag;
		float greaterThan=0;
		float amountOfDiscount = 0;
	    String yesNoFlag;
		int result= amount;
		
	
			
	
		
	
		tempDiscount = Integer.valueOf(jsonDiscount.getString("indirim"));
		
			System.out.println("--- PAYMENT SUMMARY---");
			System.out.println("-----------------------");
			System.out.println("--> amount is :"+ amount+" "+"$");
			if(tempDiscount == 5) {
				
				jsonObject.put("mounth", String.valueOf(currentDate.getMonthValue()));
				jsonObject.put("year", String.valueOf(currentDate.getYear()));
				jsonObject.put("day", String.valueOf(currentDate.getDayOfMonth()));
				result -= tempDiscount; 
				System.out.println("You have been our customer: "+ jsonObject);
			}
			else if(tempDiscount == 20 || tempDiscount == 30 || tempDiscount == 10) {
						int tempResult = 0;
				
						tempResult = (amount*(100 - tempDiscount))/100;
					   
					    System.out.println("--> Dear"+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personName")+" "+"You have"+" "+ 
					                        jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCard")+" "+"CARD");
						System.out.println("--> Applied Discount is:"+" "+tempDiscount+"%");
						
						
						result = tempResult;
				
				}
			/* If  Amount is greater than 200 */
			flag = checkpoint.amountOfBillController(result);
			
			if(flag) {
				
				
				greaterThan = calculateAmountOfDiscount(amount, 200);
				
				System.out.println("--> Your bill is greater than 200 then you gain"+" "+greaterThan+" "+"count "+" discount"+", "+ greaterThan*5+"$"+" "+"will have been identified your bill");
				result -= (greaterThan*5);
				
			}
			
			System.out.println("--> amount paid is :"+ result+"$" );
			System.out.println("--> Lefted your discount is: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("amountOfDiscountUsage"));
			System.out.println("-----------------------");
			
			return true;
		}
		
	

	

	@Override
	public float calculateAmountOfDiscount(int result, int discount) {
		
		float temp;
		
		temp = result / discount;
		return temp;
	}

	@Override
	public int counterOfBillPaidOverStatedYear(JSONObject jsonObject) {
		int countOfDay= 0;
		
		if(Integer.valueOf(Integer.valueOf(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("year"))- currentDate.getYear()) > 0) {
		
			countOfDay =  (Integer.valueOf(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("mounth")) - currentDate.getMonthValue()) * 365;
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
				
				if(length != 0 ) {
					flag = checkpoint.characterLengthController(response, length);	
					if(!flag) {
						flagNumber += 1;
					}
					else {
						System.out.println("Please, enter proper input correctly. ");
					}
					
				
				}
				else {
					flagNumber += 2;
				}
				
			}
			else {
				System.out.println("Please, You can not left blank.");
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
	public String fillingBlankedNumberField(String request, int length, String phone, String headerCharacter, int interval) {
		boolean flag= true;
		String response = null;
		int flagNumber;
		
		while(flag) {
			flagNumber = 0;
			
			System.out.println(request);
			response = myObj.nextLine();
			System.out.println("response: "+response);
			
			
			if( checkpoint.characterController(response)) {
				if(checkpoint.stringCharacterController(response)) {
					System.out.println("It's invalid that you have just written. It has just integer value");
				}
				else {
					flag = false;
					
				}
				
				if(length != 0)
				{
					
			
					if(response.length() > length || response.length() < length) {	
					System.out.println("Input should consist of"+" "+length+" "+ "character");
					flagNumber -= 1;
					flag= true;
					
					}
				}
				else {
					flagNumber += 1;
					
					if(headerCharacter != null)
					{
						flag = checkpoint.properChartacterController(response, headerCharacter,interval);
						if(!flag) {
							flag = false;
						}
						else {
							System.out.println("Warning! Please enter correctly.");
							flag= true;
						}
					}
					
				
					
				}	
			}
			else {
				flag = true;
			}
		
		}
		return response;
	
		
	}

	
	

	@Override
	public JSONObject beAffiliated(JSONObject jsonObject) {
		
		boolean flag;
		
		
		flag = checkpoint.customerController(jsonObject);
		
		if(flag)
		{
			System.out.println("You have been customer");
			jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer","null");
		}
		else {
			String temp = fillingBlankedNumberField("Please ENTER social identfier. It's required. It should be consist of 11 character",11, null, null, 0);
			System.out.println("You have been affiliated");
			jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("socialIdentityNumber",temp);
			jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer","affiliated");
			System.out.println("You're afailated");
		}
		
		
		return jsonObject;
	}
	
	
	

	@Override
	public JSONObject changePassword(JSONObject jsonObject) {
		String response ;
		String tempResponse;
		boolean flag;
		
		response = fillingBlankedNumberField("Please enter current password?",4, null, null, 0);
		flag = checkpoint.passwordController(response, jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword"));
		if(flag) {
			
			response = fillingBlankedNumberField("Please enter new password",4,null, null, 0);
			tempResponse = fillingBlankedNumberField("Please enter new password again",4,null, null, 0);
			flag = checkpoint.passwordController(response, tempResponse);
			
			if(flag) {
				
			
			if(checkpoint.passwordController(response,jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword")))
				System.out.println("Password could not be same with previous password, Password hasn't been changed");
			
			else {
				
				jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("cardPassword", response);
				System.out.println("Password has been changed. You can check it out in account detail.");
			}
			
			}
			else {
				System.out.println("You should enter both password correctly.");
			}
		}
		else {
			System.out.println("You have entered password not corectly.");
		}
		
		return jsonObject;
		
	}

	@Override
	public String fillingBlankedOptionalField(String request, String option1, String option2) {
		boolean flag= true;
		String response = null;
		while(flag) {
			
			System.out.println(request);
			response = myObj.nextLine().toUpperCase();
			
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
	
	@Override
	public String fillingBlankedStringField(String request) {
		boolean flag= true;
		String response = null;
		int flagNumber ;
		
		while(flag) {
			flagNumber = 0;
			System.out.println(request);
			response = myObj.nextLine();
			
			if(checkpoint.stringCharacterController(response)) {
				flag = false;
			}
			else {
				System.out.println("This Field can not be included number, please enter suitable something");
				flag = true;
				
			}

		}
		return response;
		
	}





	@Override
	public void gettingListed(JSONObject jsonObject) {
		System.out.println("----------------------------------");
		System.out.println("##### ALL CUSTOMER #####");
		System.out.println("All Account Detail");
		
			
			System.out.println("Your account Detail  "+jsonObject.getJSONObject("data").getJSONArray("data").length());
			
			for(int i = 0 ; i < jsonObject.getJSONObject("data").getJSONArray("data").length(); i++) {
				System.out.println("-> Person Full Name"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personName")+
								   " "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personSurname")+"\n"+
						           "-> Person Id"+":"+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personId")+"\n"+
								   "-> Person Mail"+":"+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personMail")+"\n"+
								   "-> Person Telephone Number"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber")+"\n"+
								   "-> Person Alternative Telephone Number"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personAlternativeTelephoneNumber")+"\n"+
								   "-> Person Address"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personAddress")+"\n"+
								   "-> Person Card Id"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("cardId")+"\n"+
								   "-> Person Card Number"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("cardNumber")+"\n"+
								   "-> Person Card Security Number:"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("cardSecurityNumber")+"\n"+
								   "-> Vary Of Customer"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("typeOfCustomer")+"\n"+
								   "-> Vary Of Card"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("typeOfCard")+"\n"+
								   "-> Date Of Been Customer"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("year")+"/"+
								   jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("mounth")+"/"+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("day")
								   );
				System.out.println("--------------------------------------------");
			}
		
		
	
		
	}





	@Override
	public void printing(JSONObject jsonObject) {
		
		System.out.println("------Your account Detail-----");
		System.out.println( "* Your Full Name  is: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personName").toUpperCase()+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personSurname").toUpperCase()+"\n"+
							"* Your Id: "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personId")+"\n"+
							"* Your Mail: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personMail") +"\n"+
							"* Your Telephone Number: "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personTelephoneNumber") +"\n"+
							"* Alternative Telephone Number: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personAlternativeTelephoneNumber") +"\n"+
							"* Your Address: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personAddress") +"\n"+
							"* Card Id: "+  jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardId") +"\n"+
							"* Card Number:"+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardNumber") +"\n"+
							"* Card Security Number:"+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardSecurityNumber") +"\n"+
							"* Your Percenatage Of Discount: "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("percentageOfDiscount") +"\n"+
							"* Card Password: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword") +"\n"+
							"* Amount Of Discount Usage: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("amountOfDiscountUsage") +"\n"+	
							"* Type Of Customer: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer") +"\n"+	
							"* Type Of Card: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCard") +"\n" +	
							"* Year: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("year") +"\n"+	
							"* Mounth: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("mounth") +"\n"+	
							"* Day: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("day") +"\n"	
							);
		
		if(!jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("socialIdentityNumber").equals("null")){
				System.out.println("Social Identity: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("socialIdentityNumber"));
		}
		
		System.out.println("-------------------------------------");
		
	}





	@Override
	public int discountPrinter(JSONObject discountObject) {
		String tempTypeOfDiscount= "";
		String response;
		int tempIndex= 0;
		boolean flag;
		int [] selection = new int[discountObject.getJSONArray("discount").length()];
		System.out.println("FROM DISCOUNT PRINTER"+" "+ discountObject);
		if(!discountObject.getJSONArray("discount").getJSONObject(0).getString("indirim").equals("0"))
		{
			for(int i = 0; i < discountObject.getJSONArray("discount").length(); i++) {
				if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 10) {
					System.out.println(i+".:"+" You're the affiliated that's why YOU CAN USE"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
					tempTypeOfDiscount= "DICOUNT FOR BEING AFFILIATED ";
				}
				else if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 30) {
					System.out.println(i+".:"+" You have GOLDEN CARD that's why YOU CAN USE"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
					tempTypeOfDiscount= "DICOUNT FOR YOU HAVE GOLDEN CARD ";
				}
				
				else if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 20) {
					System.out.println(i+".:"+" You have SILVER CARD that's why YOU CAN USE"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
					tempTypeOfDiscount= "DICOUNT FOR YOU SILVER CARD ";
				}
				
			}
			
			for(int i = 0 ; i< discountObject.getJSONArray("discount").length(); i++) {
				selection[i] = i;
				System.out.println("DİZİ"+" "+selection[i]);
			}
			System.out.println("SELECTION FROM DISCOUNT PRINTER"+" "+selection[0]);
			response = fillingMultipleSelectionDate("You're enable selection to discount as shown abow. Please enter number. Don't Forget YOU CAN USE ONLY ONE.",1,selection);
			
			
			tempIndex = Integer.valueOf(response);
			System.out.println("YOU HAVE SELECTED: "+" "+tempIndex+"."+" "+ tempTypeOfDiscount +discountObject.getJSONArray("discount").getJSONObject(tempIndex));
			return tempIndex;
		}
		else{
			System.out.println("There is no discount");
			return 0;
		}
		
	}

	@Override
	public String fillingMultipleSelectionDate(String request, int length, int[] name) {
		
		boolean flag= true;
		String response = null;
		int flagNumber ;
		flagNumber = 0;
		while(flag) {
			
			System.out.println(request);
			response = myObj.nextLine();
			
			if(!checkpoint.characterController(response)) {
				flag = true;
			}
			else {
		
			
			if(Integer.valueOf(response) == name[flagNumber]) {
				flag = false;
			}
			else if(Integer.valueOf(response) < name[flagNumber]) {
				flag = true;
				flagNumber += 1;
				
			}

		}
			
			if(flagNumber == name.length) {
				flag = false;
			}
		}
		return response;
	}




	@Override
	public String fillBlankedMailSpace(String request) {
		boolean flag= true;
		String response = null;
		int flagNumber ;
		
		while(flag) {
			flagNumber = 0;
			System.out.println(request);
			response = myObj.nextLine();
			System.out.println("from mail controller"+" "+response);
			
		if( checkpoint.characterController(response)) {
			flag = true;
		}
		else {
			
		
			if(checkpoint.emailController(response)) {
				flag = false;
			}
			else {
				flag = true;
				System.out.println("Please, enter your mail as *******@****.com");
			}

			}
		}
		return response;
	
	}





	@Override
	public SuccessDataResult<List<Person>> updateJson(JSONObject jsonInput, JSONObject jsonTempInput) {
		
		System.out.println("TEMP JSON FROM UPDATE JSON"+jsonTempInput);
		System.out.println("JSON FROM UPDATE JSON"+jsonInput);
		
	
		jsonInput.getJSONArray("data").getJSONObject(jsonTempInput.getInt("userId")).put("typeOfCard",jsonTempInput.getJSONObject("data").getString("typeOfCard"));
		jsonInput.getJSONArray("data").getJSONObject(jsonTempInput.getInt("userId")).put("percentageOfDiscount",jsonTempInput.getJSONObject("data").getString("percentageOfDiscount"));
		
		System.out.println("JSON UPDATE:"+" "+jsonInput);
		return new SuccessDataResult<List<Person>> 
				(jsonInput,jsonTempInput.getInt("userId"),"Change has been done successfully" ) ;
	}





	@Override
	public String fillingBlankedTelephoneNumber(String request, JSONObject jsonInput, int length, String headerCharacter, int interval, String alternativeNumber,String check) {
		boolean flag= true;
		String response = null;
		int flagNumber;
		
		while(flag) {
			flagNumber = 0;
			
			System.out.println(request);
			response = myObj.nextLine();
			System.out.println("response: "+response);
			
			
			if( checkpoint.characterController(response)) {
				if(checkpoint.stringCharacterController(response)) {
					System.out.println("It's invalid that you have just written. It has just integer value");
					flag = true;
				}
				else {
					flag = false;
					
					if(response.length() != length && length != 0) {	
						System.out.println("Input should consist of"+" "+length+" "+ "character");
						flagNumber -= 1;
						flag= true;
						
					}
					else {
						flagNumber += 1;
						flag= false;
						if(headerCharacter != null)
						{
							flag = checkpoint.properChartacterController(response, headerCharacter,interval);
							if(!flag) {
								flag = false;
							}
							else {
								System.out.println("Warning! Please enter correctly.");
								flag= true;
							}
						}
						if(!check.equals("null"))
						{
						if(checkpoint.phoneController(jsonInput, response, alternativeNumber)) {
							flag = false;
						}
						else {
							flag= true;
						}
						}
					
						
					}	
					
				}
			
			}
			else {
				flag = true;
			}
		
		}
		return response;
	}





	@Override
	public String fillingBlankedDate(String request,int length, String name) {
		boolean flag= true;
		String response = null;
		int flagNumber;
		
		while(flag) {
			flagNumber = 0;
			
			System.out.println(request);
			response = myObj.nextLine();
			System.out.println("response: "+response);
			
			
			if( checkpoint.characterController(response)) {
				if(checkpoint.stringCharacterController(response)) {
					System.out.println("It's invalid that you have just written. It has just integer value");
					flag = true;
				}
				else {
					flag = false;
					
					if(response.length() >= length && length != 0) {	
						System.out.println("Input should consist of"+" "+(length-1)+" "+ "character");
						flagNumber -= 1;
						flag= true;
						
					}
					else {
						if(checkpoint.dateController(response, name))
						{
							flagNumber += 1;
							flag= false;
						}
						else {
							flag = true;
						}
					
						
					}	
					
				}
			
			}
			else {
				flag = true;
			}
		
		}
		return response;
	}
}
