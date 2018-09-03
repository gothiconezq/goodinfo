package top.kinggg.filter;

import top.kinggg.bean.Userinfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter",urlPatterns = "/category")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取session 校验用户信息
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Userinfo user = (Userinfo) session.getAttribute("userinfo");
        //判断userinfo是否为空，若空则跳转到登录界面
        if(user==null){
           response.sendRedirect(request.getContextPath()+"login.jsp");
           return;
        }
        //若上面的判断为假即user不为空则直接放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
