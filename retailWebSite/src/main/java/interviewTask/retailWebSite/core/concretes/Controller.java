package interviewTask.retailWebSite.core.concretes;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
	
	LocalDateTime currentDate = LocalDateTime.now();
	 final int daylimit=31;//final variable  
	 final int mounthlimit=12;//final variable  
	 final int yearLimit=currentDate.getYear();//final variable  
	
	final int greatesLimitedNumberOfSecurityCode = 999;
	int calculatingDay = 0;
	int calculatingMounth = 0;
	int calculatingYear = 0;
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
		System.out.println("From register controll"+ jsonInput);
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
		
		try {
			if(data.substring(0,characterInterval).equals(headerCharacter)) {
				return false;
			}
			else {
				
				return true;
			}
		}
		catch (JSONException e){
			  e.printStackTrace();
			  
			  System.out.println("Please, Enter releated field");
			  
			  return false;
		}
	
	
	}
	
	public Boolean idConflictController(JSONObject jsonInput, int id) {
		
		System.out.println("id conflict controller"+" "+id);
		for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
			System.out.println("FROM İD CONTROLLER"+jsonInput.getJSONArray("data").getJSONObject(i).getString("personId"));
			/* If id is same either person id or car id */
			if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personId").equals(String.valueOf(id)) ||
					jsonInput.getJSONArray("data").getJSONObject(i).getString("cardId").equals(String.valueOf(id))){
					System.out.println("FROM İD CONTROLLER"+jsonInput.getJSONArray("data").getJSONObject(i).getString("personId"));
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
				
					return true;
				}
			}
			return false;
		}
		

	
	public Boolean characterController(String data) {
		if(data.isEmpty()) {
			System.out.println("This Field can not be lefted blank");
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
				
				return true;
			}
			else {
				return false;
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


public boolean emailController(String emailAddress) {
	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
              
	Pattern pat = Pattern.compile(emailRegex);
	if (pat == null)
		return false;
	
	return pat.matcher(emailAddress).matches();
}

public String customerTypeControll(JSONObject jsonInput) {
	String tempCustomer = "Being Affiliated" ;
	System.out.println("from customer controller"+jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCustomer"));
	if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCustomer").equals("affiliated")) {
		tempCustomer = "Being Customer";
	}
	return tempCustomer;
}

public boolean phoneController(JSONObject jsonInput, String response, String alternativeNumber) {
	for(int i = 0; i< jsonInput.getJSONArray("data").length(); i++) {
		if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber").equals(response)) {
			System.out.println("This phone has been registered before, Please, enter different number");
			return false;
		}
		System.out.println("from phone controoler"+jsonInput.getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber").equals(response));
	}
	if(response.equals(alternativeNumber)) {
		System.out.println("Numbers that both You have written  can not be same.");
		return false;
	}
	
	return true;
}

public boolean dateController(String number, String name) {
	LocalDate currentDate = LocalDate.now();
	
	if(name.equals("year")) {
		if( currentDate.getYear() - Integer.valueOf(number) < 0  ) {
			System.out.println("Year that you entered can not be greater than"+" "+currentDate.getYear());
			return false;
		}
		else if(currentDate.getYear() - Integer.valueOf(number) >= 0) {
			calculatingYear = currentDate.getYear() - Integer.valueOf(number) ;
			return true;
		}
	}
	else if(name.equals("mounth")) {
		if(Integer.valueOf(number) > mounthlimit) {
			System.out.println("INVALID MOUNT SELECTION");
			return false;
		}
		else {
			
			if(calculatingYear == 0) {
					
				if(currentDate.getMonthValue() - Integer.valueOf(number) < 0) {
					System.out.println("You can not enter number of mount is grater than current mounth. ");
					return false;
					}
				else {
					calculatingMounth = currentDate.getMonthValue() - Integer.valueOf(number) ;
					return true;
					}
				}
				
			else if(calculatingYear > 0) {
				if(Integer.valueOf(number) > currentDate.getMonthValue()) {
					calculatingMounth = Integer.valueOf(number) - currentDate.getMonthValue()   ;
				}
				else {
					calculatingMounth = currentDate.getMonthValue() - Integer.valueOf(number) ;
				}
				
			}
		System.out.println("calculate "+ calculatingDay);
		return true;
			
			
		}
	}
	
	else if(name.equals("day")) {
		
		
			if(calculatingMounth == 0 ) {
				if(currentDate.getDayOfMonth() - Integer.valueOf(number) < 0) {
					System.out.println("INVALID SELECTION, You can not chose date that is grater than today");
					return false;
				}
				else {
					calculatingDay = currentDate.getDayOfMonth() - Integer.valueOf(number);
					return true;
			}
			
		}
			else {
				if(Integer.valueOf(number) > currentDate.getMonthValue()) {
					calculatingDay = Integer.valueOf(number) -currentDate.getDayOfMonth()   ;
				}
				else {
					calculatingDay = currentDate.getDayOfMonth() - Integer.valueOf(number) ;
				}
			}
		
		
		return true;
	}
	return true;
}
}

	

