package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import top.hittzj.entity.Question;
import top.hittzj.entity.User;
import top.hittzj.service.FindQuestionByIDService;
import top.hittzj.service.FindUserService;
import top.hittzj.service.IsUserExistService;
import top.hittzj.service.RegisterService;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/20
 * 
 */
// ע��
public class RegisterServlet extends HttpServlet {
	/**
	 * ע����Ҫ�Ĳ��� �ʺ� count ���� nickName ���� psd �绰���� phone qq qq question qid Answer
	 * answer time time
	 */
	// ֻ����post����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error/404error.jsp").forward(request,
				response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����֤���ip��¼�˼��� ����5�ξͽ�ֹע����Сʱ��ͨ������������
		// �����û�
		// �ҵ���������
		String id = request.getParameter("qid");
		int qid = Integer.parseInt(id);
		FindQuestionByIDService service = new FindQuestionByIDService();
		Question question = service.getQuestion(qid);
		
		// System.out.println(question.getId()+question.getQuestion());
		if (question == null) {
			request.getRequestDispatcher("/error/500error.jsp").forward(
					request, response);
			return;
		} else {
			String count = (String) request.getParameter("count");
			// ȷ���Ƿ����û�����(ͨ��count)
			IsUserExistService isUserExistService = new IsUserExistService();
			boolean isUserExist = isUserExistService.isExist(count);
			if (isUserExist) {
				request.setAttribute("registerResult", "��ע����û��Ѿ�������");
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
				return;
			} else {
				String answer = (String) request.getParameter("answer");
				String nickName = (String) request.getParameter("nickName");
				String psd = (String) request.getParameter("psd");
				String phone = (String) request.getParameter("phone");
				String qq = (String) request.getParameter("qq");
				Date date = new Date();
				RegisterService r = new RegisterService();
				boolean registerResult = r.register(count, nickName, psd, qq,
						question, answer, date, phone);
				// ע��ɹ��������û���session����ת����ҳ
				if (registerResult == true) {
					FindUserService f = new FindUserService();
					User user = f.find(count, psd);
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
					int time = (Integer) session.getAttribute("registerTime");
					++time;
					session.setAttribute("registerTime", time);
					request.setAttribute("loginResult", "ע��ɹ������"+user.getNickName());
					request.getRequestDispatcher("/index.jsp").forward(
							request, response);
					return;
				}
				// ע��ʧ��
				else {
					request.setAttribute("registerResult", "��ע����û��Ѿ�������");
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
					return;
				}

			}
		}
	}
}
