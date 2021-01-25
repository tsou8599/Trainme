﻿package _01_register.model;

import java.sql.Date;

public class StudentBean extends MemberBean  {
	private static final long serialVersionUID = 1L;


	Integer stNo;
	Integer type;
	String name;
	String phone;
	String email;
	Date birth;
	String password;
	String id;
	String sex;
	Integer verification;
	Integer is_delete;
	
	
	public StudentBean(Integer stNo, Integer type, String name, String phone, String email, Date birth, String password,
			String id, String sex, Integer verification, Integer is_delete) {
		super();
		this.stNo = stNo;
		this.type = type;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.id = id;
		this.sex = sex;
		this.verification = verification;
		this.is_delete = is_delete;
	}
	
	public StudentBean() {
		
	}


	public Integer getStNo() {
		return stNo;
	}


	public void setStNo(Integer stNo) {
		this.stNo = stNo;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Integer getVerification() {
		return verification;
	}


	public void setVerification(Integer verification) {
		this.verification = verification;
	}


	public Integer getIs_delete() {
		return is_delete;
	}


	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}
	
	
	
	

	

}