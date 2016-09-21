package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;

import top.hittzj.entity.User;
import top.hittzj.service.LoginService;

/**
 * @author zy_q
 * @time 8/24
 * 
 * 
 */
public class LoginServlet extends HttpServlet {
	
	
	@Override
	public void init() throws ServletException {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error/404error.jsp").forward(request,
				response);
		return;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ�����
		String count = (String) request.getParameter("count");
		String psd = (String) request.getParameter("psd");
//		System.out.println(count + psd);
		// ����service
		LoginService service = new LoginService();
		User user = service.login(count, psd);
		HttpSession session = request.getSession();
		if (user == null) {
			int time = (Integer) session.getAttribute("loginTime");
			++time;
			// System.out.println("ʱ����" + time);
			session.setAttribute("loginTime", time);
			request.setAttribute("loginResult", "�˻��������������");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		} else {
			request.setAttribute("loginResult", "Ŷ��Ӵ"+user.getNickName());
			session.setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}
}
