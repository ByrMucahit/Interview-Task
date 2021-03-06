package interviewTask.retailWebSite.business.concretes;

import java.time.LocalDate;

import java.util.List;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.CardService;
import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.abstracts.UserService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.ErrorDataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.GoldCard;
import interviewTask.retailWebSite.entities.concretes.Person;
import interviewTask.retailWebSite.entities.concretes.SilverCard;
import interviewTask.retailWebSite.entities.concretes.AffiliatedCustomer;
import interviewTask.retailWebSite.entities.concretes.Customer;

public class UserManager implements UserService {
	/* Common Variable */
	private String tempId;
	
	private String tempSocialId;
	
	private String yesNoFlag;
	int flag = 0;
	Card card;
	Person customer;
	
	/* Services */
	Scanner myObj = new Scanner(System.in);
	CardService cardManager = new CardManager();
	Controller controller = new Controller();
	TransactionService transactionManager = new TransactionManager();
	LocalDate currentDate = LocalDate.now();
	 
	/* Person Identifier */
	@Override
	public DataResult<List<Person>> personIdentifier(JSONObject jsonInput) {
		/* Common Variable */
		String[] tempInfoArray = new String[20];
		String templatePhoneNumber;
		boolean boolFlag = true ;
		String strFlag ; 
		int tempIndex= 0;
		JSONObject tempJSON = new JSONObject();
		try {	
		
		System.out.println("Welcome to Retail Website, Have a enjoy shopping :)");
		/* Getting Telephone Number */
		templatePhoneNumber = transactionManager.fillingBlankedTelephoneNumber("Please enter your telephone number, It should be consist of 11 numbers, It's required:[It should be like that 05....]\n",jsonInput, 11, "05",2, null, "null").toUpperCase();
		/* Register Controller */
		int flag = controller.registerContoller(templatePhoneNumber,jsonInput);
		/* JSON Array */
		JSONArray jRootArray = new JSONArray();
		/* If User Registered */
		if (flag != -1) {
			// "I want to iterate though the objects in the array..." 
			System.out.println("Dear "+jsonInput.getJSONArray("data").getJSONObject(flag).getString("personName").toUpperCase()+" "+
					jsonInput.getJSONArray("data").getJSONObject(flag).getString("personSurname").toUpperCase()+", "+"Welcome to Retail Website");
			
			return new SuccessDataResult<List<Person>>
						(jsonInput,flag,"It has been good");
		}
		/* Not registered user*/
		else if(flag == -1) {
			 /* Lenth of array */
			 tempIndex = jsonInput.getJSONArray("data").length();
			/* Warning */
			 System.out.println("You're a new for us"+", "+"We're excited to meet you."+" "+ "Welcome to our family.");
			/* Getting First Name */
			 tempInfoArray[0] = transactionManager.fillingBlankedStringField("Please enter your first name. It's required !!!:\n").toUpperCase();
			/* Getting Surname */
		 	 tempInfoArray[1] = transactionManager.fillingBlankedStringField("Please enter your surname. It's required !!! :\n").toUpperCase();
		 	/* Getting Mail*/
		 	 tempInfoArray[2] = transactionManager.fillBlankedMailSpace("Please enter your  mail. It's required !!!:\n");
			/*Yes No Flag */
		 	strFlag = transactionManager.fillingBlankedOptionalField("If you want to save number you have written. Number -->"+" "+templatePhoneNumber+". "+ "It's required:[Y/N]\n", "Y", "N");	 	
			 /* Telephone Number */
			 if(strFlag.equals("Y")) {
			 		tempInfoArray[3] = templatePhoneNumber;
			 	}
			 else if(strFlag.equals("N")){	
				    tempInfoArray[3] = transactionManager.fillingBlankedTelephoneNumber("Please enter your telephone number, It's required:\n",jsonInput, 11,"05",2, null, "null"); 
			 		}
		     /* Getting Alternative Number */
			 tempInfoArray[4] = transactionManager.fillingBlankedTelephoneNumber("Please enter alternative telephone number, It's required:\n",jsonInput, 11,"05",2, tempInfoArray[3],"check");
			 /* Getting Home address*/
			 tempInfoArray[5] = transactionManager.fillingBlankedField("Please enter your home address. It's required:\n", 0, null,0);
			 /* Type Of Card Selection*/
			 tempInfoArray[6] = transactionManager.fillingBlankedOptionalField("Please enter type of card you want.Our Web Site has two optional those're one of them is Gold Card, other one's Silver Card. You need to enter G character if you want to Golden Card. You need to enter S character if you want to Silver Card .It's required. [G/S]", "G", "S").toUpperCase();   
			 /* Be Affliated Selection*/
			 tempInfoArray[7] = transactionManager.fillingBlankedOptionalField("You 're became piece of family so far. you 're able to be affilimated If you want to be closer to us. You need to enter Y if you want.[Y/N]:\n", "Y", "N").toUpperCase() ; 
			 /* Temp Social Id */
			 tempSocialId="null";
			 if( tempInfoArray[7].equals("Y")) {
				 tempSocialId = transactionManager.fillingBlankedNumberField("Please Enter Social Identity For be affiliated\n", 11, null, null,0).toUpperCase();  
			 }
			 /* Yes No Flag */
			 yesNoFlag =transactionManager.fillingBlankedOptionalField("Do you want  enter count of day that  you have been our customer? FOR TESTING[Y/N]!!!","Y","N").toUpperCase();
			/* Test selection */
			 if(yesNoFlag.equals("Y")) {
				 tempInfoArray[8] = transactionManager.fillingBlankedDate("Please enter Year", 5,"year").toUpperCase(); 
				 tempInfoArray[9] = transactionManager.fillingBlankedDate("Please enter number of mounth\n", 3, "mounth").toUpperCase(); 
				 tempInfoArray[10] = transactionManager.fillingBlankedDate("Please enter number of day of Week\n", 3, "day").toUpperCase(); 
						
			 }
			 else if(yesNoFlag.equals("N")) {
				 tempInfoArray[8] = String.valueOf(currentDate.getYear());
				 tempInfoArray[9] = String.valueOf(currentDate.getMonthValue());
				 tempInfoArray[10] = String.valueOf(currentDate.getDayOfMonth());
			 }
				
						/* JSON Object */
						JSONObject jInnerObject = new JSONObject();
						/* Setting User ID */
						tempInfoArray[12] = userIdGenerator(jsonInput);
						
						/* Setting Card Id */
						tempInfoArray[13] = cardManager.cardIdGenerator(jsonInput);
						
						/* Setting Card Number */
						tempInfoArray[14] = cardManager.cardNumberGenerator(jsonInput);
						
						/* Setting Card Security Number */
						tempInfoArray[15] = cardManager.cardSecurityNumberGenerator(jsonInput);
						
						/* Setting Card Password */
						tempInfoArray[16] = cardManager.cardPasswordGenerator();
						/* Gold Card Building */
						if(tempInfoArray[6].equals("G")) {
							card = new GoldCard(
									Integer.valueOf(tempInfoArray[13]), /* Card Id */ 
									tempInfoArray[14], /*Card Number */
									tempInfoArray[15], /*Code Of Security */
									30, /* percentage Of Discount */
									tempInfoArray[16], /* Card Password */
									1 /* Amount Of Discount */
									);
						}
						/* Silver Card Building */
						else if(tempInfoArray[6].equals("S")) {
							card = new SilverCard(
									Integer.valueOf(tempInfoArray[13]), 
									tempInfoArray[14], 
									tempInfoArray[15], 20, 
									tempInfoArray[16],1);
						}
						/* Build affiliated customer */
						if( tempInfoArray[7].equals("Y")) {
								customer = new AffiliatedCustomer(
								Integer.valueOf(tempInfoArray[9]), /*id*/
								tempInfoArray[0], /*Name */
								tempInfoArray[1], /*Surname */
								tempInfoArray[2], /*Mail */
								card,			  /*Card Object */
								tempInfoArray[3], /*Telephone Number */
								tempInfoArray[4], /*Alternative Telephone Number */
								tempInfoArray[5], /*Home address */
								card.getTypeOfCard().toUpperCase(),/* Type Of Card */
								tempInfoArray[8], /* Date */
								tempSocialId,/* social identifier */
								"affiliated"); 
						}
						/* Build Customer */
						else if(tempInfoArray[7].equals("N")) {
							 		customer = new Customer(
									Integer.valueOf(tempInfoArray[9]), 
									tempInfoArray[0], 
									tempInfoArray[1],
									tempInfoArray[2],
									card,
									tempInfoArray[3],
									tempInfoArray[4], 
									tempInfoArray[5], 
									card.getTypeOfCard().toUpperCase(),
									tempInfoArray[8],
									null,
									"Customer"
									);
						}
						/* Card Transaction */
						
						jInnerObject.put("cardId",  String.valueOf(card.getCardId()));
						jInnerObject.put("cardNumber", String.valueOf(card.getCardNumber()));
						jInnerObject.put("cardSecurityNumber", card.getCodeOfCardSecurity());
						jInnerObject.put("percentageOfDiscount", String.valueOf(card.getPercentageOfDiscount()));
						jInnerObject.put("cardPassword", String.valueOf(card.getCardPassword()));
						jInnerObject.put("amountOfDiscountUsage", String.valueOf(card.getAmountOfDiscountUsage()));
						
						/* Person Id Generator */
						tempId = userIdGenerator(jsonInput);
						
						jInnerObject.put("personId",tempId);
						
						/* Datas, which is got by Customer */
						jInnerObject.put("personName", customer.getPersonName());
						jInnerObject.put("personSurname", customer.getPersonSurname());
						jInnerObject.put("personMail", customer.getPersonMail());
						jInnerObject.put("personTelephoneNumber",customer.getPersonPhone());
						jInnerObject.put("personAlternativeTelephoneNumber", customer.getPersonAlternativePhone());
						jInnerObject.put("personAddress", customer.getPersonAddress());
						jInnerObject.put("typeOfCustomer", customer.getTypeCustomer());
						jInnerObject.put("typeOfCard", card.getTypeOfCard());
						jInnerObject.put("firstDay", customer.getFirstDayOfBeenCustomer());
						jInnerObject.put("year",tempInfoArray[8]);
						jInnerObject.put("mounth",tempInfoArray[9]);
						jInnerObject.put("day",tempInfoArray[10]);
						/* If Customer wanna be affiliated that's why user need to enter social identity */
						if( customer.getTypeCustomer().equals("affiliated")) {
							jInnerObject.put("socialIdentityNumber", tempSocialId);
						}
						else {
							jInnerObject.put("socialIdentityNumber", "null");
						}
						/* JSON Array Building */
						jRootArray.put(jInnerObject);
						jsonInput.getJSONArray("data").put(jInnerObject);
						return new SuccessDataResult<List<Person>>
						(jsonInput,jsonInput.getJSONArray("data").length()-1,"It has been good");
				}
				else {
					return new ErrorDataResult<List<Person>>
					(jsonInput,0,"It hasn't been good");
					}   
				} 
			catch (JSONException e) {
				
					System.out.println("Someting went wrong");
	                e.printStackTrace();
	                return new ErrorDataResult<List<Person>>
					(jsonInput,0,"It hasn't been good");
					}   
	          }

	

