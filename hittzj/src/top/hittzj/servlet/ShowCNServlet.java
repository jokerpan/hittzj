package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.TzjList;
import top.hittzj.service.GetAllCNService;

//��ʾ��������Ʒ�б��û���Ϊ��ǰһҳ ��һҳ ���  ��ǰ  ĳһҳ��
//�õ��Ĳ���������������һҳ��
public class ShowCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ�������Ҫȥ��һҳ
//		System.out.println("begin+++++++++++");
		String nextPage_ = request.getParameter("nextPage");
		if (nextPage_ == null) {
			nextPage_ = "1";
		}
		int nextPage = Integer.parseInt(nextPage_);
		TzjList<Commodity_Need> list = new TzjList<Commodity_Need>();
		list.setCurrentPage(nextPage);
		GetAllCNService service = new GetAllCNService();
		list = service.list(list);
		request.setAttribute("tag", "��������Ʒ");
		request.setAttribute("CNList", list);
//		System.out.println(list.getList()+"===========");
		request.getRequestDispatcher("/listCN.jsp").forward(request, response);
	}

}
