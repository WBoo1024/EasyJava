package servlet;

import bean.User;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.apache.commons.beanutils.BeanUtils;
import service.SendMail;
import service.UserService;

import service.impl.UserServiceImpl;
import util.JwtUtils;
import vo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author WANG
 */
@WebServlet("/front/*")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        String uri = request.getRequestURI();
        String URI = uri.substring(uri.lastIndexOf("/"));
        switch (URI) {
            case "/searchProvince":
                getProvince(request, response);
                break;
            case "/searchCity":
                getCity(request, response);
                break;
            case "/searchArea":
                getArea(request, response);
                break;
            case "/register":
                register(request, response);
                break;
            case "/login":
                login(request, response);
                break;
            case "/getUsers":
                getUsers(request, response);
                break;
            case "/add":
                add(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            case "/checkToken":
                checkToken(request, response);
                break;
            case "/sendCode":
                sendCode(request, response);
                break;
            case "/changeWord":
                changeWord(request, response);
                break;
            default:
                break;
        }
    }

    private void changeWord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user  = new User();
        Result result = new Result();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            result = userService.changeWord(user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        response.getWriter().write(new Gson().toJson(result));
    }

    private void sendCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        Result result = Result.ok();
        int code = (int)((Math.random()*9+1)*100000);
        result.setData(code);
        SendMail sendMail = new SendMail(email,code);
        sendMail.start();
        response.getWriter().write(new Gson().toJson(result));
    }

    private void checkToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = userService.checkToken(request);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new Gson().toJson(result));
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            result = userService.update(user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        response.getWriter().write(new Gson().toJson(result));
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("datas[]");
        Result result = userService.delete(ids);
        response.getWriter().write(new Gson().toJson(result));
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        register(request, response);
    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String name = request.getParameter("name");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", page);
        map.put("pageSize", limit);
        map.put("name", name);
        result = userService.getUsers(map);
        response.getWriter().write(new Gson().toJson(result));
    }


    //登陆请求
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Result result = userService.login(user, request);
        response.getWriter().write(new Gson().toJson(result));
    }

    //注册请求
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        Result result = new Result();
        try {
            user.setReTime(LocalDateTime.now());
            BeanUtils.populate(user, request.getParameterMap());
            result = userService.register(user);
        } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().write(new Gson().toJson(result));
    }


    //获取省数据
    private void getProvince(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = userService.getProvince();
        response.getWriter().write(new Gson().toJson(result));
    }

    //获取市数据
    private void getCity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String provincecode = request.getParameter("value");
        Result result = userService.getCity(provincecode);
        response.getWriter().write(new Gson().toJson(result));
    }

    //获取区数据
    private void getArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String citycode = request.getParameter("value");
        Result result = userService.getArea(citycode);
        response.getWriter().write(new Gson().toJson(result));
    }


}
