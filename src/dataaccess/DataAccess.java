package dataaccess;

import java.util.List;

import person.Staff;

public interface DataAccess{
	public void saveStaff(Staff member);
	public List<Staff> readStaff();
}
