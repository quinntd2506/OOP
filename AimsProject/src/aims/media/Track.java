package aims.media;

import aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Track)) {
			return false;
		}
		return ((Track)obj).getTitle() == this.getTitle() && 
				((Track)obj).getLength() == this.getLength();
	}

	@Override
	public String getPlayContent() {
		// TODO Auto-generated method stub
		return "Playing Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
	}
		
	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println(this.getPlayContent());
		} else {
			throw new PlayerException("ERROR: Track " + this.getTitle() + " length is non-positive");
		}
	}

	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
}