package interviewTask.retailWebSite.business.concretes;

import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.CardService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.entities.concretes.Card;

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
		int tempCardNumber = 00000000000000000000;
		boolean valid = true;
		
		/* If card number should be unique */
		while(valid) {
			/* If valid is false, loop will have been finished. */
			valid = checkpoint.cardNumberConflictController(jsonInput, tempCardNumber);
			tempCardNumber += 1;
		}
		return String.valueOf(tempCardNumber);
	}

	@Override
	public String cardSecurityNumberGenerator(JSONObject jsonInput) {
		/* Temp Card  Security Number.it is consist of three character. Size of password could not be greated then three */
		int tempCardSecurityNumber = 000;
		boolean valid = true;
		/* If card security number should be unique */
		while(valid) {
			/* If valid is false, loop will have been finished. */
			valid = checkpoint.securityNumberConflictController(jsonInput, tempCardSecurityNumber);
			tempCardSecurityNumber += 1;
		}
		return String.valueOf(tempCardSecurityNumber);
	}

	@Override
	public String cardPasswordGenerator(JSONObject jsonInput) {
		/*  */
		int tempCardPassword = 0000;
		boolean valid = true;
		while(valid) {
			valid = checkpoint.passwordNumberConflictController(jsonInput, tempCardPassword);
			tempCardPassword += 1;
		}
		return String.valueOf(tempCardPassword);
	}

}
