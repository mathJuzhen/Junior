package dao;

import DatabaseAccess.DatabaseAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: homework
 * @Date: 2019/5/23 10:31
 * @Author: 黄文威
 * @Description: 注册实现类
 */
public class RegisteredDAO{
	public boolean isRegistered(String userName, String passWord, String phoneNumber, String email){
		boolean isRegistered = false;
		Connection connection = DatabaseAccess.getConnection();
		String sql = "insert into shop.user(name, password, phonenumber, email) values(?,?,?,?) ";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, passWord);
			statement.setString(3, phoneNumber);
			statement.setString(4, email);
			int i = statement.executeUpdate();
			if (i == 1)
				isRegistered = true;
			System.out.println("注册成功");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("注册失败");
		}
		return isRegistered;
	}
}