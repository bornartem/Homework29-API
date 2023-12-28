package com.example.swagger_api;

import com.example.swagger_api.model.Faculty;
import com.example.swagger_api.service.FacultyService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacultyServiceTest {
    private final FacultyService test = new FacultyService();

    Faculty faculty = new Faculty(1, "Artem", "white");
    Faculty faculty1 = new Faculty(2, "Anna", "green");
    @Test
    public void shouldCreateStudent() {
        Faculty result = test.createFaculty(faculty);
        assertTrue(test.getAll().contains(result));
        assertEquals(result, faculty);
    }

    @Test
    public void shouldReadStudent() {
        Faculty result = test.createFaculty(faculty);
        test.readFaculty(1);
        assertTrue(test.getAll().contains(result));
    }

    @Test
    public void shouldUpdateStudent() {
        Faculty result = test.createFaculty(faculty);
        test.updateFaculty(faculty);
        assertTrue(test.getAll().contains(result));
        assertEquals(result, faculty);
    }

    @Test
    public void shouldDeleteStudent() {
        Faculty result = test.createFaculty(faculty);
        test.deleteFaculty(1);
        assertFalse(test.getAll().contains(result));
    }

    @Test
    public void shouldReturnList() {
        test.createFaculty(faculty);
        test.createFaculty(faculty1);
        Collection<Faculty> result = test.getAll();
        assertTrue(result.containsAll(List.of(faculty, faculty1)));
    }
    @Test
    public void shouldReturnStudentByAge() {
        Faculty result = test.createFaculty(faculty);
        test.facultyByColor("white");
        assertTrue(test.getAll().contains(faculty));
    }
}
