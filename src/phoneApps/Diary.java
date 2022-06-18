package phoneApps;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;


public class Diary {
	private ArrayList<Day> diary;
	private Date startDate;
	
	public Diary() {//default constructor
		diary = new ArrayList<Day>(); //creation of arrayList: DiaryBook
		//scan date

		Scanner s = new Scanner(System.in);
		System.out.println("Write month of the diary:");
		int month= s.nextInt();
		System.out.println("Write year of diary:");
		int year= s.nextInt();
		startDate = new Date(year - 1900, month -1 , 1, 0, 0);
	}
	
	public Diary(Date date) {// constructor
		if(date.getDate() != 1 || date.getHours()!= 0 || date.getMinutes() != 0) {
			System.out.println("Diary constructor failed, please choose a beginning of a month");
			return;
		}
		
		diary = new ArrayList<Day>(); //creation of arrayList: DiaryBook
		startDate = date;
	}
	//getters & setters
	
	public ArrayList<Day> getDiaryBook() {
		return diary;
	}

	public  void setDiary(ArrayList<Day> diary) {
		this.diary = diary;
	}
	

	
	////functions:
	
	//1- add a meeting
		public void AddMeeting(PhoneBook phoneBook) throws ParseException{
			//scan contact 
			int foundFlag = 0;
			Scanner s = new Scanner(System.in);
			System.out.println("Write name of meeting contact:");
			String name= s.next();
			Contact contact = phoneBook.getContact( name);//new Contact();		
			//scan date
			System.out.println("Write day of new meeting (between 1-30):");
			int day= s.nextInt();
			//System.out.println("Write month of new meeting:");
			//int month= s.nextInt();
			//System.out.println("Write year of new meeting:");
			//int year= s.nextInt();
			System.out.println("Write hour of new meeting:");
			int hour= s.nextInt();
			System.out.println("Write minutes of new meeting:");
			int minutes= s.nextInt();
			Date date= new Date(startDate.getYear() , startDate.getMonth(), day, hour, minutes);
			//scan duration;
			System.out.println("Write the duration of meeting: (less than 60 minutes)");
			int duration= s.nextInt();
			
			//create new meeting:
			Meeting new_meet = new Meeting(date, duration , contact); //create the contact given number and name
			diary.add(new_meet); //add to array-list
		}
		
		
		//add new event:
		public void AddEvent(PhoneBook phoneBook) throws ParseException{
			//scan description 
			int foundFlag = 0;
			Scanner s = new Scanner(System.in);
			System.out.println("Write description of event:");
			String description= s.nextLine();
			
			//scan date
			System.out.println("Write day of new meeting: (between 1-30)");
			int day= s.nextInt();
			/*System.out.println("Write month of new meeting:");
			int month= s.nextInt();
			System.out.println("Write year of new meeting:");
			int year= s.nextInt();*/
			System.out.println("Write hour of new meeting:");
			int hour= s.nextInt();
			System.out.println("Write minutes of new meeting:");
			int minutes= s.nextInt();
			Date date= new Date(startDate.getYear() , startDate.getMonth(), day, hour, minutes);
			
			
			//scan duration;
			System.out.println("Write the duration of meeting: (less than 60 minutes)");
			int duration= s.nextInt();
			
			//create new meeting:
			Event new_event = new Event(date, duration , description); //create the contact given number and name
			diary.add(new_event); //add to array-list
		}

		
		//add immediate meeting:
		public void AddImmediateDay(Day day) throws ParseException{
			if((startDate.getYear() != day.getDate().getYear()) || (startDate.getMonth() != day.getDate().getMonth()) ||day.getDate().getDay()>30 ) {
				System.out.println("Adding Failed - you are not in the diary's range");
				return;
			}
					
			diary.add(day);
		}
		
