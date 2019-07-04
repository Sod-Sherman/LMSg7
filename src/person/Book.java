package person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Book extends Publication implements Serializable {
//	public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 218530071006538965L;

	public Book(String title, String isbn, int numCop, boolean available, int borrowDayLimit) {
		super(title);
		this.isbn = isbn;
		Random rand = new Random();
		int id = rand.nextInt(100);
		this.copyid = isbn + id ;
		
		this.numCop = numCop;
		this.available = available;
		this.borrowDayLimit = borrowDayLimit;
	}
	
	private String copyid;
	private String isbn;
	private int numCop;
	private boolean available;
	private int borrowDayLimit;
	private List<Author> authors = new ArrayList<>();
	
	public void addAuthor(Author author) {
		authors.add(author);
	}
	
	public void isAvailable(boolean b) {
		available = b;
	}
	
	@Override
	public String toString() {
		return getTitle()+" cId: " + copyid + ":" + isbn + ", Copies: " + getNumCop();
	}
	public String getCopyid() {
		return copyid;
	}
	public void setCopyid(String copyid) {
		this.copyid = copyid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumCop() {
		return numCop;
	}
	public void setNumCop(int numCop) {
		this.numCop = numCop;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getBorrowDayLimit() {
		return borrowDayLimit;
	}
	public void setBorrowDayLimit(int borrowDayLimit) {
		this.borrowDayLimit = borrowDayLimit;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
