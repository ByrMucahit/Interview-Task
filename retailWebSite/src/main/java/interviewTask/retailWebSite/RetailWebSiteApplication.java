package interviewTask.retailWebSite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import interviewTask.retailWebSite.entities.concretes.Card;
import interviewTask.retailWebSite.entities.concretes.Customer;
import interviewTask.retailWebSite.entities.concretes.GoldCard;
import interviewTask.retailWebSite.entities.concretes.Person;



@SpringBootApplication
public class RetailWebSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailWebSiteApplication.class, args);
		Card c = new GoldCard(12, "1200 5400 6758 4321", "432", 30, "1453");
		Person p = new Customer(1, "Mucahit", "BAYAR", "m.mucahit@gmail.com",c,"05435446158","05433654751", "Çay çıkmazı");
		System.out.println(p.getPersonAddress());
		System.out.println(p.getOwnCardType().getCardId());
	}

}
