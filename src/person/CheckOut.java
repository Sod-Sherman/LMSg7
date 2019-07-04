package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CheckOut implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 7289660468887158897L;
	public CheckOut(String isbn, String title, LocalDate checkOutDate, LocalDate dueDate, double overDue, boolean fine,
			LocalDate paiDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		this.overDue = overDue;
		this.fine = fine;
		this.paiDate = paiDate;
	}
	private String isbn;
	private String title;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private double overDue;
	private boolean fine;
	private LocalDate paiDate;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getOverDue() {
		return overDue;
	}
	public void setOverDue(double overDue) {
		this.overDue = overDue;
	}
	public boolean isFine() {
		return fine;
	}
	public void setFine(boolean fine) {
		this.fine = fine;
	}
	public LocalDate getPaiDate() {
		return paiDate;
	}
	public void setPaiDate(LocalDate paiDate) {
		this.paiDate = paiDate;
	}



}
