package interviewTask.retailWebSite.core.concretes;



import org.json.JSONArray;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;

public class Controller {

	final int greatesLimitedNumberOfSecurityCode = 999;
	
	public Boolean deviceController(JSONObject json) {
		
		if(json.getString("device").equals("phone")) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public int registerContoller(String telephoneNumber, JSONObject jsonInput) {	
		int index = 0;
		
	    for (int i = 0, size = jsonInput.length(); i < size; i++)
	    {
	    	try {
	    	if(jsonInput.getString("personTelephoneNumber").equals(telephoneNumber)){
	    		index = i;
	    		
	    		return index;
	    	}
	    	}
	    	catch (Exception e) {
	    	      System.out.println("This Phone Number ");
	    	      return -1;
	    	    }
	   }
	   return -1;
	}
	
	public Boolean processController(JSONObject json) {
		
		int temp = 0;
		
		TransactionService transactionManager = new TransactionManager();
		temp = transactionManager.counterOfBillPaidOverStatedYear(json);
		
		if(temp >= 730) {
			return true;
		}
		else {
			return false;
		}
		
	
	}
	
	public JSONObject discountController(JSONObject jsonInput) {
		
		String AmountOfDiscount;
		
		JSONObject json = new JSONObject();
		JSONArray jDiscountArray = new JSONArray();
		System.out.println(jsonInput);
		
		AmountOfDiscount = countOfDiscountUsage(jsonInput);
				
		
		if(deviceController(jsonInput)) {
			if(jsonInput.getString("typeOfCustomer").equals("affiliated")){
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","10");
				jDiscountArray.put(jInnerObject);
				json.put("discount", jDiscountArray);
			}
		
			if(processController(jsonInput)) {
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","5");
				jDiscountArray.put(jInnerObject);
				json.put("discount", jDiscountArray);
			}
		
			if(jsonInput.getString("typeOfCard").equals("GOLDEN")) {
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","30");
				jDiscountArray.put(jInnerObject);
				json.put("discount", jDiscountArray);
			}
		
			else if(jsonInput.getString("typeOfCard").equals("SILVER")) {
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("silverCard:","20");
				jDiscountArray.put(jInnerObject);
				json.put("discount", jDiscountArray);
			}
		
		}
			else {
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","0");
				jDiscountArray.put(jInnerObject);
				json.put("discount", jDiscountArray);
				System.out.println("You have"+" "+ jsonInput.getString("amountOfDiscountUsage"));
				System.out.println("We're sorry to tell that we could not apply discount with using phone ");
			}
			return json;
	}
	
	public Boolean amountOfBillController(float result) {
		
		if(result >= 200) {
			return true;
		}
		return false;
	}
	
	public String countOfDiscountUsage(JSONObject json) {
		
		String temp;
		
		temp = json.getString("amountOfDiscountUsage");
		
		return temp;
	}
	
	
	public Boolean characterLengthController(String data, int length) {
		
		if(data.length() == length) {
			return false;
		}
		else {
			
			return true;
		}
	}
	
	
	public Boolean properChartacterController(String data, String headerCharacter, int characterInterval) {
		
		if( data.substring(0,characterInterval).equals(headerCharacter)) {
			return false;
		}
		else {
			
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
				System.out.println("controller"+ch[i]);
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean passwordController(String password, String repeatPassword) {
		if(password.equals(repeatPassword)) {
			return true;
		}
		return false;
	}
	
	public Boolean customerController(JSONObject json) {
		
		if(json.getJSONArray("data").getJSONObject(0).getString("typeOfCustomer").equals("affiliated")) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
