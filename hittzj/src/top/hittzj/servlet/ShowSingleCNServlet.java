package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.service.GetCNService;

public class ShowSingleCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_ = request.getParameter("CNId");
		int id = Integer.parseInt(id_);
		if (id_ == null) {
			request.setAttribute("findCNResult", "不存在商品");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		GetCNService service = new GetCNService();
		Commodity_Need commodity_Need = service.get(id);
		if (commodity_Need == null) {
			request.setAttribute("findCNResult", "不存在商品");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("thisCN", commodity_Need);
		request.getRequestDispatcher("/showSingleCN.jsp").forward(request,
				response);
	}
}
