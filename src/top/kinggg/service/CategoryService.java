package top.kinggg.service;

import top.kinggg.bean.Category;
import top.kinggg.bean.Page;
import top.kinggg.dao.CategoryDao;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    //创建作用域对象
    CategoryDao dao=new CategoryDao();

    /**
     * @method:addCategory  service添加种类
     * @date:2018/08/26\
     * @params:[category]
     * @return:boolean
     */
    public boolean addCategory(Category category) throws SQLException {
        dao=new CategoryDao();
        boolean addCategory1=false;
        int addCategory=dao.addCategory(category);
        if(addCategory>0){
             addCategory1=true;
        }else {
            addCategory1=false;
        }
        return addCategory1;
    }
    /**
     * @method:findPageCategory  service分页查询
     * @date:2018/08/28\
     * @params:[currentPage,currentCount]
     * @return:boolean
     */
    //注意所传参数的位置顺序
    public Page findPageCategory(int currentPage,int currentCount) throws SQLException {
//        private int totalPage;//总页数
//        private int currentPage;//当前页数
//        private int currentCount;//当前页显示的数目
//        private int totalCount;//总共的数目
        Page page=new Page();
        //1 查询数据的总数
        int totalCount = dao.queryCount();
        //2 根据总数和当前页显示数计算出总页数
        int totalPage=(int)Math.ceil(1.0*totalCount/currentCount);
        //3 将分页相关信息封装到page类中
        page.setCurrentCount(currentCount);
        page.setCurrentPage(currentPage);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        //4 计算查询的起始位置为：（页数-1）*每页显示条数
        int startPosition=(currentPage-1)*currentCount;
        //5 分页查询数据
        List<Category> categories= dao.queryPageCategoryList(startPosition,currentCount);
        //6 将集合封装到page类中
        page.setList(categories);
        return page;
    }

    /**
     * @method:updateCategory  service修改商品信息数据
     * @date:2018/08/30\
     * @params:[category]
     * @return:boolean
     */
    public boolean updateCategory(Category category) throws SQLException {
        boolean updateCategory=false;
        int row = dao.updateCategory(category);
        if(row>0){
            updateCategory=true;
        }else{
            updateCategory=false;
        }
        return updateCategory;
    }
   /**
     * @method:updateCategory  service删除商品信息数据
     * @date:2018/08/30\
     * @params:[category]
     * @return:boolean
     */
    public boolean deleteCategory(Category category) throws SQLException {
        boolean deleteCategory = dao.deleteCategory(category);
        return deleteCategory;
    }
}
