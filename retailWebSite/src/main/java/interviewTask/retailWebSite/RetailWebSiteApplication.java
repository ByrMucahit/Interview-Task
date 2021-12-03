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
import java.util.Map;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.abstracts.UserService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;
import interviewTask.retailWebSite.business.concretes.UserManager;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.Customer;
import interviewTask.retailWebSite.entities.concretes.GoldCard;
import interviewTask.retailWebSite.entities.concretes.Person;



@SpringBootApplication
public class RetailWebSiteApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RetailWebSiteApplication.class, args);
		boolean flag = true;
		String response;
		String message;
		String amount ;
		
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
			jInnerObject.put("typeOfCustomer","affiliated");
			jInnerObject.put("typeOfCard","GOLDEN");
			jInnerObject.put("year","2018");
			jInnerObject.put("mounth","10");
			jInnerObject.put("day","20");
			jRootArray.put(jInnerObject);
			json.put("data", jRootArray);
				
				
					
						
					/*
							JSONObject jInnerObject2 = new JSONObject();
							jInnerObject2.put("personId","null");
							jInnerObject2.put("personName","null");
							jInnerObject2.put("personSurname","null");
							jInnerObject2.put("personMail","null");
							jInnerObject2.put("personTelephoneNumber","null");
							jInnerObject2.put("personAlternativeTelephoneNumber","null");
							jInnerObject2.put("personAddress","null");
							jInnerObject2.put("cardId","null");
							jInnerObject2.put("cardNumber","null");
							jInnerObject2.put("cardSecurityNumber","null");
							jInnerObject2.put("percentageOfDiscount","null");
							jInnerObject2.put("cardPassword","null");
							jInnerObject2.put("amountOfDiscountUsage ","null");
							jRootArray.put(jInnerObject2);
							json.put("data", jRootArray);
						
							
							JSONObject jInnerObject3 = new JSONObject();
							jInnerObject3.put("personId","null");
							jInnerObject3.put("personName","null");
							jInnerObject3.put("personSurname","null");
							jInnerObject3.put("personMail","null");
							jInnerObject3.put("personTelephoneNumber","null");
							jInnerObject3.put("personAlternativeTelephoneNumber","null");
							jInnerObject3.put("personAddress","null");
							jInnerObject3.put("cardId","null");
							jInnerObject3.put("cardNumber","null");
							jInnerObject3.put("cardSecurityNumber","null");
							jInnerObject3.put("percentageOfDiscount","null");
							jInnerObject3.put("cardPassword","null");
							jInnerObject3.put("amountOfDiscountUsage ","null");
							jRootArray.put(jInnerObject3);
							json.put("data", jRootArray);
					
					*/
					
					/*if(json.getJSONArray("data") != null) {
						json.put("data", jRootArray);
					}*/
				
				System.out.println(json.toString());
				
				
			} catch (JSONException e) {
                e.printStackTrace();
            }
			
			
			 
			/*message = userManager.personIdentifier(json);
			System.out.println("message: "+ message);*/
			
			
				while(flag) {
					System.out.println("What would you like to do ?\n"+
										"1. View Account Detail\n"+
										"2. Paying Bill\n"+
										"3. Change Password\n"+
										"4. Be Affiliated\n"+
										"5. Remove Account\n"+
										"6. Exit");
					
					System.out.println("Please Choose it:\n-->");
					response = myObj.nextLine();
					
					switch(response) {
						case "1":
							System.out.println("Your account Detail");
							System.out.println("Your Full Name  is: "+ json.getJSONArray("data").getJSONObject(0).getString("personName").toUpperCase()+" "+ json.getJSONArray("data").getJSONObject(0).getString("personSurname").toUpperCase()+"\n"+
												"Your Id: "+ json.getJSONArray("data").getJSONObject(0).getString("personId")+"\n"+
												"Your Mail: "+ json.getJSONArray("data").getJSONObject(0).getString("personMail") +"\n"+
												"Your Telephone Number: "+ json.getJSONArray("data").getJSONObject(0).getString("personTelephoneNumber") +"\n"+
												"Alternative Telephone Number: "+ json.getJSONArray("data").getJSONObject(0).getString("personAlternativeTelephoneNumber") +"\n"+
												"Your Address: "+ json.getJSONArray("data").getJSONObject(0).getString("personAddress") +"\n"+
												"Card Id: "+  json.getJSONArray("data").getJSONObject(0).getString("cardId") +"\n"+
												"Card Number:"+ json.getJSONArray("data").getJSONObject(0).getString("cardNumber") +"\n"+
												"Card Security Number:"+ json.getJSONArray("data").getJSONObject(0).getString("cardSecurityNumber") +"\n"+
												"Your Percenatage Of Discount: "+ json.getJSONArray("data").getJSONObject(0).getString("percentageOfDiscount") +"\n"+
												"Card Password: "+ json.getJSONArray("data").getJSONObject(0).getString("cardPassword") +"\n"+
												"Amount Of Discount Usage: "+ json.getJSONArray("data").getJSONObject(0).getString("amountOfDiscountUsage") +"\n"			
									);
							
							
							break;
							
						case "2":
							
							
							
							System.out.println("Account owner is :"+ json.getJSONArray("data").getJSONObject(0).getString("personName").toUpperCase()+" "+ json.getJSONArray("data").getJSONObject(0).getString("personSurname").toUpperCase());
							
							
							amount = transactionManager.fillingBlankedField("Please enter something that how much money you want to paying ?",0, null,0);
							
							JSONObject discountObject = new JSONObject();
							discountObject = checkpoint.discountController(json.getJSONArray("data").getJSONObject(0));
							
							
							
							int tempIndex = 0;
							for(int i = 0; i < discountObject.getJSONArray("discount").length(); i++) {
								
								System.out.println(i+".:"+" "+ discountObject.getJSONArray("discount").getJSONObject(i)+"%");
							}
							
							
							System.out.println("You're enable selection to discount as shown abow. Please enter number. Don't Forget YOU CAN USE ONLY ONE.");
							response = myObj.nextLine();
							tempIndex = Integer.valueOf(response);
							System.out.println("YOU HAVE SELECTED: "+ discountObject.getJSONArray("discount").getJSONObject(tempIndex));
							
							transactionManager.payBill(json.getJSONArray("data").getJSONObject(0),discountObject.getJSONArray("discount").getJSONObject(tempIndex), Integer.valueOf(amount));
							break;
							
						case "3":
							System.out.println("Change password");
							break;
							
						case "4":
							System.out.println("Be Affiliated");
							break;
							
						case "5":
							System.out.println("Remove Account");
							break;
							
						case "6":
							System.out.println("Exit");
							break;
							
						default:
							System.out.println("Invalid Selection");
							break;
					}
					
					System.out.println("Response:"+response);
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
