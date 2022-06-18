package phoneApps;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaApp {
	private ArrayList<Media> mediaList;
	
	public MediaApp() {
		mediaList = new ArrayList<>();
	}
	
	public ArrayList<Media> getMediaList() {
		return mediaList;
	}

	public  void setMediaList(ArrayList<Media> mediaList) {
		this.mediaList = mediaList;
	}

	
	public void AddImmdiateMedia(Media newMedia){
		this.mediaList.add(newMedia);
	}
	
//*******************************1-add media*********************************************	
	public void AddMedia(){
		Scanner s = new Scanner(System.in);
		System.out.println("Which media would you like to add?\nPress 1 for music\nPress 2 for Video");
	
		String mediaKind= s.next();
		try {	 
			int mediaKind_i = Integer.parseInt(mediaKind); //cast the string to number
	
			switch(mediaKind_i) {
			  case 1:
				 //Music Adding:
				  System.out.println("Please enter the song name:");
				  String enter= s.nextLine(); 
				  String songName= s.nextLine();
				  System.out.println("Please enter the song length:");
				  String songLength= s.nextLine();
				  Music newSong= new Music(songLength, songName);
				  mediaList.add(newSong);
				  break;
			  case 2:
				  //Video Adding:
				  System.out.println("Please enter the Video name:");
				  String enter1= s.nextLine();
				  String videoName= s.nextLine();
				  System.out.println("Please enter the Video length:");
				  
				  String videoLength= s.nextLine();
				  Video newVideo= new Video(videoLength, videoName);
				  mediaList.add(newVideo);
				  break;  	
			  default:
				  System.out.println("error!");
				    break;
			}
		}
			catch(Exception e) {
				System.out.println("error!\n next time choose a number");
		}
	}
	
//*****************2- Print Media According To A Name**************************
	public void PrintMedia(){ // a loop to go all over the array-list and print the name and the length
		Scanner s = new Scanner(System.in);
		System.out.println("Write the name of the Media");
		String mediaName= s.nextLine(); //requested name scanning
		int flag1=0; //assume it wasn't found
		for (int i=0; i<mediaList.size(); i++) { // a loop to find a media with that name
			if(mediaName.equals(mediaList.get(i).getName())) { //check if the media has the name
				flag1=1; //if a contact was found- raise flag
				if(mediaList.get(i) instanceof Music) {
					System.out.print("The Song " +mediaList.get(i).getName());
					System.out.print(" is now playing for ");
					System.out.println(mediaList.get(i).getLength());
				}
				else if(mediaList.get(i) instanceof Video) {
					System.out.print("The Video "+mediaList.get(i).getName());
					System.out.print(" is now playing for ");
					System.out.println(mediaList.get(i).getLength());
				}
				break; //to delete only the first one, stop here.
			}
		}
		if (flag1==0) {//if no contact was found
			System.out.println("No such media!\n");
		}
	}
	
//****************************3- Print all media*************************
	public void PrintMediaList(){ // a loop to go all over the array-list and print the name and the length
		for (int i=0; i<mediaList.size(); i++) {
			if(mediaList.get(i) instanceof Music) {
				System.out.print("The Song " +mediaList.get(i).getName());
				System.out.print(" is now playing for ");
				System.out.println(mediaList.get(i).getLength());
			}
			else if(mediaList.get(i) instanceof Video) {
				System.out.print("The Video "+mediaList.get(i).getName());
				System.out.print(" is now playing for ");
				System.out.println(mediaList.get(i).getLength());
			}
		}
		System.out.println("\n");
	}
}

