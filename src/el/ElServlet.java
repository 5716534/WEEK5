package el;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ElServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("username","张三");
//        req.getSession().setAttribute("username","李四");
//        req.setAttribute("userInfo",new User("admin","123"));
//        List<User> list = new ArrayList<>();
//        for (int i=0;i<10;i++){
//            list.add(new User("test1"+1,"111"));
//        }
//        req.setAttribute("list",list);
//        req.getRequestDispatcher("el.jsp").forward(req,resp);
       //req设置属性值
        req.setAttribute("username","亚索");
        //req获得会话，设置属性值
        req.getSession().setAttribute("password","9999");
//        //req导入userinfo，引入user类
//        req.setAttribute("userInfo",new User("admin","111"));
//        //数组遍历加入新user
//        List<User> list = new ArrayList<>();
//        for (int i=0;i<10;i++){
//            list.add(new User("test"+1,"111"));
//        }
//        //req设置list属性值
//        req.setAttribute("list",list);
//        //转发至el.jsp
//        req.getRequestDispatcher("el.jsp").forward(req,resp);

    }
}
