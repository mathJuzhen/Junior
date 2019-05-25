package bean;

import dao.ProductDao;

import java.sql.ResultSet;
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

	public ShopCart(HashMap<Integer,Product> shopcat){
		this.shopcat = shopcat;
	}

	public ShopCart(){
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	//将产品加入购物车
	public void add(int pID){
		Product product = new Product(pID);
		this.shopcat.put(pID, product);
		ProductDao productDao = new ProductDao();
		productDao.insertShopCart(this.user, product);
	}

	//将商品从购物车移除
	public void remove(int pID){
		Product product = new Product(pID);
		this.shopcat.remove(pID, product);
		ProductDao productDao = new ProductDao();
		productDao.removeShopCart(this.user, product);
	}

	//清除购物车
	public void empty(){
		this.shopcat.clear();
		ProductDao productDao = new ProductDao();
		productDao.emptyShopCart(this.user);
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
		ArrayList<Product> products;
		Product product = new Product();
		products = product.tableToClass(resultSet);
		for (Product product1 : products) {
			this.shopcat.put(product1.getId(), product1);
		}
		return this;
	}
}
