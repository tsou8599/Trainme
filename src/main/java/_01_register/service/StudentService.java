package _01_register.service;

import _01_register.model.StudentBean;
import _04_ShoppingCart.model.OrderBean;

public interface StudentService {
	boolean idExists(String id);
	int saveStudent(StudentBean sb);
//	void updateUnpaidOrderAmount(OrderBean ob);
	StudentBean queryMember(String id);
	StudentBean checkIdPassword(String email, String password) ;
}
