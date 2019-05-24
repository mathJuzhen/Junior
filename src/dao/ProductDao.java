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
 * @Date: 2019/5/23 10:37
 * @Author: 黄文威
 * @Description: 产品操作类
 */
public class ProductDao{
	//查看所有商品
	public ArrayList<Product> findAllProduct(){
		ArrayList<Product> products = new ArrayList<>();
		Connection connection = DatabaseAccess.getConnection();
		String sql = "select * from shop.product";
		try {
			Product product = new Product();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			products = product.tableToClass(resultSet);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return products;
	}

	//展示部分商品
	public ArrayList<Product> findSomeProduct(String sql){
		ArrayList<Product> products = new ArrayList<>();
		Connection connection = DatabaseAccess.getConnection();
		try {
			Product product = new Product();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			products = product.tableToClass(resultSet);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return products;
	}

}