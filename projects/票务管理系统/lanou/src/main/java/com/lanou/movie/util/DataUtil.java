package com.lanou.movie.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: lanou
 * @description: 获取数据源
 * @author: 壹零二四
 * @created: 2022/07/12 08:38
 */
public class DataUtil {

    /** 获取用户表数据源 */
    public static DataSource getUserSource(){
        return new ComboPooledDataSource();
    }

    /** 获取电影表数据源 */
    public static DataSource getMovieSource() {
        return new ComboPooledDataSource("movieData");
    }

    /** 根据参数查询数据,返回对象的集合 */
    public static <clazz> List<clazz> getDataByparams(String sql,Class< ? > clazz,Object ... params){
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(getUserSource());
        List<clazz> list = null;
        try {
            list = (List<clazz>)runner.query(sql,new BeanListHandler<>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /** 增删改的公用方法 */
    public Boolean update(String sql,Object ... params){
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(getUserSource());
        int rows = 0;
        try {
            rows = runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            return true;
        }
        return false;
    }
}
