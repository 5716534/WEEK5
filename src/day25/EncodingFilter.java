package day25;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private  String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("EncodingFilter init...");
        encoding=filterConfig.getInitParameter("encoding");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("EncodingFilter doFilter...");
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {
        System.out.println("EncodingFilter destroy...");

    }
}
