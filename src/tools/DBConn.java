package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * 数据库连接类
 * @author Administrator
 *
 */

public class DBConn {
	
	private  static final String url =  "jdbc:mysql://localhost:3306/myvideos?useUnicode=true&characterEncoding=UTF-8";
	private  static final String driverClass = "com.mysql.jdbc.Driver";	//数据库驱动
	private static 	final String username ="root";   	//数据库用户名
	private static 	final String password ="123"; 	//数据库密码
	static Connection conn =null;
	
	//静态代码块加载数据库驱动
	
	static {
		try {
			Class.forName(driverClass);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 单例模式，获取数据库连接
	 */
	public static Connection getConnection() {
		
		 try {
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	/*public static void  main(String[] args) {
		
		getConnection();
	}*/

}
