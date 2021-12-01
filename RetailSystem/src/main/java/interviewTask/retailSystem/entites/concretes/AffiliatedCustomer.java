package main.java.interviewTask.retailSystem.entites.concretes;

import java.util.Date;

public class AffiliatedCustomer extends Person {
	
	/* Common Variable */
	private String socialIdentityNumber;
	

	public AffiliatedCustomer(int id, String personName, String personSurname, String personMail, Card ownCardType,
			String personPhone, String personAlternativePhone, String personAddress, Date firstDayOfBeenCustomer,
			String socialIdentityNumber) {
		
		/* Those're passed to superclass named Person */
		super(id, personName, personSurname, personMail, 
				ownCardType, personPhone, personAlternativePhone, 
				personAddress);
		
		this.socialIdentityNumber = socialIdentityNumber;
	}
	
	/* SocialIdentity Number */
	public void setSocialIdentityNumber(String socialIdentityNumber) {
		
		this.socialIdentityNumber = socialIdentityNumber;
	}
	
	public String getSocialIdentityNumber() {
		return socialIdentityNumber;
	}

}
