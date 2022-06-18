package phoneApps;

import java.util.ArrayList;
import phoneApps.Iprintable;
import java.util.Date;
import java.util.Scanner;

public class payment implements Iprintable{
	
	private double amountToPay;
	private String creditCardNum;
	private String creditCardCVV;
	private String creditExpiryMonth;
	private String creditExpiryYear;
	private String deliveryAdress;
	private int currentMonth;
	private int currentYear;
	private ArrayList<Product> basketList;
	private String userCity, userStreet, houseNumber, deliveryDay, deliveryTime;
	
	
	public payment(ArrayList<Product> basketList) 
	{
		this.basketList = basketList;
		amountToPay = calcTotalPrice(basketList);
		currentMonth = 6;
		currentYear = 2022;
		getCreditCardDetails();
	
	}
	
//function that calculation the total price of the basket	
	public double calcTotalPrice(ArrayList<Product> basketList) {
		basketList.forEach((product) -> amountToPay += (product.price * product.stock));
		return amountToPay;
	}
	
	public boolean checkCreditValid(String creditCardNum, String creditCardCVV, String creditExpiryMonth, String creditExpiryYear) {

		
		boolean isValid = true;
		int expiryYear =0, expiryMonth=0;
		
		//check creditCardNum
		// check if all the chars in the string are numbers
	   for(int i=0; i < creditCardNum.length(); i++) {
		   Boolean flag = Character.isDigit(creditCardNum.charAt(i));
		   if(flag == false)
			   isValid = false;
	   }
		if (creditCardNum.length()!= 16)
			isValid = false;
		
		//check creditCardCVV
	   for(int i=0; i < creditCardCVV.length(); i++) {
		   Boolean flag = Character.isDigit(creditCardNum.charAt(i));
		   if(flag == false)
			   isValid = false;
	   }
		if (creditCardCVV.length()!= 3)
			isValid = false;
			
		//check Expire Date
		for(int i=0; i < creditExpiryYear.length(); i++) {
			   Boolean flag = Character.isDigit(creditExpiryYear.charAt(i));
			   if(flag == false)
				   isValid = false;
			   else
				   expiryYear = Integer.parseInt(creditExpiryYear);
		}
		
		for(int i=0; i < creditExpiryMonth.length(); i++) {
			   Boolean flag = Character.isDigit(creditExpiryMonth.charAt(i));
			   if(flag == false)
				   isValid = false;
			   else
				   expiryMonth = Integer.parseInt(creditExpiryMonth);
		}
		
		if ((expiryYear < currentYear) || ((expiryYear == currentYear) && (expiryMonth < currentMonth)))
			isValid = false;
			
		return isValid;
	}
	
	public void getCreditCardDetails() {
		String userCreditCardNum, userCreditCardCVV, userCreditExpiryMonth, userCreditExpiryYear;
		Scanner s = new Scanner(System.in);
		System.out.println("***Enter your credit card inforamtion***");
		System.out.println("credit card number: (16 digits)");
		userCreditCardNum = s.next();
		System.out.println("CVV code: (3 digits)");
		userCreditCardCVV = s.next();
		System.out.println("Expiry date: ");
		System.out.println("month: (1-12)");
		userCreditExpiryMonth = s.next();
		System.out.println("year:");
		userCreditExpiryYear = s.next();
		
		if (checkCreditValid(creditCardNum, creditCardCVV, creditExpiryMonth, creditExpiryYear) == true) 
		{
			this.creditCardNum = userCreditCardNum;
			this.creditCardCVV = userCreditCardCVV;
			this.creditExpiryMonth = userCreditExpiryMonth;
			this.creditExpiryYear = userCreditExpiryYear;
		}
		else
		{
			System.out.println("details not valid, please try again");
			getCreditCardDetails();
		}			
	}
	
	
	public void deliveryDetails()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("***Enter delivery details***");
		System.out.println("city name: ");
		userCity = s.next();
		System.out.println("street: ");
		userStreet = s.next();
		System.out.println("number: ");
		houseNumber = s.next();
		
		deliveryAdress  = userCity + userStreet + houseNumber;
		
		System.out.println("delivery day: (Sunday-Thursday)");
		deliveryDay = s.next();
		System.out.println("delivery time: (10/12/14/16/18)");
		deliveryTime  = s.next();
		System.out.println("Delivery will arrive within two hours of the time you have chosen");
		
	}

	
	// Getters & Setters
		public double getAmountToPay() {
			return this.amountToPay;
		}
		
		public void setAmountToPay(double amountToPay) {
			this.amountToPay = amountToPay;
		} 
	public ArrayList<Product> getBasketList() {
		return basketList;
	}
	
	public void setBasketList(ArrayList<Product> ProductsList) {
		this.basketList = ProductsList;
	}
	
	
	@Override
	public void print(){ 
	}
}
