package _03_memberData.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import model.AreaBean;
import model.CityBean;
import model.GymBean;
import model.Hibernate.City;

public class MemDataDao {
	DataSource ds = null;

	public MemDataDao() {
		
		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	

	public List<CityBean> cityList() {
		CityBean city = null;
		List<CityBean> citys = new ArrayList<CityBean>();
		String sql = "SELECT * FROM city;";

		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					city = new CityBean();
					city.setId(rs.getInt("id"));
					city.setName(rs.getString("name"));


					citys.add(city);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemDataDao類別#cityList()發生SQL例外: " + ex.getMessage());
		}
		return citys;
	}
	
	public List<AreaBean> areaList(int city_id) {
		AreaBean area = null;
		List<AreaBean> areas = new ArrayList<AreaBean>();
		String sql = "SELECT * FROM area WHERE city_id = ?;";

		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			
				ps.setInt(1, city_id);
				
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					area = new AreaBean();
					area.setId(rs.getInt("id"));
					area.setName(rs.getString("name"));
					area.setCity_id(rs.getInt("city_id"));


					areas.add(area);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemDataDao類別#areaList()發生SQL例外: " + ex.getMessage());
		}
		return areas;
	}
	
}
