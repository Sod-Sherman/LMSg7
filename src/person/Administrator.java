package person;

import java.io.Serializable;
import java.util.List;

import dataaccess.DataAccessFacade;

public class Administrator extends Staff implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5707904868251677410L;
	//private DataAccessFacade member = new DataAccessFacade();
	private Book bookCollection = null;
	private Author author = null;
	private LibraryMember newMember = null;
	//private Staff staff = null;

	public Administrator(String firstName, String lastName, Address address, String username, String password, Role role) {
		super(firstName, lastName, address, username, password, role);

	}

	public boolean addNewBook(String title, String isbn, int numCop, boolean available, int borrowDayLimit,
			String authorFirstName, String authorLastName, String street, String city, String state, String zip, String phoneNumber,
			String authorCredential, String authorBio) {

		if(!isBookAvailable(isbn)) {
			bookCollection = new Book(title, isbn, numCop, available, borrowDayLimit);
			DataAccessFacade.saveBook(bookCollection);
			Address authorAddress = new Address(street, city, state, zip, phoneNumber);
			author = new Author(authorFirstName, authorLastName, authorAddress, authorCredential, authorBio, bookCollection);
			DataAccessFacade.saveAuthor(author);
			return true;

		}
		else {
			bookCollection = getBook(isbn);
			System.out.println(bookCollection.getNumCop());
			bookCollection.setNumCop( bookCollection.getNumCop() + numCop);
			System.out.println(bookCollection.getNumCop());

		}

		return false;

	}

	public Book getBook(String isbn) {
		List<Book> books = DataAccessFacade.readBook();
		for(Book book: books) {
			if(isbn.equals(book.getIsbn()))
				return book;
		}
		return null;
	}

	public boolean isBookAvailable(String isbn) {

		List<Book> books = DataAccessFacade.readBook();
		for(Book book: books) {
			if(isbn.equals(book.getIsbn())) {
				return true;
			}
		}

		return false;
	}

	public boolean addNewMember(String firstName, String lastName, Address address, String username,
			String password, Role role) {

		if(!(isUserAvailable(username))) {

			if(role == Role.ADMIN || role == Role.BOTH) {

			Administrator staff = new Administrator(firstName, lastName, address, username, password, role);

			DataAccessFacade.saveStaff(staff);
			return true;
			}
			else if(role == Role.LIBRARIAN) {
				Librarian staff = new Librarian(firstName, lastName, address, username, password, role);
				DataAccessFacade.saveStaff(staff);
				return true;
			}

		}
		return false;

		}

	public boolean isUserAvailable(String username) {

		List<Staff> list = DataAccessFacade.readStaff();
		for(Staff staff: list) {
			if(username.equals(staff.getUsername()))

				return true;
		}


		return false;
	}

	public boolean editMemberInfo() {
		return false;
	}

	public void openadminUI() {
		System.out.println("This is admin UI");

	}

	public Administrator getAdmin(String userName) {

		List<Staff> list = DataAccessFacade.readStaff();
		for(Staff staff: list) {
			if(userName.equals(staff.getUsername()))
				return (Administrator)staff;
		}
		return null;
	}
	


	public boolean addUser(String firstName, String lastName, Address address, String memeberID) {
		if(!isUserMemberAvailable(memeberID)) {
			
			newMember = new LibraryMember(firstName, lastName, address, memeberID);

			DataAccessFacade.saveUser(newMember);
			return true;

		}
		return false;
	}

	public boolean isUserMemberAvailable(String memberId) {
		List<LibraryMember> list = DataAccessFacade.readUser();
		for(LibraryMember member: list) {
			if(memberId.equals(member.getMembId()))
				return true;
		}
		return false;
	}



}
