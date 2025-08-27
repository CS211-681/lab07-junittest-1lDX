package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    StudentListFileDatasource datasource;

    @BeforeEach
    void setUp() {
        datasource = new StudentListFileDatasource("data","student-list.csv");
    }

    @Test
    void testReadFile(){
        StudentList list = datasource.readData();

        assertEquals(1,list.getStudents().size());
    }

    @Test
    void testWriteFile(){
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "Ja");
        datasource.writeData(studentList);

        StudentListFileDatasource newDatasource = new StudentListFileDatasource("data","student-list.csv");
        StudentList newStudentList = newDatasource.readData();

        assertEquals(1,newStudentList.getStudents().size());
        assertEquals("Ja",newStudentList.findStudentById("1").getName());

    }

}