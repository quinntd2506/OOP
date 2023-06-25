package aims.store;

import java.util.ArrayList;
import java.util.List;

import aims.media.Media;


public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media medium) {
		this.itemsInStore.add(medium);
		System.out.println("Item added.");
	}
	
	public String removeMedia(Media medium) {
		String warning = "";
		if (this.itemsInStore.remove(medium)) {
			System.out.println("Item removed.");
		} else {
			warning = "Item doesn't exist.";
			System.out.println(warning);
		}
		return warning;
	}
	
	public void print() {
		System.out.print("[");
		int lastindex = this.itemsInStore.size() - 1;
		for (int i = 0; i <= lastindex; i++) {
			System.out.print(this.itemsInStore.get(i).getTitle() + (i == lastindex ? "" : ", "));
		}
		System.out.println("]");
	}
	
	public Media searchByTitle(String title) { // Return one only
		Media medium;
		for (int i = 0; i < this.itemsInStore.size(); i++) {
			medium = this.itemsInStore.get(i);
			if (medium.isMatch(title)) {
				return medium;
			}
		}
		
		return null;
	}

    public List<Media> getItemsInStore() {
	return itemsInStore;
    }
}