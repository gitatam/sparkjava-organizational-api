package dao;

import model.Department;
import model.News;
import model.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name,description,employee_count) VALUES (:deptName,:deptDescription,:employeeCount)";

        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .addColumnMapping("name", "deptName")
                    .addColumnMapping("description", "deptDescription")
                    .addColumnMapping("employee_count", "employeeCount")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department getById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .addColumnMapping("name", "deptName")
                    .addColumnMapping("description", "deptDescription")
                    .addColumnMapping("employee_count", "employeeCount")
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public List<User> getDepartmentalUsers(int deptId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE department_id=:department_id")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<News> getDepartmentalNews(int department_id) {
        String sql = "SELECT * FROM news where department_id=:department_id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentId", department_id)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id = :id";
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
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
