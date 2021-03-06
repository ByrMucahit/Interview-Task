package interviewTask.retailWebSite.entities.concretes;

import java.util.Date;


public abstract class Person {
	/* Common Person Attribute */
	private int id;
	private String personName;
	private String personSurname;
	private String personMail;
	private String personPhone;
	private String personAlternativePhone;
	private String personAddress;
	private String firstDayOfBeenCustomer;
	private Card ownCardType;
	private String typeOfAffiliate;
	private String socialIdentityNumber;
	
	/* Constructor */
	public Person(int id, String personName, String personSurname, String personMail, Card ownCardType,
			String personPhone, String personAlternativePhone, String personAddress, String typeOfCard,
			String firstDayOfBeenCustomer, String typeOfAffiliate, String socialIdentityNumber) {
			
		this.id = id;
		this.personName = personName;
		this.personSurname = personSurname;
		this.personMail = personMail;
		this.personPhone = personPhone;
		this.personAlternativePhone = personAlternativePhone;
		this.personAddress = personAddress;
		this.ownCardType = ownCardType;
		
		this.firstDayOfBeenCustomer = firstDayOfBeenCustomer;
		this.typeOfAffiliate = typeOfAffiliate;
		this.socialIdentityNumber = socialIdentityNumber;
	}
	
	/* Id */
	private void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	/* Person Name */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	/* Person Surname */
	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}
	
	public String getPersonSurname() {
		return personSurname;
	}
	
	/* Person Mail */
	public void setPersonMail(String personMail) {
		this.personMail = personMail;
	}
	
	public String getPersonMail() {
		return personMail;
	}
	
	/* Personel Phone  */
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	
	public String getPersonPhone() {
		return personPhone;
	}
	
	/* Personel Alternative Phone */
	public void setPersonAlternativePhone(String personAlternativePhone) {
		this.personAlternativePhone = personAlternativePhone;
	}
	
	public String getPersonAlternativePhone() {
		return personAlternativePhone;
	}
	
	/* Personel Address */
	public void setPersonAddress(String personAddress) {
		this.personAddress =  personAddress;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	
	/* First Date of Been Customer */
	public void setFirstDayOfBeenCustomer(String firstDayOfBeenCustomer) {
		this.firstDayOfBeenCustomer= firstDayOfBeenCustomer;
	}
	public String getFirstDayOfBeenCustomer () {
		return firstDayOfBeenCustomer;
	}
	
	/* Own Card Type */
	public void setOwnCardType(Card ownCardType) {
		this.ownCardType = ownCardType;
	}
	
	public Card getOwnCardType() {
		return ownCardType;
	}

	/* Type Of Affiliated */
	public void setTypeOfCustomer(String typeOfCustomer) {
		this.typeOfAffiliate = typeOfAffiliate;
	}
	
	public String getTypeCustomer() {
		return typeOfAffiliate;
	}
	
	/* Social Identity Number */
	public void setSocialIdentityNumber(String socialIdentityNumber) {
		this.socialIdentityNumber = socialIdentityNumber;
	}
	public String getSocialIdentityNumber() {
		return socialIdentityNumber;
	}
}


/*
 * Description:
 * -------------
 * This class named Person is superclass. It has eight different parameters. It can be derivatived vary personel by this class such as customer,employee etc.
 * 
 * Parameters:
 * -------------
 * id: Person,who has been on system, is identified on id. 
 * personName: Name of the person.
 * personSurname: Surname of the person.
 * personMail: Mail of the person.
 * ownCardType: Card is used when doing shopping in this retail website. Each person has only one type of  card,and has just only one card. It's object.
 * personPhone: Phone number of the person.
 * personAlternativePhone: Second phone number of person.
 * personAddress: Home address of person.
 * 
 *  return:
 *  --------
 *  None
 *  */
