package com.qf.items.Filter;

import com.qf.hw.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        String reqURI=req.getRequestURI();
//        String newURI=reqURI.toLowerCase();
        if (reqURI.startsWith("/itemsJsp/login")||reqURI.startsWith("/itemsJsp/register")||reqURI.startsWith("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpSession session=req.getSession();
            User user = (User)session.getAttribute("userinfo");
                if (user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                PrintWriter out = servletResponse.getWriter();
                out.println("<script type='text/javascript'>alert('你没有登录')；location='/itemsJsp/login.jsp';</script>");

            }
        }

    }

    @Override
    public void destroy() {

    }
}
