package servlet;

import dao.RegisteredDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: homework
 * @Date: 2019/5/26 14:46
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset = utf-8");
		String userName;
		String passWord;
		String phoneNumber;
		String email;
		String dhtml;
		userName = req.getParameter("userName");
		passWord = req.getParameter("passWord");
		phoneNumber = req.getParameter("passWord");
		email = req.getParameter("email");
		RegisteredDAO dao = new RegisteredDAO();
		boolean isRegistered = dao.isRegistered(userName, passWord, phoneNumber, email);
		if (isRegistered)
			dhtml = "注册成功";
		else dhtml = "注册失败";
		resp.getWriter().print(dhtml);
	}
}
