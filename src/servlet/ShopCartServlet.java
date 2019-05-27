package servlet;

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

/**
 * @program: homework
 * @Date: 2019/5/26 17:13
 * @Author: 黄文威
 * @Description:
 */
@WebServlet(name = "ShopCartServlet", urlPatterns = {"/ShopCartServlet"})
public class ShopCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset = utf-8");
		String toDO = req.getParameter("toDo");
		if (toDO.equals("add"))
			addShopCart(req, resp);
		else if (toDO.equals("remove"))
			removeShopCart(req, resp);
		else emptyShopCart(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doGet(req, resp);
	}

	private void addShopCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		int pID = Integer.valueOf(req.getParameter("pid"));
		ProductDao dao = new ProductDao();
		dao.insertShopCart(user, pID);
		ShopCart shopCart = new ShopCart(user);
		session.setAttribute("shopCart", shopCart);
		req.getRequestDispatcher("findAllProductServlet").forward(req, resp);
	}

	private void removeShopCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		int pID = Integer.valueOf(req.getParameter("pid"));
		ProductDao dao = new ProductDao();
		dao.removeShopCart(user, pID);
		ShopCart shopCart = new ShopCart(user);
		session.setAttribute("shopCart", shopCart);
		req.getRequestDispatcher("showShopCartServlet").forward(req, resp);
	}

	private void emptyShopCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String dhtml;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		ProductDao dao = new ProductDao();
		dao.emptyShopCart(user);
		ShopCart shopCart = new ShopCart(user);
		session.setAttribute("shopCart", shopCart);
		req.getRequestDispatcher("showShopCartServlet").forward(req, resp);

	}
}
