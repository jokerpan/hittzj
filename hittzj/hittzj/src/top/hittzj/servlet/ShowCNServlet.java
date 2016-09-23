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

//显示所有求购商品列表（用户行为：前一页 后一页 最后  最前  某一页）
//得到的参数：接下来是哪一页？
public class ShowCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到接下来要去哪一页
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
		request.setAttribute("tag", "所有求购商品");
		request.setAttribute("CNList", list);
//		System.out.println(list.getList()+"===========");
		request.getRequestDispatcher("/listCN.jsp").forward(request, response);
	}

}
