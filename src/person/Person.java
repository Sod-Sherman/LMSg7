package person;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5872406381882033828L;
	private int memberId = 0;
	private String firstName;
	private String lastName;
	private Address address;
	
	Person(String firstName, String lastName, Address address){
		this.memberId = memberId + 1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		
	}
	Person(){
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
