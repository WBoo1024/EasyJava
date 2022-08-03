import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: 0708
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/08 14:53
 */
public class ConnUtil {
    public static DataSource getSource(){
        DataSource source = null;
        source = new ComboPooledDataSource();
        return source;
    }
    public static Connection getConn(){
        Connection conn = null;
        DataSource source = getSource();
        try {
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
