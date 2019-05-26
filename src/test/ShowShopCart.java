package test;

import bean.Product;
import bean.ShopCart;
import bean.User;
import dao.ProductDao;

/**
 * @program: homework
 * @Date: 2019/5/26 20:59
 * @Author: 黄文威
 * @Description:
 */
public class ShowShopCart{
	public static void main(String[] args){
		User user = new User(1);
		ShopCart shopCart = new ShopCart(user);
		for (Product product : new ProductDao().showShopCart(shopCart)) {
			System.out.println(product.getName());
		}
	}
}
