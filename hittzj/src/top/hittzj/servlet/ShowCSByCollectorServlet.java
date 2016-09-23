package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;
import top.hittzj.service.GetCSByCollectorService;

public class ShowCSByCollectorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "请登录哦~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		TzjList<Commodity_Sell> list = new TzjList<Commodity_Sell>();
		String page = request.getParameter("nextPage");
		if (page == null||"".equals(page)) {
			page = "1";
		}
		int currentPage = Integer.parseInt(page);
		list.setCurrentPage(currentPage);
		GetCSByCollectorService service = new GetCSByCollectorService();
		list = service.list(list, user);
		request.setAttribute("CSList", list);
		request.setAttribute("tag", "我收藏的待出售商品");
		request.getRequestDispatcher("/listCS.jsp").forward(request, response);

	}

}
