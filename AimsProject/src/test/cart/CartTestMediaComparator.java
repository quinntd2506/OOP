package test.cart;

import aims.cart.Cart;
import aims.media.*;

public class CartTestMediaComparator {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",	"Animation",		"Roger Allers", 87, 18.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",		"Science Fiction",	"George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",			"Animation",		90,		18.99f);
		DigitalVideoDisc dvdsort1 = new DigitalVideoDisc("Aladin",		"Animation 3D",		90,		28.99f);
		DigitalVideoDisc dvdsort2 = new DigitalVideoDisc("Aladin",		"Animation 3D",		100,	28.99f);
		
		Book booksort1 = new Book("A Tale of Two Cities", "Historical fiction", "Charles Dickens", 18.59f);
		Book booksort2 = new Book("The Hobbit", "Fantasy", "J. R. R. Tolkien", 18.59f);
		Book booksort3 = new Book("The Hobbit", "Fantasy", "J. R. R. Tolkien", 20.59f);
		
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(dvdsort1);
		cart.addMedia(dvdsort2);
		cart.addMedia(booksort1);
		cart.addMedia(booksort2);
		cart.addMedia(booksort3);
		
		cart.print();
		
		System.out.println("\nTEST COMPARATOR: Title-Cost\n");
		cart.sortByTitleCost();
		cart.print();
		
		System.out.println("\nTEST COMPARATOR: Cost-Title\n");
		cart.sortByCostTitle();
		cart.print();
		
		System.out.println("\nTEST COMPARATOR: Media & DVD Comparable @Override\n");
		cart.sortComparable();
		cart.print();
	}

}
