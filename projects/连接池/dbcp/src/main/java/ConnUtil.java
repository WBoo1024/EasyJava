
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



/**
 * @program: 0708
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/08 14:59
 */
public class ConnUtil {

    public static DataSource getSource(){
        DataSource source = null;
        Properties props = new Properties();
        try {
            props.load(ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            source = BasicDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            DataSource source = getSource();
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
