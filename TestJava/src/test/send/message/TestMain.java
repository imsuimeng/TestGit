package test.send.message;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;

public class TestMain {
	
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cs = null;
		
		//prServiceMgr_GetNewArticleModel
//        proc.registerOutParameter(1,java.sql.Types.INTEGER);
//		CustomServiceDB_JNDI
//        proc.setInt(2, articleId);
		
		/*try {
			conn = getConnection();
			cs = conn.prepareCall("{call prMsg_AddUserMessage(?,?,?)}");
			cs.setInt(1, 94262);
			cs.setString(2, "����һ������Ϣ111111111");
			cs.setInt(3, 4);
			cs.execute();
			System.out.println("��Ϣ�ѷ���");
			
			Calendar c = Calendar.getInstance();
			System.out.println(c.get(Calendar.HOUR) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND));
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		ResultSet rs = null;
		try {
			conn = getConnection();
			cs = conn.prepareCall("{? = call prServiceMgr_GetNewArticleModel(?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, 48);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				System.out.println("1111111111");
			}
			
			System.out.println("ִ�����");
			
			Calendar c = Calendar.getInstance();
			System.out.println(c.get(Calendar.HOUR) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����
		String dbURL = "jdbc:sqlserver://183.60.27.5:1433; DatabaseName=ServiceCenterNew"; // ���Կ�
		String userName = "ServiceCenter"; // Ĭ���û���
		String userPwd = "TerSerCer*"; // ����
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("OK!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		/*
		Connection conn = null;
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����
		String dbURL = "jdbc:sqlserver://183.60.27.12:1433; DatabaseName=Message"; // ���Կ�
		String userName = "point"; // Ĭ���û���
		String userPwd = "pt@int7Yc"; // ����
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("OK!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;*/
	}

}
