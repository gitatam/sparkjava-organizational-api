package dao;

import exc.DaoException;
import model.User;

import java.util.List;

public interface UserDao {
    //CREATE
    void add(User user) throws DaoException;

    //READ
    List<User> getAll();
    User getById(int id);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}
