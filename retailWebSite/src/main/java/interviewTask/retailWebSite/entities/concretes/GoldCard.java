package interviewTask.retailWebSite.entities.concretes;

public class GoldCard extends Card{
	/* Consturctor */
	public GoldCard(int cardId, String cardNumber, String codeOfCardSecurity, int percentageOfDiscount, 
					String cardPassword, int amountOfDiscountUsage) {
		/* Constructor */
		super(cardId, cardNumber, codeOfCardSecurity, percentageOfDiscount, 
				 cardPassword,  amountOfDiscountUsage, "GOLDCARD");
		
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
 