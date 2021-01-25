package _02_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Text {

	public static void main(String[] args) {
		DataSource ds = null;
		Connection conn = null;
		int verification;
			String sql = "SELECT verification FROM gym WHERE id = ?";
			try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);)
			{
				ps.setInt(1, 1);
				
				try (ResultSet rs = ps.executeQuery();) {
					while (rs.next()) {
						
						verification = rs.getInt("verification");

						System.out.println(verification);
					}
				}
				
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		

	}

}
