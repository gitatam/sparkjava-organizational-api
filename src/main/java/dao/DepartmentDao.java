package dao;

import model.Department;
import model.News;
import model.User;

import java.util.List;

public interface DepartmentDao {
    //CREATE
    void add(Department department);

    //READ
    List<Department> getAll();
    Department getById(int id);
    List<User> getDepartmentalUsers(int deptId);
    List<News> getDepartmentalNews(int department_id);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}
