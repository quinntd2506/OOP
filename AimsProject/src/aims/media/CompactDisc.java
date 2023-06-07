package aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist) {
		super(title, category);
		this.artist = artist;
	}

	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void addTrack(Track aTrack) {
		if (this.tracks.contains(aTrack)) {
			System.out.println("Track already added");
		} else {
			this.tracks.add(aTrack);
			System.out.println("Added " + aTrack);
		}
	}
	
	public void removeTrack(Track aTrack) {
		if (this.tracks.contains(aTrack)) {
			this.tracks.removed(aTrack);
			System.out.println("Track " + aTrack +" removed");
		} else {
			System.out.println("Track does not exist");
		}
	}
	
}
