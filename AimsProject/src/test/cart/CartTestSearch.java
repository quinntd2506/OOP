package test.cart;

import aims.cart.Cart;
import aims.media.*;

public class CartTestSearch {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",	"Animation",		"Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd1_x = new DigitalVideoDisc("The Lion King",	"Animation",		"Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",		"Science Fiction",	"George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Mulan",			"Animation", 		18.99f);
		
		Book book1 = new Book("Pride and Prejudice", "Period Romance", 12.25f);
		book1.addAuthor("Jane Austen");
		book1.addAuthor("Jane A");
		
		Track track1 = new Track("Nice", 210);
		Track track2 = new Track("Mine", 230);
		Track track3 = new Track("Moonshine", 180);
		Track track4 = new Track("Melancolia", 200);
		Track track5 = new Track("Plume", 180);
		Track track1_x = new Track("Nice", 180);
		CompactDisc cd1 = new CompactDisc("Chronologic", "Electro Swing", 52.50f, "Caravan Palace");
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		cd1.addTrack(track4);
		cd1.addTrack(track5);
		cd1.addTrack(track1_x);
		
		
		cart.addMedia(dvd1);
		cart.addMedia(dvd1_x);
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(book1);
		cart.addMedia(cd1);
		
		cart.print();
		
		System.out.println("\nTEST SEARCH:\n");
		cart.searchByID(1);
		cart.searchByID(15);
		
		System.out.println();
		cart.searchByTitle("liOn");
		cart.searchByTitle("star lion");
		cart.searchByTitle("why");
		cart.searchByTitle("Don't");
	}
}
