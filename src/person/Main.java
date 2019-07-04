package person;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7972973962420593771L;

	public static void main(String[] args) {
//		LibraryMember member = new LibraryMember("John");
//		Publication p = new Book(1, "1234","Gone with the Wind");
//		LendableCopy c = new LendableCopy();
//		c.setPublication(p);
//		c.setCopyId(1);
//		member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
//		System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);
//		DataAccess da = new DataAccessFacade();
//		da.saveLibraryMember("John", member);
//		System.out.println("Reading record for John:\n"+"  "+da.readLibraryMember("John"));
		Address address = new Address("kebena", "addis", "kilil 11", "52557", "0911510195");
		Staff admin = new Staff("John", "Khan", address, "admin", "111", Role.ADMIN);
		Administrator toBE = new Administrator("David", "Lee", address, "lib", "111",  Role.LIBRARIAN);
		Administrator toBE2 = new Administrator("Susan", "Beyer", address, "super", "111",  Role.BOTH);
		
//		System.out.println(toBE.addNewMember(1, "Abebe", "Beso", address, "abebe", "abebebeso", "waht is beso?", "bela", Role.ADMIN));
		//System.out.println(toBE.addNewMember("Admin's first", "Last", address, "admin", "111", "waht is beso?", "bela", Role.ADMIN));
		//System.out.println(toBE.addNewMember("Librarian firs", "Lastname", address, "lib", "111", "waht is beso?", "bela", Role.LIBRARIAN));
		
		//System.out.println(toBE.isUserAvailable("abebe"));
		//System.out.println(toBE.isUserAvailable("bekele"));
		
		LibraryMember lb1 = new LibraryMember("John", "Blaster", address, "303");
		LibraryMember lb2 = new LibraryMember("Susan", "Blaster", address, "304");
		LibraryMember lb3 = new LibraryMember("David", "Khan", address, "307");
		LibraryMember lb4 = new LibraryMember("Lucy", "Khan", address, "308");
		
//		Book bk1 = new Book("Donald Trump", "123122", 2, false, 7);
//		Book bk2 = new Book("Harry Potter", "223128", 1, true, -1);
//		Book bk3 = new Book("Network Engineering", "123120", 4, true, 7);
//		Book bk4 = new Book("PHP Developers", "123127", 1, true, 21);
		
//		DataAccessFacade.saveUser(lb3);
//		DataAccessFacade.saveUser(lb4);
//		DataAccessFacade.saveUser(lb2);
//		DataAccessFacade.saveUser(lb1);
////		
//		DataAccessFacade.saveStaff(admin);
//		DataAccessFacade.saveStaff(toBE);
//		DataAccessFacade.saveStaff(toBE2);
		
//		DataAccessFacade.saveBook(bk1);
//		DataAccessFacade.saveBook(bk2);
//		DataAccessFacade.saveBook(bk3);
//		DataAccessFacade.saveBook(bk4);
////		
//		List<LibraryMember> lm = DataAccessFacade.readUser();
//		System.out.println(lm.get(0).toString());
		
//admin.login("girnsfs", "abebebeso");
//		System.out.println(toBE.addNewBook("title", "ISBN", 3, true, 5));
//		Book book = toBE.getBook("ISBN");
//		
//		System.out.println(book.getNumCop());
		
		List<CheckoutRecordEntry> c = DataAccessFacade.readEntry();
		for(CheckoutRecordEntry cc: c) {
			System.out.println(cc.getMember().getFirstName());
			System.out.println(cc.getBook().getTitle());
		}
		//System.out.println(LocalDate.now());

	}
	

}
