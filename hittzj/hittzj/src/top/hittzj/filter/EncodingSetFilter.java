package top.hittzj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zy_q
 * 
 */
// Õ≥“ª…Ë÷√±‡¬Î
public class EncodingSetFilter implements Filter {
	String CharacterEncoding;
	String ContentType;

	public void destroy() {


	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding(CharacterEncoding);
		res.setCharacterEncoding(CharacterEncoding);
		res.setContentType(ContentType);
		chain.doFilter(req, res);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		CharacterEncoding = filterConfig.getInitParameter("CharacterEncoding");
		ContentType = filterConfig.getInitParameter("ContentType");
	}

}
