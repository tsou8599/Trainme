package _01_register.dao;


import java.util.List;

import _01_register.model.MemberBean;
import _01_register.model.StudentBean;
import _01_register.model.TrainerBean;
import _01_register.model.Hibernate.MemberBean_H;
import _01_register.model.Hibernate.TrainerBean_H;
import model.GymBean;


public interface MemberDao {
	
	public boolean idExists(String email);

	public int saveStudent(StudentBean mb) ;
	
	public int saveTrainer(TrainerBean tr) ;
	
	
	
	public MemberBean queryStudent(String id);
	
	public int checkverification(int verification);

	public MemberBean checkIdPassword(String email, String password);	
	

	
	public List<StudentBean> listAll() ;
	
	public List<GymBean> gymList() ;
//	
//	void updateUnpaidOrderAmount(OrderBean ob);
//
//	public void setConnection(Connection con);

}