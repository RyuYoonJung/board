package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@db.coolcode.co.kr:1521/xe", "ODUNG", "1234");
		return conn;
	}
	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
//	public static Connection getConnection() throws SQLException, ClassNotFoundException {
//	HikariConfig hikariConfig = new HikariConfig();
//	hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	hikariConfig.setJdbcUrl("jdbc:oracle:thin:@np.coolcode.co.kr:1521/xe");
//	hikariConfig.setUsername("KINDER");
//	hikariConfig.setPassword("1234");
//	
////	hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xe");
////	hikariConfig.setUsername("hr");
////	hikariConfig.setPassword("1234");
//	
//	@SuppressWarnings("resource")
//	Connection conn = new HikariDataSource(hikariConfig).getConnection();
////	dataSource.close();
//	return conn;
//}
//public static void main(String[] args) throws Exception{
//	System.out.println(getConnection());
////	PreparedStatement pstmt = getConnection().prepareStatement("");
////	CallableStatement cstmt = getConnection().prepareCall("{call proc_test(?)}");
////	cstmt.setString(1, "javamail");
////	cstmt.executeUpdate();
//}
}
