package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;
import top.hittzj.service.GetAllCSService;

//��ʾ���еĳ���
public class ShowCSServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �õ�������Ҫȥ��һҳ
		String nextPage_ = request.getParameter("nextPage");
		if (nextPage_ == null) {
			nextPage_ = "1";
		}
		int nextPage = Integer.parseInt(nextPage_);

		TzjList<Commodity_Sell> list = new TzjList<Commodity_Sell>();
		list.setCurrentPage(nextPage);
		GetAllCSService service = new GetAllCSService();
		list = service.list(list);
//		System.out.println("��ӡlist"+list);
		request.setAttribute("CSList", list);
		request.setAttribute("tag", "���д�������Ʒ");
		request.getRequestDispatcher("/listCS.jsp").forward(request, response);
	}
}
