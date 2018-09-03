package top.kinggg.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import top.kinggg.bean.Category;
import top.kinggg.dao.util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    QueryRunner queryRunner = C3P0Util.getQueryRunner();
    /**
     * @method:addCategory  添加商品信息数据
     * @date:2018/08/30\
     * @params:[category]
     * @return:int
     */
    public int addCategory(Category category) throws SQLException {
        String sql="insert into category1 values(?,null,?,?,?,?)";
        int row=queryRunner.update(sql,category.getC_id(),category.getC_name(),category.getPlace(),category.getCreatetime(),category.getType());
        return row;
    }
    /**
     * @method:queryCategoryList  查询商品信息数据
     * @date:2018/08/30\
     * @params:null
     * @return:List<Category>
     */
//    public List<Category> queryCategoryList() throws SQLException {
//        QueryRunner queryRunner = C3P0Util.getQueryRunner();
//        String sql="select * from category1";
//        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
//        return categoryList;
    //}
    //数据总条数
    public int queryCount() throws SQLException {
        String sql="select count(*) from category1";
        Long query = queryRunner.query(sql, new ScalarHandler<>());
        return query.intValue();

    }

    public List<Category> queryPageCategoryList(int startPosition,int currentCount) throws SQLException {
        String sql="select * from category1 limit ?,?";
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class),startPosition,currentCount);

        return categoryList;
    }

    /**
     * @method:queryCategoryList  修改商品信息数据
     * @date:2018/08/30\
     * @params:[category]
     * @return:boolean
     */
    public int updateCategory(Category category) throws SQLException {
        String sql="update category1 set c_name=?,place=?,type=? where c_id=?";
        int row=queryRunner.update(sql,category.getC_name(),category.getPlace(),category.getType(),category.getC_id());

        return row;
    }


    public boolean deleteCategory(Category category) throws SQLException {
        String sql="delete from category1 where c_id=?";
        int row=queryRunner.update(sql,category.getC_id());

        return row>0?true:false;
    }
}
