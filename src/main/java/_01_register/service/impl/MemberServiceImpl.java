package _01_register.service.impl;



import java.util.List;

import org.hibernate.SessionFactory;

import _01_register.dao.MemberDao;
import _01_register.dao.impl.MemberDaoImpl_Jdbc;
import _01_register.model.MemberBean;
import _01_register.model.StudentBean;
import _01_register.model.TrainerBean;
import _01_register.service.MemberService;
import model.GymBean;

public class MemberServiceImpl implements MemberService {
	
	SessionFactory factory;
	MemberDao dao;

	public MemberServiceImpl() {
		this.dao = new MemberDaoImpl_Jdbc();
	}

	@Override
	public int saveStudent(StudentBean sb) {
		return dao.saveStudent(sb);
	}
	
	@Override
	public int saveTrainer(TrainerBean tr) {
		
		return dao.saveTrainer(tr);
	}

	@Override
	public boolean idExists(String email) {
		return dao.idExists(email);
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
	public MemberBean checkIdPassword(String email, String password) {
		return dao.checkIdPassword(email , password);
		
	}

	@Override
	public List<StudentBean> listAll() {
		
		return dao.listAll();
	}

	@Override
	public List<GymBean> gymList() {
		
		return dao.gymList();
	}

	@Override
	public int checkverification(int gymId) {
		
		return dao.checkverification(gymId);
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
