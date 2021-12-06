package interviewTask.retailWebSite.entities.concretes;

public class AffiliatedCustomer extends Person {
	
	public AffiliatedCustomer(int id, String personName, String personSurname, String personMail, Card ownCardType,
			String personPhone, String personAlternativePhone, String personAddress, String typeOfCard, String firstDayOfBeenCustomer,
			String socialIdentityNumber, String typeOfAffiliate) {
		
		/* Those're passed to superclass named Person */
		super(id, personName, personSurname, personMail, 
				ownCardType, personPhone, personAlternativePhone, 
				personAddress, typeOfCard,firstDayOfBeenCustomer,typeOfAffiliate, socialIdentityNumber);
	}
	
}
