package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.TzjList;
import top.hittzj.service.FindTypeById;
import top.hittzj.service.GetCSByTypeService;

public class ShowCSByTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TzjList<Commodity_Sell> list = new TzjList<Commodity_Sell>();
		// 得到页数
		String page = request.getParameter("nextPage");
		if (page == null) {
			page = "1";
		}
		int nextPage = Integer.parseInt(page);

		list.setCurrentPage(nextPage);

		// 得到类型id(每页跳转都要有这个)
		String typeId_ = request.getParameter("tpyeId");
		if (typeId_ == null) {
			System.out.println("there is no typeId");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		int typeId = Integer.parseInt(typeId_);
		FindTypeById find = new FindTypeById();
		Commodity_Type type = find.find(typeId);

		if (type == null) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}

		GetCSByTypeService service = new GetCSByTypeService();
		list=service.list(list, type);
		request.setAttribute("CSList", list);
		request.setAttribute("tag", type.getName());
		request.getRequestDispatcher("/listCS.jsp").forward(request, response);
	}
}
