package interviewTask.retailWebSite.business.concretes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	private String tempId;
	private String cardId;
	private String tempSocialId;
	private String tempDate;
	private String yesNoFlag;
	int flag = 0;
	Card card;
	Person customer;
	
	Scanner myObj = new Scanner(System.in);
	CardService cardManager = new CardManager();
	Controller controller = new Controller();
	TransactionService transactionManager = new TransactionManager();
	LocalDate currentDate = LocalDate.now();
	 
	@Override
	public DataResult<List<Person>> personIdentifier(JSONObject jsonInput) {
		/* Common Variable */
		String[] tempInfoArray = new String[20];
		String templatePhoneNumber;
		boolean boolFlag = true ;
		String strFlag ; 
		int tempIndex= 0;
		JSONObject tempJSON = new JSONObject();
		System.out.println("Datta BEGIN"+jsonInput);
		System.out.println("Welcome to Retail Website, Have a enjoy shopping :)");
		
		templatePhoneNumber = transactionManager.fillingBlankedTelephoneNumber("Please enter your telephone number, It should be consist of 11 numbers, It's required:[It should be like that 05....]\n",jsonInput, 11, "05",2, null, "null").toUpperCase();
		 
		/* Register Controller */
		int flag = controller.registerContoller(templatePhoneNumber,jsonInput);
		JSONArray jRootArray = new JSONArray();
		
		if (flag != -1) {
			// "I want to iterate though the objects in the array..." 
			//jsonInput = jsonInput.getJSONArray("data").getJSONObject(flag);
			System.out.println("Dear "+jsonInput.getJSONArray("data").getJSONObject(flag).getString("personName").toUpperCase()+" "+
					jsonInput.getJSONArray("data").getJSONObject(flag).getString("personSurname").toUpperCase()+", "+"Welcome to Retail Website");
			
			return new SuccessDataResult<List<Person>>
						(jsonInput,flag,"It has been good");
		}
		
		else if(flag == -1) {
			
			System.out.println("Length"+jsonInput.getJSONArray("data").length());
			 tempIndex = jsonInput.getJSONArray("data").length();
			 /*tempJSON = jsonInput.getJSONArray("data").getJSONObject(tempIndex);*/
			
			
			
			
			
			
			
			 System.out.println("You're a new for us"+", "+"We're excited to meet you."+" "+ "Welcome to our family.");
			
			 tempInfoArray[0] = transactionManager.fillingBlankedStringField("Please enter your first name. It's required !!!:\n").toUpperCase();
			 
		 	 tempInfoArray[1] = transactionManager.fillingBlankedStringField("Please enter your surname. It's required !!! :\n").toUpperCase();
		 
		 	 tempInfoArray[2] = transactionManager.fillBlankedMailSpace("Please enter your  mail. It's required !!!:\n");
			 		
		 	 
		 	 
		 	 
		 	strFlag = transactionManager.fillingBlankedOptionalField("If you want to save number you have written. It's required:[Y/N]\n", "Y", "N");	 	
			 		
			 /* Telephone Number */
			 if(strFlag.equals("Y")) {
			 		tempInfoArray[3] = templatePhoneNumber;
			 	}
			 else if(strFlag.equals("N")){	
			tempInfoArray[3] = transactionManager.fillingBlankedTelephoneNumber("Please enter your telephone number, It's required:\n",jsonInput, 11,"05",2, null, "null");
				 
			 		}
				 
			 
			 tempInfoArray[4] = transactionManager.fillingBlankedTelephoneNumber("Please enter alternative telephone number, It's required:\n",jsonInput, 11,"05",2, tempInfoArray[3],"check");
			 
			 tempInfoArray[5] = transactionManager.fillingBlankedField("Please enter your home address. It's required:\n", 0, null,0);
				 
			 
			 tempInfoArray[6] = transactionManager.fillingBlankedOptionalField("Please enter type of card you want.Our Web Site has two optional those're one of them is Gold Card, other one's Silver Card. You need to enter G character if you want to Golden Card. You need to enter S character if you want to Silver Card .It's required. [G/S]", "G", "S").toUpperCase();   
					
	
			 
			 tempInfoArray[7] = transactionManager.fillingBlankedOptionalField("You 're became piece of family so far. you 're able to be affilimated If you want to be closer to us. You need to enter Y if you want.[Y/N]:\n", "Y", "N").toUpperCase() ; 
			 
			 tempSocialId="null";
			 if( tempInfoArray[7].equals("Y")) {
				 tempSocialId = transactionManager.fillingBlankedNumberField("Please Enter Social Identity For be affiliated\n", 11, null, null,0).toUpperCase();  
			 }
			 	
			 
			 
			 yesNoFlag =transactionManager.fillingBlankedOptionalField("Do you want  enter count of day that  you have been our customer? FOR TESTING[Y/N]!!!","Y","N").toUpperCase();
			 System.out.println("yes No Flag"+yesNoFlag);
			 
			 if(yesNoFlag.equals("Y")) {
				 System.out.println("BURAYA GIRDI");
				 
				 tempInfoArray[8] = transactionManager.fillingBlankedDate("Please enter Year", 5,"year").toUpperCase(); 
				 tempInfoArray[9] = transactionManager.fillingBlankedDate("Please enter number of mounth\n", 3, "mounth").toUpperCase(); 
				 tempInfoArray[10] = transactionManager.fillingBlankedDate("Please enter number of day of Week\n", 3, "day").toUpperCase(); 
				 System.out.println("BURAYA CIKTI");
							
			 }
			 else if(yesNoFlag.equals("N")) {
				 System.out.println("BURAYA GIRDI");
				 tempInfoArray[8] = String.valueOf(currentDate.getYear());
				 tempInfoArray[9] = String.valueOf(currentDate.getMonthValue());
				 tempInfoArray[10] = String.valueOf(currentDate.getDayOfMonth());
				 System.out.println("BURAYA CIKTI");
			 }
			 
			try {		
						JSONObject jInnerObject = new JSONObject();
					
						/* Setting User ID */
						tempInfoArray[12] = userIdGenerator(jsonInput);
						System.out.println("USER id"+ tempInfoArray[12]);
						/* Setting Card Id */
						tempInfoArray[13] = cardManager.cardIdGenerator(jsonInput);
						System.out.println("card id"+ tempInfoArray[13]);
						/* Setting Card Number */
						tempInfoArray[14] = cardManager.cardNumberGenerator(jsonInput);
						System.out.println("Card Number Generator"+ tempInfoArray[14]);
						/* Setting Card Security Number */
						tempInfoArray[15] = cardManager.cardSecurityNumberGenerator(jsonInput);
						System.out.println("cardSecurityNumberGenerator"+ tempInfoArray[15]);
						/* Setting Card Password */
						tempInfoArray[16] = cardManager.cardPasswordGenerator();
						System.out.println("Card Password"+ tempInfoArray[16]);                    
						
						System.out.println("Golden SILVER CONDITION"+ tempInfoArray[6]);
						
						if(tempInfoArray[6].equals("G")) {
							System.out.println("BURAYA GIRDI");
							card = new GoldCard(Integer.valueOf(tempInfoArray[13]), tempInfoArray[14], tempInfoArray[15], 30, tempInfoArray[16],1);
						}
						else if(tempInfoArray[6].equals("S")) {
							System.out.println("BURAYA GIRDI");
							card = new SilverCard(Integer.valueOf(tempInfoArray[13]), tempInfoArray[14], tempInfoArray[15], 20, tempInfoArray[16],1);
						}
						
						
						if( tempInfoArray[7].equals("Y")) {
							
							
							
							System.out.println("BURAYA GIRDI");
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
						else if(tempInfoArray[7].equals("N")) {
							System.out.println("BURAYA GIRDI");
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
						System.out.println("CARD NUMBER "+card.getCardId());
						jInnerObject.put("cardId",  String.valueOf(card.getCardId()));
						jInnerObject.put("cardNumber", String.valueOf(card.getCardNumber()));
						jInnerObject.put("cardSecurityNumber", card.getCodeOfCardSecurity());
						jInnerObject.put("percentageOfDiscount", String.valueOf(card.getPercentageOfDiscount()));
						jInnerObject.put("cardPassword", String.valueOf(card.getCardPassword()));
						jInnerObject.put("amountOfDiscountUsage", String.valueOf(card.getAmountOfDiscountUsage()));
						
						/* Person Id Generator */
						tempId = userIdGenerator(jsonInput);
						System.out.println("temp ID:"+tempId);
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
						
						
						if( customer.getTypeCustomer().equals("affiliated")) {
							jInnerObject.put("socialIdentityNumber", tempSocialId);
						}
						else {
							jInnerObject.put("socialIdentityNumber", "null");
						}
						
						
						
						System.out.println("jsonnn before"+ jsonInput.getJSONArray("data"));
						jRootArray.put(jInnerObject);
						jsonInput.getJSONArray("data").put(jInnerObject);
					    System.out.println("jsonnn"+ jsonInput);
				} catch (JSONException e) {
	                e.printStackTrace();
	            }
				System.out.println("value : "+ jsonInput.getJSONArray("data").toString());
				System.out.println("Datta "+jsonInput);
				
				return new SuccessDataResult<List<Person>>
				(jsonInput,jsonInput.getJSONArray("data").length()-1,"It has been good");
		}
		else {
			return new ErrorDataResult<List<Person>>
			(jsonInput,0,"It hasn't been good");
		}
		
		
	}

	@Override
	public String userIdGenerator(JSONObject jsonInput) {
		int  tempId= 0;
		boolean valid = true;
		System.out.println("It's user id generators"+jsonInput.getJSONArray("data"));
		/*while(valid) {
			
			Controller checkpoint = new Controller();
			valid = checkpoint.idConflictController(jsonInput, tempId);
			System.out.println("VALİD"+valid);
			
		}*/
		tempId +=1;
		return String.valueOf(tempId);
	}

	@Override
	public DataResult<List<Person>> userRemoving(JSONObject jsonInput) {
		
		System.out.println("Your Account has been removed"+jsonInput);
		jsonInput.getJSONObject("data").getJSONArray("data").remove(jsonInput.getInt("userId"));
		return new SuccessDataResult<List<Person>>
		(jsonInput.getJSONObject("data"), jsonInput.getJSONObject("data").getJSONArray("data").length(), "Transaction has been done");
	}

}