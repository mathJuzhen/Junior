package DatabaseAccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * @program: homework
 * @Date: 2019/5/21 20:07
 * @Author: 黄文威
 * @Description:
 */
public class DatabaseAccess{
	private static String driver;
	private static String username;
	private static String url;
	private static String passWord;

	static{
		init();
	}

	private static void init(){
		Properties params = new Properties();
		String configFile = "Database.properties";
		try {
			params.load(Objects.requireNonNull(DatabaseAccess.class.getClassLoader().getResourceAsStream(configFile)));
		}catch (IOException e) {
			e.printStackTrace();
		}
		driver = params.getProperty("driver");
		username = params.getProperty("username");
		passWord = params.getProperty("passWord");
		url = params.getProperty("url");
	}

	//获取连接
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passWord);

		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
