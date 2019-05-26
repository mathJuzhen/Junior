package test;

import bean.User;
import dao.ProductDao;

/**
 * @program: homework
 * @Date: 2019/5/26 22:28
 * @Author: 黄文威
 * @Description:
 */
public class EmptyShopCartTest{
	public static void main(String[] args){
		ProductDao dao = new ProductDao();
		User user = new User("张飞");
		dao.emptyShopCart(user);
	}
}
