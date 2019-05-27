package test;

import DatabaseAccess.DatabaseAccess;

import java.sql.Connection;

/**
 * @program: homework
 * @Date: 2019/5/27 8:55
 * @Author: 黄文威
 * @Description:
 */
public class DataAccessTest{
	public static void main(String[] args){
		Connection connection = DatabaseAccess.getConnection();
		if (connection != null) {
			System.out.println("连接成功");
		}
	}
}
