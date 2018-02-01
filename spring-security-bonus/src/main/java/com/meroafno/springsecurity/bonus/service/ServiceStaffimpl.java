package com.meroafno.springsecurity.bonus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meroafno.springsecurity.bonus.dao.*;
import com.meroafno.springsecurity.bonus.entity.*;


@Service
public class ServiceStaffimpl implements StaffServices {

	
	@Autowired
	private StaffDao staffdao;
	
	
	@Override
	@Transactional
	public List<Staff> getStaffList() {
		return staffdao.getStaffs();
	}

	@Override
	@Transactional
	public void saveStaff(Staff s) {
		staffdao.saveOrModify(s);
		
	}

	@Override
	@Transactional
	public void deleteStaff(int id) {
		staffdao.deleteStaff(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Staff getStaff(int id) {
		Staff staff=staffdao.getStaff(id);
		return staff;
	}

	@Override
	@Transactional
	public List<Staff> searchStaff(String theName) {
		List<Staff> staffs=new ArrayList<>();
		staffs=staffdao.searchStaff(theName);
		
		return staffs;
	}

	
}
