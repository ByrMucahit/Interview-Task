package main.java.interviewTask.retailSystem.business.abstracts;

import main.java.interviewTask.retailSystem.core.concretes.utilities.results.DataResult;
import main.java.interviewTask.retailSystem.entites.concretes.Card;

public interface CardService {

	DataResult<Card> cardIdGenerator();
	DataResult<Card> cardNumberGenerator();
	DataResult<Card> cardSecurityNumberGenerator();
}
