import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: 0708
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/08 15:40
 */
public class ConnUtil {
    public static DruidDataSource getSource(){
        DruidDataSource source = null;
        try {
            Properties props = new Properties();
            props.load(ConnUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            source = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
            DruidDataSource source = getSource();
            conn = source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        System.out.println(getConn());
    }
}
