package dao;

import DatabaseAccess.DatabaseAccess;
import bean.Product;
import bean.ShopCart;
import bean.User;

import java.sql.*;
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
		String sql = "select * from shop.product order by relation";
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
	public ArrayList<Product> findSomeProduct(ResultSet resultSet){
		ArrayList<Product> products;
		Product product = new Product();
		products = product.tableToClass(resultSet);
		return products;
	}

	//将商品加入购物车
	public void insertShopCart(User user, int pID){
		Connection connection = DatabaseAccess.getConnection();
		String sql = "insert into shop.shoppingcart values(" + user.getId() + "," + pID + ")";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//将商品从购物车中移除
	public void removeShopCart(User user, int pID){
		Connection connection = DatabaseAccess.getConnection();
		String sql = "delete from shop.shoppingcart where productID = " + pID + " AND userID =" + user.getId();
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//推荐产品
	public ArrayList<Product> recommendProduct(Product product){
		Connection connection = DatabaseAccess.getConnection();
		ArrayList<Product> products = new ArrayList<>();
		String sql = "select product.id, relation, name, price, volume, imagpath,brand,type from shop.product,shop.relation where product.relation = relation.id and product.id <>? and relation.type = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, product.getId());
			statement.setString(2, product.getType());
			ResultSet resultSet = statement.executeQuery();
			products = product.tableToClassWithRelation(resultSet);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	//找到产品信息
	public Product findProduct(int pId){
		Connection connection = DatabaseAccess.getConnection();
		String sql = "select * from shop.product,shop.relation where product.relation = relation.id and product.id = ?";
		Product product = new Product();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, pId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product.setImagpath(resultSet.getString("imagpath"));
				product.setVolume(resultSet.getInt("volume"));
				product.setPrice(resultSet.getDouble("price"));
				product.setName(resultSet.getString("name"));
				product.setBrand(resultSet.getString("brand"));
				product.setType(resultSet.getString("type"));
				product.setId(resultSet.getInt("product.id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
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

	//展示购物车
	public ArrayList<Product> showShopCart(ShopCart shopCart){
		ArrayList<Product> products = new ArrayList<>();
		for (Product product : shopCart.getShopcat().values()) {
			Product product1 = new Product();
			product1.setId(product.getId());
			product1.setName(product.getName());
			product1.setPrice(product.getPrice());
			product1.setVolume(product.getVolume());
			product1.setRelation(product.getRelation());
			product1.setImagpath(product.getImagpath());
			products.add(product1);
		}
		return products;
	}
}