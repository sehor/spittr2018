package application.servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequest extends HttpServletRequestWrapper {

	private String charset;
	public EncodingRequest(HttpServletRequest request,String charset) {
		super(request);
		this.charset=charset;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String getParameter(String name){
		
		HttpServletRequest request=(HttpServletRequest)getRequest();
		String requestType=request.getMethod();
		
		if(requestType.equalsIgnoreCase("post")){
			
			try {
				request.setCharacterEncoding(charset);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if (requestType.equalsIgnoreCase("get")) {
			String value=request.getParameter(name);
			
			 try {
				value=new String(name.getBytes("ISO-8859-1"),charset);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 return value;
		}
		
		
				return request.getParameter(name);
	}
	
}
