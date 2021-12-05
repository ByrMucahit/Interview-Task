package interviewTask.retailWebSite.business.concretes;

import java.util.List;

import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.CardService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.Person;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
public class CardManager implements CardService  {
	
	Controller checkpoint = new Controller();
	
	@Override
	public String cardIdGenerator(JSONObject jsonInput) {
		
		/* Temp id */
		int tempCardId = 0;
		/* Check point */
		boolean valid = true;
		
		/* Generating Uniaque Id */
		while(valid) {
			
			/* If valid is false, loop will have been finished. */
			valid = checkpoint.idConflictController(jsonInput, tempCardId);
			tempCardId +=1;
		}
		return String.valueOf(tempCardId);
	}

	@Override
	public String cardNumberGenerator(JSONObject jsonInput) {
		/* Temp Card Number.it is consist of twenty character. */
		int tempCardNumber = 0;
		boolean valid = true;
		int  min = 100000000;
		int  max = 999999999;
		
		/* If card number should be unique */
		while(valid) {
			tempCardNumber  = (int)Math.floor(Math.random()*(max-min+1)+min);
			System.out.println("tempCardNumber from card number generator"+tempCardNumber);
			
			/* If valid is false, loop will have been finished. */
			valid = checkpoint.cardNumberConflictController(jsonInput, tempCardNumber);
			System.out.println("tempCardNumber from card number generator"+valid);
		}
		System.out.println("tempCardNumber"+ tempCardNumber);
		return String.valueOf(tempCardNumber);
	}

	@Override
	public String cardSecurityNumberGenerator(JSONObject jsonInput) {
		/* Temp Card  Security Number.it is consist of three character. Size of password could not be greated then three */
		int tempCardSecurityNumber = 0;
		boolean valid = true;
		int min = 100;
		int max = 999;
		/* If card security number should be unique */
		while(valid) {
			/* If valid is false, loop will have been finished. */
			tempCardSecurityNumber  = (int)Math.floor(Math.random()*(max-min+1)+min);
			System.out.println("FROM SECURITY"+" "+tempCardSecurityNumber);
			valid = checkpoint.securityNumberConflictController(jsonInput, tempCardSecurityNumber);
			System.out.println("FROM SECURITY"+" "+valid);
		}
		System.out.println("temp Card Security Number"+tempCardSecurityNumber);
		return String.valueOf(tempCardSecurityNumber);
	}

	@Override
	public String cardPasswordGenerator() {
		/*  */
		int tempCardPassword = 0;
		
		int min = 1000;
		int max = 9999;
		tempCardPassword = (int)Math.floor(Math.random()*(max-min+1)+min);
		System.out.println("Card Password"+tempCardPassword);
		
		return String.valueOf(tempCardPassword);
	}

	@Override
	public boolean checkPreviousPasswordConflict(JSONObject jsonInput, String password) {
		
		if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("cardPassword").equals(password)) {
			System.out.println("Password can not be same with previous");
			return false;
		}
		return true;
	}

	@Override
	public SuccessDataResult<List<Person>> changeYourCard(JSONObject jsonInput) {
		
		if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("GOLDCARD")) {
			jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("typeOfCard","SILVERCARD");
			jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("percentageOfDiscount","20");						
		}
		else if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("SILVERCARD")) {
			jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("typeOfCard","GOLDCARD");
			jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("percentageOfDiscount","30");
		}
		return new SuccessDataResult<List<Person>>
				(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")),jsonInput.getInt("userId"),"Data has been achieved successfully" );
	}

	

}