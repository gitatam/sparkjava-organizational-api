package dao;

import exc.DaoException;
import model.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) throws DaoException {
        String sql = "INSERT INTO users(name, designation, role, department_id) VALUES(:name, :designation, :role, :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users")
                    .addColumnMapping("department_id", "departmentId")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User getById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE id=:id")
                    .addParameter("id", id)
                    .addColumnMapping("department_id", "departmentId")
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
