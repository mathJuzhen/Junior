package bean;

import DatabaseAccess.DatabaseAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/21 22:29
 * @Author: 黄文威
 * @Description: 产品实体类
 */
public class Product implements TableToClass{
	private int Id;
	private int relation;
	private String name;
	private Double price;
	private int volume;
	private String imagpath;
	private String brand;
	private String type;

	public String getBrand(){
		return brand;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public Product(int id, int relation, String name, Double price, int volume, String imagpath){
		Id = id;
		this.relation = relation;
		this.name = name;
		this.price = price;
		this.volume = volume;
		this.imagpath = imagpath;
	}

	public Product(){
	}

	public Product(int id){
		Id = id;
		Connection connection = DatabaseAccess.getConnection();
		String sql = "select * from shop.product where id = " + Id;
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				this.setImagpath(resultSet.getString("imagpath"));
				this.setRelation(resultSet.getInt("relation"));
				this.setVolume(resultSet.getInt("volume"));
				this.setPrice(resultSet.getDouble("price"));
				this.setName(resultSet.getString("name"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId(){
		return Id;
	}

	public void setId(int id){
		Id = id;
	}

	public int getRelation(){
		return relation;
	}

	public void setRelation(int relation){
		this.relation = relation;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Double getPrice(){
		return price;
	}

	public void setPrice(Double price){
		this.price = price;
	}

	public int getVolume(){
		return volume;
	}

	public void setVolume(int volume){
		this.volume = volume;
	}

	public String getImagpath(){
		return imagpath;
	}

	public void setImagpath(String imagpath){
		this.imagpath = imagpath;
	}

	@Override
	public ArrayList<Product> tableToClass(ResultSet resultSet){
		ArrayList<Product> productItems = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setVolume(resultSet.getInt("volume"));
				product.setRelation(resultSet.getInt("relation"));
				product.setImagpath(resultSet.getString("imagpath"));
				productItems.add(product);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return productItems;
	}

	public ArrayList<Product> tableToClassWithRelation(ResultSet resultSet){
		ArrayList<Product> productItems = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setVolume(resultSet.getInt("volume"));
				product.setRelation(resultSet.getInt("relation"));
				product.setImagpath(resultSet.getString("imagpath"));
				product.setBrand(resultSet.getString("brand"));
				product.setType(resultSet.getString("type"));
				productItems.add(product);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return productItems;
	}
}
