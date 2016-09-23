package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;
import top.hittzj.service.AddCN2CollectionService;
import top.hittzj.service.GetCNService;

public class AddCN2CollectionServlet extends HttpServlet {

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
		String id = request.getParameter("CNId");
		int id_ = Integer.parseInt(id);
		GetCNService service = new GetCNService();
		Commodity_Need commodity_Need = service.get(id_);
		AddCN2CollectionService serive2 = new AddCN2CollectionService();
		boolean add = serive2.add(commodity_Need, user);
		if (add) {

		} else {
		}

	}

}
