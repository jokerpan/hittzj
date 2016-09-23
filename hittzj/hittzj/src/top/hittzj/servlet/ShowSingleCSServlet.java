package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.service.GetCSService;

public class ShowSingleCSServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id_=request.getParameter("CSId");
			int id=Integer.parseInt(id_);
			if(id_==null){
				request.setAttribute("findCSResult", "不存在商品");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
			GetCSService service=new GetCSService();
			Commodity_Sell commodity_Sell = service.get(id);
			if(commodity_Sell==null){
				request.setAttribute("findCSResult", "不存在商品");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
				return;
			}
			request.setAttribute("thisCS", commodity_Sell);
			request.getRequestDispatcher("/showSingleCS.jsp").forward(request, response);
	}

}
