package dao;

import exc.DaoException;
import model.Department;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static Connection conn;
    private static Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_test";
        Sql2o sql2o = new Sql2o(connectionString, "gitata", "gitata");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        departmentDao.deleteAll();
        conn.close();
    }

    @Test
    public void add_addingDepartmentSetsId() throws Exception {
        Department testDepartment = newTestDepartment();
        int originalDepartmentId = testDepartment.getId();
        departmentDao.add(testDepartment);

        assertNotEquals(originalDepartmentId, testDepartment.getId());
    }

    @Test
    public void getAll_addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Department testDepartment = newTestDepartment();
        departmentDao.add(testDepartment);

        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void getAll_noDepartmentReturns0IfEmptyList() throws Exception {
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void getById_existingDepartmentCanBeFoundById() throws Exception {
        Department testDepartment = newTestDepartment();
        departmentDao.add(testDepartment);

        Department foundDepartment = departmentDao.getById(testDepartment.getId());

        assertEquals(testDepartment, foundDepartment);
    }

    @Test
    public void deleteById_RemovesDepartmentOfSpecifiedId() throws Exception {
        Department testDepartment = newTestDepartment();
        Department testDepartment2 = newTestDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartment2);

        assertEquals(2, departmentDao.getAll().size());
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void deleteAll_ReturnsZeroDepartments() throws DaoException {
        Department testDepartment = newTestDepartment();
        Department testDepartment2 = newTestDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartment2);

        departmentDao.deleteAll();
        assertEquals(0, departmentDao.getAll().size());
    }

    //TODO: Add test method to get all users of a given department
    //TODO: Add test method to get all news articles for a given department

    private Department newTestDepartment() {
        return new Department("ICT", "IT support and Help Center", 9);
    }

    private User newTestUser() {
        return new User ("Mathew Gitata","CTO","Make all executive decisions with regards to the technological interests of xyz company",1);
    }

}