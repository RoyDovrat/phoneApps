package phoneApps;

public class Video extends Media{
	
	// Constructors
	public Video(String VideoLength, String VideoName) {
		super(VideoLength,VideoName);
	}
	public Video() {
		super("0:00","NoName");
	}
	public Video(Video vid) {
		this(vid.getName(), vid.getLength());
	}
}
