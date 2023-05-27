package aimsproject;

import aimsproject.DigitalVideoDisc;

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

}