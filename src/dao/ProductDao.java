package dao;

import DatabaseAccess.DatabaseAccess;
import bean.Product;
import bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/23 10:37
 * @Author: 黄文威
 * @Description: 产品操作类，本来还应该有一个购物车操作类，但我忘了，购物车操作也在这个类里写完算了
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
	public ArrayList<Product> findSomeProduct(String sq){
		ArrayList<Product> products = new ArrayList<>();
		Connection connection = DatabaseAccess.getConnection();
		try {
			Product product = new Product();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sq);
			products = product.tableToClass(resultSet);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return products;
	}

	//将商品加入购物车
	public void insertShopCart(User user, Product product){
		Connection connection = DatabaseAccess.getConnection();
		String sql = "insert into shop.shoppingcart values(" + user.getId() + "," + product.getId() + ")";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//将商品从购物车中移除
	public void removeShopCart(User user, Product product){
		Connection connection = DatabaseAccess.getConnection();
		String sql = "delete from shop.shoppingcart where productID = " + product.getId() + " AND userID =" + user.getId();
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//清空购物车
	public void emptyShopCart(User user){
		Connection connection = DatabaseAccess.getConnection();
		String sql = "delete from shop.shoppingcart where  userID =" + user.getId();
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}