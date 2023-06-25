package aims;


import java.util.Scanner;

import aims.cart.Cart;
import aims.exception.PlayerException;
import aims.media.*;
import aims.store.Store;

public class Aims {
    private static Store store;
	private static Cart cart;
	private static Scanner scanner;

    public static void clearConsole() {
	    // Print 50 empty lines to clear the console
	    for (int i = 0; i < 5; i++) {
	        System.out.println();
	    }
	}

    public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		scanner = new Scanner(System.in);
		showMainMenu();
	}

	public static void showMainMenu() {
		clearConsole();
		System.out.println("AIMS:");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		switch (choice) {
			case 0: exit(); break;
			case 1: storeMenu(); break;
			case 2: updateStore(); break;
			case 3: cartMenu(); break;
			default:
				System.out.println("Invalid choice. Please try again.");
				showMainMenu();
				break;
		}
	}

	public static void storeMenu() {
		clearConsole();
		store.print();
		System.out.println("Store Options:");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");

		Media media = null;
		int choice = 0;
		
		while (true) {
			System.out.println("Please choose a number: 0-1-2-3-4");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character
			
			if (1 <= choice && choice <= 3) {
				System.out.print("Enter the title of the media: ");
				String title = scanner.nextLine();
				
				media = store.searchByTitle(title);
				if (media == null) {
					System.out.println("Media not found. Please try again.");
					continue;
				}
			}
			break;
		}
		
		switch (choice) {
			case 0:
				showMainMenu();
				break;
			case 1:
				mediaDetailsMenu(media);
				break;
			case 2:
				cart.addMedia(media);
				if (media instanceof DigitalVideoDisc) {
					int dvdCount = cart.getDVDCount();
					System.out.println("DVD added to cart. Total DVDs in cart: " + dvdCount);
				} else {
					System.out.println("Media added to cart.");
				}
				
				break;
			case 3:
				try {
					media.playMedia();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				break;
			case 4:
				cartMenu();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
		}
		
		storeMenu();
	}

	public static void mediaDetailsMenu(Media media) {
		clearConsole();
		System.out.println(media.toString());
		
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (media instanceof Playable) {
			System.out.println("2. Play");
		}
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1" + (media instanceof Playable ? "-2" : ""));

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		switch (choice) {
			case 0:
				storeMenu();
				break;
			case 1:
				cart.addMedia(media);
				storeMenu();
				break;
			case 2:
				cart.addMedia(media);
				if (media instanceof DigitalVideoDisc) {
					int dvdCount = cart.getDVDCount();
					System.out.println("DVD added to cart. Total DVDs in cart: " + dvdCount);
				} else {
					System.out.println("Media added to cart.");
				}

				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				mediaDetailsMenu(media);
				break;
		}
	}

	public static void cartMenu() {
		clearConsole();
		cart.print();
		System.out.println("Cart Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		
		Media media = null;
		int choice = 0;
		
		while (true) {
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character
			
			if (choice == 3 || choice == 4) {
				System.out.println("Enter the title of the media:");
				String title = scanner.nextLine();
				
				media = store.searchByTitle(title);
				if (media == null) {
					System.out.println("Media not found. Please try again.");
					continue;
				}
			}
			break;
		}

		switch (choice) {
			case 0:
				storeMenu();
				break;
			case 1:
				filterMediasInCart();
				break;
			case 2:
				sortMediasInCart();
				break;
			case 3:
				cart.removeMedia(media);
				break;
			case 4:
				cartMenu();
				break;
			case 5:
				placeOrder();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				cartMenu();
				break;
		}
	}
	

	public static void filterMediasInCart() {
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by Title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		
		switch (choice) {
			case 0:
				cartMenu();
				break;
			case 1:
				System.out.print("ID: ");
				cart.searchByID(scanner.nextInt());
				cartMenu();
				break;
			case 2:
				System.out.print("Title: ");
				cart.searchByTitle(scanner.nextLine());
				cartMenu();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				filterMediasInCart();
				break;
		}
	}

	public static void sortMediasInCart() {
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by Title");
		System.out.println("2. Sort by Cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		switch (choice) {
			case 0:
				cartMenu();
				break;
			case 1:
				cart.sortByTitleCost();
				cartMenu();
				break;
			case 2:
				cart.sortByCostTitle();
				cartMenu();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				sortMediasInCart();
				break;
		}
	}

	public static void placeOrder() {
		System.out.println("Order created. Thank you for your purchase!");
		cart.clear();
		cartMenu();
	}

	public static void exit() {
		System.out.println("Goodbye!");
		scanner.close();
		System.exit(0);
	}
	
	public static void updateStore() {
		clearConsole();
		store.print();
		System.out.println("Store Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to the store");
		System.out.println("2. Remove a media from the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		
		Media media = null;
		int choice = 0;
		
		while (true) {
			System.out.println("Please choose a number: 0-1-2");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character
			
			if (choice == 2) {
				System.out.println("Enter the title of the media:");
				String title = scanner.nextLine();
				
				media = store.searchByTitle(title);
				if (media == null) {
					System.out.println("Media not found. Please try again.");
					continue;
				}
			}
			break;
		}

		switch (choice) {
			case 0:
				showMainMenu();
				break;
			case 1:
				addMediaToStore();
				break;
			case 2:
				store.removeMedia(media);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
		}
		updateStore();
	}
	
	public static void addMediaToStore() {
		System.out.println("Enter the category of the media (1) Book, (2) CD, (3) DVD or (0) exit:");
		int categoryChoice = scanner.nextInt();
		scanner.nextLine();
		switch(categoryChoice) {
			case 0: break;
			case 1:
				System.out.println("Enter book title: ");
				String bookTitle = scanner.nextLine();
				System.out.println("Enter book category: ");
				String bookCategory = scanner.nextLine();
				System.out.println("Enter book cost: ");
				Float bookCost = scanner.nextFloat();
				scanner.nextLine();

				Book newBook = new Book(bookTitle, bookCategory, bookCost);
				store.addMedia(newBook);
				break;
			case 2:
				System.out.println("Enter CD title: ");
				String cdTitle = scanner.nextLine();
				System.out.println("Enter CD category: ");
				String cdCategory = scanner.nextLine();
				System.out.println("Enter CD artist: ");
				String cdArtist = scanner.nextLine();
				System.out.println("Enter CD cost: ");
				Float cdCost = scanner.nextFloat();
				scanner.nextLine();

				CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdCost, cdArtist);
				
				System.out.println("Do you want to add tracks to your CD? (1) Yes (0) No:");
				int addTrack = scanner.nextInt();
				scanner.nextLine();
				
				if (addTrack == 1) {
					System.out.println("How many tracks in your CD?");
					int numTrack = scanner.nextInt();
					scanner.nextLine();
					for (int i = 0; i < numTrack; i++) {
						System.out.println("Your " + (i+1) + " track: ");
						System.out.println("Enter track title: ");
						String trackTitle = scanner.nextLine();
						System.out.println("Enter track length: ");
						int trackLength = scanner.nextInt();
						scanner.nextLine();

						Track newTrack = new Track(trackTitle, trackLength);
						newCD.addTrack(newTrack);
					}
					store.addMedia(newCD);
				} else if (addTrack == 0) {
					store.addMedia(newCD);
				}
				break;
			case 3:
				System.out.println("Enter DVD title: ");
				String dvdTitle = scanner.nextLine();
				System.out.println("Enter DVD category: ");
				String dvdCategory = scanner.nextLine();
				System.out.println("Enter book cost: ");
				Float dvdCost = scanner.nextFloat();
				scanner.nextLine();
				
				DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost);
				store.addMedia(newDVD);
				break;
			default:
				System.out.println("Invalid option.");
				break;
		}
	}

}