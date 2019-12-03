import com.google.gson.Gson;
import dao.*;
import exc.ApiErrorException;
import model.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Api {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/org";
        Sql2o sql2o = new Sql2o(connectionString, "gitata", "gitata");
        Connection conn = sql2o.open();
        Gson gson = new Gson();

        UserDao userDao = new Sql2oUserDao(sql2o);
        DepartmentDao departmentDao = new Sql2oDepartmentDao(sql2o);
        NewsDao newsDao = new Sql2oNewsDao(sql2o);

        //CREATE new user
        post("/users", "application/json", (req, res) -> {
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
