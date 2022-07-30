package service;

import bean.Area;
import bean.Teacher;
import bean.User;
import vo.Result;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author WANG
 * @date 2022年07月20日 20:31
 */
public interface DataService {
    Result allSearch(Map<String,Object> map);

    Result add(Teacher teacher);

    Result delete(String[] ids);

    Result update(Teacher teacher);
}
