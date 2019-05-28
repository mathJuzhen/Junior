package dao;

import bean.Product;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @program: homework
 * @Date: 2019/5/25 0:45
 * @Author: 黄文威
 * @Description: 排序实现类
 */
public class SortDao{
	//排序
	public ArrayList<Product> Sort(ArrayList<Product> products, String howToSort){
		if (howToSort.equals("volume")) {
			products.sort(Comparator.comparingInt(Product::getVolume));
		}else if (howToSort.equals("price")) {
			products.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
		}else products.sort(Comparator.comparingInt(Product::getId));
		return products;
	}
}
