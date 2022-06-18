package phoneApps;

import java.util.Date;
public class DairyProduct extends Product implements Iprintable {
	
	//private Date expiryDate;
	private String expDate;
	
	public  DairyProduct(String productName, double price, double stock, String expDate) {//constructor
		super(productName, price, stock);
		//this.expiryDate = expiryDate;
		this.expDate=expDate;
		
	}
	
	public DairyProduct() {//default constructor
		super("NoName", 0 , 0);
		//this.expiryDate = new Date(0,0,0);
		this.expDate="14.6.22";
	}
	
	
	//copy constructor
	public DairyProduct(DairyProduct other) {
		
	}
	
	
	
	public String getExpDate() {
		return this.expDate;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	// Add a function that checks if the product has expired???????????????????????
	
	@Override
	public void print(){ 
		System.out.println("department: Dairy Product");
		System.out.println("product name: " + super.getName());
		System.out.println("product price: " + super.getPrice());
		System.out.println("product amount in stock: "+ super.getStock());
		System.out.println("expiry date: " + getExpDate().toString());

	}

}
