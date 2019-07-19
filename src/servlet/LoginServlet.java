package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//web给服务端utf8的形式
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + ",password" + password);
        String msg = "";
        if(username!=null&&!username.equals("")){
            msg="登陆成功";
        }else {
            msg="登录失败";
        }


        resp.setCharacterEncoding("utf-8");//服务端给web utf8形式
        resp.setContentType("text/html;character=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(msg+"</br>");
        out.println(msg);
        out.println(msg);
    }
}
