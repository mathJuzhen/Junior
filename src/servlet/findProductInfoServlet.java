package servlet;

import bean.Product;
import dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: homework
 * @Date: 2019/5/28 0:05
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "showProductInfoServlet", urlPatterns = {"/showProductInfoServlet"})
public class findProductInfoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int pid = Integer.valueOf(req.getParameter("pid"));
		ProductDao dao = new ProductDao();
		Product product = dao.findProduct(pid);
		ArrayList<Product> products = dao.recommendProduct(product);
		req.setAttribute("recommend", products);
		req.setAttribute("product", product);
		req.getRequestDispatcher("showProductInfo.jsp").forward(req, resp);
	}
}
