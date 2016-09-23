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
import top.hittzj.service.GetCSService;

public class ModifyCSForwardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("CSId");
		int CNId = Integer.parseInt(id);
		GetCSService service = new GetCSService();
		Commodity_Sell cs = service.get(CNId);
		if (cs == null) {
			request.setAttribute("findCSResult", "没有此商品");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
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
		if (!cs.getUser().getCount().equals(user.getCount())) {
			request.setAttribute("loginResult", "这不是你的商品");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("thisCS", cs);
		request.getRequestDispatcher("/modifyCS.jsp")
				.forward(request, response);
		return;
	}
}
