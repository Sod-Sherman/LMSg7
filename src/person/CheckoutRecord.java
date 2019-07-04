package person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.DataAccessFacade;

public class CheckoutRecord implements Serializable {
	
	private double lateFine;
	public double getLateFine() {
		return lateFine;
	}

	public void setLateFine(double lateFine) {
		this.lateFine = lateFine;
	}

	private double paidFineDate;
	
	private static final long serialVersionUID = -3119855589946373695L;
	private Librarian member;
	//private LibraryMember lbmemeber;
	private static List<CheckoutRecordEntry> entries = new ArrayList<>();
	
	public static void addEntry(CheckoutRecordEntry c) {
		entries = DataAccessFacade.readEntry();
//		List<CheckoutRecordEntry> newTemp = new ArrayList<CheckoutRecordEntry>();
//		System.arraycopy(entries, 0, newTemp, 0, entries.size());
//		newTemp.add(c);
		entries.add(c);
		DataAccessFacade.saveEntry(entries);
	}
	
	public String toString() {
		return entries.toString();
	}

	public List<CheckoutRecordEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<CheckoutRecordEntry> entries) {
		this.entries = entries;
	}
}
