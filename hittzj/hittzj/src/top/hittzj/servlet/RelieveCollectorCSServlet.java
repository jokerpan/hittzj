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
import top.hittzj.entity.User;
import top.hittzj.service.GetCNService;
import top.hittzj.service.GetCSService;
import top.hittzj.service.RelieveCollectorCSService;

public class RelieveCollectorCSServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "ÇëµÇÂ¼");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		//µÃµ½CN
		String id = request.getParameter("CSid");
		int id_ = Integer.parseInt(id);
		GetCSService service=new GetCSService();
		Commodity_Sell cs = service.get(id_);
		
		
		RelieveCollectorCSService service2=new RelieveCollectorCSService();
		boolean relieve = service2.relieve(cs, user);
		if(relieve){
			
		}
		else{
			
		}
	}

}
