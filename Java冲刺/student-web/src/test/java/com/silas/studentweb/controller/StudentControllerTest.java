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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}