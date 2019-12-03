package dao;

import exc.DaoException;
import model.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    private static Connection conn;
    private static Sql2oNewsDao newsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_test";
        Sql2o sql2o = new Sql2o(connectionString, "gitata", "gitata");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        newsDao.deleteAll();
        conn.close();
    }

    @Test
    public void add_addingNewsSetsId() throws Exception {
        News testNews = newTestNews();
        int originalNewsId = testNews.getId();
        newsDao.add(testNews);

        assertNotEquals(originalNewsId, testNews.getId());
    }

    @Test
    public void getAll_addedNewsAreReturnedFromGetAll() throws Exception {
        News testNews = newTestNews();
        newsDao.add(testNews);

        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void getAll_noNewsReturns0IfEmptyList() throws Exception {
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void getById_existingNewsCanBeFoundById() throws Exception {
        News testNews = newTestNews();
        newsDao.add(testNews);

        News foundNews = newsDao.getById(testNews.getId());

        assertEquals(testNews, foundNews);
    }

    @Test
    public void deleteById_RemovesNewsArticleOfSpecifiedId() throws Exception {
        News testNews = newTestNews();
        newsDao.add(testNews);
        News testNews2 = newTestNews();
        newsDao.add(testNews2);

        assertEquals(2, newsDao.getAll().size());
        newsDao.deleteById(testNews.getId());
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void deleteAll_ReturnsZeroNewsArticles() throws DaoException {
        News testNews = newTestNews();
        newsDao.add(testNews);
        News testNews2 = newTestNews();
        newsDao.add(testNews2);

        newsDao.deleteAll();
        assertEquals(0, newsDao.getAll().size());
    }

    private News newTestNews() {
        return new News("Meeting", "There will be a meeting at 4PM", "General", 0);
    }
}