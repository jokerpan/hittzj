package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;
import top.hittzj.service.GetCNByUserService;

//得到用户自己拥有的求购信息
public class ShowCNByUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到页数
		String page_ = request.getParameter("nextPage");
		if (page_ == null) {
			page_ = "1";
		}
		int nextPage = Integer.parseInt(page_);
		// 得到用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "请登录哦~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		//
		TzjList<Commodity_Need> list = (TzjList<Commodity_Need>) request
				.getAttribute("userCNLIst");
		if (list == null) {
			list = new TzjList<Commodity_Need>();
		}
		list.setCurrentPage(nextPage);
		GetCNByUserService service = new GetCNByUserService();
		list = service.list(list, user);
		request.setAttribute("tag", "我发布的求购商品");
		request.setAttribute("CNList", list);
		request.getRequestDispatcher("/listCN.jsp").forward(request, response);

	}
}
