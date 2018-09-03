package top.kinggg.dao.util;

import java.sql.*;

public class JDBCUtil {

    public Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String driver="jdbc:mysql://47.106.196.24:3306/fresh";
            String name="admin";
            String password="123456";
            connection=DriverManager.getConnection(driver,name,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void release(Connection connection){

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
