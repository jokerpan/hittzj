package top.hittzj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.hittzj.dao.GetUserDao;
import top.hittzj.entity.User;
import top.hittzj.service.FindUserService;
import top.hittzj.service.ModifyUserInfoService;

/**
 * @author zy_q
 * 
 */
public class ModifyUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error.jsp").forward(request, response);
	}

	// (账户 密码) 修改后的qq phone nickname
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "请登录~");
			request.getRequestDispatcher("register.jsp").forward(
					request, response);
		} else {
			String count = user.getCount();
			String psd = user.getPsd();
			String nickName = (String) request.getParameter("nickName");
			String qq = (String) request.getParameter("qq");
			String phone = (String) request.getParameter("phone");
			ModifyUserInfoService service = new ModifyUserInfoService();
			boolean modify = service.modify(count, psd, qq, phone, nickName);
			if (modify) {
				FindUserService findUserService = new FindUserService();
				User find = findUserService.find(count, psd);
				session.setAttribute("user", find);
				request.setAttribute("changeUserInfoResult", "修改成功");
				request.getRequestDispatcher("center.jsp").forward(
						request, response);
			} else {
				request.setAttribute("changeUserInfoResult", "修改失败了");
				request.getRequestDispatcher("/infoChange.jsp").forward(request, response);

			}
		}
	}
}
