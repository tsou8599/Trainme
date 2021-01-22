package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author ali82
 *
 */
public class StudentBean implements Serializable {
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
	
	public StudentBean(Integer stNo, String name, String phone, Date birth, String email,  String password,
			String id, String sex) {
		super();
		this.stNo = stNo;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.id = id;
		this.sex = sex;
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

}