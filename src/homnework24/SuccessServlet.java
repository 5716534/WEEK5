package homnework24;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex=req.getParameter("sex");
        String[] hobby=req.getParameterValues("hobby");

        if (username!=null&&!"".equals(username)
                &&password!=null&&!"".equals(password)){
            User user = new User(username,password,hobby,sex);

            HttpSession session = req.getSession();
            session.setAttribute("UserInfo",user);
            resp.sendRedirect("LoginServlet.jsp");
        }else {
            req.setAttribute("msg","注册失败，重输");
            req.getRequestDispatcher("zhuce1.jsp")  .forward(req,resp);      }
    }
}
