package aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
	}

	public List<String> getAuthors() {
		return authors;
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
	
	
	

}
