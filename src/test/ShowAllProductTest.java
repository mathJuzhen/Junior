package test;

import bean.Product;
import dao.ProductDao;

import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/26 20:52
 * @Author: 黄文威
 * @Description:
 */
public class ShowAllProductTest{
	public static void main(String[] args){
		ProductDao dao = new ProductDao();
		ArrayList<Product> products = dao.findAllProduct();
		for (Product product : products) {
			System.out.println(product.getName());
		}
	}
}
