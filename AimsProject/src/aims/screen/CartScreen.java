package aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.DigitalVideoDisc;
import aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private StoreScreen storeScreen;
	private CartScreenController cartcontrol;

	public void switchCart(boolean book, boolean cd, boolean dvd) {
        Platform.runLater(new Runnable() {
            @Override public void run() {
            	if (book ^ cd ^ dvd) {
            		cartcontrol.switchAdd(book, cd, dvd);
            	} else if (!book && !cd && !dvd) {
            		cartcontrol.switchCart();
            	}
            }
        });
	}

	public void changeTotalCost() {
        Platform.runLater(new Runnable() {
            @Override public void run() {
                cartcontrol.changeTotalCost();
            }
        });
	}

	public CartScreen (StoreScreen storeScreen, Store store, Cart cart) {
		super();

		this.cart = cart;
		this.storeScreen = storeScreen;


		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);


		this.setTitle("Cart");
		this.setVisible(true);
		this.setSize(1024, 768);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					cartcontrol = controller;
					loader.setController(controller);

					Parent root = loader.load();

					controller.getViewStoreMenuItem().setOnAction(event -> {
						storeScreen.setVisible(true);
						storeScreen.refreshStore(cart);
		                setVisible(false);
		            });

					controller.setStore(store);
					if (store == null) {
						System.out.println("WHEWYEW");
					}

					fxPanel.setScene(new Scene(root, 600, 600));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Store store = new Store();

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

		new CartScreen(new StoreScreen(store, cart), store, cart);
	}

}
