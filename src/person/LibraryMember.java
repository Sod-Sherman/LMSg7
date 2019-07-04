package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class LibraryMember extends Person implements Serializable {
	public LibraryMember(String firstName, String lastName, Address address, String membId) {
		super(firstName, lastName, address);
		this.membId = membId;
	}


	private String membId;
	private List<CheckoutRecordEntry> checkOutRecords;
	
	public List<CheckoutRecordEntry> getCheckOutRecords() {
		return checkOutRecords;
	}
	public void setCheckOutRecords(List<CheckoutRecordEntry> checkOutRecords) {
		this.checkOutRecords = checkOutRecords;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
	public List<CheckoutRecordEntry> entryRecord(int memberId){
		return null;
	}
	
	
	private static final long serialVersionUID = -2226197306790714013L;

	public String getMembId() {
		return membId;
	}
	@Override
	public String toString() {
		return "FirstName: " + this.getFirstName() + ", LastName: " + getLastName() + ", ID: " + getMembId();
	}
	
}
