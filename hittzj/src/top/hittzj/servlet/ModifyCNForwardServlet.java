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

public class ModifyCNForwardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("CNId");
		int CNId = Integer.parseInt(id);
		GetCNService service = new GetCNService();
		Commodity_Need cn = service.get(CNId);
		if (cn == null) {
			request.setAttribute("findCNResult", "没有此商品");
			request.getRequestDispatcher("/index").forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "请登录");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		if (!cn.getUser().getCount().equals(user.getCount())) {
			request.setAttribute("loginResult", "这不是你的商品");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("thisCN", cn);
		request.getRequestDispatcher("/modifyCN.jsp")
				.forward(request, response);
		return;
	}
}
