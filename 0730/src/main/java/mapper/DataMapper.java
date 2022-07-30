package mapper;

import bean.Area;
import bean.Teacher;
import bean.User;
import vo.Result;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author WANG
 * @date 2022年07月20日 20:32
 */
public interface DataMapper {

    List<Teacher> allSearch(Map<String,Object> map);

    int add(Teacher teacher);

    int delete(String[] ids);

    int update(Teacher teacher);
}
