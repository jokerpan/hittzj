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
// 过滤多次成功注册
public class LimitRegisterFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 开启session
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
			req.setAttribute("registerResult", "注册次数太多了");
			req.getRequestDispatcher("/index.jsp").forward(req, res);
		}
		chain.doFilter(req, res);

	}

}
