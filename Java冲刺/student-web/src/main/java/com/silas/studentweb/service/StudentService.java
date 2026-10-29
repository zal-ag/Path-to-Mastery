package com.silas.studentweb.service;

import com.silas.studentweb.model.Student;
import com.silas.studentweb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(String id) throws SQLException {
        return studentRepository.findById(id);
    }

    public List<Student> findByAgeRange(int minAge,int maxAge) throws SQLException {
        return studentRepository.findByAgeRange(minAge,maxAge);
    }

    public int addStudent(Student student) throws SQLException {
        return studentRepository.insert(student);
    }

    public int updateStudent(String id,Student student) throws SQLException {
        return studentRepository.update(id,student);
    }

    public int deleteStudent(String id) throws SQLException {
        return studentRepository.delete(id);
    }

    public List<Student> findAll() throws SQLException {
        return studentRepository.findAll();
    }
}
