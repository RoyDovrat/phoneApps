package phoneApps;
import java.util.Comparator;
import phoneApps.Contact;

public abstract class Product implements Iprintable, Cloneable{
	protected double price;
	protected double stock;
	protected String name;
	
	//constructor
	public Product(String name, double price, double stock) {
		this.price = price;
		this.stock = stock; 
		this.name = name;
	}
	
	public Product() {//default constructor 
		this.price = 0;
		this.stock = 0;
		this.name = "noName";
	}
		
	public Product(Product otherProduct) { //copy constructor
		this.price = otherProduct.getPrice();
		this.stock = otherProduct.getStock();
		this.name = otherProduct.getName();
	}
	
	
	public void reduceProductInStock(double boughtAmountOfItem) {
		try {
			if((stock - boughtAmountOfItem < 0)) 
			{
				throw new Exception("Out of stock, there are" + stock + name + "in stock");
			}
			
			else
			{
				stock -= boughtAmountOfItem;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Getters & Setters
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getStock() {
		return this.stock;
	}
	
	public void setStock(double stock) {
		this.stock = stock;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////sort:
	
	//define comparator methods to sort products
	
	 /*Comparator for sorting a list by Product Name*/
    public static Comparator<Product> NameComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String Name1 = p1.getName().toUpperCase();
	   String Name2 = p2.getName().toUpperCase();

	   //ascending order
	   return Name1.compareTo(Name2);

    }
	};

    /*Comparator for sorting a list by Product's Price*/
    public static Comparator<Product> PriceComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {

		if(p1.getPrice() < p2.getPrice()) {
			return -1;
		}
		if(p1.getPrice() > p2.getPrice()) {
			return 1;
		}
		return 0;
   }};
   
   
  
  
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	//print function:
	@Override
	public void print(){ 
	}
	
	
	
}
