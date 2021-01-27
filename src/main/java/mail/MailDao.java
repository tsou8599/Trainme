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
    
    
    public int changeVerification(String type , String email , String hash) {
    	String MemType = "";
    	int typeInt = Integer.parseInt(type);
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
	
	
}
