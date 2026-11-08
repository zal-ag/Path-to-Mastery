package com.silas.studentweb.controller;

import com.silas.studentweb.controller.StudentController;
import com.silas.studentweb.model.Student;
import com.silas.studentweb.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StudentService studentService;

    @Test
    void findStudent() throws Exception {
        Student stu = new Student("1001","张三",20,"北京");
        when(studentService.findById("1001")).thenReturn(stu);
        mockMvc.perform(get("/students/1001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1001"))
                .andExpect(jsonPath("$.name").value("张三"));

    }
    @Test
    void notFoundStudent() throws Exception {
        when(studentService.findById("9999")).thenReturn(null);
        mockMvc.perform(get("/students/9999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void addStudentWithBlankName() throws Exception {
        mockMvc.perform(post("/students/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"test001\",\"name\":\"\",\"age\":20}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("姓名不能为空"));
        verify(studentService,never()).addStudent(any(Student.class));
    }

    @Test
    void addStudentSuccess() throws Exception {
        when(studentService.addStudent(any(Student.class))).thenReturn(1);
        mockMvc.perform(post("/students/add")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\"id\":\"test001\",\"name\":\"test\",\"age\":20}"))
               .andExpect(status().isOk())
               .andExpect(content().string("新增成功"));
    }

}