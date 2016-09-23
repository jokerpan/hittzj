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
import top.hittzj.service.GetCNService;
import top.hittzj.service.RelieveCollectorCNService;
import top.hittzj.service.RelieveCollectorCSService;

public class RelieveCollectorCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "请登录");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		// 得到CN
		String id = request.getParameter("CNid");
		int id_ = Integer.parseInt(id);
		GetCNService service = new GetCNService();
		Commodity_Need commodity_Need = service.get(id_);
		RelieveCollectorCNService service2 = new RelieveCollectorCNService();
		boolean relieve = service2.relieve(commodity_Need, user);
		if (relieve) {

		} else {
		}

	}

}
