package interviewTask.retailWebSite.business.concretes;

import java.util.HashMap;
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
import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.GoldCard;
import interviewTask.retailWebSite.entities.concretes.Person;
import interviewTask.retailWebSite.entities.concretes.SilverCard;

public class UserManager implements UserService {
	private String tempId;
	private String cardId;
	int flag = 0;
	Card card;
	
	Scanner myObj = new Scanner(System.in);
	CardService cardManager = new CardManager();
	Controller controller = new Controller();
	TransactionService transactionManager = new TransactionManager();
	
	@Override
	public String personIdentifier(JSONObject jsonInput) {
		/* Common Variable */
		String[] tempInfoArray = new String[20];
		String templatePhoneNumber;
		boolean boolFlag = true ;
		String strFlag ; 
		
		System.out.println("Welcome to Retail Website, Have a enjoy shopping :)");
		
		templatePhoneNumber = transactionManager.fillingBlankedField("Please enter your telephone number, It's required:[It should be like that 05....]\n", 11, "05").toUpperCase();
		 
		
		int flag = controller.registerContoller(templatePhoneNumber,jsonInput);
		JSONArray jRootArray = new JSONArray();
	
		if (flag != -1) {
			// "I want to iterate though the objects in the array..."      
			System.out.println("Dear "+jsonInput.getJSONArray("data").getJSONObject(flag).getString("personName").toUpperCase()+" "+
								jsonInput.getJSONArray("data").getJSONObject(flag).getString("personSurname").toUpperCase()+", "+"Welcome to Retail Website");
			
			return "Transaction has been done";
		}
		
		else if(flag == -1) {
			
			
			 System.out.println("You're a new for us"+", "+"We're excited to meet you."+" "+ "Welcome to our family.");
			
			 tempInfoArray[0] = transactionManager.fillingBlankedField("Please enter your first name. It's required !!!:\n", 0, null).toUpperCase();
			 
		 	 tempInfoArray[1] = transactionManager.fillingBlankedField("Please enter your surname. It's required !!! :\n", 0, null).toUpperCase();
		
		 	 tempInfoArray[2] = transactionManager.fillingBlankedField("Please enter your  mail. It's required !!!:\n", 0, null);
			 		
		 	strFlag = transactionManager.fillingBlankedField("If you want to save number you wrote. It's required:[Y/N]\n", 0, null);	 	
			 		
			 /* Telephone Number */
			 if(strFlag.equals("Y")) {
			 		tempInfoArray[3] = templatePhoneNumber;
			 	}
			 else if(strFlag.equals("N")){	
				 tempInfoArray[3] = transactionManager.fillingBlankedField("Please enter your telephone number, It's required:\n", 0, null);
				 
			 		}
				 
			 System.out.println("Please enter alternative telephone number, It's optional:\n");
			 tempInfoArray[4] = myObj.nextLine();
				
			 
			 tempInfoArray[5] = transactionManager.fillingBlankedField("Please enter your home address. It's required:\n", 0, null);
				 
			 
			 tempInfoArray[6] = transactionManager.fillingBlankedField("Please enter type of card you want.Our Web Site has two optional those're one of them is Gold Card, other one's Silver Card. You need to enter G character if you want to Golden Card. You need to enter S character if you want to Silver Card .It's required. [G/S]\n", 0, null).toUpperCase(); 
					
				 
			 System.out.println("You 're became piece of family so far. you 're able to be affilimated If you want to be closer to us. You need to enter E if you want.[E/N]:\n");
			 tempInfoArray[7] = myObj.nextLine().toUpperCase();
			
			
			
			
			try {
						
						JSONObject jInnerObject = new JSONObject();
					
						/* Setting User ID */
						tempInfoArray[9] = userIdGenerator(jsonInput);
						
						/* Setting Card Id */
						tempInfoArray[10] = cardManager.cardIdGenerator(jsonInput);
						/* Setting Card Number */
						tempInfoArray[11] = cardManager.cardNumberGenerator(jsonInput);
						/* Setting Card Security Number */
						tempInfoArray[12] = cardManager.cardSecurityNumberGenerator(jsonInput);
						/* Setting Card Password */
						tempInfoArray[13] = cardManager.cardPasswordGenerator(jsonInput);
						
						if(tempInfoArray[6].equals("G")) {
							card = new GoldCard(Integer.valueOf(tempInfoArray[10]), tempInfoArray[11], tempInfoArray[12], 30, tempInfoArray[13],1);
						}
						else if(tempInfoArray[6].equals("S")) {
							card = new SilverCard(Integer.valueOf(tempInfoArray[10]), tempInfoArray[11], tempInfoArray[12], 20, tempInfoArray[13],1);
						}
						/* Card Transaction */
						jInnerObject.put("cardId",  String.valueOf(card.getCardId()));
						jInnerObject.put("cardNumber", card.getCardNumber());
						jInnerObject.put("cardSecurityNumber", card.getCodeOfCardSecurity());
						jInnerObject.put("percentageOfDiscount", String.valueOf(card.getPercentageOfDiscount()));
						jInnerObject.put("cardPassword ", card.getCardPassword());
						jInnerObject.put("amountOfDiscountUsage ", card.getAmountOfDiscountUsage());
						
						/* Person Id Generator */
						tempId = userIdGenerator(jsonInput);
						jInnerObject.put("personId",tempId);
						
						/* Datas, which is got by Customer */
						jInnerObject.put("personName",tempInfoArray[0]);
						jInnerObject.put("personSurname",tempInfoArray[1]);
						jInnerObject.put("personMail",tempInfoArray[2]);
						jInnerObject.put("personTelephoneNumber",tempInfoArray[3]);
						jInnerObject.put("personAlternativeTelephoneNumber", tempInfoArray[4]);
						jInnerObject.put("personAddress",tempInfoArray[5]);
						
						
						jRootArray.put(jInnerObject);
						jsonInput.put("data", jRootArray);
					
				} catch (JSONException e) {
	                e.printStackTrace();
	            }
				System.out.println("value : "+ jsonInput.getJSONArray("data").toString());
				
				return "Transaction has been done";
		}
		else {
			return "process is fault";
		}
		
		
	}

	@Override
	public String userIdGenerator(JSONObject jsonInput) {
		int  tempId= 0;
		boolean valid = true;
		
		while(valid) {
			
			Controller checkpoint = new Controller();
			valid = checkpoint.idConflictController(jsonInput, tempId);
			tempId +=1;
		}
		return String.valueOf(tempId);
	}

}
