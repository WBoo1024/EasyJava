package service;

import bean.User;
import com.sun.deploy.net.HttpRequest;
import vo.Result;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author WANG
 * @date 2022年07月20日 20:29
 */
public interface UserService {
    //注册
    Result register(User user) throws SQLException;

    //登陆
    Result login(User user, HttpServletRequest request);

    Result getUsers(Map<String, Object> map);

    Result delete(String[] ids);

    Result getProvince();

    Result getCity(String provincecode) ;

    Result getArea(String citycode);

    Result update(User user);

    String searchPic(String name);

    Result checkToken(HttpServletRequest request);

    Result changeWord(User user);
}
