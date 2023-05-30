package aims.store;

import aims.disc.DigitalVideoDisc;


public class Store {
    public static final int MAX_NUMBERS_STORE = 1000000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORE];

    int qtyStore = 0;

    public int getqtyStore(){
        return this.qtyStore;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyStore == MAX_NUMBERS_STORE) {
            System.out.println("The store is almost full");
        }
        itemsInStore[qtyStore] = dvd;
        qtyStore++;
        System.out.println("The disc has been added to the store");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int index = -1;

        for (int i = 0; i<qtyStore; i++) {
            if (itemsInStore[i] == dvd) index = 1;
        }

        if (index == 1) {
            qtyStore--;
            for (int i = index; i<qtyStore; i++) {
                itemsInStore[i] = itemsInStore[i+1];
            }
            System.out.println("The disc has been removed in the store");
        }
        else {
            System.out.println("The disc doesn't exist.");
        }

    }

}
