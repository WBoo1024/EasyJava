package servlet;

import bean.Teacher;
import bean.User;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import service.DataService;
import service.impl.DataServiceImpl;
import vo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WANG
 */
@WebServlet("/index/*")
public class IndexServlet extends HttpServlet {
    private DataService dataService;

    public IndexServlet() {
        dataService = new DataServiceImpl();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();
        String URI = uri.substring(uri.lastIndexOf("/"));
        switch (URI) {
            case "/jump":
                request.getRequestDispatcher("/WEB-INF/table.html").forward(request, response);
                break;
            case "/linkage":
                request.getRequestDispatcher("/WEB-INF/linkage.html").forward(request, response);
                break;
            case "/allSearch":
                allSearch(request,response);
                break;
            case "/add":
                add(request,response);
                break;
            case "/delete":
                delete(request,response);
                break;
            case "/update":
                update(request, response);
                break;
            default:
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = Result.failed();
        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher,request.getParameterMap());
            result = dataService.update(teacher);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        response.getWriter().write(new Gson().toJson(result));
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();
        String[] ids = request.getParameterValues("datas[]");
        result = dataService.delete(ids);
        response.getWriter().write(new Gson().toJson(result));
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = new Teacher();
        Result result = new Result();
        try {
            BeanUtils.populate(teacher,request.getParameterMap());
            result = dataService.add(teacher);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        response.getWriter().write(new Gson().toJson(result));
    }

    //表格数据
    private void allSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String name = request.getParameter("name");
        Map<String, Object> map = new HashMap<String, Object>(10);
        map.put("pageNum",page);
        map.put("pageSize",limit);
        map.put("name",name);
        Result result = dataService.allSearch(map);
        response.getWriter().write(new Gson().toJson(result));
    }
}
