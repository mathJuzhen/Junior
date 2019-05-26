package test;

import bean.Product;
import dao.SortDao;

/**
 * @program: homework
 * @Date: 2019/5/26 21:00
 * @Author: 黄文威
 * @Description:
 */
public class SortTest{
	public static void main(String[] args){
		SortDao dao = new SortDao();
		String sort = "volume";
		for (Product product : dao.Sort(sort)) {
			System.out.println(product.getName());
		}
	}
}
