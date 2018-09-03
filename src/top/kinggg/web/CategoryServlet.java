package top.kinggg.web;

import org.apache.commons.beanutils.BeanUtils;
import top.kinggg.bean.Category;
import top.kinggg.bean.Page;
import top.kinggg.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")

public class CategoryServlet extends BaseServlet {
    /**
     * @method:addCategory 增加种类
     * @date:2018/08/29
     * @params:[request,response]
     * @return:void
     */
    public void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取参数，通过BeanUtils封装实体类
            Map<String, String[]> parameterMap = request.getParameterMap();
            Category category=new Category();
            BeanUtils.populate(category,parameterMap);
            category.setCreatetime(new Date());
            CategoryService categoryService=new CategoryService();
            boolean b = categoryService.addCategory(category);
            if(b){
                //添加成功
                response.setStatus(201);
                request.getRequestDispatcher("/category-add.jsp").forward(request,response);
            }else{
                //添加失败
                response.setStatus(600);
                request.getRequestDispatcher("/category-add.jsp").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @method:getCategoryList 分页查询种类
     * @date:2018/08/28\
     * @params:[request,response]
     * @return:void
     */
    public void getCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service中的查询方法

        try {
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            int currentCount = Integer.parseInt(request.getParameter("currentCount"));

            //给分页设置初始默认值
            if(currentCount==0){
                currentCount=10;
            }
            if(currentPage==0){
                currentPage=1;
            }

            CategoryService service=new CategoryService();
            Page page = service.findPageCategory(currentPage, currentCount);
            if(page!=null){
                request.setAttribute("page",page);
                request.getRequestDispatcher("/category-list.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/category-list.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @method:updateCategory 更新种类信息
     * @date:2018/08/30\
     * @params:[request,response]
     * @return:void
     */
    public void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //调用service中的查询方法
            Map<String, String[]> parameterMap = request.getParameterMap();
            Category category=new Category();
            BeanUtils.populate(category,parameterMap);
            CategoryService service=new CategoryService();
            boolean updateCategory = service.updateCategory(category);
            if(updateCategory){
                //修改成功后重定向到列表界面
                response.sendRedirect(request.getContextPath()+"/category?method=getCategoryList&currentPage=1&currentCount=10");
            }else{
                //修改失败，提示修改失败并设置返回跳转链接
                response.setContentType("text/html;charset=utf-8");
                 response.getWriter().write("修改失败，<a href='/category?method=getCategoryList&currentPage=1&currentCount=10'>点击这里直接返回</a>)");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * @method:deleteCategory 更新种类信息
     * @date:2018/08/30\
     * @params:[request,response]
     * @return:void
     */
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //调用service中的查询方法
            Map<String, String[]> parameterMap = request.getParameterMap();
            Category category=new Category();
            BeanUtils.populate(category,parameterMap);
            CategoryService service=new CategoryService();
            boolean deleteCategory = service.deleteCategory(category);
            if(deleteCategory){
                //删除成功后重定向到列表界面
                response.sendRedirect(request.getContextPath()+"/category?method=getCategoryList&currentPage=1&currentCount=10");
            }else{
                //删除失败，提示修改失败并设置返回跳转链接
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("修改失败，<a href='/category?method=getCategoryList&currentPage=1&currentCount=10'>点击这里直接返回</a>)");
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
