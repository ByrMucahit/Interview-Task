package interviewTask.retailWebSite.core.concretes;



import org.json.JSONObject;

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
	
	public Boolean processController() {
		
		return null;
	}
	
	public Boolean discountController() {
		
		return null;
	}
	
	public Boolean amountOfBillController() {
		
		return null;
	}
	
	public Boolean countOfDiscountUsage() {
		
		return null;
	}
	
	public Boolean characterLengthController(String data, int length, String headerCharacter) {
		if(data.length() == length) {
			
			if(data.substring(0,2).equals(headerCharacter)) {
				return false;
			}
			else {
				System.out.println("It's invalid. Please enter correctly.");
				return true;
			}
			
		}
		else {
			System.out.println("It's invalid. Please enter correctly.");
			return true;
		}
	}
	
	public Boolean properChartacterController() {
		
		return null;
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
	
	
}
