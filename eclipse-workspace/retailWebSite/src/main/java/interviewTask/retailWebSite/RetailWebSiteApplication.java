package interviewTask.retailWebSite;

import java.util.Scanner;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import interviewTask.retailWebSite.business.abstracts.CardService;
import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.abstracts.UserService;
import interviewTask.retailWebSite.business.concretes.CardManager;
import interviewTask.retailWebSite.business.concretes.TransactionManager;
import interviewTask.retailWebSite.business.concretes.UserManager;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;

import interviewTask.retailWebSite.entities.concretes.Person;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class RetailWebSiteApplication {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(RetailWebSiteApplication.class, args);
		/* Common Variable */
		/* State Controll Flag */
		boolean flag = true;
		boolean parentFlag = true;
		/* It's used for getting data from user */
		String response;
		/* It keeps that percentage of discount */
		String amount ;
		/* Data is returned as object named DataResult. */
		DataResult<List<Person>> jsonAllData;
	
		/* Transaction Of Releated User */
		UserService userManager = new UserManager();
		/* Transaction Of Releated Card*/
		CardService cardManager = new CardManager(); 
		/*Input */
		Scanner myObj = new Scanner(System.in);
		/* State Controll Unit */
		Controller checkpoint = new Controller();
		/* All Transaction */
		TransactionService transactionManager = new TransactionManager();
		 
		/* DataResult is converted from JAVA object to JSON object */
		JSONObject json = new JSONObject();
		JSONArray jRootArray = new JSONArray();
		
		
		try {
			/* Test */
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
			
				/* MENU */
				while(parentFlag){
					/* Register */
					jsonAllData = userManager.personIdentifier(json);
					/* Convert JAVA object to JSON Object */
					JSONObject jsonObject = new JSONObject(jsonAllData);
					
					/* If User want to continue to doing something */
					flag = true;
					
					/* After Registered */
					while(flag) {
						/* It can changed while changing type of customer */
						String tempCustomer;
						/* Check Type Of Customer Out */
						tempCustomer = checkpoint.customerTypeControll(jsonObject);
							/* Menu List */
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
					/* Transaction on List */
					switch(response) {
						/* View Of Profile Detail Such as Profile Page */
						case "1":
							/* Print All */
							transactionManager.printing(jsonObject);
							/* Back to Menu Page */
							flag= true;
							break;
							
						case "2":
							/* Input */
							amount = transactionManager.fillingBlankedNumberField("Please enter something that how much money you want to paying ?",0,null,null, 0);
							/* Json Object to variable can accept object from controller */
							JSONObject discountObject = new JSONObject();
							/* Discount Controller */
							discountObject = checkpoint.discountController(jsonObject);
							/* It keeps value that is type of discount User has choosen */
							int tempIndex = 0;

							/* All discount user deserved is printed */
							tempIndex = transactionManager.discountPrinter(discountObject);
							/* Paying Bill */
							flag = transactionManager.payBill(jsonObject,discountObject.getJSONArray("discount").getJSONObject(tempIndex), Integer.valueOf(amount));
							/* Back to Menu */
							flag= true;
							break;
							
						case "3":
							/*JSON Object */
							JSONObject tempJSON = new JSONObject();
							/* Password changing processing */
							tempJSON = transactionManager.changePassword(jsonObject);
							/* Update JSON */
							jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("cardPassword", tempJSON.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword"));
							/* Update main JSON */
							json.put("data", jsonObject.getJSONObject("data").getJSONArray("data"));
							/* Back to Main Page */
							flag= true;
							break;
							
						case "4":
							/* Type of Customer Changing */
							tempJSON = transactionManager.beAffiliated(jsonObject);
							/* Iterate JSON updating */
							jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer", tempJSON.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer"));
							/* JSON Array is updated */
							jRootArray.put(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")));
							/* Main JSON object is updated */
							json.put("data", jsonObject.getJSONObject("data").getJSONArray("data"));
							/* Back to menu page */
							flag= true;
							break;
							
						case "5":
							/* JAVA object keeps Object */
							DataResult<List<Person>> tempJson ;
							/* User removing transaction */
							tempJson = userManager.userRemoving(jsonObject);
							/* Convert from JAVA Object to JSON Object */
							JSONObject removedTempJSON = new JSONObject(tempJson);
							/* Main object updating */
							json.put("data", jsonObject.getJSONObject("data").getJSONArray("data"));
							/* Exit */
							flag = false;
							break;
						
						case "6":
						    /* All Account Listed */
							transactionManager.gettingListed(jsonObject);
							/* Back to list */
							flag = true;
							break;
							
						case "7":
							/* JAVA Object is used for keeps data that is returned */
							DataResult<List<Person>> tempData;
							/* Card changing transaction */
							tempData = cardManager.changeYourCard(jsonObject);
							/* Convert from JAVA object to JSON Object */
							JSONObject jsontempObject = new JSONObject(tempData);
							/* Main JSON Updating */
							json.getJSONArray("data").getJSONObject(jsontempObject.getInt("userId")).put("typeOfCard",jsontempObject.getJSONObject("data").getString("typeOfCard"));
							json.getJSONArray("data").getJSONObject(jsontempObject.getInt("userId")).put("percentageOfDiscount",jsontempObject.getJSONObject("data").getString("percentageOfDiscount"));
							/* Back to Main */
							flag = true;	
							break;
							
						case "8":
							System.out.println("See u soon, By By");
							/* Exit */
							flag = false;
							
						default:
							/* If User press nothing */
							System.out.println("Invalid Selection");
							break;
							
					}
				}
				/* If user want to continue */
				response = transactionManager.fillingBlankedNumberField("Please, press 1 for continue.",1,null,null,0);
				if(response.equals("1")){
					/* To continue */
					parentFlag= true;
				}
				else {
					/* Exit completely */
					parentFlag= false;
					}
				}	
			} catch (JSONException e) {
                e.printStackTrace();
			}
		}
	}
