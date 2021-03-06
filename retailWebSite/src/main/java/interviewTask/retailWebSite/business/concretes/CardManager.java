package interviewTask.retailWebSite.business.concretes;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.CardService;
import interviewTask.retailWebSite.core.concretes.Controller;

import interviewTask.retailWebSite.entities.concretes.Person;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
	
	
public class CardManager implements CardService  {
	
	/* Controller */
	Controller checkpoint = new Controller();
	
	/* Card Id Generator */
	@Override
	public String cardIdGenerator(JSONObject jsonInput) {
		/* Temp id */
		int tempCardId = 0;
		/* Check point */
		boolean valid = true;
		try {
			/* Generating Uniaque Id */
			while(valid) {
				/* If valid is false, loop will have been finished. */
				valid = checkpoint.idConflictController(jsonInput, tempCardId);
				tempCardId +=1;
						}
				return String.valueOf(tempCardId);
		}	
		catch(JSONException e) {
			
            System.out.println("Something went wrong");
			e.printStackTrace();
			return String.valueOf(tempCardId);
			}	
		}
	
	/*
	 * Parameters:
	 * --------------
	 * This function is used for generate card id
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * 
	 * Return:
	 * -------------
	 * Card id is returned.
	 * 
	 * --------------------------------------------------------------------
	 *  */
	
	/* Card Number Generator */
	@Override
	public String cardNumberGenerator(JSONObject jsonInput) {
		/* Temp Card Number.it is consist of twenty character. */
		int tempCardNumber = 0;
		/* State Flag */
		boolean valid = true;
		int  min = 100000000;
		int  max = 999999999;
		
		try {
			/* If card number should be unique */
			while(valid) {
				/* Generate Card Number */
				tempCardNumber  = (int)Math.floor(Math.random()*(max-min+1)+min);
				/* If valid is false, loop will have been finished. */
				valid = checkpoint.cardNumberConflictController(jsonInput, tempCardNumber);
			}
			return String.valueOf(tempCardNumber);
		}
			catch(JSONException e) {
			
            System.out.println("Something went wrong");
			e.printStackTrace();
			return String.valueOf(tempCardNumber);
					}	
		}

	/*
	 * Description:
	 * -----------------
	 * This function is used for generate card number
	 * 
	 * Parameters:
	 * -----------------
	 * jsonInput: All data
	 * 
	 * Returns:
	 * -----------------
	 * Card number that is generated is returned
	 * 
	 * ----------------------------------------------------------
	 */
	
	/* Card Security Number Generator */
	@Override
	public String cardSecurityNumberGenerator(JSONObject jsonInput) {
		/* Temp Card  Security Number.it is consist of three character. Size of password could not be greated then three */
		int tempCardSecurityNumber = 0;
		boolean valid = true;
		int min = 100;
		int max = 999;
		
		try {
			/* If card security number should be unique */
			while(valid) {
				/* If valid is false, loop will have been finished. */
				tempCardSecurityNumber  = (int)Math.floor(Math.random()*(max-min+1)+min);
				valid = checkpoint.securityNumberConflictController(jsonInput, tempCardSecurityNumber);
			}
			return String.valueOf(tempCardSecurityNumber);
		}
		catch(JSONException e) {
			
            System.out.println("Something went wrong");
			e.printStackTrace();
			return String.valueOf(tempCardSecurityNumber);
					}	
	}
	
	/*
	 * Description:
	 * ----------------
	 * This function is used for generate security number
	 * 
	 * Parameters:
	 * ----------------
	 * jsonInput: All data
	 * 
	 * Returns:
	 * ----------------
	 * Card Security number is returned as string
	 * 
	 * ----------------------------------------------------------
	 * */

	
	/* Card password generator */
	@Override
	public String cardPasswordGenerator() {
		/* Temp card password  */
		int tempCardPassword = 0;
		/* Min - Max vlaue */
		int min = 1000;
		int max = 9999;
		try {
			/* Card password generator */
			tempCardPassword = (int)Math.floor(Math.random()*(max-min+1)+min);
			return String.valueOf(tempCardPassword);
		}
		catch(JSONException e) {
			
            System.out.println("Something went wrong");
			e.printStackTrace();
			return String.valueOf(tempCardPassword);
		}	
	}

	/* 
	 * Description:
	 * --------------
	 * This function is used for generate card password.
	 * 
	 * Parameters:
	 * --------------
	 * none
	 * 
	 * Returns:
	 * -------------
	 * Card password that is generated is returned.
	 * 
	 * ------------------------------------------------------------------
	 *  */
	
	/* Check Previous Controller */
	@Override
	public boolean checkPreviousPasswordConflict(JSONObject jsonInput, String password) {
		try {
			/* If Any password is the same with password that has been written by user */
			if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("cardPassword").equals(password)) {
				System.out.println("Password can not be same with previous");
				return false;
			}
			return true;	
		}
	catch(JSONException e) {
			
            System.out.println("Something went wrong");
			e.printStackTrace();
			return true;
		}	
	}
	
	/* 
	 * Description:
	 * --------------
	 * This function is used to check password to prevent conflict.
	 * 
	 * Parameters:
	 * -------------
	 * jsonInput: All data
	 * password: Input that have just written by user
	 * 
	 * Returns:
	 * -------------
	 * True/False
	 * 
	 *-----------------------------------------------------------------
	 * */

	/* Change Your Card */
	@Override
	public SuccessDataResult<List<Person>> changeYourCard(JSONObject jsonInput) {
		try {
			/* If User has gold card */
			if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("GOLDCARD")) {
				System.out.println("YOU HAVE SILVER CARD NOW");
				jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("typeOfCard","SILVERCARD");
				jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("percentageOfDiscount","20");						
			}
			/* If User has silver card */
			else if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("SILVERCARD")) {
				System.out.println("YOU HAVE GOLD CARD NOW");
				jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("typeOfCard","GOLDCARD");
				jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("percentageOfDiscount","30");
			}
			return new SuccessDataResult<List<Person>>
					(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")),jsonInput.getInt("userId"),"Data has been achieved successfully" );
			}	
			catch(JSONException e) {
				
	            System.out.println("Something went wrong");
				e.printStackTrace();
				return new SuccessDataResult<List<Person>>
				(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")),jsonInput.getInt("userId"),"Data hasn't been achieved successfully" );
			}	
		}
	
	}

	/*
	 * Description:
	 * --------------
	 * This function is used for change type of card.
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * 
	 * Return:
	 * -------------
	 * Java Object is returned. It has three information those're json object that is all data, integer value that is used id ,and String value that is message.
	 * 
	 * ---------------------------------------------------------------------------------------------------
	 * */
