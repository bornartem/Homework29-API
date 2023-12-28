package com.example.swagger_api.controller;

import com.example.swagger_api.model.Faculty;
import com.example.swagger_api.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> readFaculty(@PathVariable long id) {
        Faculty faculty = facultyService.readFaculty(id);
        if (faculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(Faculty faculty) {
        Faculty foundFaculty = facultyService.updateFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping
    public Faculty deleteFaculty(long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("/color")
    public Collection<Faculty> getFacultyByColor(@RequestParam String color) {
        return facultyService.facultyByColor(color);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getFaculties() {
        return ResponseEntity.ok(facultyService.getAll());
    }
}
