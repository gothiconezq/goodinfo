package top.kinggg.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns ="/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//        Userinfo userinfo = new Userinfo();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        try {
//            //分别将属性封装到对象中
//            //BeanUtils.setProperty(userinfo,name,name);
//            //将属性的map集合封装到对象中
//            BeanUtils.populate(userinfo,parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        UserService userService=new UserService();
//        boolean register = userService.register(userinfo);
//        if(register){
//           response.sendRedirect(request.getContextPath()+"login.jsp");
//        }else{
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write("注册失败");
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
