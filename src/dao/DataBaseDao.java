package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @program: homework
 * @Date: 2019/5/21 22:15
 * @Author: 黄文威
 * @Description: 这个类及其子类实现对数据库的增删改查操作
 */
public class DataBaseDao{
	private Connection connection;
	private PreparedStatement preparedStatement;

	public DataBaseDao(Connection connection){
		this.connection = connection;
	}
}
