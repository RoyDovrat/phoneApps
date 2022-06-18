package phoneApps;

import java.util.Date;
//inherits from day
public class Meeting extends Day {
		private Contact contact;

		// Constructors
		public Meeting(Date date, int duration, Contact con) {
			super(date, duration);
			this.contact = con;
		}
		
		//default constructor 
		public Meeting() {
			super();
			this.contact = new Contact();
		}
		
		//copy constructor
		public Meeting(Meeting m) {
			super(m.getDate(), m.getDuration());
			this.contact = m.getContact();
		}
		
		// Getters & Setters
		public Contact getContact() {
			return this.contact;
		}
		
		public void setContact(Contact c) {
			this.contact = c;
		}
		
		public Date getDate() {
			return super.getDate();
		}
		
		public void setDate(Date d) {
			super.setDate(d);
		}
		
		public int getDuration() {
			return super.getDuration();
		}
		
		public void setDuration(int d) {
			super.setDuration(d); 
		}

		//printings:
	/*	public void printMeeting() {
			super.printDay();
			System.out.println(" " + this.getContact());
			
		}*/
		
		public void printDay() {
			super.printDay();
			System.out.print("contact:");
			this.getContact().printContact();
			
		}
		
		

}
