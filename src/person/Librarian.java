package person;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import dataaccess.DataAccessFacade;

public class Librarian extends Staff implements Serializable {
	public Librarian (String firstName, String lastName, Address address, String username, String password, Role role) {
		super(firstName, lastName, address, username, password, role);

	}
	CheckoutRecordEntry entry = null;
	private CheckoutRecord record = new CheckoutRecord();

	private LibraryMember newMember = null;

	
	public int checkout(Book selectedBook, LibraryMember selectedmember) { //return 0: copies 0 -1:error 1:OK

		List<Book> books = DataAccessFacade.readBook();
		if(books == null)
			System.out.println("No available books");
		else {

			if(selectedBook.getNumCop() == 0) {
				System.out.println("copies=0");
				return 0;
			}
			selectedBook.setNumCop(selectedBook.getNumCop() - 1);

		for(Book book: books) {
			if(book.getIsbn().equals(selectedBook.getIsbn()))
				book.setNumCop(selectedBook.getNumCop());
		}
		
		DataAccessFacade.saveBookList(books);
		
		CheckoutRecordEntry entry = new CheckoutRecordEntry(selectedBook,selectedmember);
		CheckoutRecord.addEntry(entry);
		return 1; //OK
		}	
		return -1; //book is null
}

	public boolean addUser(String firstName, String lastName, Address address, String memeberID) {
		if(!isUserAvailable(memeberID)) {
			newMember = new LibraryMember(firstName, lastName, address,memeberID);
			DataAccessFacade.saveUser(newMember);
			return true;
			
		}	
		return false;
	}
	
	public boolean isUserAvailable(String memberId) {
		List<LibraryMember> list = DataAccessFacade.readUser();
		for(LibraryMember member: list) {
			if(memberId.contentEquals(member.getMembId()))
				return true;
		}
		return false;
	}
	
	private static final long serialVersionUID = -2226197306790714013L;

	public boolean checkoutRecord(Book book) {
		return false;

	}
	public void openLibraryUI(){
		System.out.println("This is Library UI");

	}
}
