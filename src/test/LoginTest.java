package test;

import dao.LoginDao;

/**
 * @program: homework
 * @Date: 2019/5/26 20:28
 * @Author: 黄文威
 * @Description:
 */
public class LoginTest{

	public static void main(String[] args){
		LoginDao dao = new LoginDao();
		String userName = "刘备";
		String passWord = "111";
		if (dao.login(userName, passWord)) {
			System.out.println("登录成功");
		}else System.out.println("账号密码错误");
	}
}
