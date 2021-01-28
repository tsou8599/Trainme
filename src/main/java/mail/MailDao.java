package mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;

public class MailDao {

	private DataSource ds = null;
	

    public MailDao() {
    	System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
    
    // 更改驗證狀態碼
    public int changeVerification(String type , String email , String hash) {
    	String MemType = "";
    	int typeInt = Integer.parseInt(type);
    	// 判斷會員類型
    	if(typeInt == 1) {
    		 MemType = "student";
		}
		if(typeInt == 2) {
			 MemType = "trainer";
			
		}
		
    	String sql1 = "select email, Hash, verification from " + MemType + " where Email=? and Hash=? and verification='0'";
    	int i = 0;
    	try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql1);) {
    		
    		ps.setString(1, email);
			ps.setString(2, hash);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			
				String sql2 = "update " + MemType + " set verification='1' where Email=? and Hash=?";
				try (Connection con2 = ds.getConnection(); PreparedStatement ps2 = con.prepareStatement(sql2);){
					ps2.setString(1, email);
					ps2.setString(2, hash);
					
					i = ps2.executeUpdate();
					
					return i;
				}	
			}	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return i;
 
	}
    
    // 檢查是否通過信箱驗證
    public boolean checkPass(int type , String email ) {
    	boolean pass = false;
    	
    	String MemType = "";
//    	
    	
    	if(type == 1) {
    		 MemType = "student";
		}
		if(type == 2) {
			 MemType = "trainer";
		}
		
    	String sql1 = "select verification from " + MemType + " where Email=? ";
    	int i = 0;
    	try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql1);) {
    		
    		ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt("verification");
			}
			if(i == 1) {
		
				pass = true;
			}
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return pass;
    }
}
