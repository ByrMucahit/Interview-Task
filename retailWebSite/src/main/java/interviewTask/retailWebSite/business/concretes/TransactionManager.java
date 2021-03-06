package interviewTask.retailWebSite.business.concretes;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

import interviewTask.retailWebSite.business.abstracts.TransactionService;
import interviewTask.retailWebSite.core.concretes.Controller;
import interviewTask.retailWebSite.core.concretes.utilities.results.DataResult;
import interviewTask.retailWebSite.core.concretes.utilities.results.SuccessDataResult;
import interviewTask.retailWebSite.entities.concretes.Person;


public class TransactionManager implements TransactionService {
	
	/* Services */
	
	Scanner myObj = new Scanner(System.in);
	LocalDateTime currentDate = LocalDateTime.now();
	
	
	/* Paying Bill */
	@Override
	public boolean payBill(JSONObject jsonObject, JSONObject jsonDiscount, int amount) {
		/* Common Variable */
		int tempDiscount = 0 ;
		Controller checkpoint = new Controller();
		boolean flag;
		float greaterThan=0;
		int result= amount;
	
		/*Summary */
		System.out.println("--- PAYMENT SUMMARY---");
		System.out.println("-----------------------");
		System.out.println("--> amount is :"+ amount+" "+"$");
		
		try {
			if(jsonObject != null || jsonDiscount!=null) {
				/* Getting All Discount */
				tempDiscount = Integer.valueOf(jsonDiscount.getString("indirim"));
				
				if(tempDiscount == 5) {
					/* If User has been customer since two year */
					jsonObject.put("mounth", String.valueOf(currentDate.getMonthValue()));
					jsonObject.put("year", String.valueOf(currentDate.getYear()));
					jsonObject.put("day", String.valueOf(currentDate.getDayOfMonth()));
					result -= tempDiscount; 
					System.out.println("You have been our customer over 2 year That's Why %5 discount will have been applied your bill.");
					}
					/* All Discount */
					else if(tempDiscount == 20 || tempDiscount == 30 || tempDiscount == 10) {
							/* Print Result */
							int tempResult = 0;
							tempResult = (amount*(100 - tempDiscount))/100;
							System.out.println("--> Dear"+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personName")+" "+"You have"+" "+ 
							                       jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCard")+" "+"CARD");
							System.out.println("--> Applied Discount is:"+" "+"%"+tempDiscount);
							result = tempResult;
						}
				
			}
			else {
				System.out.println("We're sorry to tell that The percentage based discounts do not apply on phones.");
			}
			
			/* If  Amount is greater than 200 */
			flag = checkpoint.amountOfBillController(amount);
			/* Flag is true */
			if(flag) {
				greaterThan = calculateAmountOfDiscount(amount, 200);
				System.out.println("--> Your bill is greater than 200 then you gain"+" "+greaterThan+" "+"count "+" discount"+", "+ greaterThan*5+"$"+" "+"will have been identified your bill");
				result -= (greaterThan*5);
				/* Footer Summary */
				
			}
			
			System.out.println("--> amount paid is :"+ result+"$" );
			System.out.println("-----------------------");
			
			return true;
		
		}catch(JSONException e) {
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return false;
		}
			
		}
		
	/*
	 * Description:
	 * ----------------
	 * This method is used for paying bill.
	 * 
	 * Parameters:
	 * ----------------
	 * jsonObject: It's all data
	 * jsonDiscount: It's all Discount
	 * amount: It's Amount Of Discount
	 * 
	 * Return:
	 * True or false
	 * 
	 * ----------------------------------------------------------------------------
	 */

	/* Calculate Amount Of Discount */
	@Override
	public float calculateAmountOfDiscount(int result, int discount) {
		
		float temp= 0;
		try {
			temp = result / discount;
		}
		catch(JSONException e) {
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return temp;
		}
		
		return temp;
	}
	
	/*
	 * Description:
	 * ----------------
	 * This function is used for calculate over each 200 dolar.
	 * 
	 * 
	 * Parameters:
	 * ----------------
	 * result: It's amount of bill
	 * discount: It's discount
	 * 
	 * return:
	 * ----------------
	 * Amount of discounted bill is returned;
	 * 
	 * 
	 * ----------------------------------------------------------------------
	 */
	
	/* Calculate Discount Based On Process of being customer */
	@Override
	public long counterOfBillPaidOverStatedYear(JSONObject jsonObject) throws ParseException {
		/* Template count day */
		int countOfDay= 0;
		/* Calculate process of time*/
		String customerDate;
		String currentDate;
		
		Date dateCustomer;
		Date dateCurrent;
		
		try {
			LocalDateTime objectDate = LocalDateTime.now();
			
			System.out.println("From Counter of cill paid over stated year"+" "+jsonObject);
			
			customerDate = jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("mounth")+"/"+
						   jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("day")+"/"+
						   jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("year");
			
			currentDate = String.valueOf(objectDate.getMonthValue())+"/"+ String.valueOf(objectDate.getDayOfMonth()+"/"+String.valueOf(objectDate.getYear()));
			
			SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
			
			// Setting dates
			dateCustomer = dates.parse(customerDate);
			dateCurrent = dates.parse(currentDate);
			
			final long days = ChronoUnit.DAYS.between(dateCustomer.toInstant(), dateCurrent.toInstant());
			return days;
			
		}
		catch(JSONException e) {
            System.out.println("Someting went wrong");
			e.printStackTrace();
			
			return 0;
		}	
	}

	/*
	 * Description:
	 * ---------------
	 * This function is used for calculate how long user have been customer.
	 * 
	 * Parameters:
	 * ---------------
	 * jsonObject: It's all data
	 * 
	 * Return:
	 * --------------
	 * Calculated count of day is returned
	 * 
	 * -------------------------------------------------------------------------------
	 */
	
	
	/* Filling Blanked Fiedl */
	@Override
	public String fillingBlankedField(String request, int length, String headerCharacter, int interval) {
		/* Common Variable*/
		Controller checkpoint = new Controller();
		/* State Control Flag */
		boolean flag= true;
		/* Input  */
		String response = null;
		/* State Counter */
		int flagNumber ;
		try {
			
			/* Infinitive loop */
			while(flag) {
				/* ??nitial variable */
				flagNumber = 0;
				/* Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine();
				/* If Field left blank */
				if(checkpoint.characterController(response)) {
					/* State number is increased */
					flagNumber += 1;
					/*  */
					if(length != 0 ) {
						/* Check length of character */
						flag = checkpoint.characterLengthController(response, length);	
						/* ??f It is true */
						if(!flag) {
							flagNumber += 1;
						}
						else {
							System.out.println("Please, enter proper input correctly. ");
						}
					}
					else {
						flagNumber += 2;
					}
				}
				else {
					System.out.println("Please, You can not left blank.");
				}
				/* Flag number would achieve three, while loop will have been finished */
				if(flagNumber == 3) {
					flag = false;
				}
				else {
					flag = true;
				}
			}
			return response;
			
		}	
		catch(JSONException e) {
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * This function is used for filling blank.
	 * 
	 * Parameters:
	 * --------------
	 * request: It's request about releated field.
	 * length: Input length if Exist limited length.
	 * headerCharacter: If input need to be stated format
	 * interval: If input need to stated format in interval.
	 * 
	 * Return:
	 * --------------
	 * Entered input is returned
	 * 
	 * ----------------------------------------------------------------------------
	 */
	
	/* Filling Blank That need to be included integer value. */
	@Override
	public String fillingBlankedNumberField(String request, int length, String phone, String headerCharacter, int interval) {
		Controller checkpoint = new Controller();
		/* Common Variable */
		boolean flag= true;
		String response = null;
		/*int flagNumber;*/
		/*Infinitive Loop */
		
		try {
			while(flag) {
				/*flagNumber = 0;*/
				/* Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine();
				/* If Field left blank */
				if( checkpoint.characterController(response)) {
					/* Char Character Controoler */
					if(checkpoint.stringCharacterController(response)) {
						System.out.println("It's invalid that you have just written. It has just integer value");
					}
					else {
						flag = false;
					}
					/* If length is not zero */
					if(length != 0)
					{
						/* Length Condition */
						if(response.length() > length || response.length() < length) {	
						System.out.println("Input should consist of"+" "+length+" "+ "character");
						/*flagNumber -= 1;*/
						flag= true;
						}
					}
					else {
						/*flagNumber += 1;*/
						/* If header character exist */
						if(headerCharacter != null)
						{	
							/* Suitable Character Controller*/
							flag = checkpoint.properChartacterController(response, headerCharacter,interval);
							/* If it is not suitable */
							if(!flag) {
								flag = false;
							}
							else {
								System.out.println("Warning! Please enter correctly.");
								flag= true;
							}
						}
					}	
				}
				else {
					flag = true;
				}
			}
			return response;
		}
		catch(JSONException e) {
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "0";
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * This method is used for enter integer input from releated blank.
	 * 
	 *  Parameters:
	 *  -------------
	 *  request: It's request about releated field.
	 *  length:  Input length if Exist limited length.
	 *  phone:  It's String value that for check phone controll for prevent conflict.
	 *  headerCharacter: If input need to be stated format
	 *  interval: If input need to stated format in interval.
	 *  
	 *  Parameters:
	 *  -------------
	 *  Return entered input
	 *  
	 *  --------------------------------------------------------------------------------------
	 */

	/* Filling Optional Field */
	@Override
	public String fillingBlankedOptionalField(String request, String option1, String option2) {
		/* Common Variable */
		/* State Controll Flag */
		boolean flag= true;
		/* Entered Input */
		String response = null;
		try {
			/* Infinitive Loop */
			while(flag) {
				/* Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine().toUpperCase();
				/* If Response equals one of the any options */
				if(response.equals(option1) || response.equals(option2)) {
					flag = false;
				}
				else {
					flag = true;
					System.out.println("Please input one of"+" "+option1+" "+"or"+" "+option2);
				}
			}
			return response;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}
	
	/*
	 * Description:
	 * ---------------
	 * This method is used for enter input that is should be one of options.
	 * 
	 * Parameters:
	 * ---------------
	 * request: It's request about releated value that is desired.
	 * option1: It's one of the options that must be choosen.
	 * option2: It's one of the options that must be choosen.
	 * 
	 * Returns:
	 * ---------------
	 * Selection is returned.
	 * 
	 * 
	 * ------------------------------------------------------------------------
	 */
	
	/* Enter String Input */
	@Override
	public String fillingBlankedStringField(String request) {
		Controller checkpoint = new Controller();
		/* Common Variables*/
		/* Stated Controll Flag */
		boolean flag= true;
		/* Entered Input */
		String response = null;
		
		try {
			/* Infinitive Loops */
			while(flag) {
				/* Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine();
				/* Char Character checking */
				if(checkpoint.stringCharacterController(response)) {
					flag = false;
				}
				else {
					System.out.println("This Field can not be included number, please enter suitable something");
					flag = true;
				}
			}
			return response;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}

	/*
	 * Description:
	 * --------------
	 * This function is used for enter string input.
	 * 
	 * Parameters:
	 * --------------
	 * request: It's request about releated value that is desired.
	 * 
	 * Returns:
	 * --------------
	 * Entered input is returned
	 * 
	 * -------------------------------------------------------------------------
	 */


	/* Filing Multiple Selection Date */
	@Override
	public String fillingMultipleSelectionDate(String request, int length, int[] name) {
		Controller checkpoint = new Controller();
		/* Common Variables */
		boolean flag= true;
		/* Response */
		String response = null;
		/* Iterator Flag */
		int flagNumber ;
		/* Iterator initial */
		flagNumber = 0;
		
		try {
			/* Infinitive Loop */
			while(flag) {
				/* Print Request */
				System.out.println(request);
				/* Input Object*/
				response = myObj.nextLine();
				/* Character Controller */
				if(!checkpoint.characterController(response)) {
					flag = true;
				}
				else {
					/* If response is selection that user wants to */
					if(Integer.valueOf(response) >= name.length) {
						System.out.println("INVALID SELECTION");
						/* To continue */
						flag = true;
					}
					/* If user would choose that is not exist as option */
					else {
						/* To Exit Loop */
						flag = false;
					}
				}
			}
			return response;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}

	/*
	 * Description:
	 * -------------
	 * This method is used for selection one of the multiple options.
	 * 
	 * Parameters:
	 * -------------
	 * request: It's request about releated value that is desired.
	 * length: Limit of length of selection
	 * name: It's array include selection of user
	 * 
	 * Returns:
	 * -------------
	 * Entered input is returned
	 * 
	 * ------------------------------------------------------------------------
	 */
	
	
	/* Fill Mail Field */
	@Override
	public String fillBlankedMailSpace(String request) {
		Controller checkpoint = new Controller();
		/* Common Variable */
		/* State Controller */
		boolean flag= true;
		String response = null;
		/*int flagNumber ;*/
		
		try {
			/* Infinitive Loop */
			while(flag) {
				/* flagNumber = 0;*/
				/* Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine();
			/* Empty Character Controller */
			if(!checkpoint.characterController(response)) {
				flag = true;
			}
			else {
				/* It is email */
				if(checkpoint.emailController(response)) {
					/* Exit Function */
					flag = false;
				}
				else {
					/* Wrong Warning */
					flag = true;
					System.out.println("Please, enter your mail as *******@****.com");
					}
				}
			}
			return response;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}

	/*
	 * Description:
	 * -------------
	 * This method is used for input mail.
	 * 
	 * Parameters:
	 * -------------
	 * request: It's request about releated value that is desired.
	 * 
	 * Return:
	 * -------------
	 * Mail is returned.
	 * 
	 * --------------------------------------------------------------------
	 */
	
	
	/* Filling telephone number on releated field */
	@Override
	public String fillingBlankedTelephoneNumber(String request, JSONObject jsonInput, int length, String headerCharacter, int interval, String alternativeNumber,String check) {
		Controller checkpoint = new Controller();
		/* Common Variable */
		/* State Controller */
		boolean flag= true;
		/* Entered Input */
		String response = null;
		
		try {
			/* Infinitive Loop */
			while(flag) {
				
				/*Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine();
				/* Empty Character Controller */
				if( checkpoint.characterController(response)) {
					/* String Character Controller */
					if(checkpoint.stringCharacterController(response)) {
						System.out.println("It's invalid that you have just written. It has just integer value");
						/* Continue to loop */
						flag = true;
					}
					else {
						/* To exit loop */
						flag = false;
						/* Length Controller */
						if(response.length() != length && length != 0) {	
							/* Warning */
							System.out.println("Input should consist of"+" "+length+" "+ "character");
							/*flagNumber -= 1;*/
							/* Continue to loop */
							flag= true;
						}
						else {
							/* Exit to loop */
							flag= false;
							/*Header Character Check */
							if(headerCharacter != null)
							{
								/* Proper Character Checking */
								flag = checkpoint.properChartacterController(response, headerCharacter,interval);
								if(!flag) {
									/* To exit loop */
									flag = false;
								}
								else {
									/* Warning */
									System.out.println("Warning! Please enter correctly.");
									/* To Continue */
									flag= true;
								}
							}
							if(!check.equals("null"))
							{
								/* Phone Controller */
								if(checkpoint.phoneController(jsonInput, response, alternativeNumber)) {
									/* To exit loop */
									flag = false;
								}
								else {
									/* to continue loop */
								flag= true;
								}
							}
						}	
					}
				
				}
				else {
					flag = true;
				}
			
			}
			/* to continue loop */
			return response;
		}	
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * This method is used for filling Telephone number on related field.
	 * 
	 * Parameters:
	 * --------------
	 * request: It's request about releated value that is desired.
	 * jsonInput: It's all data.
	 * length: Limit of length of selection
	 * headerCharacter: It's desired format.
	 * interval: It's desired format in releated interval.
	 * alternativeNumber: Alternative telephone number:
	 * check: If it's not null apply check process.
	 * 
	 * Return:
	 * -------------
	 * Telephone number that user have written is returned.
	 */



	/* Filling Date*/
	@Override
	public String fillingBlankedDate(String request,int length, String name) {
		Controller checkpoint = new Controller();
		/* Common Variable */
		boolean flag= true;
		String response = null;
		
		try {
			/* Infinitive Loop */
			while(flag) {
				/*flagNumber = 0;*/
				/* Print Request */
				System.out.println(request);
				/* Input Object */
				response = myObj.nextLine();
				/* Input Empty Controller */
				if( checkpoint.characterController(response)) {
					/* String Character Controller */
					if(checkpoint.stringCharacterController(response)) {
						System.out.println("It's invalid that you have just written. It has just integer value");
						/* Continue to loop */
						flag = true;
					}
					else {
						/* to exit loop */
						flag = false;
						/* Length Controller */
						if(response.length() >= length && length != 0) {	
							/*Warning */
							System.out.println("Input should consist of"+" "+(length-1)+" "+ "character");
							/*flagNumber -= 1;*/
							/* Exit loop */
							flag= true;
							
						}
						else {
							if(checkpoint.dateController(response, name))
							{
								/*flagNumber += 1;*/
								flag= false;
							}
							else {
								/* Continue to loop */
								flag = true;
							}	
						}	
					}
				}
				else {
					/* Continue to loop */
					flag = true;
				}
			}
			return response;
		}	
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return "null";
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * this method is used for filling date to releated field.
	 * 
	 * Parameters:
	 * --------------
	 * request: It's request about releated value that is desired.
	 * length:  Limit of length of selection
	 * name: It's array include selection of user
	 *
	 * Returns:
	 * ---------------
	 * Date that user have entered is returned.
	 */
	

	/* Be Affiliated */
	@Override
	public JSONObject beAffiliated(JSONObject jsonObject) {
		Controller checkpoint = new Controller();
		/* State Controller Flag */
		boolean flag;
		
		try {
			/* Customer Controller */
			flag = checkpoint.customerController(jsonObject);
			/* If it's true */
			if(flag)
			{	
				/* Be Customer */
				System.out.println("You have been customer");
				jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer","null");
			}
			else {
				/* Getting Social Identity Number */
				String temp = fillingBlankedNumberField("Please ENTER social identfier. It's required. It should be consist of 11 character",11, null, null, 0);
				System.out.println("You have been affiliated");
				/* Update JSON */
				jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("socialIdentityNumber",temp);
				jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("typeOfCustomer","affiliated");
				System.out.println("You're afailated");
			}
			
			return jsonObject;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Description:
	 * --------------
	 * the method is used for change type of customer.
	 * 
	 * Parameters:
	 * --------------
	 * jsonObject: It's all data
	 * 
	 * Returns:
	 * -------------
	 * Update all data is returned.
	 * 
	 * -------------------------------------------------------------------
	 */
	
	/* Change Password */
	@Override
	public JSONObject changePassword(JSONObject jsonObject) {
		Controller checkpoint = new Controller();
		/* Common Variable */
		String response ;
		String tempResponse;
		boolean flag;
		
		try {
			System.out.println("FOR TESTING !!!!, Your password's"+": "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword"));
			/* Enter Input that is should be integer character */
			response = fillingBlankedNumberField("Please enter current password?",4, null, null, 0);
			/* Passsword Controller */
			flag = checkpoint.passwordController(response, jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword"));
			if(flag) {
				response = fillingBlankedNumberField("Please enter new password",4,null, null, 0);
				tempResponse = fillingBlankedNumberField("Please enter new password again",4,null, null, 0);
				flag = checkpoint.passwordController(response, tempResponse);
				
				if(flag) {
				if(checkpoint.passwordController(response,jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword")))
					System.out.println("Password could not be same with previous password, Password hasn't been changed");
				
				else {
					jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).put("cardPassword", response);
					System.out.println("Password has been changed. You can check it out in account detail.");
				}
				}
				else {
					System.out.println("You should enter both password correctly.");
					}
				}
			else {
				System.out.println("You have entered password not corectly.");
			}
			return jsonObject;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Description:
	 * --------------
	 * This method is used for change password.
	 * 
	 * 
	 * Parameters:
	 * --------------
	 * jsonObject: It's all data
	 * 
	 * Return:
	 * --------------
	 * All data is returned
	 * 
	 * --------------------------------------------------------------------------------------
	 */
	
	/* Getting Listed */
	@Override
	public void gettingListed(JSONObject jsonObject) {
		
		
		try {
			
			/* Printed Header Summary */
			System.out.println("----------------------------------");
			System.out.println("##### ALL CUSTOMER #####");
			System.out.println("All Account Detail");
			/* Length Of Object */
			System.out.println("Your account Detail"+" "+(jsonObject.getJSONObject("data").getJSONArray("data").length()-1));
			/* iterative Loop */
			for(int i = 1 ; i < jsonObject.getJSONObject("data").getJSONArray("data").length(); i++) {
				System.out.println("-> Person Full Name"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personName")+
								   " "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personSurname")+"\n"+
							       "-> Person Id"+":"+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personId")+"\n"+
								   "-> Person Mail"+":"+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personMail")+"\n"+
								   "-> Person Telephone Number"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personTelephoneNumber")+"\n"+
								   "-> Person Alternative Telephone Number"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personAlternativeTelephoneNumber")+"\n"+
								   "-> Person Address"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("personAddress")+"\n"+
								   "-> Person Card Id"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("cardId")+"\n"+
								   "-> Person Card Number"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("cardNumber")+"\n"+
								   "-> Person Card Security Number:"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("cardSecurityNumber")+"\n"+
								   "-> Vary Of Customer"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("typeOfCustomer")+"\n"+
								   "-> Vary Of Card"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("typeOfCard")+"\n"+
								   "-> Date Of Been Customer"+":"+" "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("year")+"/"+
								    jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("mounth")+"/"+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(i).getString("day")
									   );
					System.out.println("--------------------------------------------");
				}
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
		}
	}
	
	/*
	 * Description:
	 * ---------------
	 * This method used for print all that comes from other methods.
	 * 
	 * Parameters:
	 * ---------------
	 * jsonObject: It's all data
	 * 
	 * Returns:
	 * ---------------
	 * None
	 * 
	 * ------------------------------------------------------------------
	 */
	
	/* Printing Account */
	@Override
	public void printing(JSONObject jsonObject) {
		try {
			/* Individual Account Listing */
			System.out.println("------Your account Detail-----");
			System.out.println( "* Your Full Name  is: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personName").toUpperCase()+" "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personSurname").toUpperCase()+"\n"+
								"* Your Id: "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personId")+"\n"+
								"* Your Mail: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personMail") +"\n"+
								"* Your Telephone Number: "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personTelephoneNumber") +"\n"+
								"* Alternative Telephone Number: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personAlternativeTelephoneNumber") +"\n"+
								"* Your Address: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("personAddress") +"\n"+
								"* Card Id: "+  jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardId") +"\n"+
								"* Card Number:"+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardNumber") +"\n"+
								"* Card Security Number:"+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardSecurityNumber") +"\n"+
								"* Your Percenatage Of Discount: "+jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("percentageOfDiscount") +"\n"+
								"* Card Password: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("cardPassword") +"\n"+
								"* Amount Of Discount Usage: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("amountOfDiscountUsage") +"\n"+	
								"* Type Of Customer: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCustomer") +"\n"+	
								"* Type Of Card: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("typeOfCard") +"\n" +	
								"* Year: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("year") +"\n"+	
								"* Mounth: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("mounth") +"\n"+	
								"* Day: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("day") +"\n"	
								);
			/* If user is affliated, user has social identity info */
			if(!jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("socialIdentityNumber").equals("null")){
					System.out.println("Social Identity: "+ jsonObject.getJSONObject("data").getJSONArray("data").getJSONObject(jsonObject.getInt("userId")).getString("socialIdentityNumber"));
			}
			System.out.println("-------------------------------------");
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
		}
	}
	
	/*
	 * Description:
	 * -------------
	 * This method is used for print an account.
	 * 
	 * Parameters:
	 * -------------
	 * jsonObject: all data
	 * 
	 * Return:
	 * -------------
	 * None
	 * 
	 * ----------------------------------------------------------------
	 */


	/* Print All Discount */
	@Override
	public SuccessDataResult discountPrinter(JSONObject jsonInput, JSONObject discountObject) {
		/*Commont Variable*/
		/* Variable is initialed */
		String tempTypeOfDiscount= "";
		String response;
		int tempIndex= 0;
		/* State controller */
		boolean flag;
		/* Array keeps those're selection of user*/
		int [] selection = new int[discountObject.getJSONArray("discount").length()];
		
		System.out.println("discount object from discount printer"+" "+discountObject);
		
		try {
			/* If discount is exist */
			if(!discountObject.getJSONArray("discount").getJSONObject(0).getString("indirim").equals("0"))
			{	
				/* View discount user has */
				for(int i = 0; i < discountObject.getJSONArray("discount").length(); i++) {
					if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 10) {
						System.out.println(i+".:"+" You're the affiliated that's why YOU CAN USE"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
						tempTypeOfDiscount= "DICOUNT FOR BEING AFFILIATED ";
					}
					else if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 30) {
						System.out.println(i+".:"+" You have GOLDEN CARD that's why YOU CAN USE"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
						tempTypeOfDiscount= "DICOUNT FOR YOU HAVE GOLDEN CARD ";
					}
					
					else if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 20) {
						System.out.println(i+".:"+" You have SILVER CARD that's why YOU CAN USE"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
						tempTypeOfDiscount= "DICOUNT FOR YOU SILVER CARD ";
					}
					
					else if(Integer.valueOf(discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")) == 5) {
						System.out.println(i+".:"+" You have been our customer over two year"+" "+discountObject.getJSONArray("discount").getJSONObject(i).getString("indirim")+"%");
						tempTypeOfDiscount= "DICOUNT FOR YOU HAVE BEEN CUSTOMER 2 YEAR ";
					}
				}
				/* Adding selection of user to array */
				for(int i = 0 ; i< discountObject.getJSONArray("discount").length(); i++) {
					selection[i] = i;
				}
				/* Selection Of User*/
				response = fillingMultipleSelectionDate("You're enable selection to discount as shown above. Please enter number. Don't Forget YOU CAN USE ONLY ONE.",1,selection);
				
				/*Temp Index From Discount*/
				tempIndex = Integer.valueOf(response);
				
				if(discountObject.getJSONArray("discount").getJSONObject(tempIndex).getString("indirim").equals("5")) {
					System.out.println("Hello World");
					jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("mounth", String.valueOf(currentDate.getMonthValue()));
					jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("year", String.valueOf(currentDate.getYear()));
					jsonInput.getJSONObject("data").getJSONArray("data").getJSONObject(jsonInput.getInt("userId")).put("day", String.valueOf(currentDate.getDayOfMonth()));
				}
				
				
				System.out.println("YOU HAVE SELECTED: "+" "+tempIndex+"."+" "+ tempTypeOfDiscount +discountObject.getJSONArray("discount").getJSONObject(tempIndex));
				return new SuccessDataResult<List<Person>>
				(jsonInput.getJSONObject("data"),discountObject, tempIndex, "data has been achieved successfully");
			}
			else{
				System.out.println("There is no discount");
				return new SuccessDataResult<List<Person>>
				(null,null, 0, "false");
			}
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return new SuccessDataResult<List<Person>>
			(null,null, 0, "false");
		}
	}

	
	/*
	 * Description:
	 * -----------------
	 * This method is used for print all discount
	 * 
	 * Parameters:
	 * -----------------
	 * discountObject: It's all data
	 * 
	 * 
	 * Return:
	 * ----------------
	 * Seletion of user is returned;
	 * 
	 * -----------------------------------------------------------
	 */
	

	/* Update JSON */
	@Override
	public SuccessDataResult<List<Person>> updateJson(JSONObject jsonInput, JSONObject jsonTempInput) {
		try {
			/* Update Transaction */
			jsonInput.getJSONArray("data").getJSONObject(jsonTempInput.getInt("userId")).put("typeOfCard",jsonTempInput.getJSONObject("data").getString("typeOfCard"));
			jsonInput.getJSONArray("data").getJSONObject(jsonTempInput.getInt("userId")).put("percentageOfDiscount",jsonTempInput.getJSONObject("data").getString("percentageOfDiscount"));
			
			return new SuccessDataResult<List<Person>> 
					(jsonInput,jsonTempInput.getInt("userId"),"Change has been done successfully" ) ;
		}
		catch(JSONException e) {
			/* If Something went wrong*/
            System.out.println("Someting went wrong");
			e.printStackTrace();
			return new SuccessDataResult<List<Person>> 
			(null,0,"Change hasn't been done successfully" ) ;
		}
		
	}

	/*
	 * Description:
	 * -------------
	 * This method is used for update to JSON.
	 * 
	 * Parameters:
	 * -------------
	 * jsonInput: All data, that is going to be updated;
	 * jsonTempInput: It updates to main JSON.
	 * 
	 * Returns:
	 * -------------
	 * JAVA object is returned. It has three variables, those're all data, used id and message.
	 * 
	 */

	
}
