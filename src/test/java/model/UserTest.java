package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private final String expectedName = "Mathew Gitata";
    private final String expectedPosition = "CTO";
    private final String expectedRole = "Make all executive decisions with regards to the technological interests of xyz company";
    private final int expectedDepartmentId = 1;

    @Test
    public void newUserInstantiatescorrectly_true() {
        User testUser = createUser();
        assertTrue(testUser instanceof User);
    }

    @Test
    public void getName_returnsCorrectName() {
        User user = createUser();
        assertEquals(expectedName, user.getName());

    }


    @Test
    public void getPosition_returnsCorrectPosition() {
        User user = createUser();
        assertEquals(expectedPosition, user.getPosition());

    }

    @Test
    public void getRole_returnsCorrectRole() {
        User user = createUser();
        assertEquals(expectedRole, user.getRole());

    }

    @Test
    public void getDepartmentId_returnsCorrectDepartment() {
        User user = createUser();
        assertEquals(expectedDepartmentId, user.getDepartmentId());

    }

    private User createUser() {
        return new User(expectedName, expectedPosition, expectedRole, expectedDepartmentId);
    }

}