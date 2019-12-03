package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {
    private final String expectedTitle = "";
    private final String expectedContent = "";
    private final String expectedAuthor = "Mathew Gitata";
    private final int expectedDepartmentId = 23;


    @Test
    public void newUserInstantiatescorrectly_true() {
        News testNews = new News(expectedTitle, expectedContent, expectedAuthor , expectedDepartmentId);
        assertTrue(testNews instanceof News);
    }

    @Test
    public void getTitle_returnsCorrectTitle() {
        News testNews = new News(expectedTitle, expectedContent, expectedAuthor , expectedDepartmentId);
        assertEquals(expectedTitle, testNews.getTitle());

    }


    @Test
    public void getContent_returnsCorrectContent() {
        News testNews = new News(expectedTitle, expectedContent, expectedAuthor , expectedDepartmentId);
        assertEquals(expectedContent, testNews.getContent());

    }

    @Test
    public void getAuthor_returnsCorrectAuthor() {
        News testNews = new News(expectedTitle, expectedContent, expectedAuthor , expectedDepartmentId);
        assertEquals(expectedAuthor, testNews.getAuthor());

    }

    @Test
    public void getDepartmentId_returnsCorrectDepartment() {
        News testNews = new News(expectedTitle, expectedContent, expectedAuthor , expectedDepartmentId);
        assertEquals(expectedDepartmentId, testNews.getDepartmentId());

    }



}