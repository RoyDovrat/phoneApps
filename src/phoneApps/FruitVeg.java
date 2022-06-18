package phoneApps;


public class FruitVeg  extends Product implements Iprintable{
	
	private boolean isOrganic = false;
	
	//constructors
	public FruitVeg( String productName, double price, double stock, boolean isOrganic) {
		super(productName, price, stock);
		this.isOrganic = isOrganic;
	}

	public FruitVeg() {
		super("NoName",0, 0);
	}
	
	public boolean getIsOrganic() {
		return this.isOrganic;
	}
	
	public void setIsOrganic(boolean isOrganic) {
		this.isOrganic = isOrganic;
	}
	

	//print function:
	@Override
	public void print(){ //print product details
		System.out.println("Department: Vegetables and Fruits");
		System.out.println("product name: " + super.getName());
		System.out.println("price for 1Kg: " + super.getPrice());
		System.out.println("weight in stock: " + super.getStock() + "kg");
		System.out.println("is organic: " + (isOrganic ? "yes": "no"));
	}
}

