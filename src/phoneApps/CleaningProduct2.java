package phoneApps;

public class CleaningProduct2 extends Product implements Iprintable{
	
	enum riskLevel {
		  LOW,
		  MEDIUM,
		  HIGH
		}
	
	private riskLevel riskLevel;
	
	//constructors
	public CleaningProduct2(String productName, double price, double stock, riskLevel riskLevel) {
		super(productName, price, stock);
		this.riskLevel = riskLevel;
	}
	
	public CleaningProduct2() {
		super ( "NoName",0, 0);

		this.riskLevel = riskLevel.HIGH;
	}
	
	//additional getters and setters
	public riskLevel getRiskLevel() {
		return this.riskLevel;
	}
	
	public void setRiskLevel(riskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}
	

	@Override
	public void print(){ 
		System.out.println("department: Cleaning Product");
		System.out.println("product name: " + super.getName());
		System.out.println("product price: " + super.getPrice());
		System.out.println("product amount in stock: "+ super.getStock());
		System.out.println("risk level: " + getRiskLevel().toString());

	}
}

