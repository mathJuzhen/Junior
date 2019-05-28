package test;

import bean.Product;
import dao.SortDao;

import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/26 21:00
 * @Author: 黄文威
 * @Description:
 */
public class SortTest{
	public static void main(String[] args){
		SortDao dao = new SortDao();
		ArrayList<Product> products = new ArrayList<>();
		String sort = "volume";
		for (Product product : dao.Sort(products, sort)) {
			System.out.println(product.getName());
		}
	}
}
