package _01_register.model.Hibernate;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Hibernate.Area;
import model.Hibernate.City;

@Entity
@Table(name="StudentBean_H")
public class StudentBean_H extends MemberBean_H {
	private static final long serialVersionUID = 1L;
	
//-----會員資料--------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(columnDefinition = "INT Default 1")
	Integer type;
	String name;
	String phone;
	String email;  
	Date birth;
	String password;
	String id_number;
	String sex;
	@Column(columnDefinition = "INT Default 0")
	Integer verification;
	
	
	
//-----個人資料--------
	@ManyToOne
	@JoinColumn(name="FK_City_Id")
	City city;
	@ManyToOne
	@JoinColumn(name="FK_Area_Id")
	Area area;
	String address;
	Double heigth;
	Double weight;
	String photo;
	String nickname;
	@Column(columnDefinition = "INT Default 0")
	Integer is_delete;
	
	
	
	
	public StudentBean_H(Integer id, Integer type, String name, String phone, String email, Date birth, String password,
			String id_number, String sex, Integer verification) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.id_number = id_number;
		this.sex = sex;
		this.verification = verification;
	}

	public StudentBean_H() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getHeigth() {
		return heigth;
	}

	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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