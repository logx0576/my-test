package me.logx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import me.logx.servlet.CustomHttpServletResponseWrapper;

public class CustomFilterB implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("enter into custom filter B Before..");
		chain.doFilter(request, response);
		getContent(request, response);
		System.out.println("enter into custom filter B after..");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void getContent(ServletRequest req, ServletResponse resp) throws IOException, ServletException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		CustomHttpServletResponseWrapper response = new CustomHttpServletResponseWrapper((HttpServletResponse) resp,
				os);
		// 刷新response的输出流, 在某些情况下, 如果不刷新的话, 会导致部分信息还在缓存中, 而没有写入os中
		response.flush();
		String html = new String(os.toByteArray(), "UTF-8");
		resp.getWriter().print(html);

		resp.setContentLength(html.getBytes("UTF-8").length);
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().flush();
	}

}
