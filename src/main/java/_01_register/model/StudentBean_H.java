package _01_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="StudentBean_H")
public class StudentBean_H implements Serializable {
	private static final long serialVersionUID = 1L;
	
//-----會員資料--------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer stNo;
	@Column(columnDefinition = "INT Default 1")
	Integer type;
	String name;
	String phone;
	String email;
	// @Temporal只能用在java.util.Date, @Temporal(TemporalType.DATE)表示刪除時分秒，僅保留年月日。
	@Temporal(TemporalType.DATE)  
	Date birth;
	String password;
	String id;
	String sex;
//-----個人資料--------
	Integer area_id;
	String address;
	Double heigth;
	Double weight;
	String photo;
	String nickname;
	@Column(columnDefinition = "INT Default 0")
	Integer is_delete;
	
	
	public StudentBean_H(Integer stNo, String name, String phone, Date birth, String email,  String password,
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
	
	public StudentBean_H() {
	
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
	
	Integer city_id;
	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public Integer getArea_id() {
		return area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
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

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

}