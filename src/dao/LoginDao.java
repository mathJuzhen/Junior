package dao;

import DatabaseAccess.DatabaseAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: homework
 * @Date: 2019/5/23 10:30
 * @Author: 黄文威
 * @Description: 登录实现类
 */
public class LoginDao{
	public Boolean login(String userName, String passWord){
		boolean isLogin = false;
		Connection connection = DatabaseAccess.getConnection();
		String sql = "SELECT * from  shop.user where name =? and password = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, passWord);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				isLogin = true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return isLogin;
	}

}