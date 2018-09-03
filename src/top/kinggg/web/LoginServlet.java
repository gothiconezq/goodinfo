package top.kinggg.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        UserService userService=new UserService();
//        Userinfo userinfo=null;
//        try {
//            userinfo = userService.login(name, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if(userinfo!=null){
//            //登录成功后，如果记住密码控件被选中，则将用户信息保存于cookie中
//            String remember = request.getParameter("remember");
//            if(remember.equals("yes")){
//                //将用户名和密码保存加入到cookie中
//                Cookie nameCookie = new Cookie("name", name);
//                Cookie passwordCookie = new Cookie("password", password);
//                //持久化cookie，防止被销毁
//                nameCookie.setMaxAge(60*10);
//                passwordCookie.setMaxAge(60*10);
//                //将cookie发送给客户端保存
//                response.addCookie(nameCookie);
//                response.addCookie(passwordCookie);
//            }else{
//                response.sendRedirect(request.getContextPath()+"/category-list.jsp");
//            }
//            response.sendRedirect(request.getContextPath()+"/category-list.jsp");
//        }else{
//            //登录失败提示
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write("登录失败");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
