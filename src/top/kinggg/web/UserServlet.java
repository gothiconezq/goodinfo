package top.kinggg.web;

import org.apache.commons.beanutils.BeanUtils;
import top.kinggg.bean.Userinfo;
import top.kinggg.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserService userService=new UserService();
        Userinfo userinfo=null;
        try {
            userinfo = userService.login(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(userinfo!=null){
            //登录成功后，如果记住密码控件被选中，则将用户信息保存于cookie中
            String remember = request.getParameter("remember");
            if(!("").equals(remember)){
                //将用户名和密码保存加入到cookie中
                Cookie nameCookie = new Cookie("name", name);
                Cookie passwordCookie = new Cookie("password", password);
                //持久化cookie，防止被销毁
                nameCookie.setMaxAge(60*10);
                passwordCookie.setMaxAge(60*10);
                //将cookie发送给客户端保存
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);

                request.getSession().setAttribute("userinfo",userinfo);

            }
            response.sendRedirect(request.getContextPath()+"/category?method=getCategoryList&currentPage=1&currentCount=10");
        }else{
            //登录失败提示
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录失败");
        }
    }
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Userinfo userinfo = new Userinfo();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            //分别将属性封装到对象中
            //BeanUtils.setProperty(userinfo,name,name);
            //将属性的map集合封装到对象中
            BeanUtils.populate(userinfo,parameterMap);
            UserService userService=new UserService();
            boolean register = userService.register(userinfo);
            if(register){
                response.sendRedirect(request.getContextPath()+"login.jsp");
            }else{
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("注册失败");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
