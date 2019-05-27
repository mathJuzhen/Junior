package servlet;

import bean.ShopCart;
import bean.User;
import dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		resp.setContentType("text/html;charset = utf-8");
		LoginDao loginDao = new LoginDao();
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("PassWord");
		Boolean isLogin = loginDao.login(userName, passWord);
		String dthtml;
		if (isLogin) {
			dthtml = "登陆成功";
			HttpSession session = req.getSession(true);
			User user = new User(userName);
			ShopCart shopCart = new ShopCart(user);
			session.setAttribute("User", user);
			session.setAttribute("shopCart", shopCart);
			req.getRequestDispatcher("findAllProductServlet").forward(req, resp);
		}else dthtml = "登录失败";
		resp.getWriter().print(dthtml);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doGet(req, resp);
	}
}
