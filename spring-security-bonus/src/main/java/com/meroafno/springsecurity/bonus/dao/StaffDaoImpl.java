package com.meroafno.springsecurity.bonus.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meroafno.springsecurity.bonus.entity.*;


@Repository
public class StaffDaoImpl implements StaffDao {

	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	@Override
	public List<Staff> getStaffs() {
		Session session=sessionFactory.getCurrentSession();
		
		/*Query<Staff> query=session.createQuery("from Staff",Staff.class);
		List<Staff> staffs=query.getResultList();
		return staffs;
		*/
		//create a query
				Query<Staff> theQuery=
						session.createQuery("from Staff", Staff.class);//in "from Customer" Customer is a class not a table name..
						System.out.println("hellooooooooooooo..............");
				//execute query and get result list
				List<Staff> staffs=theQuery.getResultList();
				
				//return the result
				return staffs;
	}


	@Override
	public void saveOrModify(Staff myStaff) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(myStaff);
		
	}


	@Override
	public void deleteStaff(int id) {
		Session session=sessionFactory.getCurrentSession();
		Staff staff=session.get(Staff.class, id);
		session.delete(staff);
		
	}


	@Override
	public Staff getStaff(int id) {
		Session session=sessionFactory.getCurrentSession();
		Staff staff=session.get(Staff.class,id);
		return staff;
	}


	@Override
	public List<Staff> searchStaff(String theName) {
		Session session=sessionFactory.getCurrentSession();
		 Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theName != null && theName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =session.createQuery("from Staff where lower(firstName) like :theName or lower(lastName) like :theName", Staff.class);
	            theQuery.setParameter("theName", "%" + theName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =session.createQuery("from Staff", Staff.class);            
	        }
	        
	        // execute query and get result list
	        List<Staff> staffs = theQuery.getResultList();
	                
	        // return the results        
	        return staffs;
	        
	}

}
