package interviewTask.retailWebSite.core.concretes;



import org.json.JSONArray;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;

public class Controller {
	
	final int greatesLimitedNumberOfSecurityCode = 999;
	
	
	
	public Boolean deviceController() {
		TransactionService transactionManager = new TransactionManager();
		String yesNoFlag;
		yesNoFlag = transactionManager.fillingBlankedOptionalField("Are you doing shopping with using phone?[Y/N]!!!","Y","N").toUpperCase();
		
		if(yesNoFlag.equals("Y")) {
			return false;
		}
		else if(yesNoFlag.equals("N")) {
			return true;
		}
		else {
			return true;
		}
		
	}
	
	public int registerContoller(String telephoneNumber, JSONObject jsonInput) {	
		int index = 0;
		
	    for (int i = 0, size = jsonInput.getJSONArray("data").length(); i < size; i++)
	    {
	    	try {
	    		
	    	if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber").equals(telephoneNumber)){
	    		index = i;
	    		
	    		return index ;
	    	}
	    	}
	    	catch (Exception e) {
	    	      System.out.println("The phone hasn't been registered");
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
		
		JSONObject jsonDiscount = new JSONObject();
		JSONArray jDiscountArray = new JSONArray();
		
		AmountOfDiscount = countOfDiscountUsage(jsonInput);
		
		
		if(deviceController()) {
			System.out.println("TELEFON DEGIL");
			System.out.println("OBJE"+ jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCustomer"));
			if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCustomer").equals("affiliated")){
				System.out.println("SEN UYESIN");
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","10");
				jDiscountArray.put(jInnerObject);
				jsonDiscount.put("discount", jDiscountArray);
			}
		
			if(processController(jsonInput)) {
				System.out.println("2 SENEDIR UYESIN");
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","5");
				jDiscountArray.put(jInnerObject);
				jsonDiscount.put("discount", jDiscountArray);
			}
		
			if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("GOLDCARD")) {
				System.out.println("GOLDEN CARD");
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","30");
				jDiscountArray.put(jInnerObject);
				jsonDiscount.put("discount", jDiscountArray);
			}
		
			else if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("SILVERCARD")) {
				System.out.println("SILVER CARD");
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim:","20");
				jDiscountArray.put(jInnerObject);
				jsonDiscount.put("discount", jDiscountArray);
			}
			
		}
			else {
				JSONObject jInnerObject = new JSONObject();
				jInnerObject.put("indirim","0");
				jDiscountArray.put(jInnerObject);
				jsonDiscount.put("discount", jDiscountArray);
				System.out.println("You have"+" "+ jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("amountOfDiscountUsage"));
				System.out.println("We're sorry to tell that we could not apply discount with using phone ");
			}
		System.out.println(jsonDiscount);
			return jsonDiscount;
	}
	
	public Boolean amountOfBillController(float result) {
		
		if(result >= 200) {
			return true;
		}
		return false;
	}
	
	public String countOfDiscountUsage(JSONObject jsonInput) {
		
		String temp;
		
		temp = jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("amountOfDiscountUsage");
		
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
		
		System.out.println("id conflict controller"+" "+jsonInput);
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			/* If id is same either person id or car id */
			if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personId").equals(String.valueOf(id)) ||
					jsonInput.getJSONArray("data").getJSONObject(i).getString("cardId").equals(String.valueOf(id))){
				
				return true;
			}
		}
		return false;
	}
	
	
	public Boolean cardNumberConflictController(JSONObject jsonInput, int cardNumber ) {
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			if(jsonInput.getJSONArray("data").getJSONObject(i).getString("cardNumber").equals(String.valueOf(cardNumber))){
				return true;
			}
		}
		return false;
	}
		
	public Boolean securityNumberConflictController(JSONObject jsonInput, int securityNumber ) {
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			if(jsonInput.getJSONArray("data").getJSONObject(i).getString("cardSecurityNumber").equals(String.valueOf(securityNumber))&&
				securityNumber < greatesLimitedNumberOfSecurityCode){
				
					return false;
				}
			}
			return true;
		}
		
	public Boolean passwordNumberConflictController(JSONObject jsonInput, String passwordNumber ) {
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			if(jsonInput.getJSONArray("data").getJSONObject(i).getString("cardPassword").equals(passwordNumber)){
					
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
	
	public Boolean customerController(JSONObject jsonObject) {
		
		if(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer").equals("affiliated")) {
			return true;
		}
		else {
			return false;
		}
	}
	
public void transactionController(boolean flag) {
		
		if(flag) {
			System.out.println("Transaction has been done.");
		}
		else {
			System.out.println("Something went wrong....");
		}
	}
	
}
