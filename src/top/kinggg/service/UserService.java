package top.kinggg.service;

import top.kinggg.bean.Userinfo;
import top.kinggg.dao.UserDao;

import java.sql.SQLException;



public class UserService {

/**
 * @method:Login 用户登录
 * @date:2018/08/26\
 * @params:[name,password]
 * @return:void
*/
    public Userinfo login(String name, String password) throws SQLException {
        UserDao userDao=new UserDao();
        Userinfo userinfo = userDao.login(name, password);
        return userinfo;
    }
    /**
     * @method:Login 用户注册
     * @date:2018/08/26\
     * @params:[userinfo]
     * @return:boolean
     */
    public boolean register(Userinfo userinfo) throws SQLException {
        boolean register=false;
        UserDao userDao=new UserDao();
        Userinfo checkUser = userDao.checkUser(userinfo.getName());
        //2、如不存在则将用户信息添加入数据库
        if(checkUser==null){
            int registerSuccessful= userDao.register(userinfo);
            if (registerSuccessful>0){
                register=true;
            }
        }
        return register;
    }
}
