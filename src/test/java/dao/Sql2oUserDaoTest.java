package dao;

import exc.DaoException;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {

    private static Connection conn;
    private static Sql2oUserDao userDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_test";
        Sql2o sql2o = new Sql2o(connectionString, "gitata", "gitata");
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        userDao.deleteAll();
        conn.close();
    }



    @Test
    public void add_addingUserSetsId() throws Exception {
        User testUser = newTestUser();
        int originalUserId = testUser.getId();
        userDao.add(testUser);

        assertNotEquals(originalUserId, testUser.getId());
    }

    @Test
    public void getAll_addedUsersAreReturnedFromGetAll() throws Exception {
        User testUser = newTestUser();
        userDao.add(testUser);

        assertEquals(1, userDao.getAll().size());
    }

    @Test
    public void getAll_noUsersReturnsIfEmptyList() throws Exception {
        assertEquals(0, userDao.getAll().size());
    }

    @Test
    public void getById_existingUsersCanBeFoundById() throws Exception {
        User testUser = newTestUser();
        userDao.add(testUser);

        User foundUser = userDao.getById(testUser.getId());

        assertEquals(testUser, foundUser);
    }

    @Test
    public void deleteById_RemovesUserOfSpecifiedId() throws Exception {
        User testUser = newTestUser();
        User testUser2 = newTestUser();
        userDao.add(testUser);
        userDao.add(testUser2);

        assertEquals(2,userDao.getAll().size());
        userDao.deleteById(testUser.getId());
        assertEquals(1,userDao.getAll().size());
    }

    @Test
    public void deleteAll_ReturnsZeroUsers() throws DaoException {
        User testUser = newTestUser();
        User testUser2 = newTestUser();
        userDao.add(testUser);
        userDao.add(testUser2);

        userDao.deleteAll();
        assertEquals(0, userDao.getAll().size());
    }




    private User newTestUser() {
        return new User ("Mathew Gitata","CTO","Make all executive decisions with regards to the technological interests of xyz company",1);
    }
}