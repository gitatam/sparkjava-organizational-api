package dao;

import model.Department;
import model.User;

import java.util.List;

public interface DepartmentDao {
    //CREATE
    void add(Department department);

    //READ
    List<Department> getAll();
    Department getById(int id);
    List<User> getDepartmentUsers(int deptId);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}
