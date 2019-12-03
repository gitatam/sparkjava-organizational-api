import com.google.gson.Gson;
import dao.*;
import model.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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

    }
}
