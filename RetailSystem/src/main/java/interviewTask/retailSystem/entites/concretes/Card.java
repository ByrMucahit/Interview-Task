package main.java.interviewTask.retailSystem.entites.concretes;

public abstract class Card {
	
	private int cardId;
	private String cardNumber;
	private String codeOfCardSecurity;
	private int percentageOfDiscount;
	private String cardPassword;
	
	public Card(int cardId, String cardNumber, String codeOfCardSecurity, int percentageOfDiscount, String cardPassword) {
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.codeOfCardSecurity = codeOfCardSecurity;
		this.percentageOfDiscount = percentageOfDiscount;
		this.cardPassword = cardPassword;
	}
	
	/* Card Id */
	protected void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCardId() {
		return cardId;
	}
	
	/* Card Number */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	protected String getCardNumber() {
		return cardNumber;
	}
	
	/* Card Security Code */
	public void setCodeOfCardSecurity(String codeOfCardSecurity) {
		this.codeOfCardSecurity = codeOfCardSecurity;
	}
	
	protected String getCodeOfCardSecurity() {
		return codeOfCardSecurity;
	}
	
	/* Card Password */
	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}
	
	public String getCardPassword(String cardPassword) {
		return cardPassword;
	}

}
