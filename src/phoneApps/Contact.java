package phoneApps;

import java.util.Comparator;

public class Contact {
		private int phoneNumber;
		private String name;
		
		// Constructors
		public Contact(int initPnum, String initName) {
			this.phoneNumber = initPnum;
			this.name = initName;
			
		}
		
		public Contact() {//default constructor 
			this.phoneNumber = 0;
			this.name = "noName";
		}
		
		public Contact(Contact c) {
			this.phoneNumber = c.getPNum();
			this.name = c.getName();
		}
		
		// Getters & Setters
		public int getPNum() {
			return phoneNumber;
		}
		
		public void setPNum(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void printContact() {
			System.out.print(" name: ");
			System.out.print(this.getName());
			System.out.print(", number: ");
			System.out.println(this.getPNum());
			System.out.println("\n");
			}
		
		
		//sort:
		
		//define comparator methods for Contact.name and Contact.number
		//in order to sort Arraylist by object fields
		//uses by Collections.sort 
		
		 /*Comparator for sorting a list by Contact Name*/
	    public static Comparator<Contact> ContNameComparator = new Comparator<Contact>() {

		public int compare(Contact c1, Contact c2) {
		   String Name1 = c1.getName().toUpperCase();
		   String Name2 = c2.getName().toUpperCase();

		   //ascending order
		   return Name1.compareTo(Name2);

	    }
		};

	    /*Comparator for sorting a list by Contact Number*/
	    public static Comparator<Contact> ContNumberComparator = new Comparator<Contact>() {

		public int compare(Contact c1, Contact c2) {

		   String Num1 = String.valueOf(c1.getPNum());
		   String Num2 = String.valueOf(c2.getPNum());

		   /*For ascending order*/
		   return Num1.compareTo(Num2);
	   }};
	   
	   //overwrite the function equals and hashCode 
	   //to enable comparison between two Contact objects

	   @Override
	   public boolean equals(Object obj) {

	       if(obj instanceof Contact)
	       {
	           Contact temp = (Contact) obj;
	           if(this.getName().equals(temp.getName()) && String.valueOf(this.getPNum()).equals(String.valueOf(temp.getPNum())))
	               return true;
	       }
	       return false;
	   }


}
