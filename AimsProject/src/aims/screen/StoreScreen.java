package aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;
import aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;

    private CartScreen cartScreen;

    private JPanel changingPanel;

    private class goToCart implements ActionListener {
        private boolean book;
        private boolean cd;
        private boolean dvd;

        public goToCart(boolean book, boolean cd, boolean dvd) {
			this.book = book;
			this.cd = cd;
			this.dvd = dvd;
		}
            @Override
            public void actionPerformed(ActionEvent e) {
                cartScreen.setVisible(true);
                cartScreen.changeTotalCost();
                cartScreen.switchCart(book, cd, dvd);
                setVisible(false);
            }
        }


    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new goToCart(true, false, false));
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new goToCart(false, true, false));
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new goToCart(false, false, true));

		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);

		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(new goToCart(false, false, false));

		menu.add(smUpdateStore);
		menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    private JPanel createCenter(Cart cart) {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
		for (Media element : mediaInStore) {
			MediaStore cell = new MediaStore(element, cart);
			center.add(cell);
		}

        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cartScreen = new CartScreen(this, store, cart);
        this.cartScreen.setVisible(false);

        this.changingPanel = createCenter(cart);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(changingPanel, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public void refreshStore(Cart cart) {
        Container cp = getContentPane();
        cp.remove(changingPanel);

        this.changingPanel = createCenter(cart);
        cp.add(changingPanel, BorderLayout.CENTER);

        cp.revalidate();
        cp.repaint();

        this.revalidate();
        this.repaint();
    }

    public static void initApplication() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Mulan", "Animation", "Barry Cook", 88, 18.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Breakfast at Tiffany's", "Romantic Comedy", "Blake Edwards", 114, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Batman", "CBM", 176, 33.99f);

        Book book1 = new Book("Pride and Prejudice", "Romance", "Jane Austen", 15.99f);
        Book book2 = new Book("Harry Potter", "Fantasy", "J. K. Rowling", 18.59f);
        Book book3 = new Book("Harry Potter 2", "Fantasy", "J. K. Rowling", 18.59f);

        Track track1 = new Track("Moon River", 314);
        Track track2 = new Track("Sway", 330);
        Track track3 = new Track("Paper Rings", 280);
        Track track4 = new Track("Melancolia", 263);
        Track track5 = new Track("Purple Rain", 352);
        CompactDisc cd1 = new CompactDisc("Don't", "Ballad", 15.50f, "Zoe Kravitz");
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);
        cd1.addTrack(track4);
        cd1.addTrack(track5);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("No Length DVD", "Animation", 0, 0.99f);

        Store theStore = new Store();
        Cart theCart = new Cart();

        theStore.addMedia(dvd1);
        theStore.addMedia(dvd2);
        theStore.addMedia(dvd3);
        theStore.addMedia(dvd4);
        theStore.addMedia(cd1);
        theStore.addMedia(book1);
        theStore.addMedia(book2);
        theStore.addMedia(book3);
        

        new StoreScreen(theStore, theCart);
    }

    public static void main(String[] args) {
        initApplication();
    }

}
