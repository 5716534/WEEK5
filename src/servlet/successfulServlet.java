package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class successfulServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
       String username = (String)req.getAttribute("username");
       String password = (String)req.getAttribute("password");
       String sex = (String)req.getAttribute("sex");

       StringBuffer hobby=(StringBuffer) req.getAttribute("hobby");


        PrintWriter out = resp.getWriter();
        out.println("注册成功！<br/>");
        out.println("用户名："+username+"<br/>");
        out.println("密码："+password+"<br/>");
        out.println(hobby.toString()+"<br/>");
        out.println("性别："+sex);


    }
}
