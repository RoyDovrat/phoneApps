package phoneApps;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBook {
	private ArrayList<Contact> phoneBook;
	
	
	
	public PhoneBook() {
		phoneBook = new ArrayList<Contact>(); //creation of arrayList: phoneBook
	}
	//1- add a contact
		
		public void AddImmdiateContact(Contact con){
			this.phoneBook.add(con);
		}
		
		public ArrayList<Contact> getPhoneBook() {
			return phoneBook;
		}

		public  void setPhoneBook(ArrayList<Contact> phoneBook) {
			this.phoneBook = phoneBook;
		}

		
		public void AddContact(){
			Scanner s = new Scanner(System.in);
			System.out.println("Write name of new contact:");
			
			String name= s.next();
			
			for (int i=0; i<phoneBook.size(); i++) { // a loop to find a contact with that name
				if(name.equals(phoneBook.get(i).getName())) { //if the contact has the name, delete
					System.out.println("The name already exists- please enter another name");
					name= s.next();
					i=0;
				}
			}
			System.out.println("Write number of new contact:");
			int num=s.nextInt();
			Contact new_cont = new Contact(num, name); //create the contact given number and name
			phoneBook.add(new_cont); //add to array-list
		}
		
		//2- delete a contact
		//*********************2- delete a contact****************************
		public  void RemoveContact(SMSApp SmsBook, Diary diary) throws ParseException {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the contact you would like to remove");
			String name= s.next(); //requested name scanning
			int flag1=0; //assume it wasn't find
			for (int i=0; i<phoneBook.size(); i++) { // a loop to find a contact with that name
				if(name.equals(phoneBook.get(i).getName())) { //if the contact has the name, delete
					flag1=1; //if a contact was found- raise flag
					phoneBook.remove(phoneBook.get(i));
					int sender= 1;
					SmsBook.RemoveSMS(name, sender); 
					diary.RemoveContact(name);
					break; //to delete only the first one, stop here.
				}
			}
			if (flag1==0) {//if no contact was found
				System.out.println("No such contact!\n");
			}
		}
		
		//*********************3- print all contacts***************************
		public  void PrintPhoneBook(){ // a loop to go all over the array-list and print the name and the number
			for (int i=0; i<phoneBook.size(); i++) {
				System.out.print(phoneBook.get(i).getName());
				System.out.print(",");
				System.out.println(phoneBook.get(i).getPNum());
			}
			System.out.println("\n");
		}
		
		////***************************4- search for a contact**********************
		public  void SearchContact() {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the contact you would like to search");
			String name= s.next(); // name scanning
			int flag=0; //assume it wasn't find
			for (int i=0; i<phoneBook.size(); i++) { // a loop to find a contact with that name
				if(name.equals(phoneBook.get(i).getName())) { 
					flag=1; //if a contact was found- raise flag
					//print details of the contact:
					System.out.print(phoneBook.get(i).getName());
					System.out.print(", ");
					System.out.println(phoneBook.get(i).getPNum());
				}
			}
			if (flag==0) {//if no contact was found
				System.out.println("No such contact!\n");
			}
		}
		
		
		//swap function
		public void swapContacts(int index1, int index2) {
			Contact temp = new Contact();
			temp = phoneBook.get(index1);
			phoneBook.set(index1, phoneBook.get(index2));
			phoneBook.set(index2, temp);
		}
		
		  //5
		public void sort_by_name() { 
			Collections.sort(phoneBook, Contact.ContNameComparator);
		}
		//6
		public void sort_by_number() {
			Collections.sort(phoneBook, Contact.ContNumberComparator );
		}

		//**********************7- remove duplicates*************************************
		//Function to remove doubles- if there are more than 1 contact with the same name and number
		//leave only one in the phone book
		public void RemoveDoubles(){ // loop to go all over the contacts
			for (int i=0; i<phoneBook.size(); i++) {  // a loop to compare each contact with all contacts
				for (int j=0; j<phoneBook.size(); j++) {
					//if the names and numbers are equal, and its not the same one- remove:
					if (phoneBook.get(i).getName().equals(phoneBook.get(j).getName()) && i!=j){
						if (phoneBook.get(i).getPNum()==phoneBook.get(j).getPNum()) {
							phoneBook.remove(phoneBook.get(j));
						}
					}
				}
			}
		}
		

		 //*************************8- arrange a phone book in reverse order**************
		public void reverseOrder() {
			System.out.println("before reverse:\n");
			PrintPhoneBook();
			for (int i=0; i < (phoneBook.size())/2 ; i++) {
				swapContacts( i, phoneBook.size() -1 - i);
			}	
			System.out.println("after reverse:\n");
			PrintPhoneBook();
		}

		
		////********************9- save phonebook data in a text file********************
		public void PhoneBookToText() {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the file you would like to write to");
			String file_name= s.next();
			file_name = file_name.concat(".txt");
			try (PrintWriter out = new PrintWriter(file_name)) {
				for (int i=0; i<phoneBook.size(); i++) {
					out.println(phoneBook.get(i).getName()+ ", "+ phoneBook.get(i).getPNum());
				}
			    
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//10-loading phone book data from a text file
		//Function which reads a text file with contacts and adds them to the phone book
		public static void TextToPhoneBook(PhoneBook phoneBook2) {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the file you would like to read from");
			String file_name= s.next(); //scan name of wanted file
			file_name = file_name.concat(".txt"); // add .txt in the end
		//	String final_name=("C:\\Users\\revital\\eclipse-workspace\\project1\\src\\project1\\");
			//final_name = final_name.concat(file_name);
			try { 
				File phone_file = new File(file_name); 
			    Scanner FileReadrer = new Scanner(phone_file);
			    while (FileReadrer.hasNextLine()) {
			    	String name = FileReadrer.nextLine(); //read name from file
				    String numberS = FileReadrer.nextLine(); // read number (in string) from file
				    int number = Integer.parseInt(numberS); //cast the string to number
				    Contact new_cont = new Contact(number, name); //make a new contact with the details
				    phoneBook2.AddImmdiateContact(new_cont);  //add the contact
				    }
			      FileReadrer.close();
			    } 
			catch (FileNotFoundException e) { //if reading didn't succeed:
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		}
		
		public Contact getContact(String name) {
			Scanner s = new Scanner(System.in);
			int flag=0; //assume it wasn't found
			for (int i=0; i<phoneBook.size(); i++) { // a loop to find a contact with that name
				if(name.equals(phoneBook.get(i).getName())) { 
					flag=1; //if a contact was found- raise flag
					//print details of the contact:
					return phoneBook.get(i);
				}
			}
			if (flag==0) {//if no contact was found
				System.out.println("No such contact!\n");
			}
			return null;
		}
		
		
}

