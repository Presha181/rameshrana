package com.meroafno.springsecurity.bonus.service;

import java.util.List;

import com.meroafno.springsecurity.bonus.entity.*;

public interface StaffServices {

	public List<Staff> getStaffList();

	//public void saveOrModify(Staff s);

	public void saveStaff(Staff theStaff);

	public void deleteStaff(int id);

	public Staff getStaff(int id);

	public List<Staff> searchStaff(String theName);
}
