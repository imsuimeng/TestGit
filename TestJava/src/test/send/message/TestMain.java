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
			cs.setString(2, "这是一条新消息111111111");
			cs.setInt(3, 4);
			cs.execute();
			System.out.println("消息已发送");
			
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
			
			System.out.println("执行完毕");
			
			Calendar c = Calendar.getInstance();
			System.out.println(c.get(Calendar.HOUR) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
		String dbURL = "jdbc:sqlserver://183.60.27.5:1433; DatabaseName=ServiceCenterNew"; // 测试库
		String userName = "ServiceCenter"; // 默认用户名
		String userPwd = "TerSerCer*"; // 密码
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
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
		String dbURL = "jdbc:sqlserver://183.60.27.12:1433; DatabaseName=Message"; // 测试库
		String userName = "point"; // 默认用户名
		String userPwd = "pt@int7Yc"; // 密码
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
