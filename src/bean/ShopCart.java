package bean;

import DatabaseAccess.DatabaseAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: homework
 * @Date: 2019/5/23 10:48
 * @Author: 黄文威
 * @Description: 购物车
 */
public class ShopCart implements TableToClass{
	private User user;
	private HashMap<Integer,Product> shopcat;//<产品id，产品>

	public ShopCart(){
		this.user = new User();
		this.shopcat = new HashMap<>();
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}


	public ShopCart(User user){
		ShopCart shopCart = null;
		Connection connection = DatabaseAccess.getConnection();
		String sql = "SELECT * from shop.product,shop.shoppingcart where userID =" + user.getId() + " and productID = product.id";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			shopCart = this.tableToClass(resultSet);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		assert shopCart != null;
		this.setShopcat(shopCart.getShopcat());
		this.setUser(user);
	}

	//计算购物车内总价格
	public double totalPrice(){
		double totalPrice = 0;
		for (Product product : shopcat.values()) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}

	@Override
	public ShopCart tableToClass(ResultSet resultSet){
		ShopCart shopCart = new ShopCart();
		ArrayList<Product> products;
		Product product = new Product();
		products = product.tableToClass(resultSet);
		for (Product product1 : products) {
			shopCart.shopcat.put(product1.getId(), product1);
		}
		return shopCart;
	}

	public HashMap<Integer,Product> getShopcat(){
		return shopcat;
	}

	public void setShopcat(HashMap<Integer,Product> shopcat){
		this.shopcat = shopcat;
	}
}
