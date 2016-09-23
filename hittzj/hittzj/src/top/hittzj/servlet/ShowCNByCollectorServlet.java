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
import top.hittzj.service.GetCNListByCollectorService;



//��ʾ�ղص�����Ϣ
public class ShowCNByCollectorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "���¼Ŷ~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		TzjList<Commodity_Need> list = new TzjList<Commodity_Need>();
		//�õ�ҳ������
		String page = request.getParameter("nextPage");
		int nextPage = Integer.parseInt(page);
		list.setCurrentPage(nextPage);
		GetCNListByCollectorService service = new GetCNListByCollectorService();
		list = service.list(list, user);
		request.setAttribute("CNList", list);
		request.setAttribute("tag", "���ղص�����Ʒ");
		request.getRequestDispatcher("/listCN.jsp").forward(request, response);

	}

}
