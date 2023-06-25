package aims.media;

import java.util.ArrayList;
import java.util.List;

import aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
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
			System.out.println("Track " + aTrack + " removed");
		} else {
			System.out.println("Track does not exist");
		}
	}

	@Override
	public String toString() {
		return String.format("CD - %s - %s - %s - %s: %s $",
				this.getTitle(),
				this.getCategory(),
				this.getArtist(),
				this.getLength(),
				this.getCost());
	}

	@Override
	public int getLength() {
		int len = 0;
		for (Track track : tracks) {
			len += track.getLength();
		}
		return len;
	}

	@Override
	public String getPlayContent() {
		// TODO Auto-generated method stub
		return "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
	}

	@Override
	public void play() throws PlayerException {
		
		if(this.getLength() > 0) {
			System.out.println("Disc Artist: " + this.getArtist());
			System.out.println(this.getPlayContent());
			int index = 0;

        for (Track track : tracks) {
        	track.play();
	        	index += 1;
	        	System.out.println("Track number" + index);
	        }
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
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

}
