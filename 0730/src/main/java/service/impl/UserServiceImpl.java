package service.impl;

import bean.Area;
import bean.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpRequest;
import io.jsonwebtoken.Claims;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import util.JwtUtils;
import util.SessionUtils;
import vo.Result;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: NewJavaWebProject
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/20 20:30
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public Result register(User user) {
        Result result = new Result();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.register(user);
            result = Result.ok();
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
            result.setMsg("用户名重复，请重新输入");
        } finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result login(User user, HttpServletRequest request) {
        Result result = new Result();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            int count = userMapper.searchName(user);
            //如果count=0，说明未查询到用户名
            if (count == 1) {
                count += userMapper.login(user);
                if (count == 2) {
                    //查询到用户名和密码匹配，登陆成功
                    result = Result.ok();
//                    HttpSession session = request.getSession();
//                    session.setAttribute("username", user.getUsername());
                    String token = JwtUtils.toJwtToken(user.getUsername(), LocalDateTime.now());
                    result.setData(token);
                    return result;
                } else {
                    //查询到用户名，但未查询到密码
                    result = Result.failed();
                    result.setMsg("密码错误，请重新输入");
                }
            } else if (count == 0){
                result.setCode(2);
                result.setMsg("用户名不存在，请先注册");
            }
        } catch (IOException e) {
            result.setCode(3);
            result.setMsg("系统错误，请稍后再试");
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result getUsers(Map<String, Object> map) {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            PageHelper.startPage(map);
            List<User> list = userMapper.getUsers(map);
            PageInfo<User> pageInfo = new PageInfo<>(list);
            result.setData(pageInfo.getList());
            result.setCount(pageInfo.getTotal());
        } catch (IOException e) {
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result delete(String[] ids) {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            int count = userMapper.delete(ids);
            result = Result.ok();
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result getProvince() {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            List<Area> list = userMapper.getProvince();
            result.setData(list);
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result getCity(String provincecode) {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            List<Area> list = userMapper.getCity(provincecode);
            result.setData(list);
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result getArea(String citycode) {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            List<Area> list = userMapper.getArea(citycode);
            result.setData(list);
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result update(User user) {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.update(user);
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public String searchPic(String name) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.searchPic(name);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return null;
    }

    @Override
    public Result checkToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Result result = new Result();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            if (token == null) {
                result.setCode(1);
            } else {
                Claims claims = JwtUtils.fromJwtToken(token);
                if (claims == null) {
                    result.setCode(1);
                } else {
                    result.setCode(0);
                    String name = (String) claims.get("userName");
                    String url = userMapper.searchPic(name);
                    List<String> list = new ArrayList<>();
                    list.add(url);
                    list.add(name);
                    result.setData(list);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result changeWord(User user) {
        Result result = Result.ok();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.changeWord(user);
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failed();
        }
        return result;
    }


}
