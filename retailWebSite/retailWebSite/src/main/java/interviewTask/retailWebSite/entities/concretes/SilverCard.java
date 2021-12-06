package interviewTask.retailWebSite.entities.concretes;

public class SilverCard extends Card {
	/* Constructor */
	public SilverCard(int cardId, String cardNumber, String codeOfCardSecurity, 
			int percentageOfDiscount, String cardPassword, int amountOfDiscountUsage) 
	{
		super(cardId, cardNumber, codeOfCardSecurity, percentageOfDiscount, 
				 cardPassword,  amountOfDiscountUsage, "SILVERCARD");
	}
}


/* 
 * Description:
 * ------------
 * It's a type of card. It's derivated by Card Class. It's a child class 
 * 
 * Parameters:
 * ------------
 * It has same parameters with superclass named Card.
 * 
 * Returns:
 * ------------
 * None
 * */
 

