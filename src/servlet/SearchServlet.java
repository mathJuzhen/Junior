package servlet;

import bean.Product;
import dao.ProductDao;
import dao.SearchDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/26 16:28
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String key = req.getParameter("key");
		SearchDao dao = new SearchDao();
		ArrayList<Product> products = new ProductDao().findSomeProduct(dao.search(key));
		HttpSession session = req.getSession();
		session.setAttribute("Products", products);
		req.setAttribute("Products", products);
		req.getRequestDispatcher("showProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
