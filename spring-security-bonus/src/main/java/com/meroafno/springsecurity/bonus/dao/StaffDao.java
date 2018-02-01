package com.meroafno.springsecurity.bonus.dao;

import java.util.List;

import com.meroafno.springsecurity.bonus.entity.*;

public interface StaffDao {
	public List<Staff> getStaffs();

	public void saveOrModify(Staff s);

	public void deleteStaff(int id);

	public Staff getStaff(int id);

	public List<Staff> searchStaff(String theName);

}
