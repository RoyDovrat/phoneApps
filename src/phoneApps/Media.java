package phoneApps;


//media apllication
public abstract class Media {
	protected String Length;
	protected String Name;
	
	public Media(String initLength, String initName) {
		this.Length = initLength;
		this.Name = initName;
	}
	
	//default constructor
	public Media() { 
		this.Length = "0:00";
		this.Name = "noName";
	}
	
	
	public Media(Media copyMedia) { 
		this.Length = copyMedia.getLength();
		this.Name = copyMedia.getName();
	}
	
	// Getters & Setters
	public String getLength() {
		return Length;
	}
	
	public void setLength(String Length) {
		this.Length = Length;
	}
	
	public String getName() {
		return Name;
	}
	
	public void SetVideoName(String Name) {
		this.Name = Name;
	}
	
	
}

