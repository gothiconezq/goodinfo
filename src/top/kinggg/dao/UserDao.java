package top.kinggg.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import top.kinggg.bean.Userinfo;
import top.kinggg.dao.util.C3P0Util;

import java.sql.SQLException;

public class UserDao {
    /**
     * @method:checkUser 检查用户名是否存在
     * @date:2018/08/26\
     * @params:[name]
     * @return:Userinfo
     */
    public Userinfo checkUser(String name) throws SQLException {
        Userinfo userinfo=null;
        try {
            QueryRunner queryRunner = C3P0Util.getQueryRunner();
            String sql = "select name from userinfo where name=?";
            userinfo = queryRunner.query(sql, new BeanHandler<Userinfo>(Userinfo.class), name);
            //如果没有查询到数据则说明该用户未被注册

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userinfo;
    }
    /**
     * @method:register 插入数据
     * @date:2018/08/26\
     * @params:[userinfo]
     * @return:boolean
     */
    public int register(Userinfo userinfo) throws SQLException {
            int row=0;
            try {
                QueryRunner queryRunner = C3P0Util.getQueryRunner();
                String sql = "insert into userinfo values(null,?,?,?)";
                row = queryRunner.update(sql, userinfo.getName(), userinfo.getPassword(), userinfo.getEmail());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return row;
    }
    /**
     * @method:Login 查询数据库
     * @date:2018/08/26\
     * @params:[name,password]
     * @return:userinfo
     */
    public Userinfo login(String name, String password) throws SQLException {
        QueryRunner queryRunner = C3P0Util.getQueryRunner();
        String sql="select * from userinfo where name=? and password=?";
        Userinfo userinfo = queryRunner.query(sql, new BeanHandler<Userinfo>(Userinfo.class),name,password);
        return userinfo;
    }



}
