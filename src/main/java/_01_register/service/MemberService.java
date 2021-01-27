package _01_register.service;

import java.util.List;

import _01_register.model.MemberBean;
import _01_register.model.StudentBean;
import _01_register.model.TrainerBean;
import model.GymBean;


public interface MemberService {
	boolean idExists(String email);
	int checkverification(int gymId);
	int saveStudent(StudentBean sb);
	int saveTrainer(TrainerBean tr);
//	void updateUnpaidOrderAmount(OrderBean ob);
	MemberBean queryMember(String id);
	MemberBean checkIdPassword(String email, String password) ;
	
	List<StudentBean> listAll();
	List<GymBean> gymList();
	
}
