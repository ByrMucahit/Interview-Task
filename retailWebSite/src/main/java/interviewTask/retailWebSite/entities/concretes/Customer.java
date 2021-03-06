package interviewTask.retailWebSite.entities.concretes;



public class Customer extends Person {

	/* Constructor */
	public Customer(int id, String personName, String personSurname, String personMail, Card ownCardType,
			String personPhone, String personAlternativePhone, String personAddress, String typeOfCard,
			String firstDayOfBeenCustomer, String typeOfAffiliate, String socialIdentityNumber) {
		
		/* Those're passed into superclass named PERSON */
		super(id,  personName,  personSurname,  personMail,  ownCardType,
			  personPhone, personAlternativePhone, personAddress, typeOfCard,
		      firstDayOfBeenCustomer, socialIdentityNumber, typeOfAffiliate);		
	}
}


/*
 * Description:
 * -----------
 * It's child class of superclass named Person.
 * 
 * Parameters:
 * -----------
 * It has same parameters with superclass. You can check it out from superclass.
 * 
 * Returns:
 * -----------
 * None
 *  */
 