package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void testAddStudent() {
        studentList.addNewStudent("1", "bew");
        studentList.addNewStudent("2", "gun");
        studentList.addNewStudent("3", "pond");
        studentList.addNewStudent("4", "wit");
        assertEquals(4, studentList.getStudents().size());
        assertEquals("bew", studentList.getStudents().get(0).getName());
    }

    @Test
    void testAddStudentWithScore() {
        studentList.addNewStudent("1", "bew", 100);
        assertEquals(100, studentList.getStudents().get(0).getScore());
    }

    @Test
    void testGetStudentById() {
        studentList.addNewStudent("1", "bew", 100);
        Student f = studentList.findStudentById("1");
        assertEquals("1", f.getId());
    }

    @Test
    void testFilterByName() {
        studentList.addNewStudent("1", "gun", 100);
        studentList.addNewStudent("2", "wit", 100);
        studentList.addNewStudent("3", "wong", 100);

        StudentList filtered = studentList.filterByName("w");
        assertEquals(2, filtered.getStudents().size());
        assertNull(filtered.findStudentById("1"));

    }

    @Test
    void testGiveScoreToId() {
        studentList.addNewStudent("1", "bew", 100);
        studentList.addNewStudent("2", "wong", 100);
        studentList.addNewStudent("3", "wong", 100);

        studentList.giveScoreToId("1",20);
        studentList.giveScoreToId("3",40);

        assertEquals(120, studentList.findStudentById("1").getScore());
        assertEquals(140, studentList.findStudentById("3").getScore());

    }

    @Test
    void testViewGradeOfId(){
        studentList.addNewStudent("1", "bew", 100);
        studentList.addNewStudent("2", "wong", 50);
        studentList.addNewStudent("3", "wong", 1);

        assertEquals("A", studentList.viewGradeOfId("1"));
        assertEquals("F", studentList.viewGradeOfId("3"));
    }
}