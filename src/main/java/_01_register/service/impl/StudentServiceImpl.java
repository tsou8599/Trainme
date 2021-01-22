package _01_register.service.impl;



import _01_register.dao.StudentDao;
import _01_register.dao.impl.StudentDaoImpl_Jdbc;
import _01_register.model.StudentBean;
import _01_register.service.StudentService;
import _04_ShoppingCart.model.OrderBean;

public class StudentServiceImpl implements StudentService {

	StudentDao  dao ;
	public StudentServiceImpl() {
		this.dao = new StudentDaoImpl_Jdbc();
	}

	@Override
	public int saveStudent(StudentBean sb) {
		return dao.saveStudent(sb);
	}

	@Override
	public boolean idExists(String id) {
		return dao.idExists(id);
	}

//	@Override
//	public void updateUnpaidOrderAmount(OrderBean ob) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public StudentBean queryMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean checkIdPassword(String email, String password) {
		return dao.checkIdPassword(email , password);
		
	}

//	@Override
//	public StudentBean queryMember(String id) {
//		return dao.queryMember(id);
//	}
//
//	@Override
//	public void updateUnpaidOrderAmount(OrderBean ob) {
//		dao.updateUnpaidOrderAmount(ob);
//	}
//	public StudentBean checkIdPassword(String userId, String password) {
//		StudentBean mb = dao.checkIdPassword(userId, password);
//		return mb;
//	}
}
