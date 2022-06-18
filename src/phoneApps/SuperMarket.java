package phoneApps;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import phoneApps.CleaningProduct2.riskLevel;
import phoneApps.Contact;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;


public class SuperMarket extends Canvas implements Runnable {
	private ArrayList<Product> ProductsList;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH * 9/16;
	public boolean running = false;
	

	public SuperMarket() {
		ProductsList = new ArrayList<>();
		
		canvasSetup();
		new Window("SuperMarket", this);
	}
	
	public ArrayList<Product> getProductsList() {
		return ProductsList;
	}

	public void setProductsList(ArrayList<Product> ProductsList) {
		this.ProductsList = ProductsList;
	}
	
	public void AddImmdiateProduct(Product newProduct){
		ProductsList.add(newProduct);
	}
	
	
	
	public void canvasSetup() {	// sets the size of the window
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
	}
	
	/// Addition of products to superMarket: ///
	public void initSuper() {
		DairyProduct Dairy1 = new DairyProduct("Milk", 5, 10, "19.6.22");
		DairyProduct Dairy2 = new DairyProduct("Cheese", 8, 20, "20.6.22");
		DairyProduct Dairy3 = new DairyProduct("Milky", 3, 15, "25.6.22");
		this.AddImmdiateProduct(Dairy1);
		this.AddImmdiateProduct(Dairy2);
		this.AddImmdiateProduct(Dairy3);
		
		FruitVeg FruitVeg1 = new FruitVeg("Strawberry", 56.5, 10, false);
		FruitVeg FruitVeg2 = new FruitVeg("Tomato", 5.9, 10, false);
		FruitVeg FruitVeg3 = new FruitVeg("Cucumber", 4.9, 10, false);
		this.AddImmdiateProduct(FruitVeg1);
		this.AddImmdiateProduct(FruitVeg2);
		this.AddImmdiateProduct(FruitVeg3);
		
		CleaningProduct2 CleaningProduct_1 = new CleaningProduct2("bleach", 8.9, 12.0, riskLevel.HIGH);
		CleaningProduct2 CleaningProduct_2 = new CleaningProduct2("Washing Powder", 29.9, 21.0, riskLevel.MEDIUM);
		CleaningProduct2 CleaningProduct_3 = new CleaningProduct2("Window Spray", 13.9 , 7.0, riskLevel.LOW);
		this.AddImmdiateProduct(CleaningProduct_1);
		this.AddImmdiateProduct(CleaningProduct_2);
		this.AddImmdiateProduct(CleaningProduct_3);
		
		
	}	
	
	//Sorting methods for products:
	public void sort_by_name() { 
		Collections.sort(ProductsList, Product.NameComparator);
	}

	public void sort_by_price() {
		Collections.sort(ProductsList, Product.PriceComparator );
	}
	
	//search product by name
	public Product searchProduct(String productName) {
		int flag=0; //assume it wasn't found
		for (int i=0; i<ProductsList.size(); i++) { // a loop to find a Product with that name
			if(productName.equals(ProductsList.get(i).getName())) { 
				flag=1; //if a contact was found- raise flag
				//print details of the contact:
				return ProductsList.get(i);
			}
		}
		if (flag==0) {//if no contact was found
			System.out.println("No such Product!\n");
		}
		return null;
	}
	
	public void printSuper() {
		System.out.println("\n\nall products in supermarket:");
		for (int i=0; i<ProductsList.size(); i++) {
			ProductsList.get(i).print();
		}
		System.out.println("\n\n");
	}
	
	

	//main menu

	public static void PrintSuperMenu() {
		System.out.println("***supermarket menu:***");
		System.out.println("1. Contacts");
		System.out.println("2. SMS");
		System.out.println("3. Diary");
		System.out.println("4. Media");
		System.out.println("5. print all information");
		System.out.println("6. exit");
		System.out.println("please enter your choice:");
	}

	@Override
	public void run() {
		draw();
		
	}

	public void draw() {
		// Initialize drawing tools
		BufferStrategy buffer = this.getBufferStrategy();
		
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = buffer.getDrawGraphics();
		
		
		
		// 1
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, WIDTH, HEIGHT);
//		
//		paint1(g);
//		paint2(g);
//		paint3(g);
//		paint4(g);
//		paint5(g);
		
		// 2
		drawBackground(g);
		
		
		
		// dispose
		g.dispose();
		buffer.show();
	}
	
	private void drawBackground(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Graphics2D g2d = (Graphics2D)g;	
		g2d.setColor(Color.white);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(SuperMarket.WIDTH/2, 0, SuperMarket.WIDTH/2, SuperMarket.HEIGHT);
		
		
		// circle in the middle
		int r = 120;
		g2d.drawOval(SuperMarket.WIDTH/2-r, SuperMarket.HEIGHT/2-r, 2*r, 2*r);
		g2d.setStroke(new BasicStroke(2));
		
	}
	
}
