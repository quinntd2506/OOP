package aims.media;

import java.util.Comparator;

import aims.exception.PlayerException;

public abstract class Media implements Comparable<Media> {
	@Override
	public int compareTo(Media o2) {
		int titleComparison = this.title.compareTo(o2.title);
		return titleComparison != 0 ? titleComparison : Double.compare(o2.cost, this.cost);
	}
	private int id;
	private String title;
	private String category;
	private float cost;
	
	private static int numMedia = 1;
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = numMedia;
		numMedia += 1;
	}

	public Media(String title) {
		// TODO Auto-generated constructor stub
		this.setId();
		this.title = title;
	}
	public Media(String title, String category) {
		this.setId();
		this.title = title;
		this.category = category;
	}
	public Media(String title, String category, float cost) {
		this.setId();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public boolean isMatch(String keywords) {
		// Split the keywords into an array of individual words
		String[] words = keywords.toLowerCase().split("\\s+");
		
		// Check if any word in the array matches the Book/Disc's title (case-insensitive)
		for (String word : words) {
			if (this.getTitle().toLowerCase().contains(word)) {
				return true;
			}
		}
		   
		// No match found
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			System.out.println("Duplicate media.");
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
		return ((Media)obj).getTitle() == this.getTitle();
	}

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String playMedia() throws PlayerException {
		String playContent = "";
		if (this instanceof Playable) {
			((Playable) this).play();
			playContent = ((Playable) this).getPlayContent();
		} else {
			System.out.println("Playable media not found. Please try again.");
		}
		return playContent;
	}
}