package dao;

import DatabaseAccess.DatabaseAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: homework
 * @Date: 2019/5/25 0:20
 * @Author: 黄文威
 * @Description: 搜索实现类
 */
public class SearchDao{

	public ResultSet search(String key){
		String sql = "SELECT * from shop.product where name like '%" + key + "%'";
		Connection connection = DatabaseAccess.getConnection();
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
