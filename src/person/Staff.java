package person;

import java.io.Serializable;
import java.util.List;

import dataaccess.DataAccessFacade;

public class Staff extends Person implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -744868448131030678L;
	private int memberId = 0;
	private String username;
	private String password;
	private Role role;
	private String firstNamef;
	private String lastNamef;

	//private DataAccessFacade member = new DataAccessFacade();
	private Staff staffMember = null;

	Staff(String firstName, String lastName, Address address, String username, String password, Role role){

		super(firstName, lastName, address);
		this.memberId = memberId + 1;
		this.username = username;
		this.password = password;
		this.role = role;

	}

	public Role isAvailable(String username, String password) {
		List<Staff> list = DataAccessFacade.readStaff();
		for(Staff staff: list) {
			if(username.equals(staff.getUsername()) && password.equals(staff.getPassword())) {
				staffMember = staff;
				return staff.getRole();

			}
		}
		return null;
	}
	public void login(String username, String password) {
		Role role = isAvailable(username, password);
		if(staffMember == null) {
			System.out.println("no user found");
			return;

		}

		switch(role) {
			case ADMIN:
				Administrator admin = (Administrator)staffMember;
				admin.openadminUI();

			case LIBRARIAN:
				Librarian librarian = (Librarian)staffMember;
				librarian.openLibraryUI();
			//case BOTH:
		}


	}
	public String getUsername() {
		return username;
	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


}
