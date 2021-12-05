package interviewTask.retailWebSite;

import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
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

import interviewTask.retailWebSite.business.abstracts.CardService;
import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.abstracts.UserService;
import interviewTask.retailWebSite.business.concretes.CardManager;
import interviewTask.retailWebSite.business.concretes.TransactionManager;
import interviewTask.retailWebSite.business.concretes.UserManager;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
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
		DataResult<List<Person>> jsonUpdateTemp;
		
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
				
			} catch (JSONException e) {
                e.printStackTrace();
            }
			
			while(parentFlag){
				
				System.out.println("Persona giden json"+json);
				jsonAllData = userManager.personIdentifier(json);
				JSONObject jsonObject = new JSONObject(jsonAllData);
			
				System.out.println("first "+json);
		
				flag = true;
				while(flag) {
					String tempCustomer;
					tempCustomer = checkpoint.customerTypeControll(jsonObject);
	
						System.out.println("What would you like to do ?\n"+
								"1. View Account Detail\n"+
								"2. Paying Bill\n"+
								"3. Change Password\n"+
								"4."+" "+tempCustomer+"\n"+
								"5. Remove Account\n"+
								"6. All Customer FOR TESTING\n"+
								"7. Change Card\n"+
								"8. Exit");
					System.out.println("Please Choose it:\n-->");
					response = myObj.nextLine();
					
					switch(response) {
						case "1":
							transactionManager.printing(jsonObject);
							System.out.println("jsonObject from case 1"+ jsonObject);
							flag= true;
							break;
							
						case "2":
							amount = transactionManager.fillingBlankedNumberField("Please enter something that how much money you want to paying ?",0,null,null, 0);
							
							JSONObject discountObject = new JSONObject();
							
							discountObject = checkpoint.discountController(jsonObject);
							System.out.println("FROM MENU"+" "+discountObject);
							int tempIndex = 0;

					
							
							System.out.println("JSON OBJECT CASE 2 "+jsonObject);
							tempIndex = transactionManager.discountPrinter(discountObject);
							
							flag = transactionManager.payBill(jsonObject,discountObject.getJSONArray("discount").getJSONObject(tempIndex), Integer.valueOf(amount));
							flag= true;
							break;
							
						case "3":
						
							JSONObject tempJSON = new JSONObject();
							tempJSON = transactionManager.changePassword(jsonObject);
							jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("cardPassword", tempJSON.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword"));
							flag= true;
							/*jRootArray.put(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")));*/
							json.put("data", jsonObject.getJSONObject("data").getJSONArray("data"));
							break;
							
						case "4":
							
							tempJSON = transactionManager.beAffiliated(jsonObject);
						
							jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer", tempJSON.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer"));
							flag= true;
							jRootArray.put(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")));
							json.put("data", jsonObject.getJSONObject("data").getJSONArray("data"));
							break;
							
						case "5":
							DataResult<List<Person>> tempJson ;
							tempJson = userManager.userRemoving(jsonObject);
							JSONObject removedTempJSON = new JSONObject(tempJson);
							System.out.println(removedTempJSON);
							flag = false;
							json.put("data", jsonObject.getJSONObject("data").getJSONArray("data"));
							break;
						
						case "6":
						
							System.out.println("All:"+" "+jsonObject);
							
							transactionManager.gettingListed(jsonObject);
							
							flag = true;
							
							break;
							
						case "7":
							System.out.println("Change to Card");
							DataResult<List<Person>> tempData;
							
							CardService cardManager = new CardManager(); 
							tempData = cardManager.changeYourCard(jsonObject);
							
							JSONObject jsontempObject = new JSONObject(tempData);
							System.out.println("Change to card "+jsontempObject);
						
							json.getJSONArray("data").getJSONObject(jsontempObject.getInt("userId")).put("typeOfCard",jsontempObject.getJSONObject("data").getString("typeOfCard"));
							json.getJSONArray("data").getJSONObject(jsontempObject.getInt("userId")).put("percentageOfDiscount",jsontempObject.getJSONObject("data").getString("percentageOfDiscount"));
							flag = true;
							System.out.println("json from menu"+json);
						
							
							break;
						case "8":
							System.out.println("See u soon, By By");
							flag = false;
							
							
						default:
							System.out.println("Invalid Selection");
							break;
					}
					
					System.out.println("Response:"+response);
				}
				
				System.out.println("json in"+json);
				response = transactionManager.fillingBlankedNumberField("Please, press 1 for continue.",1,null,null,0);
				if(response.equals("1")){
					parentFlag= true;
				}
				else {
					parentFlag= false;
				}
			}
			
			
		
		
	}
}
