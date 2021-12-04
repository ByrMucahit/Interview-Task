package interviewTask.retailWebSite;

import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.abstracts.UserService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;
import interviewTask.retailWebSite.business.concretes.UserManager;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.Customer;
import interviewTask.retailWebSite.entities.concretes.GoldCard;
import interviewTask.retailWebSite.entities.concretes.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.google.gson.Gson;    

@SpringBootApplication
public class RetailWebSiteApplication {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(RetailWebSiteApplication.class, args);
		boolean flag = true;
		boolean parentFlag = true;
		String response;
		String message;
		String amount ;
		DataResult<List<Person>> jsonAllData;
		DataResult<List<Person>> jsonTemp;
		
		UserService userManager = new UserManager();
		Scanner myObj = new Scanner(System.in);
		LocalDateTime currentDate = LocalDateTime.now();
		Controller checkpoint = new Controller();
		TransactionService transactionManager = new TransactionManager();
		 
		
		JSONObject json = new JSONObject();
		JSONArray jRootArray = new JSONArray();
			
		try {
			JSONObject jInnerObject = new JSONObject();
			jInnerObject.put("personId","12");
			jInnerObject.put("personName","mucahit");
			jInnerObject.put("personSurname","bayar");
			jInnerObject.put("personMail","m.mucahitbayar@gmail.com");
			jInnerObject.put("personTelephoneNumber","05435446158");
			jInnerObject.put("personAlternativeTelephoneNumber","05433654751");
			jInnerObject.put("personAddress","çay çıkmazı");
			jInnerObject.put("cardId","21");
			jInnerObject.put("cardNumber","4562 1234 7894 1235");
			jInnerObject.put("cardSecurityNumber","432");
			jInnerObject.put("percentageOfDiscount","30");
			jInnerObject.put("cardPassword","1453");
			jInnerObject.put("amountOfDiscountUsage","1");
			jInnerObject.put("typeOfCustomer","Customer");
			jInnerObject.put("typeOfCard","GOLDCARD");
			jInnerObject.put("year","2018");
			jInnerObject.put("mounth","10");
			jInnerObject.put("day","20");
			jInnerObject.put("device","phone");
			jInnerObject.put("socialIdentityNumber","null");
			jRootArray.put(jInnerObject);
			json.put("data", jRootArray);
				
				
					
						
					
							JSONObject jInnerObject2 = new JSONObject();
							jInnerObject2.put("personId","12");
							jInnerObject2.put("personName","mucahit");
							jInnerObject2.put("personSurname","bayar");
							jInnerObject2.put("personMail","m.mucahitbayar@gmail.com");
							jInnerObject2.put("personTelephoneNumber","05435446158");
							jInnerObject2.put("personAlternativeTelephoneNumber","05433654751");
							jInnerObject2.put("personAddress","çay çıkmazı");
							jInnerObject2.put("cardId","21");
							jInnerObject2.put("cardNumber","4562 1234 7894 1235");
							jInnerObject2.put("cardSecurityNumber","432");
							jInnerObject2.put("percentageOfDiscount","30");
							jInnerObject2.put("cardPassword","1453");
							jInnerObject2.put("amountOfDiscountUsage","1");
							jInnerObject2.put("typeOfCustomer","Customer");
							jInnerObject2.put("typeOfCard","SILVERCARD");
							jInnerObject2.put("year","2018");
							jInnerObject2.put("mounth","10");
							jInnerObject2.put("day","20");
							jInnerObject2.put("device","phone");
							jInnerObject2.put("socialIdentityNumber","null");
							jRootArray.put(jInnerObject2);
							json.put("data", jRootArray);
						
							
						
						
					
					/*if(json.getJSONArray("data") != null) {
						json.put("data", jRootArray);
					}*/
				
		
				
				
			} catch (JSONException e) {
                e.printStackTrace();
            }
			
		
		 
