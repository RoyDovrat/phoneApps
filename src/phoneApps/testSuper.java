package phoneApps;

public class testSuper {

public static void mainFunc() {//main function
		
		SuperMarket supmar = new SuperMarket();//create a new supermarket
		supmar.initSuper();
		supmar.printSuper();
		
		
		supmar.sort_by_name();
		supmar.printSuper();
		
		
		supmar.sort_by_price();
		supmar.printSuper();
		
		
		System.out.println("\nsearch milk");
		supmar.searchProduct("milk").print();
		
		
		
		
		
	}
	
}
