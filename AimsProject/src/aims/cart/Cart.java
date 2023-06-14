package aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import aims.media.DigitalVideoDisc;
import aims.media.Media;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void clear() {
		this.itemsOrdered = new ArrayList<Media>();
	}
	
	public String addMedia (Media medium) {
		String warning = "";
		if (this.itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (itemsOrdered.contains(medium)) {
				warning = "Media already added. Cannot add.";
				System.out.println(warning);
			} else {
				itemsOrdered.add(medium);
				System.out.printf("Item added to cart. (%d)\n", itemsOrdered.size());	
			}
		} else {
			warning = "The cart is full. Cannot add.";
			System.out.println(warning);
		}
		return warning;
	}
	
	// METHOD OVERLOADING: Java varargs
	public String addMedia (Media ... mediumList) {
		String warning = "";
		for (int i = 0; i < mediumList.length; i++) {
			warning += addMedia(mediumList[i]);
		}

		return warning;
	}
	
	public String removeMedia (Media medium) {
		String warning = "";
		if (itemsOrdered.remove(medium)) {
			System.out.println("Media (Disc/Book) removed.");
		} else {
			warning = "Media (Disc/Book) doesn't exist.";
			System.out.println(warning);
		}
		return warning;

	}
	
	public String getContentAllMedia() {
		String buffer = "";
        for (int i = 0; i < itemsOrdered.size(); i++) {
            buffer += itemsOrdered.get(i).getTitle() + "\n";
        }
        
        return buffer;
	}
	
	public int getDVDCount() {
		int count = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i) instanceof DigitalVideoDisc) {
            	count = count + 1;
            };
        }
		return count;
	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) 
		{
			total = total + itemsOrdered.get(i).getCost();
		}
		
		return total;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		
		Media medium;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
        	medium = this.itemsOrdered.get(i);
        	System.out.printf("%d. %s\n", i+1, medium.toString());
        }

		System.out.println("Total cost: " + this.totalCost() + "$");
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
		System.out.println("Search for: " + id);
		
		Media medium;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
        	medium = this.itemsOrdered.get(i);
        	if (medium.getId() == id) {
        		System.out.println("Found: " + medium.toString());
        		return;
        	}
        }
        System.out.println("Disc not found.");
	}
	
	public void searchByTitle(String keywords) {
		System.out.println("- Search for: \"" + keywords + "\"");
		
		int found = 0;
		Media medium;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
        	medium = this.itemsOrdered.get(i);
        	if (medium.isMatch(keywords)) {
        		System.out.println("Found: " + medium.toString());
        		// No return because there maybe many found
        		found += 1;
        	}
        }
        if (found == 0) {
        	System.out.println("Disc not found.");    	
        }
	}
	
	
	public void sortByTitleCost() {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	public void sortByCostTitle() {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	public void sortComparable() {
		Collections.sort(this.itemsOrdered);
	}
}