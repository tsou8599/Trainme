package _01_register.service.Hibernate;

import java.util.List;


import _01_register.model.Hibernate.MemberBean_H;
import _01_register.model.Hibernate.StudentBean_H;
import _01_register.model.Hibernate.TrainerBean_H;
import model.Hibernate.GymBean_H;


public interface MemberService_H {
	boolean idExists_H(int type,String email);
	int checkverification_H(int gymId);
	int saveStudent_H(StudentBean_H sb);
	int saveTrainer_H(TrainerBean_H tr);
//	void updateUnpaidOrderAmount(OrderBean ob);

	MemberBean_H queryStudent_H(String id);
	MemberBean_H checkIdPassword_H(String email, String password) ;
	
	List<StudentBean_H> listAll_H();
	List<GymBean_H> gymList_H();

	
}
