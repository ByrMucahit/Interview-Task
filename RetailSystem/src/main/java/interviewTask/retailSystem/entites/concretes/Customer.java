package main.java.interviewTask.retailSystem.entites.concretes;

import java.util.Date;

public class Customer extends Person {

	
	public Customer(int id, String personName, String personSurname, 
			String personMail, Card ownCardType, String personPhone, 
			String personAlternativePhone, String personAddress) {
		
		super(id, personName, personSurname, personMail, ownCardType, personPhone, personAlternativePhone, personAddress);
		
	}

}
