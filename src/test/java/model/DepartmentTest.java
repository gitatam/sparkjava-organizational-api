package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    private final String expectedDeptName ="Technology/Engineering Department";
    private final String expectedDescription = "Develops policies and procedures and use technology to enhance products and services that focus on external customers.";
    private final int expectedEmployeeCount = 4;

    @Test
    public void newUserInstantiatescorrectly_true() {
        Department testDept = createDept();
        assertTrue(testDept instanceof Department);
    }

    @Test
    public void getName_returnsCorrectName() {
        Department testDept = createDept();
        assertEquals(expectedDeptName, testDept.getDeptName());
    }


    @Test
    public void getDescription_returnsCorrectDescription() {
        Department testDept = createDept();
        assertEquals(expectedDescription, testDept.getDeptDescription());
    }

    @Test
    public void getEmployeeCount_returnsCorrectCount() {
        Department testDept = createDept();
        assertEquals(expectedEmployeeCount, testDept.getEmployeeCount());
    }


    public Department createDept() {
        return new Department(expectedDeptName, expectedDescription, expectedEmployeeCount);
    }

}