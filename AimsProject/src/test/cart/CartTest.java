package test.cart;

import aims.disc.DigitalVideoDisc;
import aims.cart.Cart;

public class CartTest {

	public static void main(String[] args) {
		
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",	"Animation","Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		
		cart.addDigitalVideoDisc(dvd1);
		cart.addDigitalVideoDisc(dvd2);
		cart.addDigitalVideoDisc(dvd3);

        System.out.println(dvd1.getTitle());
		
		cart.print();
		
		System.out.println("\nTEST SEARCH:\n");
		cart.searchByID(1);
		cart.searchByID(15);
		
		System.out.println();
		cart.searchByTitle("liOn");
		cart.searchByTitle("why");
		cart.searchByTitle("Star Wars");
	}

}