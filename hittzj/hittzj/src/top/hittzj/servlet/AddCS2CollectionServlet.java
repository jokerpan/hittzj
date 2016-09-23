package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;
import top.hittzj.service.AddCS2CollectionService;
import top.hittzj.service.GetCSService;

public class AddCS2CollectionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "要登录之后再发布哦~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		String id = request.getParameter("CSId");
		int id_ = Integer.parseInt(id);
		GetCSService service = new GetCSService();
		Commodity_Sell commodity_Sell = service.get(id_);
		AddCS2CollectionService serive2 = new AddCS2CollectionService();
		boolean add = serive2.add(commodity_Sell, user);
		if (add) {

		} else {
		}

	}

}
