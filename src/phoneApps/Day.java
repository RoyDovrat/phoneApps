package phoneApps;

import java.util.Comparator;
import java.util.Date;

//an abstract class for meetings and events- inheritance
public abstract class Day {

	private Date date;
	private int duration;
	
	// Constructors
	public Day(Date date, int duration) {
		
		this.date = date;
		this.duration = duration;
		
	}	
	
//default constructor						
	public Day() {
		this.date = new Date(0,0,0);
		this.duration = 0;
	}
	
	//copy constructor
	public Day(Day d) {
		this.date = d.getDate();
		this.duration = d.getDuration();
	}
	
	// Getters & Setters
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void printDay() {
		System.out.println("date: " + this.getDate());
		System.out.println("duration: " + this.duration + " minutes");
	}
	
	
    public static Comparator<Day> ContDayComparator = new Comparator<Day>() {

	public int compare(Day d1, Day d2) {
		return d1.getDate().compareTo(d2.getDate());

   }};


}

