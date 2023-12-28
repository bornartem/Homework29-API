package com.example.swagger_api;

import com.example.swagger_api.model.Student;
import com.example.swagger_api.service.StudentService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {
    private final StudentService test = new StudentService();

    Student student = new Student(1, "Artem", 30);
    Student student1 = new Student(2, "Anna", 29);

    @Test
    public void shouldCreateStudent() {
        Student result = test.createStudent(student);
        assertTrue(test.getAll().contains(result));
        assertEquals(result, student);
    }

    @Test
    public void shouldReadStudent() {
        Student result = test.createStudent(student);
        test.readStudent(1);
        assertTrue(test.getAll().contains(result));
    }

    @Test
    public void shouldUpdateStudent() {
        Student result = test.createStudent(student);
        test.updateStudent(student);
        assertTrue(test.getAll().contains(result));
        assertEquals(result, student);
    }

    @Test
    public void shouldDeleteStudent() {
        Student result = test.createStudent(student);
        test.deleteStudent(1);
        assertFalse(test.getAll().contains(result));
    }

    @Test
    public void shouldReturnList() {
        test.createStudent(student);
        test.createStudent(student1);
        Collection<Student> result = test.getAll();
        assertTrue(result.containsAll(List.of(student, student1)));
    }
    @Test
    public void shouldReturnStudentByAge() {
        Student result = test.createStudent(student);
        test.studentsByAge(30);
        assertTrue(test.getAll().contains(student));
    }
}
