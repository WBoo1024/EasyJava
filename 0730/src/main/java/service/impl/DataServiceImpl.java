package service.impl;

import bean.Area;
import bean.Teacher;
import bean.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.DataMapper;
import org.apache.ibatis.session.SqlSession;
import service.DataService;
import util.SessionUtils;
import vo.Result;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @program: NewJavaWebProject
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/20 20:31
 */
public class DataServiceImpl implements DataService {
    private DataMapper dataMapper;

    @Override
    public Result allSearch(Map<String,Object> map) {
        SqlSession sqlSession = null;
        Result result = new Result();
        try {
            sqlSession = SessionUtils.getSession(true);
            dataMapper = sqlSession.getMapper(DataMapper.class);
            PageHelper.startPage(map);
            List<Teacher> list = dataMapper.allSearch(map);
            PageInfo<Teacher> pageInfo = new PageInfo<>(list);
            result.setData(pageInfo.getList());
            result.setCount(pageInfo.getTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }


    @Override
    public Result add(Teacher teacher) {
        SqlSession sqlSession = null;
        Result result = new Result();
        try {
            sqlSession = SessionUtils.getSession(true);
            dataMapper = sqlSession.getMapper(DataMapper.class);
            if (dataMapper.add(teacher) == 1){
                result = Result.ok();
            };
        } catch (IOException e) {
            result = Result.failed();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result delete(String[] ids) {
        Result result = Result.failed();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            dataMapper = sqlSession.getMapper(DataMapper.class);
            int count = dataMapper.delete(ids);
            if (ids.length == count){
                result = Result.ok();
                return result;
            };
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }

    @Override
    public Result update(Teacher teacher) {
        Result result = Result.failed();
        SqlSession sqlSession = null;
        try {
            sqlSession = SessionUtils.getSession(true);
            dataMapper = sqlSession.getMapper(DataMapper.class);
            dataMapper.update(teacher);
            return Result.ok();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            SessionUtils.close(sqlSession);
        }
        return result;
    }


}
