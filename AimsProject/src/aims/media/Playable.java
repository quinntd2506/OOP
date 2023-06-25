package aims.media;

import aims.exception.PlayerException;

public interface Playable {
	public String getPlayContent();
	public void play() throws PlayerException;
}