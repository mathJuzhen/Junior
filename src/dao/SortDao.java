package dao;

import DatabaseAccess.DatabaseAccess;
import bean.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/25 0:45
 * @Author: 黄文威
 * @Description: 排序实现类
 */
public class SortDao{
	//排序
	public ArrayList<Product> Sort(String howToSort){
		Connection connection = DatabaseAccess.getConnection();
		ArrayList<Product> products = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from shop.product order by " + howToSort;
			ResultSet resultSet = statement.executeQuery(sql);
			Product product = new Product();
			products = product.tableToClass(resultSet);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
