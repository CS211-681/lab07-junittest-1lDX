package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student s;

    @BeforeEach
    void setUp() {
        s = new Student("6710405389","Wit");
    }

    @Test
    @DisplayName("Test add 10 score")
    void testAddScore(){
        s.addScore(10);
        assertEquals(10,s.getScore());
    }

    @Test
    void testGrade(){
        s.addScore(100);
        assertEquals("A",s.getGrade());
    }

    @Test
    void testChangeName(){
        s.changeName("Ja");
        assertEquals("Ja",s.getName());

        s.changeName("Wit");
        assertEquals("Wit",s.getName());
    }

    @Test
    void testIsId(){
        assertFalse(s.isId("6710405397"));
        assertTrue(s.isId("6710405389"));
    }

    @Test
    void testNameContain(){
        assertTrue(s.isNameContains("it"));
        assertFalse(s.isNameContains("hu"));
    }
}