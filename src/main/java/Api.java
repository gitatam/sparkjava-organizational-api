import com.google.gson.Gson;
import dao.*;
import exc.ApiErrorException;
import model.Department;
import model.News;
import model.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static DB.DB.sql2o;
import static spark.Spark.*;

public class Api {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);


        UserDao userDao = new Sql2oUserDao(sql2o);
        DepartmentDao departmentDao = new Sql2oDepartmentDao(sql2o);
        NewsDao newsDao = new Sql2oNewsDao(sql2o);
        Gson gson = new Gson();

        //CREATE new user
        post("/users/new-user", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            return user;
        }, gson::toJson);

        //READ show users
        get("/users", "application/json",
                (req, res) -> userDao.getAll(), gson::toJson);

        //READ show users of a given id
        get("/users/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            User user = userDao.getById(id);
            if (user == null) {
                throw new ApiErrorException(404, "Could not find user with id " + id);
            }
            return user;
        }, gson::toJson);

        //CREATE new department
        post("/departments/new-department", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);// update the response status code
            return gson.toJson(department);
        }, gson::toJson);

        //READ show departments
        get("/departments", "application/json",
                (req, res) -> departmentDao.getAll(), gson::toJson);

        //READ show departments by given id
        get("/departments/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Department department = departmentDao.getById(id);
            if (department == null) {
                throw new ApiErrorException(404, "Could not find department with id " + id);
            }
            return department;
        }, gson::toJson);

        //CREATE new news entry
        post("/news/new-news", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });

        //READ all the news
        get("/news", "application/json",
                (req, res) -> newsDao.getAll(), gson::toJson);

        //READ show specific news
        get("/news/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            News news = newsDao.getById(id);
            if (news == null) {
                throw new ApiErrorException(404, "Could not find news article with id " + id);
            }
            return news;
        }, gson::toJson);

        //TODO: READ employees of a given department

        //TODO: READ news of a given department


        //exception handler
        exception(ApiErrorException.class, (exc, req, res) -> {
            ApiErrorException err = (ApiErrorException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatus());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatus());
            res.body(gson.toJson(jsonMap));
        });


        //FILTERS
        after((req, res) -> {
            res.type("application/json");
        });

    }
}
