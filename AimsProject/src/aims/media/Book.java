package aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media {

	public Book(String title, String category, String author, float cost) {
		super(title, category, cost);
		this.addAuthor(author);
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	private List<String> authors = new ArrayList<String>();
	
	public String getAuthors() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < authors.size(); i++) {
			stringBuilder.append(authors.get(i));
			if (i != authors.size() - 1)
				stringBuilder.append(", ");
		}
		return stringBuilder.toString();
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			System.out.println("Author alread added");
		} else {
			this.authors.add(authorName);
			System.out.println("Athor added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			this.authors.remove(authorName);
			System.out.println("Author removed");
		} else {
			System.out.println("Author do not exist");
		}
	}
	
	public String toString() {
		return String.format("Book - %s - %s - %s: %s $", 
			this.getTitle(), 
			this.getCategory(), 
			this.getAuthors(),
			this.getCost()
		);
	}
	
	

}
