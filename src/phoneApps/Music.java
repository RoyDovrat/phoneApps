package phoneApps;



public class Music extends Media {
	// Constructors
		public Music(String MusicLength, String MusicName) {
			super(MusicLength,MusicName);
		}
		public Music() {
			super("0:00","NoName");
		}
		public Music(Music song) {
			this(song.getName(), song.getLength());
		}
}

