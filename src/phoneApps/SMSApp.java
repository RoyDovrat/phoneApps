package phoneApps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SMSApp {
		private PhoneBook phoneBook;
		//private HashMap<String, SMS> SmsBook;
		private ArrayList<SMS> SmsBook;
		
		public SMSApp(PhoneBook phoneBook) {
			SmsBook = new ArrayList<SMS>();
			//SmsBook = new HashMap<>(); //creation of arrayList: phoneBook
			this.phoneBook = phoneBook;
		}
		
		//Add Message app:
		public void AddImmdiateSMS(SMS newSMS){
			this.SmsBook.add(newSMS);
		}
	
		public  void SendNewMessege() {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the contact you would like to write to");
			
			String contact = s.next();
			
			int i=0;
			int foundSMS=0;
			for (i=0; i<SmsBook.size(); i++) { // a loop to find a contact with that name in sms book
				if(contact.equals(SmsBook.get(i).getName())) { 
					SmsBook.get(i).addMessege();
					foundSMS=1;
					break;
				}
			}
			if (foundSMS==0) { //if SMS wasn't found check if you can start a new one
				for (i=0; i<phoneBook.getPhoneBook().size(); i++) { // a loop to find a contact with that name in phone book
					if(contact.equals(phoneBook.getPhoneBook().get(i).getName())) { 
						System.out.println("Write the messege:");
						String enter1 = s.nextLine();
						String newMessege = s.nextLine();
						SMS NewSms= new SMS(phoneBook.getPhoneBook().get(i).getName(), "Me: "+newMessege);
						SmsBook.add(NewSms);
						foundSMS=1;
						break;
					}
				}
			}
			if (foundSMS==0){
				System.out.println("Error, No such Contact!\n");
			}
			//else
			//	System.out.println(SmsBook.get(i).getName()+" Messeges: \n"+ SmsBook.get(i).getMesseges());
		}
		
		//Remove SMS
		public void RemoveSMS(String name, int sender) {
			int flag1=0; //assume it wasn't found
			for (int i=0; i<SmsBook.size(); i++) { // a loop to find a contact with that name
				if(name.equals(SmsBook.get(i).getName())) { //if the contact has the name, delete
					flag1=1; //if a contact was found- raise flag
					SmsBook.remove(SmsBook.get(i));
					break; //no need to continue- stop here.
				}
			}
			if (flag1==0 && sender==0) {//if no contact was found
				System.out.println("No such correspondence!\n");
			}
		}
		//Remove a requested correspondence
		
		public void RemoveReqSMS() {
			int sender=0;
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the contact you would like to remove");
			String name= s.next(); //requested name scanning
			RemoveSMS(name, sender);
		}
		
		//Print all SMS's
		public void PrintAllSMS() {
			for (int i=0; i<SmsBook.size(); i++) {
				System.out.print("\n"+SmsBook.get(i).getName()+ " messeges:\n");
				System.out.println(SmsBook.get(i).getMesseges());
			}
			System.out.println("\n");
		}
		
		public void SearchSentence() {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the Sentence you are searching");
			String Sentence= s.next(); //requested Sentence scanning
			int flag1=0;
			System.out.println("Found in the chats with the contact:");
			for (int i=0; i<SmsBook.size(); i++) { // a loop to find a chat with that Sentence
				if(SmsBook.get(i).getMesseges().contains(Sentence)) { //if the chat contains the string
					System.out.println(SmsBook.get(i).getName());
					flag1=1;
				}
			}
			if (flag1==0) {//if no contact was found
				System.out.println("None");
			}
			System.out.println("\n");
		}

		public void PrintRequestedSMS() {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the name of the contact you would like to remove");
			String name= s.next(); //requested name scanning
			int flag1=0; //assume it wasn't found
			for (int i=0; i<SmsBook.size(); i++) { // a loop to find a contact with that name
				if(name.equals(SmsBook.get(i).getName())) { //if the contact has the name, delete
					flag1=1; //if a contact was found- raise flag
					System.out.print("\n"+SmsBook.get(i).getName()+ " messeges:\n");
					System.out.println(SmsBook.get(i).getMesseges());
					break; //no need to continue- stop here.
				}
			}
			if (flag1==0) {//if no contact was found
				System.out.println("No such correspondence!\n");
			}
			System.out.println("\n");
		}

}
