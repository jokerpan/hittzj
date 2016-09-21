package top.hittzj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zyq
 * 
 */
// ���˶�γɹ�ע��
public class LimitRegisterFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// ����session
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("registerTime");
		if (obj == null) {
			session.setAttribute("registerTime", 1);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60 * 30);
			res.addCookie(cookie);
		}
		int time = (Integer) session.getAttribute("registerTime");
		if (time > 4) {
			req.setAttribute("registerResult", "ע�����̫����");
			req.getRequestDispatcher("/index.jsp").forward(req, res);
		}
		chain.doFilter(req, res);

	}

}
