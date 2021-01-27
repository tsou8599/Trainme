package _01_register.dao.Hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_init.util.DBService;
import _00_init.util.HibernateUtils;
import _01_register.model.StudentBean;
import _01_register.model.Hibernate.MemberBean_H;
import _01_register.model.Hibernate.StudentBean_H;
import _01_register.model.Hibernate.TrainerBean_H;
import model.GymBean;
import model.Hibernate.GymBean_H;

// 本類別使用為標準的JDBC技術來存取資料庫。
public class MemberDaoImpl_H implements MemberDao_H {
	
	SessionFactory factory ;
	
	public MemberDaoImpl_H() {
		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		factory = HibernateUtils.getSessionFactory();
	}

	// 儲存StudentBean物件，將參數sb新增到Student表格內。
	
	@Override
	public int saveStudent_H(StudentBean_H sb) {
		int n = 0;
		Session session = factory.getCurrentSession();
		session.save(sb);
		n++;
		return n;
	}
	
	// 儲存TrainerBean物件，將參數tr新增到Trainer表格內。
	

	@Override
	public int saveTrainer_H(TrainerBean_H tr) {
		int n = 0;
		Session session = factory.getCurrentSession();
		session.save(tr);
		n++;
		
		return n;
	}

	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，

	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists_H(int type,String email) {
		boolean exist = false;
		String hql = null;
		if(type == 1) {
			 hql = "FROM StudentBean_H  WHERE email = :memail";			
		}
		if(type == 2) {
			 hql = "FROM TrainerBean_H  WHERE email = :memail";			
		}
		Session session = factory.getCurrentSession();
		
		
            
            try {
            	
            	MemberBean_H mb = (MemberBean_H) session.createQuery(hql)
								            	    	 .setParameter("memail", email)
								            	    	 .getSingleResult();
            	if(mb != null) {
    				exist = true;
    			} 
            	
            }catch(NoResultException e) {
    			exist = false;
    		}catch(NonUniqueResultException e) {
    			exist = true;
    		}
    		return exist;
        }
		
		

	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，

	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public StudentBean_H queryStudent_H(String id) {
		StudentBean_H sb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM StudentBean_H WHERE id = :mId";
		try {
			sb = (StudentBean_H) session.createQuery(hql).setParameter("mId", id).getSingleResult();
		}catch (Exception e) {
			
		}
		
		return sb;
	}

//	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	//	// 否則傳回 null。
		@Override
	    public MemberBean_H checkIdPassword_H(String email, String password) {
	        String[] types = {"StudentBean_H", "TrainerBean_H"};
	        MemberBean_H mbh = null;
	        StudentBean_H sbh;
	        TrainerBean_H trh;
	        Session session = factory.getCurrentSession();
	        for (int i = 0; i < types.length; i++) {
	            String hql = "FROM " + types[i] + " WHERE email = :memail and password = :psw";
	           
	            	
	            	if(types.equals("StudentBean_H")){
	            		sbh =(StudentBean_H) session.createQuery(hql)
								            		.setParameter("memail", email)
								            		.setParameter("psw", password)
								            		.getResultList();
	            		return sbh;
	            		
	            	}else {
	            		trh = (TrainerBean_H) session.createQuery(hql)
			            		.setParameter("memail", email)
			            		.setParameter("psw", password)
			            		.getResultList();
	            	}
	            	
	            	return trh;  
	        }
	       
	        return mbh;
	    }
	


	@Override
	public List<StudentBean_H> listAll_H() {
		StudentBean sb = null;
		List<StudentBean_H> list = new ArrayList<StudentBean_H>();
//		String sql = "SELECT * FROM student;";
//		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
//
//			try (ResultSet rs = ps.executeQuery();) {
//				while (rs.next()) {
//					sb = new StudentBean();
//					sb.setStNo(rs.getInt("id"));
//					sb.setName(rs.getString("name"));
//					sb.setPhone(rs.getString("phone"));
//					sb.setBirth(rs.getDate("birthday"));
//					sb.setEmail(rs.getString("email"));
//					sb.setPassword(rs.getString("password"));
//					sb.setId(rs.getString("id_number"));
//					sb.setSex(rs.getString("sex"));
//					
//					list.add(sb);
//				}
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " + ex.getMessage());
//		}
		return list;
	}

