package phoneApps;


import java.util.Scanner;

public class SMS {
		private String name;
		private String messeges;
		
		// Constructors
		public SMS(String initName, String initMesseges) {
			this.messeges = initMesseges;
			this.name = initName;
		}
		
		public SMS() {//default constructor 
			this.messeges = "No Messeges";
			this.name = "noName";
		}
		
		public SMS(SMS another) {
			this.messeges = another.getMesseges();
			this.name = another.getName();
		}
		
		// Getters & Setters
		public String getMesseges() {
			return messeges;
		}
		
		public void setMesseges(String messeges) {
			this.messeges = messeges;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void addMessege() {
			Scanner s = new Scanner(System.in);
			System.out.println("Write the messege:");
			String newMessege = s.nextLine();
			this.messeges = this.messeges +"\nMe: "+ newMessege;
		}
	
}

