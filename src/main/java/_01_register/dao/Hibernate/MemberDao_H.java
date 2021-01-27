package _01_register.dao.Hibernate;


import java.util.List;


import _01_register.model.Hibernate.MemberBean_H;
import _01_register.model.Hibernate.StudentBean_H;
import _01_register.model.Hibernate.TrainerBean_H;
import model.Hibernate.GymBean_H;


public interface MemberDao_H {

	
	public MemberBean_H queryStudent_H(String id);
	
	public int checkverification_H(int verification);

	public MemberBean_H checkIdPassword_H(String email, String password);	
	
	public List<StudentBean_H> listAll_H() ;
	
	public List<GymBean_H> gymList_H() ;
//	
//	void updateUnpaidOrderAmount(OrderBean ob);
//
//	public void setConnection(Connection con);

	int saveStudent_H(StudentBean_H sb);

	int saveTrainer_H(TrainerBean_H tr);

	boolean idExists_H(int type, String email);

}