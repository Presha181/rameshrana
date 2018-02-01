package com.meroafno.springsecurity.bonus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {
/*
 * STEPS
 * 1. DEFINE FIELDS FOR ENTITY CLASS
 * 2. CREATE A CONSTRUCTOR
 * 3. GENERATE GETTERS AND SETTERS
 * 4. GENERATE TOSTRING() METHOD
 * 5. ANNOTATE FIELD WITH DATABASE FIELD
 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="home_phone")
	private String homePhone;
	
	@Column(name="cell_phone")
	private String cellPhone;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	public Staff() {
		
	}

	public Staff(String homePhone, String cellPhone, String firstName, String lastName, String email) {
	
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", homePhone=" + homePhone + ", cellPhone=" + cellPhone + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

	
	
	
}
