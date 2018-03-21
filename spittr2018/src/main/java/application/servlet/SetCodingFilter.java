package application.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class SetCodingFilter implements Filter{

	private String charset;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
			this.charset=filterConfig.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if(this.charset==null||this.charset.isEmpty()){
			
			this.charset="UTF-8";
		}
		
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		EncodingRequest reqs=new EncodingRequest((HttpServletRequest)request, charset);
		chain.doFilter(reqs, response);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	


}
