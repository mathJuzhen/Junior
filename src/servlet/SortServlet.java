package servlet;

import bean.Product;
import dao.SortDao;

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
 * @Date: 2019/5/26 16:36
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "SortServlet", urlPatterns = {"/SortServlet"})
public class SortServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		SortDao dao = new SortDao();
		String howToSort = req.getParameter("key");
		HttpSession session = req.getSession();
		ArrayList<Product> products;
		products = (ArrayList<Product>) session.getAttribute("Products");
		products = dao.Sort(products, howToSort);
		req.setAttribute("Products", products);
		req.getRequestDispatcher("showProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
