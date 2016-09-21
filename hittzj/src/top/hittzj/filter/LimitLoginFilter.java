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
 * @author zy_q
 * 
 */
// 过滤多次登录
public class LimitLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginTime");
		if (obj == null) {
			session.setAttribute("loginTime", 1);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60 * 30);
			res.addCookie(cookie);
		} else {
			Integer time = (Integer) obj;
			if (time > 5) {
				req.setAttribute("loginResult", "登录失败过多，请半小时之后再试");
				req.getRequestDispatcher("/index.jsp").forward(req,
						res);
				return;
			}
		}
		chain.doFilter(req, res);

	}

	public void init(FilterConfig congfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
