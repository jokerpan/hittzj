package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.hittzj.dao.CNSearchDao;
import top.hittzj.dao.CSSearchDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Commodity_Sell cs = null;
		Commodity_Need cn = null;
		String id = request.getParameter("searchId");
		String context = request.getParameter("context");
		if ("1".equals(id)) {
			if (context != null) {
				cs = new Commodity_Sell();
				cs.setName(context);
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}
			// CS
			request.setAttribute("tag", "搜索待出售商品");
			CSSearchDao dao = new CSSearchDao();
			List<Commodity_Sell> search = dao.search(cs);
			TzjList<Commodity_Sell> list=new TzjList<Commodity_Sell>();
			list.setList(search);
			request.setAttribute("CSList", list);
			request.getRequestDispatcher("/searchCS.jsp").forward(request,
					response);
			return;
		}
		if ("2".equals(id)) {
			// CN
			if (context != null) {
				cn = new Commodity_Need();
				cn.setName(context);
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}

			request.setAttribute("tag", "搜索他人求购商品");
			CNSearchDao dao = new CNSearchDao();
			List<Commodity_Need> search = dao.search(cn);
			TzjList<Commodity_Need> list=new TzjList<Commodity_Need>();
			list.setList(search);
			request.setAttribute("CNList", list);
			request.getRequestDispatcher("/searchCN.jsp").forward(request,
					response);
			return;
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}

	}

}
