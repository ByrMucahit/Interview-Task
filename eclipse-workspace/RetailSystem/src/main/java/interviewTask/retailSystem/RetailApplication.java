package main.java.interviewTask.retailSystem;

import main.java.interviewTask.retailSystem.entites.concretes.Customer;

import main.java.interviewTask.retailSystem.entites.concretes.Person;
import main.java.interviewTask.retailSystem.entites.concretes.Card;
import main.java.interviewTask.retailSystem.entites.concretes.GoldCard;
public class RetailApplication {
		public static void main(String[] args) {
			
			Card c = new GoldCard(12, "1200 5400 6758 4321", "432", 30, "1453");
			Person p = new Customer(1, "Mucahit", "BAYAR", "m.mucahit@gmail.com",c,"05435446158","05433654751", "�ay ��kmaz�");
			System.out.println(p.getPersonAddress());
			System.out.println(p.getOwnCardType().getCardId());
		}
}