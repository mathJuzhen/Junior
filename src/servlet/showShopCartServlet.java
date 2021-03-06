package servlet;

import bean.Product;
import bean.ShopCart;
import bean.User;
import dao.ProductDao;

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
 * @Date: 2019/5/26 16:55
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "showShopCartServlet", urlPatterns = {"/showShopCartServlet"})
public class showShopCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		ShopCart shopCart = (ShopCart) session.getAttribute("shopCart");
		ProductDao dao = new ProductDao();
		ArrayList<Product> products = dao.showShopCart(shopCart);
		products = dao.getAmount(user, products);
		Double totalPrice = dao.totalPrice(products);
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("shopCart", products);
		req.getRequestDispatcher("showShopCart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}
}
