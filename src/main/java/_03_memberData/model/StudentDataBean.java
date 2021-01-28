package _03_memberData.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * @author ali82
 *
 */
public class StudentDataBean implements Serializable {
	private static final long serialVersionUID = 1L;

	Integer area_id;
	String address;
	Double heigth;
	Double weight;
	String photo;
	String nickname;
	Integer is_delete;

	public StudentDataBean(Integer area_id, String address, Double heigth, Double weight, String photo, String nickname,
			Integer is_delete) {
		super();
		this.area_id = area_id;
		this.address = address;
		this.heigth = heigth;
		this.weight = weight;
		this.photo = photo;
		this.nickname = nickname;
		this.is_delete = is_delete;

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