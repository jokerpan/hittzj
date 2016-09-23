package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;
import top.hittzj.service.GetCNByUserService;
import top.hittzj.service.GetCSByUserService;

//�����û��Լ����۵���Ʒ
public class ShowCSByUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ�ҳ��
		String page_ = request.getParameter("nextPage");
		if (page_ == null||"".equals(page_)) {
			page_ = "1";
		}
		int nextPage = Integer.parseInt(page_);
		// �õ��û�
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "���¼Ŷ~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		//
		TzjList<Commodity_Sell> list = (TzjList<Commodity_Sell>) request
				.getAttribute("userCSLIst");
		if (list == null) {
			list = new TzjList<Commodity_Sell>();
		}
		list.setCurrentPage(nextPage);
		GetCSByUserService service = new GetCSByUserService();
		list = service.list(list, user);
		request.setAttribute("CSList", list);
		request.setAttribute("tag", "�ҷ����Ĵ�������Ʒ");
		request.getRequestDispatcher("/listCS.jsp").forward(request, response);

	}

}
