package test;

import bean.Product;
import dao.ProductDao;
import dao.SearchDao;

/**
 * @program: homework
 * @Date: 2019/5/26 21:08
 * @Author: 黄文威
 * @Description:
 */
public class SearchTest{
	public static void main(String[] args){
		SearchDao dao = new SearchDao();
		String search = "Max";
		for (Product product : new ProductDao().findSomeProduct(dao.search(search))) {
			System.out.println(product.getName());
		}
	}
}
