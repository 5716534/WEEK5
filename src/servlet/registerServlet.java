package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        String sex = req.getParameter("sex");
        String msg = "";
        if (username != null && !username.equals("")
                && password != null && !password.equals("")) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);

            StringBuffer sf = new StringBuffer();
            sf.append("兴趣爱好：");
            for (int i = 0; i < hobby.length; i++) {
                sf.append(hobby[i] + " ");
            }
            req.setAttribute("hobby", sf);
            req.setAttribute("sex", sex);

            req.getRequestDispatcher("/successfulServlet").forward(req, resp);
        } else {
            System.out.println("登陆失败");
        }

    }
}