package model;

public class GymBean {
	Integer id;
	String name;
	String address;
	String phone;
	Integer verification; //≈Á√“ΩX
	
	public GymBean(Integer id, String name, String address, String phone, Integer verification) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.verification = verification;
	}
	
	public GymBean() {
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getVerification() {
		return verification;
	}

	public void setVerification(Integer verification) {
		this.verification = verification;
	}
	
	
	
	
}
