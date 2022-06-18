package phoneApps;
import java.text.ParseException;

import phoneApps.SuperMarket;

public class main {
	public static void main(String[] args) {//main function
		
		SuperMarket supmar = new SuperMarket();//create a new supermarket
		supmar.initSuper();
		supmar.printSuper();
		
		
		System.out.println("\n sorted by name\n");
		supmar.sort_by_name();
		supmar.printSuper();
		
		System.out.println("\nsort_by_price \n");
		supmar.sort_by_price();
		supmar.printSuper();
		
		
		System.out.println("\nsearch milk");
		supmar.searchProduct("Milk").print();
	
		
		
		
		
		
	}
	
	
	
}