	/* 
	 * Description:
	 * --------------
	 * This Method is used for Register and login .
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: all data
	 * 
	 * Return:
	 * -------------
	 * Java object is returned. Object has different variables those're JSONObject which is named user info, User which is named user id, and message;
	 * 
	 * ----------------------------------------------------------------
	 * 
	 * */
	
	/* User Id Generator */
	@Override
	public String userIdGenerator(JSONObject jsonInput) {
		/* Temp id is the variables that keeps id */
		int  tempId= 0;
		/* State flag */
		boolean valid = true;
		try {
			/* FOR TEST */
			/*while(valid) {
				
				Controller checkpoint = new Controller();
				valid = checkpoint.idConflictController(jsonInput, tempId);
				System.out.println("VAL??D"+valid);
				
			}*/
			tempId +=1;
			return String.valueOf(tempId);	
		}
		catch (JSONException e) {
			
			System.out.println("Someting went wrong");
            e.printStackTrace();
            return null;	
			}   
	}
	
	/*
	 * Description:
	 * ---------------
	 * This function is used for id generator.
	 * 
	 * Parameters:
	 * ---------------
	 * jsonInput: All data
	 * 
	 * Return:
	 * ----------------
	 * User id is returned.
	 * 
	 * ---------------------------------------------------
	 * */
	
	
	/* User Removing */
	@Override
	public DataResult<List<Person>> userRemoving(JSONObject jsonInput) {
		try {
			/*Remonig transaction within JSON*/
			jsonInput.getJSONObject("data").getJSONArray("data").remove(jsonInput.getInt("userId"));
			/**/
			return new SuccessDataResult<List<Person>>
			(jsonInput.getJSONObject("data"), jsonInput.getJSONObject("data").getJSONArray("data").length(), "Transaction has been done");
		}
			catch (JSONException e) {
			
			System.out.println("Someting went wrong");
            e.printStackTrace();
            return null;	
		}   
	}
}


	/*
	 * Description:
	 * ---------------
	 * This function is used for remove account
	 * 
	 * Parameters:
	 * ---------------
	 * jsonInput: All data
	 * 
	 * Return:
	 * ---------------
	 * Json
	 * 
	 * -------------------------------------------------------------
	 * */
	 