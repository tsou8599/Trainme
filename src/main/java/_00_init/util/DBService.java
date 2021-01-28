package _00_init.util;

public class DBService {
	public  static final String host = "127.0.0.1";
	public  static final String DB_MYSQL = "MYSQL";


	public  static final String DB_TYPE = DB_MYSQL;


	public  static final String nameMy = "java:comp/env/jdbc/BookDataMySQL";
	
	public  static String JNDI_DB_NAME = nameMy;
	
	static {
		if (JNDI_DB_NAME.equals(DB_MYSQL)) {
			JNDI_DB_NAME = nameMy;
		} 
	}
	
	private static final String DBURL_MySQL = "jdbc:mysql://" + host
			+ "/trainme?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei";
	public static final String USERID_MySQL = "root";
	public static final String PSWD_MySQL = "root";

	
	

	

	public static String getDbUrl() {
		String url = null;
		if (DB_TYPE.equalsIgnoreCase(DB_MYSQL)) {
			url = DBURL_MySQL;
		}
		System.out.println("url=" + url);
		return url;
	}

	public static String getUser() {
		String user = null;
		if (DB_TYPE.equalsIgnoreCase(DB_MYSQL)) {
			user = USERID_MySQL;
		} 
		return user;
	}

	public static String getPassword() {
		String pswd = null;
		if (DB_TYPE.equalsIgnoreCase(DB_MYSQL)) {
			pswd = PSWD_MySQL;
		} 
		return pswd;
	}

}