			while(parentFlag){
				int userId;
				jsonAllData = userManager.personIdentifier(json);
				JSONObject jsonObject = new JSONObject(jsonAllData);
				
		
				
		
				
				
			
				
			
				flag = true;
				while(flag) {
				
					if(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer").equals("affiliated")) {
						System.out.println("What would you like to do ?\n"+
								"1. View Account Detail\n"+
								"2. Paying Bill\n"+
								"3. Change Password\n"+
								"4. Be Customer\n"+
								"5. Remove Account\n"+
								"6. All Customer FOR TESTING\n"+
								"7. Exit");
					}
					else {
						System.out.println("What would you like to do ?\n"+
								"1. View Account Detail\n"+
								"2. Paying Bill\n"+
								"3. Change Password\n"+
								"4. Be Affiliated\n"+
								"5. Remove Account\n"+
								"6. All Customer FOR TESTING\n"+
								"7. Exit");
					}
					
					System.out.println("Please Choose it:\n-->");
					response = myObj.nextLine();
					
					switch(response) {
						case "1":
							transactionManager.printing(jsonObject);
							flag= true;
							break;
							
						case "2":
							amount = transactionManager.fillingBlankedNumberField("Please enter something that how much money you want to paying ?",0);
							
							JSONObject discountObject = new JSONObject();
							discountObject = checkpoint.discountController(jsonObject);
							
							int tempIndex = 0;

							flag = transactionManager.payBill(jsonObject,discountObject.getJSONArray("discount").getJSONObject(0), Integer.valueOf(amount));
							jsonObject = new JSONObject(jsonAllData);
							
							tempIndex = transactionManager.discountPrinter(discountObject);
							
							flag = transactionManager.payBill(jsonObject,discountObject.getJSONArray("discount").getJSONObject(tempIndex), Integer.valueOf(amount));
							flag= true;
							break;
							
						case "3":
							System.out.println("Change password");
							JSONObject tempJSON = new JSONObject();
							tempJSON = transactionManager.changePassword(jsonObject);
							/*jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("cardPassword", tempJSON)*/
							/*tempJSON = new JSONObject(jsonTemp);*/
							
							/*jsonObject.put("data",tempJSON);*/
							/*jsonAllData = userManager.personIdentifier(json);
							JSONObject jsonObject = new JSONObject(jsonAllData);*/
						
							jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("cardPassword", tempJSON.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword"));
							flag= true;
							 
							break;
							
						case "4":
							System.out.println("CHANGE YOUR TYPE OF CUSTOMER");
							tempJSON = transactionManager.beAffiliated(jsonObject);
							
							jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer", tempJSON.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer"));
							flag= true;
							break;
							
						case "5":
							System.out.println("Remove Account");
							json = userManager.userRemoving(json);
							flag = false;
							break;
						
						case "6":
							System.out.println("All ACCOUNT");
							
							System.out.println("All:"+" "+jsonObject.getJSONObject("data"));
							
							transactionManager.gettingListed(jsonObject);
							
							flag = true;
							
							break;
							
						case "7":
							System.out.println("See u soon, By By");
							flag = false;
							
							break;
						case "8":
							System.out.println("Change to Card");
							flag = true;
							
						default:
							System.out.println("Invalid Selection");
							break;
					}
					
					System.out.println("Response:"+response);
				}
			
				response = transactionManager.fillingBlankedNumberField("Please, press 1 for continue.",1);
				if(response.equals("1")){
					parentFlag= true;
				}
				else {
					parentFlag= false;
				}
			}
			
		
		/*String m = "Merhaba";
		System.out.println(m.substring(0,2));*/
	
		 /*String[] elementNames = JSONObject.getNames();*/
		/*JSONObject objectInArray = jRootArray.getJSONObject("1");*/
		/*System.out.println("value : "+ json.toString());*/
			
	
		
		
	
		/*Date inputString1 = "2021 12 03";
		Date inputString2 = "2022 04 2025";

		 long diff = d2.getTime() - d1.getTime();
		 System.out.println(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));*/
			 
		
		
	}
}
