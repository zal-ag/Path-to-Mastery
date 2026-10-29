package com.silas.studentweb.controller;

import com.silas.studentweb.model.Student;
import com.silas.studentweb.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/demo")
    public Student getDemoStudent() {
        return new Student("1001","张三",20,"北京");
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String studentId) throws SQLException {
        Student stu = studentService.findById(studentId);
        if (stu == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(stu);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() throws SQLException {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/students/filter")
    public ResponseEntity<List<Student>> filterStudents(
            @RequestParam("minAge") int minAge,
            @RequestParam("maxAge") int maxAge) throws SQLException {
        if(minAge > maxAge) {
            return ResponseEntity.badRequest().build();
        }
        List<Student> result = studentService.findByAgeRange(minAge,maxAge);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/students/echo")
    public Student echoStudent (@RequestBody Student student) {
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return student;
    }

    @PostMapping("/students/add")
    public ResponseEntity<String> addStudent (@RequestBody Student student) throws SQLException {
        if(student.getId() == null || student.getId().isBlank()) return ResponseEntity.badRequest().body("学号不能为空");
        if(student.getName() == null || student.getName().isBlank()) return ResponseEntity.badRequest().body("姓名不能为空");
        if(student.getAge() < 1 || student.getAge() > 120) return ResponseEntity.badRequest().body("年龄必须在1-120之间");
        try{
            int rows = studentService.addStudent(student);
            if(rows == 1) return ResponseEntity.ok("新增成功");
            else return ResponseEntity.badRequest().body("新增失败");
        } catch (SQLException e) {
            if(e.getErrorCode() == 1062) return ResponseEntity.status(409).body("学号已存在");
            else throw e;
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable String id,@RequestBody Student student) throws SQLException {
        if(student.getName() == null || student.getName().isBlank()) return ResponseEntity.badRequest().body("姓名不能为空");
        if(student.getAge() < 1 || student.getAge() > 120) return ResponseEntity.badRequest().body("年龄必须在1-120之间");
        int rows = studentService.updateStudent(id,student);
        if(rows == 1) return ResponseEntity.ok("修改成功");
        else if(rows == 0) return ResponseEntity.status(404).body("学生不存在");
        else return ResponseEntity.badRequest().body("修改失败");
    }


    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) throws SQLException {
        int rows = studentService.deleteStudent(id);
        if(rows == 1) return ResponseEntity.ok("删除成功");
        else if(rows == 0) return ResponseEntity.status(404).body("学生不存在");
        else return ResponseEntity.badRequest().body("删除失败");
    }
}
