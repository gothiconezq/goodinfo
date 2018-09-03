package top.kinggg.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class C3P0Util {


    public static QueryRunner getQueryRunner(){
        ComboPooledDataSource dataSources=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSources);
        return queryRunner;
    }
    public static void release(ComboPooledDataSource dataSources){
        if(dataSources!=null){
            dataSources.close();
        }

    }
}
