package aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	
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
			this.tracks.remove(aTrack);
			System.out.println("Track " + aTrack +" removed");
		} else {
			System.out.println("Track does not exist");
		}
	}
	
	public int getLength() {
		int len = 0;
        for (Track track : tracks) {
            len += track.getLength();
        }
		return len;
	}

	public void play() {
		int index = 0;
		
		System.out.println("Disc Artist: " + this.getArtist());
		System.out.println("Disc length: " + this.getLength());
        for (Track track : tracks) {
        	track.play();
        	index += 1;
        	System.out.println("Track number" + index);
        }
	}

}
