package _01_register.dao;


import _01_register.model.StudentBean;

public interface StudentDao {
	
	public boolean idExists(String id);

	public int saveStudent(StudentBean mb) ;
	
	public StudentBean queryMember(String id);
	

	public StudentBean checkIdPassword(String email, String password);	
//	
//	void updateUnpaidOrderAmount(OrderBean ob);
//
//	public void setConnection(Connection con);
}