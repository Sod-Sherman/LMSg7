package person;

import java.io.Serializable;

public class Author extends Person implements Serializable {

	public Author(String firstName, String lastName, Address address, String credential, String bio, Book book) {
		super(firstName, lastName, address);
		this.memberId += 1;
		this.credential = credential;
		this.bio = bio;
		this.book = book;
	}
	private int memberId = 0;
	private String credential;
	private String bio;
	private Book book;
	private static final long serialVersionUID = 567823456789L;
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}



}
