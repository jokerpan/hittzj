package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import top.hittzj.entity.Question;
import top.hittzj.entity.User;
import top.hittzj.service.FindQuestionByIDService;
import top.hittzj.service.FindUserService;
import top.hittzj.service.ModifyPsdService;

public class ModifyPsdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error/404error.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String qids = request.getParameter("qid");
		int qid = Integer.parseInt(qids);
		FindQuestionByIDService findQuestionByIDService = new FindQuestionByIDService();
		Question question = findQuestionByIDService.getQuestion(qid);
		if (question == null) {
			request.getRequestDispatcher("/error/500error.jsp").forward(
					request, response);
		} else {
			HttpSession session = request.getSession();
			String count = request.getParameter("count");
			String answer = (String) request.getParameter("answer");
			String newpsd = (String) request.getParameter("newpsd");
			ModifyPsdService service = new ModifyPsdService();
			boolean modify = service.modify(count, newpsd, question, answer);
			if (modify) {
				FindUserService findUserService = new FindUserService();
				User find = findUserService.find(count, newpsd);
				session.setAttribute("user", find);
				//密码修改完了直接登录
				request.setAttribute("changePsdResult", "修改完成，欢迎回来："+find.getNickName());
				request.getRequestDispatcher("/index.jsp").forward(
						request, response);
			} else {
				request.setAttribute("changePsdResult", "保密问题错误");
				request.getRequestDispatcher("/changePassword.jsp").forward(
						request, response);
			}
		}

	}
}
