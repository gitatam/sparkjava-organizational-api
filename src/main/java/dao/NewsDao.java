package dao;

import model.News;

import java.util.List;

public interface NewsDao {
    //CREATE
    void add(News news);

    //READ
    News getById(int id);
    List<News> getAll();
    List<News> getNewsByDept(int departmentId);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}
