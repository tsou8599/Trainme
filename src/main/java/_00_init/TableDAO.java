package _00_init;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import _00_init.util.GlobalService;

public class TableDAO {
	
	 DataSource ds = null;
	 Connection conn = null;
	
	public TableDAO() {
		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	
	public void insertProductType(){
		String sql = "insert into city values(?)";
		int result = -1;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);
				BufferedReader br = new BufferedReader(new FileReader("\\Trainme\\data\\city.csv"));) {
			String line = "";
			int count = 0;
			while ((line = br.readLine()) != null) {
//				if (line.startsWith(UTF8)) {
//					line = line.substring(1);
//				}
				String[] segment = line.split(",");
				
			
				ps.setString(1, segment[0]); 
			

				result =  ps.executeUpdate();
				if (result == 1)
					System.out.println(segment[1] +" : " + segment[0]  + " - add success ");
				else
					System.out.println("table gets error");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	
}