	//2- delete day
		public void RemoveDay() throws ParseException {
			//scan day
			Scanner s = new Scanner(System.in);
			System.out.println("Write day of the meeting:");
			int day= s.nextInt();
			/*System.out.println("Write month of the meeting:");
			int month= s.nextInt();
			System.out.println("Write year of the meeting:");
			int year= s.nextInt();*/
			System.out.println("Write hour of the meeting:");
			int hour= s.nextInt();
			System.out.println("Write minutes of new meeting:");
			int minutes= s.nextInt();
			Date date= new Date(startDate.getYear() , startDate.getMonth() , day, hour, minutes);
			//search date in diary:
			int flag1=0; //assume it wasn't found
			for (int i=0; i<diary.size(); i++) { // a loop to find a day with that date
				int isequal = date.compareTo(diary.get(i).getDate());
				if(isequal == 0) { //if the date exists, delete
					flag1=1; //if a contact was found- raise flag
					diary.remove(diary.get(i));
					System.out.println("the date was successfully deleted");
					break; //to delete only the first one, stop here.
				}
			}
			if (flag1==0) {//if no contact was found
				System.out.println("No such event/ meeting!\n");
			}
		}
		
	//3
		public void PrintOneDay() {
			sort_by_date(); //sort diary
			//scan date
			Scanner s = new Scanner(System.in);
			System.out.println("Write day of date:");
			int day= s.nextInt();
			System.out.println("Write month of date:");
			int month= s.nextInt();
			System.out.println("Write year of date:");
			int year= s.nextInt();
			//boundaries of the day we want to print
			Date startDate = new Date(year - 1900, month-1 , day, 0, 0);
			Date endDate = new Date(year - 1900, month-1 , day, 23, 59);
			
			//search date in diary:
			int flag1=0; //assume it wasn't found 
			for (int i=0; i<diary.size(); i++) { // a loop to find a day within the boundaries
				boolean isequal1 = startDate.before(diary.get(i).getDate());
				boolean isequal2 = endDate.after(diary.get(i).getDate());
				if(isequal1 && isequal2) { //if the date is day within the boundaries
					flag1=1; //if a contact was found- raise flag
					diary.get(i).printDay();
				}
			}
			if (flag1==0) {//if no contact was found
				System.out.println("No such date in the diary!\n");
			}
		}

	//4
		public void PrintOneContact(PhoneBook phoneBook) {
			sort_by_date(); //sort diary
			//scan contact 
			Scanner s = new Scanner(System.in);
			System.out.println("Write name of meeting contact:");
			String name= s.next();
			Contact contact = phoneBook.getContact(name);//we found the contact (if exists)
			//search contact in diary:
			if(contact != null) {
				int flag1=0; //assume it wasn't found 
				for (int i=0; i<diary.size(); i++) { // a loop to find the contact
					if(diary.get(i) instanceof Meeting) {
						Meeting m = (Meeting)diary.get(i);
						if(m.getContact() == contact) {
							m.printDay();
						}
					}
				}
			}
		}
		
	//5
		public void DeleteCollidingEvents() {
			sort_by_date(); //sort diary
			for (int i=0; i<diary.size(); i++) {//first loop
				//end of meeting/event:
				int year = diary.get(i).getDate().getYear();
				int month = diary.get(i).getDate().getMonth();
				int day = diary.get(i).getDate().getDate();
				int hour = diary.get(i).getDate().getHours();
				int minutes = diary.get(i).getDate().getMinutes() + diary.get(i).getDuration();
	
				Date endDate = new Date(year,month ,day ,hour, minutes);
				
				for (int j=i+1; j<diary.size(); j++) {//for what comes after
					Date thisDate = diary.get(j).getDate();
					boolean isequal = endDate.after(thisDate);//if starts during meeting
					if(isequal) {//if starts during meeting
						diary.remove(diary.get(j));//remove
						j = j-1;
					}
					}			
				}
			}


	// 6 print content:
	public  void PrintDiaryBook(){ // a loop to go all over the array-list and print the Days
			System.out.println("Diary Book:");
			for (int i=0; i<diary.size(); i++) {
				diary.get(i).printDay();
			}
		}
		
	//sort
	//sort diary by date
		public void sort_by_date() {
			Collections.sort(diary, Day.ContDayComparator );
		}

	//delete contact's meetings:
		public void RemoveContact(String contact) throws ParseException {
			//search contact in diary:
			if(contact != null) {
				int flag1=0; //assume it wasn't found 
				for (int i=0; i<diary.size(); i++) { // a loop to find the contact
					if(diary.get(i) instanceof Meeting) {
						Meeting m = (Meeting)diary.get(i);
						String s = m.getContact().getName();
						if(s.equals(contact)) {
							diary.remove(diary.get(i));	//remove;
							i = i-1;
						}
					}
				}
			}
		}
		


}

