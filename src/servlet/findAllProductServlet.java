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
 * @Date: 2019/5/26 16:22
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "findAllProductServlet", urlPatterns = {"/findAllProductServlet"})
public class findAllProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ProductDao dao = new ProductDao();
		ArrayList<Product> allProduct = dao.findAllProduct();
		req.setAttribute("Products", allProduct);
		req.getRequestDispatcher("showProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
