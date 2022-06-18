package phoneApps;

import java.util.ArrayList;
import phoneApps.Iprintable;
import phoneApps.Product;
import phoneApps.SuperMarket;
import phoneApps.Meeting;

public class Basket implements Iprintable{
	
	private ArrayList<Product> basketList;
		
	
	public ArrayList<Product> getBasketList() {
		return basketList;
	}
	
	public void setBasketList(ArrayList<Product> ProductsList) {
		this.basketList = ProductsList;
	}
	
	public void AddImmdiateProduct(Product newProductInBasket){
		basketList.add(newProductInBasket);
	}
	
// function that add new product to basket	
	public void AddProductFromStock(SuperMarket superMarket, String productName, int numOfWantedProduct) throws CloneNotSupportedException{
		
		Product wantedProduct = superMarket.searchProduct(productName);
		wantedProduct.reduceProductInStock(numOfWantedProduct); // reduce from supermarket stock
		if(wantedProduct instanceof DairyProduct) {
			DairyProduct newProduct = new DairyProduct(); // add new object
			newProduct = (DairyProduct)wantedProduct.clone();
			newProduct.setStock(numOfWantedProduct); // how many products there is in the basket
			this.AddImmdiateProduct(newProduct); // add to basket list
		}
		else if(wantedProduct instanceof FruitVeg) {
			FruitVeg newProduct = new FruitVeg();
			newProduct = (FruitVeg)wantedProduct.clone();
			newProduct.setStock(numOfWantedProduct);
			this.AddImmdiateProduct(newProduct);
		}
		else if(wantedProduct instanceof CleaningProduct2) {
			CleaningProduct2 newProduct = new CleaningProduct2();
			newProduct = (CleaningProduct2)wantedProduct.clone();
			newProduct.setStock(numOfWantedProduct);
			this.AddImmdiateProduct(newProduct);
		}
	
		
	}
	
	//print function:
		@Override
		public void print(){ 
		}
}

