package phoneApps;

//Exercise 2
//Group number: 8
//Mor Agiv 314616095
//Revital Badalov 315406223
//Roy Dovrat 208423756
//Hila Senderovitch 208706812

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class Phone {
	private PhoneBook phoneBook;
	private SMSApp SmsBook;
	private Diary diary;
	private MediaApp mediaList;

//constructor
	public Phone() {//default constructor 
		this.phoneBook = new PhoneBook();
		this.SmsBook = new SMSApp(phoneBook);
		this.diary = new Diary();
		this.mediaList= new MediaApp();
	}

	// Getters & Setters
	public PhoneBook getPhoneBook() {
		return phoneBook;
	}
	
	public SMSApp getSMSApp() {
		return SmsBook;
	}
	
	public Diary getDiary() {
		return diary;
	}
	
	public MediaApp getMediaApp() {
		return mediaList;
	}

	//setters
	public void setPhoneBook(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	
	public void setMediaApp(MediaApp mediaList) {
		this.mediaList = mediaList;
	}
	
	public void setSMSApp(SMSApp sms) {
		this.SmsBook = sms;
	}
	
/////////////////////////////all menus////////////////////////////////////	
//*****************contact menu****************************
//the function print the contact menu
	public static void PrintMenu() {
		System.out.println("***contact menu:***");
		System.out.println("1. add contact");
		System.out.println("2. delete contact");
		System.out.println("3. print all contacts");
		System.out.println("4. search contact");
		System.out.println("5. sort phonebook by name");
		System.out.println("6. sort phonebook by phone number");
		System.out.println("7. remove duplicate contacts");
		System.out.println("8. arrange the phonebook in reverse order");
		System.out.println("9. save phonebook data in a text file");
		System.out.println("10. loading phonebook data from a text file");
		System.out.println("11. exit");
		System.out.println("please enter your choice:");
	}
	
//*****************application menu****************************
//the function print the application menu
	public static void PrintAppMenu() {
		System.out.println("***applications menu:***");
		System.out.println("1. Contacts");
		System.out.println("2. SMS");
		System.out.println("3. Diary");
		System.out.println("4. Media");
		System.out.println("5. print all information");
		System.out.println("6. exit");
		System.out.println("please enter your choice:");
	}
	
//*****************sms menu****************************
//the function print the sms menu
	public static void printSmsAppMenu() {
		System.out.println("***SMS menu:***");
		System.out.println("1. add SMS");
		System.out.println("2. delete correspondence");
		System.out.println("3. printing correspondence");
		System.out.println("4. search for a sentence");
		System.out.println("5. print to screen all correspondence");
		System.out.println("6. exit");
		System.out.println("please enter your choice:");
	}
	
////*****************Diary book menu****************************
//the function print the diary book menu
		public static void printDiaryAppMenu() {
		System.out.println("***Diary menu:***");
		System.out.println("1. Add meeting or event");
		System.out.println("2. Delete meeting or event");
		System.out.println("3. Printing day's events by order");
		System.out.println("4. print contact's meeting by order");
		System.out.println("5. Find colliding events");
		System.out.println("6. Print diary");
		System.out.println("7. Exit");
		System.out.println("Please enter your choice:");}
		
		
//*****************phone book menu****************************
//the function print the phone book menu
	public static void PrintMediaAppMenu() {
		System.out.println("***media menu:***");
		System.out.println("1. Add media");
		System.out.println("2. media player-music\\video");
		System.out.println("3. Media player-music and video");
		System.out.println("4. Exit");
		System.out.println("Please enter your choice:");
	}	
	
/////////////////////////////switch cases///////////////////////////////
	
	
//*****************phone book switch case****************************
//the function check what the user chose
	public static void PhoneBookMenu(PhoneBook phoneBook, SMSApp SmsBook, Diary diary) {
		int choice=0;
		Scanner s = new Scanner(System.in);
		//the menu:
		while (choice != 11) {
			PrintMenu();
			String choices = s.next();; // read number
			try {	 
				int choices_i = Integer.parseInt(choices); //cast the string to number
				//choice=s.nextInt();
				switch(choices_i) {
				  case 1:
					  phoneBook.AddContact();
				    break;
				  case 2:
					  phoneBook.RemoveContact(SmsBook, diary);
				    break;
				  case 3:
					  phoneBook.PrintPhoneBook();
					break;
				  case 4:
					  phoneBook.SearchContact();
					  break;
				  case 5:
					  phoneBook.sort_by_name();
					    break;
					  case 6:
					  phoneBook.sort_by_number();
					  break;
				  case 7:
					  phoneBook.RemoveDoubles();
					  break;
				  case 8:
					  phoneBook.reverseOrder();
					  break;
				  case 9:
					  phoneBook.PhoneBookToText();
					    break;
				  case 10:
					  phoneBook.TextToPhoneBook(phoneBook);
					    break;
				  case 11:
					  System.out.println("exit contact menu...\n");
					  choice=11;
					    break;
					  	
				  default:
					  System.out.println("error!\nplease choose again");
					    break;
				}
			}
				catch(Exception e) {
					System.out.println("error!\nplease choose again");
				
			}
		}
		
	}
	
//*****************sms switch case****************************
//the function check what the user chose
	public static void SmsMenu(PhoneBook phoneBook, SMSApp SmsBook) {
		int choice=0;
		Scanner s = new Scanner(System.in);
		while (choice != 6) {
			printSmsAppMenu();
			String choices = s.next(); // read number
			try {	 
				int choices_i = Integer.parseInt(choices); //cast the string to number
				switch(choices_i) {
				  case 1:
					  SmsBook.SendNewMessege();
				    break;
				  case 2:
					  SmsBook.RemoveReqSMS();
				    break;
				  case 3:
					  SmsBook.PrintRequestedSMS();
					break;
				  case 4:
					  SmsBook.SearchSentence();
					  break;
				  case 5:
					  SmsBook.PrintAllSMS();
					  break;
				  case 6:
					  System.out.println("exit SMS Menu...\n");
					  choice=6;
					  break;	  	
				  default:
					  System.out.println("error!\nplease choose again");
					    break;
				}
			}
				catch(Exception e) {
					System.out.println("error!\nplease choose again");
				
			}
		}
	}
	
//*****************Diary switch case****************************
//the function check what the user chose		

	public static void DiaryMenu( PhoneBook phoneBook, Diary diary) {
			int choice=0;
			Scanner s = new Scanner(System.in);
			//the menu:
			while (choice != 7) {
				printDiaryAppMenu();
				String choices = s.next(); // read number
				try {	 
					int choices_i = Integer.parseInt(choices); //cast the string to number
					//choice=s.nextInt();
					switch(choices_i) {
					  case 1://add new day
						 System.out.println("for meeting choose 1, for event choose 2");
						  String dayChoice = s.next(); // read number
							try {	 
								int dayChoices_i = Integer.parseInt(dayChoice);
								if(dayChoices_i == 1) {//add new meeting
									diary.AddMeeting(phoneBook);
								}
								else if(dayChoices_i ==2) {//add new event
									diary.AddEvent(phoneBook);
								}
								} //cast the string to number
							catch(Exception dayE) {
								System.out.println("Wrong input! choose again");
							}
					    break;
					  case 2://delete day
						   diary.RemoveDay();
					    break;
					  case 3:
						  diary.PrintOneDay();
						break;
					  case 4:
						  diary.PrintOneContact( phoneBook);
						  break;
					  case 5:
						  diary.DeleteCollidingEvents();
						  break;
					  case 6:
						  diary.PrintDiaryBook();//print diary
						  break;
					  case 7:
						  choice = 7;
						  break;
					  default:
						  System.out.println("Wrong input! choose again:");
						    break;
					}
				}
					catch(Exception e) {
						System.out.println("Wrong input! choose again (a number):");
					
				}
			}
		}	
	

//*****************media switch case****************************
//the function check what the user chose	
	public static void MediaMenu(MediaApp mediaList) {
		int choice=0;
		Scanner s = new Scanner(System.in);
		while (choice != 4) {
			PrintMediaAppMenu();
			String choices = s.next(); // read number
			try {	 
				int choices_i = Integer.parseInt(choices); //cast the string to number
				switch(choices_i) {
				  case 1:
					 mediaList.AddMedia();
				    break;
				  case 2:
					  mediaList.PrintMedia();
				    break;
				  case 3:
					  mediaList.PrintMediaList();
					break;
				  case 4:
					  System.out.println("exiting Media Menu...\n");
					  choice=4;
					  break;	  	
				  default:
					  System.out.println("error!\nplease choose again:");
					    break;
				}
			}
				catch(Exception e) {
					System.out.println("error!\nplease choose again:");
				
			}
		}
	}
	
//main

	public void main() throws ParseException {
		Scanner s = new Scanner(System.in);
		////////////////////////////////// Phone Book ////////////////////////////
		/*PhoneBook phoneBook= new PhoneBook();
		SMSApp SmsBook = new SMSApp(phoneBook);
		 Diary diary = new Diary();
		 MediaApp mediaList= new MediaApp();*/

//**************************application menu*************************************
		int appFlag=0;
		while (appFlag!=5) {
			PrintAppMenu();
			String appChoice = s.next();
			try {	 
				int appChoice_i = Integer.parseInt(appChoice); //cast the string to number
				switch(appChoice_i) {
				  case 1: //Phone Book
					  PhoneBookMenu(this.phoneBook, this.SmsBook, this.diary);
				  break;
				  case 2:
					  SmsMenu(this.phoneBook, this.SmsBook);
				  break;
				  case 3:
					  DiaryMenu(this.phoneBook, diary);
               break;
				  case 4:
					  MediaMenu(mediaList);
				  break;
				  case 5:
					  System.out.println("printing....\n");
					  System.out.println("phone book:");
					  phoneBook.PrintPhoneBook();
					  System.out.print("SMS book:");
					  SmsBook.PrintAllSMS();
					  System.out.print("Diary book:");
					  diary.PrintDiaryBook();
					  System.out.println("Media:");
					  mediaList.PrintMedia();
				  break;
				  case 6:
					  appFlag=5;
					  System.out.println("exit Phone...\nHave a nice day :)");
				  break;
				}		
			}
			catch(Exception err) {
				System.out.println("error!please choose again:");
		}
		}
		

	}
}
