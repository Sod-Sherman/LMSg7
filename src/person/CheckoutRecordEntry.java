package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import dataaccess.DataAccessFacade;

public class CheckoutRecordEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3623134760191079175L;
	private Book book;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private LibraryMember member;
	
	public CheckoutRecordEntry(Book book, LibraryMember member){
		this.book = book;
		this.checkoutDate = LocalDate.now();
		this.dueDate = LocalDate.now().plusDays(book.getBorrowDayLimit());
		this.member = member;
	}

	public Book getBook() {
		return book;
	}
	public String getBookISBN() {
		return book.getIsbn();
	}
	public String getBookTitle() {
		return book.getTitle();
	}
	public long getBookOverDue() {
		return ChronoUnit.DAYS.between( LocalDate.now(),this.dueDate);
	}
	
	public boolean getIsFine() {
		
		return (getBookOverDue() < 0) ? true : false;
	}
	public String getMemberName() {
		return member.getFirstName() + " " + member.getLastName();
	}
//	public LocalDate getPaidDate() {
//		return;
//	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	

	public LibraryMember getMember() {
		return member;
	}

	public void setMember(LibraryMember member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
