package aims.cart;

import aims.media.DigitalVideoDisc;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private float totalCost = 0f;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public int getQtyOrderd() {
        return this.qtyOrdered;
    }

    public boolean isFulled() {
        if (qtyOrdered == MAX_NUMBERS_ORDERED)
            return true;
        else
            return false;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (isFulled())
            System.out.println("The Cart is almost full");
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        if (isFulled())
            System.out.println("The Cart is almost full");
        for (DigitalVideoDisc i:dvdList) {
            itemsOrdered[qtyOrdered] = i;
            qtyOrdered++;
            if (isFulled()) {
                System.out.println("The Cart is almost full");
                break;
            }
        }
    }

    public void addDigitalVideoDisc(int dvdNum) {
        if (isFulled())
            System.out.println("The Cart is almost full");
        for (int i = 0; i < dvdNum; i++) {
            itemsOrdered[qtyOrdered] = new DigitalVideoDisc(null);
            qtyOrdered++;
            if (isFulled()) {
                System.out.println("The Cart is almost full");
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < 20; i++)
            if (itemsOrdered[i] == disc)
                index = i;
        if (index == -1) {
            System.out.println("Can't find the disc");
        } else {
            qtyOrdered--;
            for (int i = index; i < qtyOrdered; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
        }
        System.out.println("The disc has been removed");
    }

    public float getTotalCost() {
        for (int i = 0; i < qtyOrdered; i++) {

                totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		
        for (int i = 0; i < qtyOrdered; i++) {
        	System.out.println(i + 1 + ".DVD - " + itemsOrdered[i].toString());
        }

		System.out.println("Total cost: " + getTotalCost() + "$");
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
		System.out.println("Search for: " + id);
		
        for (int i = 0; i < qtyOrdered; i++) {
        	if (itemsOrdered[i].getId() == id) {
        		System.out.println("Found: " + itemsOrdered[i].toString());
        		return;
        	}
        }
        System.out.println("Disc not found.");
	}
	
	public void searchByTitle(String keywords) {
		System.out.println("- Search for: " + keywords);
		
		int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
        	if (itemsOrdered[i].isMatch(keywords)) {
        		System.out.println("Found: " + itemsOrdered[i].toString());
        		// No return because there maybe many found
        		index = i;
        	}
        }
        if (index == -1) {
        	System.out.println("Disc not found.");    	
        }
        else {
            System.out.println(itemsOrdered[index].toString());
        }
	}
}
