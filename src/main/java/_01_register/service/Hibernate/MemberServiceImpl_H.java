package _01_register.service.Hibernate;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtils;
import _01_register.dao.Hibernate.MemberDaoImpl_H;
import _01_register.model.Hibernate.MemberBean_H;
import _01_register.model.Hibernate.StudentBean_H;
import _01_register.model.Hibernate.TrainerBean_H;
import model.GymBean;
import model.Hibernate.GymBean_H;

public class MemberServiceImpl_H implements MemberService_H {
	
	SessionFactory factory;
	MemberDaoImpl_H dao;

	public MemberServiceImpl_H() {
		this.dao = new MemberDaoImpl_H();
		factory = HibernateUtils.getSessionFactory();
	}


	@Override
	public int saveStudent_H(StudentBean_H sb) {
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			n = dao.saveStudent_H(sb);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return n;
	}
	
	@Override
	public int saveTrainer_H(TrainerBean_H tr) {
		
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			n = dao.saveTrainer_H(tr);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public boolean idExists_H(int type,String email) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			exist = dao.idExists_H(type,email);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return exist;
	
	}

//	@Override
//	public void updateUnpaidOrderAmount(OrderBean ob) {
//		// TODO Auto-generated method stub
//		
//	}



	@Override
	public MemberBean_H checkIdPassword_H(String email, String password) {
		MemberBean_H mb = null;

		Session session = factory.getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			mb = dao.checkIdPassword_H(email, password);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return mb;
	}
		
	

	@Override
	public List<StudentBean_H> listAll_H() {
		
		return dao.listAll_H();
	}

	@Override
	public List<GymBean_H> gymList_H() {
		
		return dao.gymList_H();
	}

	@Override
	public int checkverification_H(int gymId) {
		
		return dao.checkverification_H(gymId);
	}


	@Override
	public MemberBean_H queryStudent_H(String id) {
		// TODO Auto-generated method stub
		return null;
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
