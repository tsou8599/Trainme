package _01_register.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import _01_register.dao.StudentDao;
import _01_register.model.StudentBean;
// 本類別使用為標準的JDBC技術來存取資料庫。
public class StudentDaoImpl_Jdbc implements StudentDao {

	private DataSource ds = null;
	private Connection conn = null;
	public StudentDaoImpl_Jdbc() {
		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	public int saveStudent(StudentBean sb) {
		String sql = "insert into student " 
				+ " (st_id, st_name, st_phone, st_birthday, "
				+ " st_email,  st_password, st_id_number, st_sex)" 
				+ " values (null, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getPhone());
			ps.setDate(3, sb.getBirth());
			ps.setString(4, sb.getEmail());
			ps.setString(5, sb.getPassword());
			ps.setString(6, sb.getId());
			ps.setString(7, sb.getSex());
			
			
			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("StudentDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists(String email) {
		boolean exist = false;
		String sql = "SELECT * FROM student WHERE st_email = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("StudentDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		return exist;
	}

	

	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public StudentBean queryMember(String id) {
		StudentBean sb = null;
		String sql = "SELECT * FROM Member WHERE st_id = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					sb = new StudentBean();
					sb.setStNo(rs.getInt("st_id"));
					sb.setType(rs.getInt("target_type"));
					sb.setName(rs.getString("st_name"));
					sb.setPhone(rs.getString("st_phone"));
					sb.setBirth(rs.getDate("st_birthday"));
					sb.setEmail(rs.getString("st_email"));
					sb.setPassword(rs.getString("st_password"));
					sb.setId(rs.getString("st_id_number"));
					sb.setSex(rs.getString("st_sex"));
					
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		return sb;
	}
//	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
//	// 否則傳回 null。
	@Override
	public StudentBean checkIdPassword(String email, String password) {
		StudentBean sb = null;
		String sql = "SELECT * FROM Student s WHERE s.st_email = ? and s.st_password = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, email);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					sb = new StudentBean();
					sb.setStNo(rs.getInt("st_id"));
					sb.setName(rs.getString("st_name"));
					sb.setPhone(rs.getString("st_phone"));
					sb.setBirth(rs.getDate("st_birthday"));
					sb.setEmail(rs.getString("st_email"));
					sb.setPassword(rs.getString("st_password"));
					sb.setId(rs.getString("st_id_number"));
					sb.setSex(rs.getString("st_sex"));
					
					
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		return sb;
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
