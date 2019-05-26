package test;

import dao.RegisteredDAO;

/**
 * @program: homework
 * @Date: 2019/5/26 20:40
 * @Author: 黄文威
 * @Description:
 */
public class RegisterTest{
	public static void main(String[] args){
		RegisteredDAO dao = new RegisteredDAO();
		String username = "张飞";
		String password = null;
		String number = "13973879338";
		String email = "761764092@163.com";
		if (dao.isRegistered(username, password, number, email)) {
			System.out.println("注册成功");
		}else System.out.println("注册失败");
	}
}
