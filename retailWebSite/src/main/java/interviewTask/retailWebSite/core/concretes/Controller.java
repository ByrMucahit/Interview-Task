package interviewTask.retailWebSite.core.concretes;



import org.json.JSONArray;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;

public class Controller {

	final int greatesLimitedNumberOfSecurityCode = 999;
	
	public Boolean deviceController() {
		return null;
	}
	
	public int registerContoller(String telephoneNumber, JSONObject jsonInput) {	
		int index = 0;
		
	    for (int i = 0, size = jsonInput.getJSONArray("data").length(); i < size; i++)
	    {
	    	if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber").equals(telephoneNumber)){
	    		index = i;
	    		
	    		return index;
	    }
	   }
	    return -1;
	}
	
	public Boolean processController(JSONObject json) {
		
		int temp = 0;
		
		TransactionService transactionManager = new TransactionManager();
		temp = transactionManager.counterOfBillPaidOverStatedYear(json);
		
		if(temp > 2) {
			return true;
		}
		else {
			return false;
		}
		
	
	}
	
	public JSONObject discountController(JSONObject jsonInput) {
		
		JSONObject json = new JSONObject();
		JSONArray jDiscountArray = new JSONArray();
		System.out.println(jsonInput);
		if(jsonInput.getString("typeOfCustomer").equals("affiliated")){
			JSONObject jInnerObject = new JSONObject();
			jInnerObject.put("affiliatedDiscount","10");
			jDiscountArray.put(jInnerObject);
			json.put("discount", jDiscountArray);
		}
		
		if(processController(jsonInput)) {
			JSONObject jInnerObject = new JSONObject();
			jInnerObject.put("longOfYouHaveBeenCustomer","3");
			jDiscountArray.put(jInnerObject);
			json.put("discount", jDiscountArray);
		}
		
		if(jsonInput.getString("typeOfCard").equals("GOLDEN")) {
			JSONObject jInnerObject = new JSONObject();
			jInnerObject.put("goldenCard:","30");
			jDiscountArray.put(jInnerObject);
			json.put("discount", jDiscountArray);
		}
		
		else if(jsonInput.getString("typeOfCard").equals("SILVER")) {
			JSONObject jInnerObject = new JSONObject();
			jInnerObject.put("silverCard:","20");
			jDiscountArray.put(jInnerObject);
			json.put("discount", jDiscountArray);
		}
		return json;
	}
	
	public Boolean amountOfBillController() {
		
		return null;
	}
	
	public Boolean countOfDiscountUsage() {
		
		return null;
	}
	
	
	public Boolean characterLengthController(String data, int length) {
		
		if(data.length() == length) {
			return false;
		}
		else {
			System.out.println("It's invalid. Please enter correctly.");
			return true;
		}
	}
	
	
	public Boolean properChartacterController(String data, String headerCharacter, int characterInterval) {
		
		if( data.substring(0,characterInterval).equals(headerCharacter)) {
			return false;
		}
		else {
			System.out.println("It's invalid. Please enter correctly.");
			return true;
		}
	}
	
	public Boolean idConflictController(JSONObject jsonInput, int id) {
		
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			/* If id is same either person id or car id */
			if(jsonInput.getJSONArray("data").getJSONObject(0).getString("personId").equals(String.valueOf(id)) ||
					jsonInput.getJSONArray("data").getJSONObject(0).getString("cardId").equals(String.valueOf(id))){
				
				return true;
			}
		}
		return false;
	}
	
	
	public Boolean cardNumberConflictController(JSONObject jsonInput, int cardNumber ) {
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			if(jsonInput.getJSONArray("data").getJSONObject(0).getString("cardNumber").equals(String.valueOf(cardNumber))){
				return true;
			}
		}
		return false;
	}
		
	public Boolean securityNumberConflictController(JSONObject jsonInput, int securityNumber ) {
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			if(jsonInput.getJSONArray("data").getJSONObject(0).getString("cardSecurityNumber").equals(String.valueOf(securityNumber))&&
				securityNumber < greatesLimitedNumberOfSecurityCode){
				
					return false;
				}
			}
			return true;
		}
		
	public Boolean passwordNumberConflictController(JSONObject jsonInput, int passwordNumber ) {
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			if(jsonInput.getJSONArray("data").getJSONObject(0).getString("cardPassword").equals(String.valueOf(passwordNumber))){
					
				return false;
				}
			}
			return true;
		}
	
	public Boolean characterController(String data) {
		if(data.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public Boolean stringCharacterController(String data) {
		int size;
	
		data=data.toLowerCase();
		data=data.replaceAll("\\s","");
	    char[] ch=data.toCharArray();
	    size =data.length();
	    
		for(int i = 0; i< size; i++) {
			
			if((ch[i] >= 'a' && ch[i]<= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
