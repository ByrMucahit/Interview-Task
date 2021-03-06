package interviewTask.retailWebSite.core.concretes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.business.concretes.TransactionManager;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.regex.Pattern;

public class Controller {
	/* Getting Date Information */
	LocalDateTime currentDate = LocalDateTime.now();
	 /* Final variables */
	 final int daylimit=31;
	 final int mounthlimit=12;  
	 final int yearLimit=currentDate.getYear(); 
	 final int greatesLimitedNumberOfSecurityCode = 999;
	 
	 /* Those Keep Date Detail */
	 int calculatingDay = 0;
	 int calculatingMounth = 0;
	 int calculatingYear = 0;
	 
	 /* Services */
	 TransactionService transactionManager = new TransactionManager();
	
	 /* Device Controller */
	 public Boolean deviceController() {
		/* State Controller Flag */
		String yesNoFlag;
		try {
			/* Input that has option to selection */
			yesNoFlag = transactionManager.fillingBlankedOptionalField("Are you buying phone?[Y/N]!!!","Y","N").toUpperCase();
			/* Condition */
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
		catch (JSONException e) {
			System.out.println("Something went wrong");
            e.printStackTrace();
            return true;
		}
		
	}
	 
	/*
	 * Description:
	 * -------------
	 * This function is controller that aim is which device user does shopping.
	 * 
	 * Prameters:
	 * -------------
	 * None
	 * 
	 * Return
	 * -------------
	 * False value is returned If User is shopping with using phone, otherwise
	 * returned true value.
	*-------------------------------------------------------------------------------------------
	*
	 * */
	
	 /* Register Controller */
	public int registerContoller(String telephoneNumber, JSONObject jsonInput) {	
		/* Temp index that keeps value of index */
		int index = 0;
		
		/* Try Catch */
		try {
		/* Loop */
	    for (int i = 0, size = jsonInput.getJSONArray("data").length(); i < size; i++)
	    	{
	    		
	    			/* If Telephone number that is entered by current user has been within JSON */
	    			if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber").equals(telephoneNumber)){
	    				/* Variable Updating */
	    				index = i;
	    				/* When Condition is realized, index will have been returned */
	    				return index ;
	    			}
	    		}
			}
	    		catch (Exception e) {
	    			System.out.println("The phone hasn't been registered");
	    			return -1;
	    	    }
	    	
	    /* User hasn't been registered yet */
	    return -1;
		}
	
	 /* Customer Process Controller */
	public Boolean processController(JSONObject jsonInput) throws ParseException {
		/* Variable */
		long temp = 0;
		try {
			/* Is User being customer since 2 year */
			temp = transactionManager.counterOfBillPaidOverStatedYear(jsonInput);
			
			/* If User is */
			if(temp >= 730) {
				return true;
			}
			/* If User is not */
			else {
				return false;
			}
		}
		catch (JSONException e) {
			System.out.println("Something went wrong");
            e.printStackTrace();
            return true;
		}
	
	}
	
	/*
	 * Description:
	 * -------------
	 * This function checks What User have done so far.
	 * 
	 * Parameters:
	 * -------------
	 * json: All data
	 * 
	 * Return:
	 * -------------
	 * ??f User has been customer since two year, false value will have been returned,
	 * other wise true.
	 * -------------------------------------------------------------------------------------------
	 *  */
	
