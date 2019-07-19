package day24review;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置编码方式
       req.setCharacterEncoding("utf-8");;
        // 2、获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 3、验证数据是否合法
        if (username!=null&&!"".equals(username)&&password!=null&&!"".equals(password)){
            // 用户名和密码都不能为空，登录成功，否则就失败
            //  3.1、成功就跳转成功页面，显示登录成功(重定向)
            // 重定向：通知浏览器发出第2次请求
            req.setAttribute("msg","登陆成功");
            resp.sendRedirect("SuccssServlet");
        }else{
            req.setAttribute("msg","登陆失败，用户名或密码错误");
            req.getRequestDispatcher("ErrorServlet").forward(req,resp);
        }
    }
}




// response.sendRedirect(url)：
// request：请求对象，获取客户端的数据
// response：响应对象，数据发回给客户端
//  3.2、失败就跳转到失败页面，并将错误消息输出（转发）
