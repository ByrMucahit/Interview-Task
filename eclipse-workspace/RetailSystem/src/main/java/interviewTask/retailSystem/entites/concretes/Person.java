package main.java.interviewTask.retailSystem.entites.concretes;

import java.util.Date;
import main.java.interviewTask.retailSystem.entites.concretes.Card;
public abstract class Person {
	
	/* Common Person Attribute */
	private int id;
	private String personName;
	private String personSurname;
	private String personMail;
	private String personPhone;
	private String personAlternativePhone;
	private String personAddress;
	private Date firstDayOfBeenCustomer;
	private Card ownCardType;
	
	/* Constructor */
	public Person(int id, String personName, String personSurname, String personMail, Card ownCardType,
			String personPhone, String personAlternativePhone, String personAddress) {
			
		this.id = id;
		this.personName = personName;
		this.personSurname = personSurname;
		this.personMail = personMail;
		this.personPhone = personPhone;
		this.personAlternativePhone = personAlternativePhone;
		this.personAddress = personAddress;
		this.ownCardType = ownCardType;
		
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
	public void setPersonelMail(String personMail) {
		this.personMail = personMail;
	}
	
	public String getPersonelMail() {
		return personMail;
	}
	
	/* Personel Phone  */
	public void setPersonelPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	
	public String getPersonelPhone() {
		return personPhone;
	}
	
	/* Personel Alternative Phone */
	public void setPersonelAlternativePhone(String personAlternativePhone) {
		this.personAlternativePhone = personAlternativePhone;
	}
	
	public String getPersonelAlternativePhone() {
		return personAlternativePhone;
	}
	
	/* Personel Address */
	public void setPersonelAddress(String personAddress) {
		this.personAddress =  personAddress;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	
	/* First Date of Been Customer */
	public void setFirstDayOfBeenCustomer(Date firstDayOfBeenCustomer) {
		this.firstDayOfBeenCustomer= firstDayOfBeenCustomer;
	}
	public Date getFirstDayOfBeenCustomer () {
		return firstDayOfBeenCustomer;
	}
	
	/* Own Card Type */
	public void setOwnCardType(Card ownCardType) {
		this.ownCardType = ownCardType;
	}
	
	public Card getOwnCardType() {
		return ownCardType;
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
