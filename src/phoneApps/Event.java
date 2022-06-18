package phoneApps;

import java.util.Date;

//inherits from day
public class Event extends Day {
		private String description;

		
		// Constructors
		public Event(Date date, int duration, String desc) {
			super(date, duration);
			this.description = desc;
		}
		
		//default constructor 
		public Event() {
			super();
			this.description = null;
		}
		
		//copy constructor
		public Event(Event e) {
			super(e.getDate(), e.getDuration());
			this.description = e.getDescription();
		}
		
		// Getters & Setters
		public String getDescription() {
			return this.description;
		}
		
		
		public void setDescription(String s) {
			this.description = s;
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
		
		
		public void printEvent() {
			super.printDay();
			System.out.println(" " + this.getDescription() + "\n");
			
		}
		
		public void printDay() {
			super.printDay();
			System.out.println("description: " + this.getDescription()+ "\n \n");
		}
		
		

}

