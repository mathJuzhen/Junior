package servlet;

import dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: homework
 * @Date: 2019/5/23 21:41
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset = ust-8");
		LoginDao loginDao = new LoginDao();
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("PassWord");
		Boolean islogin = loginDao.login(userName, passWord);
		String dthtml;
		if (islogin)
			dthtml = "登陆成功";
		else dthtml = "登录失败";
		resp.getWriter().print(dthtml);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