	@Override
	public List<GymBean_H> gymList_H() {
		GymBean gb = null;
		List<GymBean_H> gyms = new ArrayList<GymBean_H>();
//		String sql = "SELECT * FROM gym;";
//		
//		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
//
//			try (ResultSet rs = ps.executeQuery();) {
//				while (rs.next()) {
//					gb = new GymBean();
//					gb.setId(rs.getInt("id"));
//					gb.setName(rs.getString("name"));
//					gb.setPhone(rs.getString("phone"));
//					gb.setAddress(rs.getString("address"));
//					gb.setVerification(rs.getInt("verification"));
//					
//					gyms.add(gb);
//				}
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#gymList()發生SQL例外: " + ex.getMessage());
//		}
		return gyms;
	}
//=========================================================================
	@Override
	public int checkverification_H(int gymId) {
		int verification = 0;
//		String sql = "SELECT verification FROM gym WHERE id = ?";
//		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
//			ps.setInt(1, gymId);
//			
//			try (ResultSet rs = ps.executeQuery();) {
//				while (rs.next()) {
//					
//					verification = rs.getInt("verification");
//
//				}
//			}
//			
//			
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("StudentDaoImpl_Jdbc類別#checkverification()發生例外: " + ex.getMessage());
//		}
		return verification;
	}


}
//	/*
//	 * 功能：更新客戶的未付款訂購金額。
//	 * 說明：處理客戶訂單時，[訂單的總金額 + 該客戶的未付款餘額]不能超過限額，
//	 * 此限額定義在 GlobalService類別的常數: ORDER_AMOUNT_LIMIT
//	 * 步驟：
//	 * 1. 取出Member表格內的 Member#unpaid_amount欄位(未付款餘額) 
//	 * 2. unpaid_amount加上本訂單的總金額後，檢查該數值是否超過限額
//	 *    (GlobalService.ORDER_AMOUNT_LIMIT)。 
//	 *    如果超過限額， 則
//	 *    		該訂單不予處裡， 丟出UnpaidOrderAmountExceedingException，
//	 * 	    否則更新Member表格的unpaid_amount欄位: Member#unpaid_amount += currentAmount;
//	 */
//	@Override
//	public void updateUnpaidOrderAmount(OrderBean ob) {
//		double currentAmount = ob.getTotalAmount(); // 取出該訂單的總金額
//		Double unpaidAmount = 0.0;
//		// 讀取Member表格中，該客戶的未付款金額(unpaid_amount)
//		String sql = "SELECT unpaid_amount FROM Member m WHERE m.memberId = ? ";
//		try (
//			PreparedStatement ps = conn.prepareStatement(sql);
//		) {
//			ps.setString(1, ob.getMemberId());
//			try (ResultSet rs = ps.executeQuery();) {
//				if (rs.next()) {
//					unpaidAmount = rs.getDouble(1);
//				}
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#updateUnpaidOrderAmount()發生SQL例外: " + ex.getMessage());
//		}
//        // 如果該客戶的最新未付款總額 大於 公司規定之允許未付款總額
//		if (currentAmount + unpaidAmount > GlobalService.ORDER_AMOUNT_LIMIT) {
//			throw new UnpaidOrderAmountExceedingException("未付款金額超過限額: " + (currentAmount + unpaidAmount));
//		} else {
//			;
//		}
//		// 更新Member表格之未付款餘額欄位 unpaid_amount
//		String sql1 = "UPDATE Member SET unpaid_amount = unpaid_amount + ? " 
//		            + " WHERE memberId = ?";
//		
//		try (
//			PreparedStatement ps1 = conn.prepareStatement(sql1);
//		) {
//			ps1.setDouble(1, currentAmount);
//			ps1.setString(2, ob.getMemberId());
//			ps1.executeUpdate();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#updateUnpaidOrderAmount()發生SQL例外: " + ex.getMessage());
//		}
//	}
//	
//	@Override
//	public void setConnection(Connection conn) {
//        this.conn = conn;
//	}
//}
