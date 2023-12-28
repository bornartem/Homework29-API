package com.example.swagger_api.service;

import com.example.swagger_api.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();

    private long studentId = 0;

    public Student createStudent(Student student) {
        student.setId(++studentId);
        students.put(studentId, student);
        return student;
    }

    public Student readStudent(long id) {
        return students.get(id);
    }

    public Student updateStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Collection<Student> getAll() {
        return students.values();
    }

    public List<Student> studentsByAge(int age) {
        return getAll().stream()
                .filter(student -> student.getAge() == (age))
                .collect(Collectors.toList());
    }
}