	/* Discount Controller */
	public JSONObject discountController(JSONObject jsonInput) throws JSONException, ParseException {
		/* Temp variable */
		String AmountOfDiscount;
		/* Object Building */
		JSONObject jsonDiscount = new JSONObject();
		JSONArray jDiscountArray = new JSONArray();
		
		/* Device Check */
		try {
			/* view of count Of discount user deserved */
			AmountOfDiscount = countOfDiscountUsage(jsonInput);
			
			if(deviceController()) {
				/* Type of customer check */
				if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCustomer").equals("affiliated")){
					/* Inner  object Building*/
					JSONObject jInnerObject = new JSONObject();
					jInnerObject.put("indirim","10");
					jDiscountArray.put(jInnerObject);
					jsonDiscount.put("discount", jDiscountArray);
				}
			
				/* If User has a GOLD CARD */
				if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("GOLDCARD")) {
					/* Inner  object Building*/ 
					JSONObject jInnerObject = new JSONObject();
					jInnerObject.put("indirim","30");
					jDiscountArray.put(jInnerObject);
					jsonDiscount.put("discount", jDiscountArray);
				}
				/* If User has a SILVER CARD */
				else if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCard").equals("SILVERCARD")) {
					/* Inner  object Building*/ 
					JSONObject jInnerObject = new JSONObject();
					jInnerObject.put("indirim","20");
					jDiscountArray.put(jInnerObject);
					jsonDiscount.put("discount", jDiscountArray);
				}
			}
				/* If device which is Phone that  User had been shopping */
				else {
					/* Object building */
					JSONObject jInnerObject = new JSONObject();
					jInnerObject.put("indirim","0");
					jDiscountArray.put(jInnerObject);
					jsonDiscount.put("discount", jDiscountArray);
				}

			/* All discount User have */
			return jsonDiscount;
		}
		catch(JSONException e) {
			
            System.out.println("Something went wrong");
			e.printStackTrace();	
			return jsonDiscount;
		}
	}
	
	/*
	 * Description:
	 * -------------
	 * This function calculate count of discount User have.
	 * 
	 * Parameters:
	 * -------------
	 * jsonInput: All data 
	 * 
	 * Return:
	 * ------------
	 * All discount user have
	 * 
	 * -------------------------------------------------------------------------------------------
	 *  */
	
	/* Bill controller */
	public Boolean amountOfBillController(float result) {
		try {
			/* If bill is greater than 200 */
			if(result >= 200) {
				return true;
			}
			/* If it is not */
			return false;
		}
		catch(JSONException e) {
            
			System.out.println("Something went wrong");
			e.printStackTrace();
			return true;
		}
	}
	
	/*
	 * Description:
	 * This function is used for checking  bill .
	 * 
	 * Parameters:
	 * result: It's a bill to checking
	 * 
	 * Return: 
	 * If result is greater than 200, True value is returned, otherwise
	 * false value is returnned.
	 * 
	 * -------------------------------------------------------------------------------------------
	 *  */
	
	/* Count of Discount that user is enable to use */
	public String countOfDiscountUsage(JSONObject jsonInput) {
		try {
			/* Temp Variable */
			String temp;
			/* Count of discount value user has is passed into variable. */
			temp = jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("amountOfDiscountUsage");
			/* Return count of discount */
			return temp;
		}
		catch(JSONException e) {
            
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}
	}
	
	/* 
	 * Description:
	 * --------------
	 * This function is used to calculating of discount which is user is enable to use
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * 
	 * Return:
	 * --------------
	 * Count of discount is returned
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	/* Character length controller */
	public Boolean characterLengthController(String data, int length) {
		try {
			/* If length of input is suitable of desired length */
			if(data.length() == length) {
				return false;
			}
			else {
				return true;
			}
		}
		catch(JSONException e) {
            
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * It's used for checking length is suitable.
	 * 
	 * Parameters:
	 * --------------
	 * data: It's input
	 * length: Desired length
	 * 
	 * Return:
	 * --------------
	 * If data is suitable on desired length, returned value will have been false,
	 * otherwise true
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	/* Proper character controller */
	public Boolean properChartacterController(String data, String headerCharacter, int characterInterval) {
		/* Try-Catch */
		try {
			/* If character that is number of desired from user is suitable. */
			if(data.substring(0,characterInterval).equals(headerCharacter)) {
				return false;
			}
			else {
				return true;
			}
		}
		catch (JSONException e){
			  e.printStackTrace();
			  System.out.println("Something went wrong");
			  return false;
		}
	}
	
	/*
	 * Description
	 * --------------
	 * This function is used for suitable format controller.
	 * 
	 * Parameters:
	 * --------------
	 * data: data that is  desired being suitable format is input.
	 * headerCharacter: Character that is needed having.
	 * characterInterval:  Character that is needed interval.
	 * 
	 * Return:
	 * --------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 *  */
	
	/* Id Conflict Controller */
	public Boolean idConflictController(JSONObject jsonInput, int id) {
		try {
			/* iteration of all id */
			for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
				/* If id is same either person id or car id */
				if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personId").equals(String.valueOf(id)) ||
						jsonInput.getJSONArray("data").getJSONObject(i).getString("cardId").equals(String.valueOf(id))){
					return true;
				}
			}
			return false;	
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong");
			  return false;
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * This function is used for check id to prevent conflict.
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * id:  Id that has just generated by function.
	 * 
	 * Returns:
	 * --------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	/* Card number conflict controller */
	public Boolean cardNumberConflictController(JSONObject jsonInput, int cardNumber ) {
		try {
			/* iteration of all card number */ 
			for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
				if(jsonInput.getJSONArray("data").getJSONObject(i).getString("cardNumber").equals(String.valueOf(cardNumber))){
					return true;
				}
			}
			return false;
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println("Something went wrong");
			  return false;
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * This function is used for check card number to prevent conflict
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * cardNumber:  Card Number that has just generated by function
	 * 
	 * Return:
	 * --------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	/* Security Number Conflict Controller */
	public Boolean securityNumberConflictController(JSONObject jsonInput, int securityNumber ) {
		try {
			/* iteration of all security number */ 
			for(int i = 0; i < jsonInput.getJSONArray("data").length(); i++) {
				if(jsonInput.getJSONArray("data").getJSONObject(i).getString("cardSecurityNumber").equals(String.valueOf(securityNumber))&&
					securityNumber < greatesLimitedNumberOfSecurityCode){
			
						return true;
					}
				}
				return false;
			}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return false;
		}
	}
		
	/*
	 * Description:
	 * --------------
	 * This function is used for check security number to prevent conflict
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * cardNumber: Security Number that has just generated by function
	 * 
	 * Return:
	 * --------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	/* Checking Blank Filed */
	public Boolean characterController(String data) {
		try {
			/* If Input field lefted blank */
			if(data.isEmpty()) {
				System.out.println("This Field can not be lefted blank");
				return false;
			}
			return true;	
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return false;
		}
	}
	
	/* String Character Controller */
	public Boolean stringCharacterController(String data) {
		/* Temp size */
		int size;
		
		try {
			/* Getting suitable form to data. */
			data=data.toLowerCase();
			data=data.replaceAll("\\s","");
		    char[] ch=data.toCharArray();
		    size =data.length();
		    
			for(int i = 0; i< size; i++) {
				/* Char character  comparison*/
				if((ch[i] >= 'a' && ch[i]<= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
					
					return true;
				}
				else {
					return false;
				}
			}
			
			return false;
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return false;
		}
	}
	
	/*
	 * Description:
	 * -------------
	 * This function is used for check  data that is included char character.
	 * 
	 * Parameters:
	 * -------------
	 * data: It's going to be checked on data.
	 * 
	 * Return:
	 * -------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 *  */
	
	/* Password Controller */
	public Boolean passwordController(String password, String repeatPassword) {
		try {
			/* Check Password with the password repeat write again */
			if(password.equals(repeatPassword)) {
				return true;
			}
			return false;
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return false;
		}
	}
	
	/* 
	 * Description:
	 * --------------
	 * This function is used for check password with password User has written again.
	 * 
	 * Parameters:
	 * --------------
	 * password: It's used card password
	 * repeatPassword: It's validation of password.
	 * 
	 * Return:
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	/* Cutomer Controller */
	public Boolean customerController(JSONObject jsonObject) {
		try {
			/* If customer is affiliated. */
			if(jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer").equals("affiliated")) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return false;
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * This function is used for check type of customer .
	 * 
	 * Parameters:
	 * --------------
	 * jsonObject: All data
	 * 
	 * Returns:
	 * --------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 */

	/* Email Controller */
	public boolean emailController(String emailAddress) {
		/* Regex Variable */
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";
		try {
			/* Regex Object */
			Pattern pat = Pattern.compile(emailRegex);
			if (pat == null)
				return false;
			return pat.matcher(emailAddress).matches();	
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return false;
		}
	}

	/* 
	 * Description:
	 * -------------
	 * This function is used for check  suitable email format.
	 * 
	 * Parameters:
	 * -------------
	 * emailAddress: It's input
	 * 
	 * Return:
	 * -------------
	 * True/false
	 * 
	 * -------------------------------------------------------------------------------------------
	 * 
	 * */
	
	/* Customer Type Controller */
	public String customerTypeControll(JSONObject jsonInput) {
		/* Temp Variable that keeps type of customer */
		String tempCustomer = "Being Affiliated" ;
		try {
			/* If user is affiliated*/
			if(jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).getString("typeOfCustomer").equals("affiliated")) {
				tempCustomer = "Being Customer";
			}
			return tempCustomer;
		}
		catch (JSONException e){
			
			  e.printStackTrace();
			  System.out.println(" Something went wrong)");
			  return null;
		}
	}
	
	/*
	 * Description:
	 * -------------
	 * This function is used for check type of customer;
	 * 
	 * Parameters:
	 * -------------
	 * jsonInput: All data
	 * 
	 * Returns:
	 * -------------
	 * true/false
	 * 
	 * -------------------------------------------------------------------------------------------
	 */
	
	/* Phone Controller */
	public boolean phoneController(JSONObject jsonInput, String response, String alternativeNumber) {
		try {
			/* Iterate all phone number */
			for(int i = 0; i< jsonInput.getJSONArray("data").length(); i++) {
				/* If telephone number user has just entered is the sampe with telephone number within json. */
				if(jsonInput.getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber").equals(response)) {
					return false;
				}
			}
			if(response.equals(alternativeNumber)) {
				return false;
		}
		return true;
	}
	catch (JSONException e){
			
			e.printStackTrace();
			System.out.println(" Something went wrong)");
			return false;
		}
}
	/* 
	 * Description:
	 * --------------
	 * This function is used for telephone number controller.
	 * 
	 * Parameters:
	 * --------------
	 * jsonInput: All data
	 * response: It's input
	 * alternativeNumber: It's input
	 * 
	 * return:
	 * --------------
	 * true/false
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */

	/* Date Controller */
	public boolean dateController(String number, String name) {
		try {
			/* Date Objection */
			LocalDate currentDate = LocalDate.now();
			
			/* Year */
			if(name.equals("year")) {
				/* Entered year is greater than current year. */
				if( currentDate.getYear() - Integer.valueOf(number) < 0  ) {
					System.out.println("Year that you entered can not be greater than"+" "+currentDate.getYear());
					return false;
				}
				/* Entered year is smaller than current year. */
				else if(currentDate.getYear() - Integer.valueOf(number) >= 0) {
					calculatingYear = currentDate.getYear() - Integer.valueOf(number) ;
					return true;
					}
				}
			/* Mounth */
			else if(name.equals("mounth")) {
				/* Entered mounth is greater than 30. */
				if(Integer.valueOf(number) > mounthlimit) {
					System.out.println("INVALID MOUNT SELECTION");
					return false;
				}
				else {
					/* User haven't been customer smaller than 1 year. */
					if(calculatingYear == 0) {
						/* User haven't been customer smaller than 1 year. */
						if(currentDate.getMonthValue() - Integer.valueOf(number) < 0) {
							System.out.println("You can not enter number of mount is grater than current mounth. ");
							return false;
							}
						/* User have been customer greater than 1 year. */
						else {
							calculatingMounth = currentDate.getMonthValue() - Integer.valueOf(number) ;
							return true;
							}
						}
					/* User have been customer smaller than 1 year. */ 
					else if(calculatingYear > 0) {
						if(Integer.valueOf(number) >= currentDate.getMonthValue()) {
							calculatingMounth = Integer.valueOf(number) - currentDate.getMonthValue()   ;
							return true;
						}
						/* User have been customer greater than 1 year. */ 
					else {
						calculatingMounth = currentDate.getMonthValue() - Integer.valueOf(number) ;
						return true;
					}	
				}
			return true;
				
			}
		}
		
		/* Day */
		else if(name.equals("day")) {
				/* If mounth is the current mounth */
				if(calculatingMounth == 0 && calculatingYear == 0 ) {
					if(currentDate.getDayOfMonth() - Integer.valueOf(number) < 0) {
						System.out.println("INVALID SELECTION, You can not chose date that is grater than today");
						return false;
					}
					/* Different Mounth */
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
		 catch (JSONException e){
			
			e.printStackTrace();
			System.out.println(" Something went wrong)");
			return false;
		 }
		}
	
	/*
	 * Description:
	 * -------------
	 * This function is used for date controller.
	 * 
	 * Parameters:
	 * -------------
	 * String number: It's number of Mounth or Year or Day
	 * String name: It's mounth, day or year
	 * 
	 * Returns:
	 * ------------
	 * True/False
	 * 
	 * -------------------------------------------------------------------------------------------
	 * */
	
	}




