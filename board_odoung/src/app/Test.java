package app;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConn;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		CallableStatement cstmt = DBConn.getConnection().prepareCall("{call getdate}");
		ResultSet rs = DBConn.getConnection().prepareStatement("SELECT GETDATE FROM DUAL").executeQuery();
		rs.next();
		System.out.println(rs.getString(1));
		
	}
}
